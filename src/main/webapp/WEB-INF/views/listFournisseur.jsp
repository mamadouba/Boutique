<%@ page language="java" contentType="text/html; charset=ISO-8859-1" isELIgnored="false" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form"   uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c"      uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">

<title>Insert title here</title>
</head>
<body>
	<div class="container">
	       <table class="table table-bordered">
	            <h2>Liste des fournisseurs</h2>
	            <thead>
	                <tr>
	                    <th>ID</th>
	                    <th>Nom</th>
	                    <th>Prénom</th>
	                    <th>Email</th>
	                     <th>Adresse</th>
	                    
	                </tr>
	            </thead>
	            <tbody>
	                <c:forEach items="${listFournisseur}" var="fournisseur">
	                    <tr>
	                        <td><c:out value="${fournisseur.id}"/></td>
	                        <td><c:out value="${fournisseur.prenom}"/></td>
	                        <td><c:out value="${fournisseur.nom}"/></td>
	                        <td><c:out value="${fournisseur.email}"/></td>
	                        <td><c:out value="${fournisseur.adresse}"/></td>
	                        <td>
	                        	<spring:url value="/fournisseur/${fournisseur.id}" var="userUrl"></spring:url>
	                        	<spring:url value="/fournisseur/${fournisseur.id}/edit" var="editUrl"></spring:url>
	                        	<spring:url value="/fournisseur/${fournisseur.id}/delete" var="delUrl"></spring:url>
	                        	
	                        	<button class="btn btn-success btn-sm" onclick="location.href='${userUrl}'">Afficher</button>
	                        	<button class="btn btn-warning btn-sm" onclick="location.href='${editUrl}'">Editer</button>
	                        	<button class="btn btn-danger  btn-sm" onclick="location.href='${delUrl}'">Supprimer</button>
	                        </td>
	                    </tr>
	                </c:forEach>
	            </tbody>
	        </table>
	</div>
	<script src="webjars/jquery/2.2.2/dist/jquery.min.js"></script>
	<script src="webjars/bootstrap/3.3.6/dist/js/bootstrap.min.js"></script>
</body>
</html>