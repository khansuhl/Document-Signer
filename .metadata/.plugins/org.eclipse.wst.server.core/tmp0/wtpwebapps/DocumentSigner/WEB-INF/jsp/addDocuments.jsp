<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<title>Document Signer</title>
</head>
<body background="${pageContext.request.contextPath}/images/green.jpg"
	style="text-align: center; background-size: cover">
	<h2>Document Signer</h2>
	<h3>Add new document</h3>
	<form:form action="addDocuments" commandName="document" method="post"
		style="margin-left:35%" enctype="multipart/form-data">
		<table>
			<tr>
				<td><form:label path="name">Name</form:label></td>
				<td><form:input path="name" /></td>
			</tr>
			<tr>
				<td><form:label path="filename">Filename</form:label></td>
				<td><form:input path="filename" /></td>
			</tr>
			<tr>
				<td><form:label path="description">Description</form:label></td>
				<td><form:textarea path="description" /></td>
			</tr>
			<tr>
				<td><form:label path="contentType">Content Type</form:label></td>
				<td><form:input path="contentType" /></td>
			</tr>
			<tr>
				<td><form:label path="createdDate">Date Created</form:label></td>
				<td><form:input path="createdDate" /></td>
			</tr>
			<tr>
				<td><form:label path="content">Document</form:label></td>
				<td><input type="file" name="file" id="file"></input></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Add Document" /></td>
			</tr>
		</table>
	</form:form>
</body>
</html>