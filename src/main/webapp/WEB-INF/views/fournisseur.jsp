<%@ page language="java" contentType="text/html; charset=ISO-8859-1" isELIgnored="false" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
 
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">
<title>Détail fournisseur</title>
</head>
<body>
    <div class="container">
		<c:if test="${not empty msg}">
			<div class="alert alert-${css}" role="alert">
				<button type="button" class="close" data-dismiss="alert" aria-label="Close">
					<span aria-hidden="true">×</span>
				</button>
				<strong>${msg}</strong>
			</div>
		</c:if>
        <h2>Détail du fournisseur</h2>
		<div class="row">
			<label class="col-sm-2">Nom</label>
			<div class="col-sm-10">${fournisseur.nom}</div>
		</div>
		<div class="row">
			<label class="col-sm-2">Prénom</label>
			<div class="col-sm-10">${fournisseur.prenom}</div>
		</div>
		
		<div class="row">
			<label class="col-sm-2">Téléphone</label>
			<div class="col-sm-10">${fournisseur.telephone}</div>
		</div>
		
		<div class="row">
			<label class="col-sm-2">Email</label>
			<div class="col-sm-10">${fournisseur.email}</div>
		</div>
		
		<div class="row">
			<label class="col-sm-2">Adresse</label>
			<div class="col-sm-10">${fournisseur.adresse}</div>
		</div>
		
		<div class="row">
			<label class="col-sm-2">Catégorie</label>
			<div class="col-sm-10">${fournisseur.categorie}</div>
		</div>
		<div class="form-group">
			<c:if test="${action == 'add'}">
			<div class="col-sm-offset-2 col-sm-10">
				<spring:url value="/fournisseur/new" var="newUrl"></spring:url>
				<button class="btn btn-primary btn-sm pull-right" onclick="location.href='${newUrl}'">Nouveau</button>
			</div>
			</c:if>
			<c:if test="${action == 'update'}">
			<div class="col-sm-offset-2 col-sm-10">
				<spring:url value="/fournisseur/list" var="listUrl"></spring:url>
				<button class="btn btn-primary btn-sm pull-right" onclick="location.href='${listUrl}'">Tous les fournisseurs</button>
			</div>
			</c:if>
		</div>
    </div>
</body>
</html>