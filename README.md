# 2016ADG04
Trabajo Práctico grupo 04 de Aplicaciones Distribuidas , 2016


Instrucciones para levantar el servidor
-----------------------------------------

**Uso de Maven**:
- Para descargar maven: https://maven.apache.org/download.cgi 
- Para instalar maven seguir las siguientes instrucciones: https://maven.apache.org/install.html

**Uso de Github**

1. Hacer click en "Fork" y elegir usuario
2. Posicionarse en el directorio donde se desee descargar el repositorio en consola (cmd en windows)
3. En la pantalla inicial de tu repositorio (en la url va a aparecer el nombre de tu usuario), hacer click en  el boton "clone or download" y copiar la url que se indica (si no tenes key ssh, elegir Use https y copiar la url)
4. En la consola ingresar : git clone [url del paso anterior]
5. Indicar por consola: git remote add upstream git@github.com:2016AplicacionesDistribuidas/2016ADG04.git 
(si falla, probar con git remote add upstream https://github.com/2016AplicacionesDistribuidas/2016ADG04.git)
6. Indicar: git remote -v   y comprobar figuren origin y upstream. Origin debe tener la url de tu repositorio y upstream la url del repositorio master.
7. Una vez que hayan bajado los archivos ir a eclipse

(si hiciste git pull del repositorio master, forkeá el repo y modificá el remote origin con los siguientes pasos:
- git remote set-url origin  [url de tu repo forkeado]
- git remote add upstream git@github.com:2016AplicacionesDistribuidas/2016ADG04.git
- git remote -v (verificá origin y upstream)
)


**En eclipse**

1. Ir a File>Import , buscar Maven y elegir "Existing maven project"
2. Elegir el proyecto a importar (lo que se descargó de github, al momento será un proyecto Servidor y otro proyecto Repositorio)

Una vez que se descargaron los proyectos, modificar la configuración de la base de datos local

1. En eclipse, en el proyecto 2016AD_G04_Servidor, ir a src/main/resources/META-INF y abrir el archivo persistencia.xml
2. Modificar la property

```<property name="hibernate.connection.url" value="jdbc:sqlserver://....>```  
(recordar previamente tener creado la base de datos que se indique en esta property)

3. Modificar password y contraseña de la base de datos en las propiedades respectivas
4. En el archivo pom.xml verificar la dependency apunta al directorio correcto
```
<dependency>
       <groupId>com.2016ADG04</groupId>
       <artifactId>2016AD_G04_Repositorio</artifactId>
       <version>0.0.1-SNAPSHOT</version>
       <scope>system</scope>
       <systemPath>${basedir}/../2016AD_G04_Repositorio/target/2016AD_G04_Repositorio-0.0.1-SNAPSHOT.jar</systemPath>
</dependency>
```
(systemPath debe apuntar al directorio donde se encuentra el jar del proyecto Repositorio)

5. Ir por consola al proyecto 2016AD_G04_Repositorio y ejecutar ```mvn clean install``` y luego ```mvn package```  (cada vez que haya un cambio en el projeto 2016AD_G04_Repositorio deberá hacerse un nuevo jar , eso lo ejecuta el **mvn package**)

6. Usando la consola, posicionarse en el directorio del proyecto 2016AD_G04_Servidor e ingresar  ```mvn clean install```

Una vez que el proyecto es compilado por maven, bajará todos los archivos que se indiquen en el archivo pom.xml. Realizar el paso 6 para todos los proyectos (ej 2016AD_G04_Repositorio)

Al utilizar **sql server**, debe realizarse lo siguiente, también en consola, en el proyecto Servidor

```mvn install:install-file -Dfile=sqljdbc4.jar -DgroupId=com.microsoft.sqlserver -DartifactId=sqljdbc4 -Dversion=4.0 -Dpackaging=jar```

Indicar en Dfile el directorio (path) donde se encuentre el jar sqljdbc4.

Volver a hacer mvc clean install.


7. Ir a eclipse y probar correr el Servidor en src/java/main/ > com.ADG04.Servidor > Servidor.java. Debera levantar el servidor rmi
8. Tambien correr en src/java/main  , en com.ADG04.Servidor > App.java.  Si la configuracion de la base es correcta, se crearán las tablas y se ejecutara la prueba que figure exitosamente.


Como subir cambios al master usando Git
-----------------------------------------
(Estos pasos deben realizarse ya habiendose efectuado los pasos **Uso de Github** detallados arriba)

1- Desde consola realizar los siguientes pasos:

- ```git add .```
- ```git commit -m "comentarios de los cambios..."```
- ```git push origin master ```

2- Ir a github web y verificar si los cambios fueron subidos a TU repositorio (ej https://github.com/**dcorvetto**/2016ADG04) . La url tendra el nombre de su usuario. Veran la leyenda:
"This branch is 1 commit ahead of 2016AplicacionesDistribuidas:master." (puede ser 1 o más commits diferentes)

3- Desde github web, crear un Pull Request (PR). La opción está al costado debajo del botón "Clone or Download"

4- Una vez creado el PR pueden mergearlo desde allí mismo. Abajo de todo esta el botón "Merge"

5- Una vez que mergean el cambio, verificar que los cambios estan en el repositorio master: https://github.com/2016AplicacionesDistribuidas/2016ADG04

6- **Todavía falta bajar los cambios de master a su fork!!** Para eso realizar por consola los siguientes pasos

- ```git fetch upstream```
- ```git rebase upstream/master```
- ```git push origin master```

El comando ```git status``` les puede ser de utilidad para verificar el estado de su repositorio en cualquier momento.

7- En github web podes verificar que en TU repositorio aparece una leyenda como esta:
"This branch is even with 2016AplicacionesDistribuidas:master."

De ser así, su repositorio y el master son iguales. :)


-------Agregado por Vane-----------------------

Si te aparece el error "Cannot rebase: You have unstaged changes. Please commit or stash them."
ejecuta:
- "git stash": resguarda los cambios que no queres que se te pisen
- "git rebase upstream/master"
- "git push origin master"
- "git stash apply" : retoma los cambios que guardaste previamente.


Si queres descartar los cambios de algun archivo en tu compu:

- git checkout <file>
