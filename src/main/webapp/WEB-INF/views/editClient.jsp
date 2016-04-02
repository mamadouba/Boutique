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
		<c:if test="${not empty client}">
        <h3>Modification du client: ${client.prenom} ${client.nom}</h3>
	        <table border="0" width="90%">
			<spring:url value="/client/edit" var="addUrl"></spring:url>
	        <form:form modelAttribute="client" method="post" action="${addUrl}" >
					<tr>
						 <td>ID:</td>
	                     <td align="left" width="40%"><form:input path="id" size="30" value="${client.id}"/></td>
	 					 <td align="left"><form:errors path="id" cssClass="error"/></td>
	 				</tr>
	 				<tr>
						 <td>Nom:</td>
	                     <td align="left" width="40%"><form:input path="nom" size="30" value="${client.nom}"/></td>
	 					 <td align="left"><form:errors path="nom" cssClass="error"/></td>
	 				</tr>
	 				<tr>
						 <td>Prénom:</td>
	                     <td align="left" width="40%"><form:input path="prenom" size="30" value="${client.prenom}"/></td>
	 					 <td align="left"><form:errors path="prenom" cssClass="error"/></td>
	 				</tr>
	 				<tr>
						 <td>Télephone:</td>
	                     <td align="left" width="40%"><form:input path="telephone" size="30" value="${client.telephone}"/></td>
	 					 <td align="left"><form:errors path="telephone" cssClass="error"/></td>
	 				</tr>
	 				<tr>
						 <td>Email:</td>
	                     <td align="left" width="40%"><form:input path="email" size="30" value="${client.email}"/></td>
	 					 <td align="left"><form:errors path="email" cssClass="error"/></td>
	 				</tr>
	 				<tr>
						 <td>Adresse:</td>
	                     <td align="left" width="40%"><form:input path="adresse" size="30" value="${client.adresse}"/></td>
	 					 <td align="left"><form:errors path="adresse" cssClass="error"/></td>
	 				</tr>
	 				<tr>
						 <td>Catégorie:</td>
	                     <td align="left" width="40%">
							<form:select path="categorie">
								<form:option value="${client.categorie}"/>
								<form:options items="${categories}"/>
							</form:select>
						</td>
	 					 <td align="left"><form:errors path="categorie" cssClass="error"/></td>
	 				</tr>
	 		        <tr>
	                    <td></td>
	                    <td align="center"><input type="submit" value="Modifier"/></td>
	                    <td></td>
	                </tr>
	        </form:form>
	        </table>
		</c:if>
    </div>
</body>
</html>