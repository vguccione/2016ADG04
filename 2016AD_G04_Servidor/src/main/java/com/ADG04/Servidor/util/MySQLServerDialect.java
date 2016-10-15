package com.ADG04.Servidor.util;

import org.hibernate.dialect.function.VarArgsSQLFunction;
import org.hibernate.type.TimestampType;

public class MySQLServerDialect extends org.hibernate.dialect.SQLServerDialect {

	  public MySQLServerDialect() {
	    registerFunction("addhours", new VarArgsSQLFunction(TimestampType.INSTANCE, "dateadd(hh,", ",", ")"));
	  }


}
