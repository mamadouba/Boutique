<%@ page language="java" contentType="text/html; charset=ISO-8859-1" isELIgnored="false" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form"   uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c"      uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
 
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Enregistrement client</title>
<style>
    .error {
        color: red; font-weight: bold;
    }
</style>
</head>
<body>
    <div align="center">
        <h2>Gestion des clients</h2>
	    <c:if test="${not empty msg}">
	    	<strong>${msg}</strong>
	    </c:if>
	    
	    <c:if test="${not empty client}">
	    	<h2>Détail du client</h2>
	        <table border="1" width="90%">
					<tr>
						 <td>ID:</td>
						 <td>${client.id}</td>
	 				</tr>
	 				<tr>
						 <td>Nom:</td>
						 <td>${client.nom}</td>
	 				</tr>
	 				<tr>
						 <td>Prénom:</td>
	                     <td>${client.prenom}</td>
	 				</tr>
	 				<tr>
						 <td>Téléphone:</td>
						 <td>${client.telephone}</td>
	 				</tr>
	 				<tr>
						 <td>Email:</td>
	                     <td>${client.email}</td>
	 				</tr>
	 				<tr>
						 <td>Adresse:</td>
						 <td>${client.adresse}</td>
	 				</tr>
	 				<tr>
						 <td>Catégorie:</td>
						 <td>${client.categorie}</td>
	 				</tr>
	        </table>
		</c:if>
    </div>
</body>
</html>