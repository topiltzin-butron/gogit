<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>GoGIT - Spring based play ground</title>
</head>
<body>
	
	<form:form method="post" action="giphy/search" modelAttribute="searchTerm">
		
		<form:input path="term" />
		<input value="OK" type="submit">
	</form:form>

	<div id="imageContainer" >
	</div>

</body>
</html>