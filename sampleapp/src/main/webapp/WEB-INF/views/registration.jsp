<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ page session="false" %>
<html>
<head>
	<title>Registration</title>
</head>
<body>
				
<h1>
	<form:form method="post" commandName="User" action="registration">
			<table>
				<tr> 
				<td> 
				<s:bind path="*">
		  			<c:if test="${status.error}">
				  		Form has errors
		  			</c:if>
		  		</s:bind>
		  		</td>
		  		</tr>
		  
			<tr>  
				<td colspan="2">Register here</td>  
			</tr>  
			<tr>  
				<td><form:label path="firstName">First Name</form:label></td>  
				<td><form:input path="firstName" /></td>  
				<td><form:errors path="firstName" cssClass="error" /></td>
			</tr>  
			<tr>  
				<td><form:label path="lastName">Last Name</form:label></td>  
				<td><form:input path="lastName" /></td> 
				<td><form:errors path="lastName" cssClass="error" /></td> 
			</tr>  
			<tr>  
				<td><form:label path="email">Email</form:label></td>  
				<td><form:input path="email" /></td>  
				<td><form:errors path="email" cssClass="error" /></td>
			</tr>
			<tr>  
				<td><form:label path="dateOfBirth">Date of birth</form:label></td>  
				<td><form:input path="dateOfBirth"/></td>  
				<td><form:errors path="dateOfBirth" cssClass="error" /></td>
			</tr>
			
			<tr>
				<fieldset class="radio">
					<td><form:label path="salutation">Salutation</form:label></td>
			 		<td><label><form:radiobutton path="salutation" value="male" />Mr.</label>
					<label><form:radiobutton path="salutation" value="female" />Mrs.</label></td>
					<td><form:errors path="salutation" cssClass="error" /></td>
				</fieldset>
			</tr>
			<tr>  
				<td><form:label path="password">Password</form:label></td>  
				<td><form:input path="password" /></td>  
				<td><form:errors path="password" cssClass="error" /></td>
			</tr>
			<tr>  
				<td><form:label path="reTypePassword">Re-type Password</form:label></td>  
				<td><form:input path="reTypePassword" /></td>  
				<td><form:errors path="reTypePassword" cssClass="error" /></td>
				<td>${PasswordReTypePasswordMatchConstraint}</td>
			</tr>
			<tr>
				<fieldset class="radio">
					<td><form:label path="receiveMarketingEmail">receiveMarketingEmail</form:label></td>
			 		<td><form:checkbox path="salutation" value="true" /></td>				
				</fieldset>
			</tr>
			<tr>  
				<td colspan="2"><input type="submit" value="Register" /></td>  
			</tr>  
			
			
		</table>  
	</form:form>   
</h1>

</body>
</html>