<%@ page language="java" contentType="text/html; charset=ISO-8859-1" isELIgnored="false" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form"   uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c"      uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="boutique.css" type="text/css" rel="stylesheet" />
<title>Insert title here</title>
</head>
<body>
	<div id="header"></div>
	<div id="menu">
	
	
	</div>
	<div id="content">
		<h3>Liste des clients</h3>
	        <table border="1">
	            <thead>
	                <tr>
	                    <th>ID</th>
	                    <th>Nom</th>
	                    <th>Prénom</th>
	                    
	                </tr>
	            </thead>
	            <tbody>
	                <c:forEach items="${listClient}" var="client">
	                    <tr>
	                        <td><c:out value="${client.id}"/></td>
	                        <td><c:out value="${client.nom}"/></td>
	                        <td><c:out value="${client.prenom}"/></td>
	                        <td>
	                        	<spring:url value="/client/${client.id}" var="userUrl"></spring:url>
	                        	<button onclick="location.href='${userUrl}'">Afficher</button>
	                        </td>
	                        <td>
	                        	<spring:url value="/client/${client.id}/edit" var="editUrl"></spring:url>
	                        	<button onclick="location.href='${editUrl}'">Editer</button>
	                        </td>
	                        <td>
	                        	<spring:url value="/client/${client.id}/delete" var="delUrl"></spring:url>
	                        	<button onclick="location.href='${delUrl}'">Supprimer</button>
	                        </td>
	                        
	                    </tr>
	                </c:forEach>
	            </tbody>
	        </table>
	       </div>
	
	</div>
	<div id="footer"></div>
</body>
</html>