<%@ page language="java" contentType="text/html; charset=ISO-8859-1" isELIgnored="false" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
 
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">
<title>Enregistrement client</title>
<style>
    .error {
        color: red; font-weight: bold;
    }
</style>
</head>
<body>
    <div class="container">
        <h2>Modification d'un client</h2>

		<c:if test="${not empty msg}">${msg}</c:if>
		<spring:url value="/client/edit" var="addUrl"></spring:url>
        <form:form class="form-horizontal" modelAttribute="client" method="post" action="${addUrl}" >
				<form:hidden path="id" />
				<div class="form-group">
					<label for="nom" id="nom" class="col-sm-2 label-control">Nom</label>
					<div class="col-sm-10">
						<form:input path="nom" type="text" class="form-control" id="nom" value="${client.nom}" placeholder="Nom" pattern="^[A-Za-z]{3,15}$" required="required"/>
						<form:errors path="nom" class="control-label"/>
					</div>
				</div>
				
				<div class="form-group">
					<label for="prenom" id="prenom" class="col-sm-2 label-control">Prénom</label>
					<div class="col-sm-10">
						<form:input path="prenom" type="text" class="form-control" id="nom" value="${client.prenom}" placeholder="Prénom" pattern="^[A-Za-z]{3,15}$" required="required"/>
						<form:errors path="prenom" class="control-label"/>
					</div>
				</div>
				
				<div class="form-group">
					<label for="telephone" id="telephone" class="col-sm-2 label-control">Téléphone</label>
					<div class="col-sm-10">
						<form:input path="telephone" type="tel" class="form-control" id="telephone" value="${client.telephone}" placeholder="Téléphone" pattern="^[0-9]{10}$" required="required"/>
						<form:errors path="telephone" class="control-label"/>
					</div>
				</div>
				
				<div class="form-group">
					<label for="email" id="email" class="col-sm-2 label-control">Email</label>
					<div class="col-sm-10">
						<form:input path="email" type="text" class="form-control" id="email" value="${client.email}" placeholder="Email" required="required" />
						<form:errors path="email" class="control-label"/>
					</div>
				</div>
				
				<div class="form-group">
					<label for="adresse" id="adresse" class="col-sm-2 label-control">Adresse</label>
					<div class="col-sm-10">
						<form:input path="adresse" type="text" class="form-control" id="adresse" value="${client.adresse}" placeholder="Adresse"  required="required"/>
						<form:errors path="adresse" class="control-label"/>
					</div>
				</div>
				
				<div class="form-group">
					<label for="categorie" id="categorie" class="col-sm-2 label-control">Catégorie</label>
					<div class="col-sm-10">
							<form:select path="categorie" class="form-control">
								<form:option value="Premium"/>
								<form:options items="${categories}"/>
							</form:select>
						<form:errors path="categorie" class="control-label"/>
					</div>
				</div>
				<div class="form-group">
					<div class="col-sm-offset-2 col-sm-10">
						<button class="btn btn-m btn-primary pull-right" type="submit">Modifier</button>
					</div>
				</div>
        </form:form>
    </div>
</body>
</html>