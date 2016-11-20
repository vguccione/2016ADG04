<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.io.*"%>
<%@ page import= "java.util.*"%>
<%@ page import="com.ADG04.bean.Administracion.DTO_Usuario"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<%@ include file="header.jsp" %>

<body>
<div class="container">
    <div class="content">
  
    <%
    if(sesionIntento.getAttribute("usuario") == null || sesionIntento.getAttribute("usuario").equals("")){
    	 response.sendRedirect("login.jsp");
    }
    %>
  
    </div>
  </div>
</body>
</html>