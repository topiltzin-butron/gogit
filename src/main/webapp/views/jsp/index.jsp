<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>GoGIT - Spring based play ground</title>
<spring:url value="/resources/css/gogit.css" var="css" />
<spring:url value="/resources/js/gogit.js" var="js" />
<link href="${css}" rel="stylesheet" />
<script src="${js}"></script>
</head>
<body>

	<h1>GoGIT</h1>
	<h2>Spring based play ground</h2>
	<a href="<%=request.getContextPath()%>/home">Try me</a>

	<br />
	<a href="${pageContext.request.contextPath}/interviews/giphy">Giphy</a>


</body>
</html>