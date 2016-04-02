<%@ page language="java" contentType="text/html; charset=ISO-8859-1" isELIgnored="false" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
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
        <h2>Enregistrement d'un client'</h2>
        <table border="0" width="90%">
        <form:form modelAttribute="client" method="post" action="/add" >
                <tr>
					 <td>ID:</td>
                     <td align="left" width="40%"><form:input path="id" size="30"/></td>
 					 <td align="left"><form:errors path="id" cssClass="error"/></td>
 				</tr>
 				<tr>
					 <td>Nom:</td>
                     <td align="left" width="40%"><form:input path="nom" size="30"/></td>
 					 <td align="left"><form:errors path="nom" cssClass="error"/></td>
 				</tr>
 				<tr>
					 <td>Prénom:</td>
                     <td align="left" width="40%"><form:input path="prenom" size="30"/></td>
 					 <td align="left"><form:errors path="prenom" cssClass="error"/></td>
 				</tr>
 				<tr>
					 <td>Télephone:</td>
                     <td align="left" width="40%"><form:input path="telephone" size="30"/></td>
 					 <td align="left"><form:errors path="telephone" cssClass="error"/></td>
 				</tr>
 				<tr>
					 <td>Email:</td>
                     <td align="left" width="40%"><form:input path="email" size="30"/></td>
 					 <td align="left"><form:errors path="email" cssClass="error"/></td>
 				</tr>
 				<tr>
					 <td>Catégorie:</td>
                     <td align="left" width="40%"><form:input path="categorie" size="30"/></td>
 					 <td align="left"><form:errors path="categorie" cssClass="error"/></td>
 				</tr>
 		        <tr>
                    <td></td>
                    <td align="center"><input type="submit" value="Ajouter"/></td>
                    <td></td>
                </tr>
        </form:form>
        </table>
    </div>
</body>
</html>