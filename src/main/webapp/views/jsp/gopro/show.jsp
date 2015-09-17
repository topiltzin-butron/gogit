<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>GoGIT - Spring based play ground</title>

<script type="text/javascript">
var CONTEXT_ROOT = "<%= request.getContextPath() %>";
</script>
<spring:url value="/resources/css/gogit.css" var="css" />
<spring:url value="/resources/js/gogit.js" var="js" />
<link href="${css}" rel="stylesheet" />
<script src="${js}"></script>
</head>
<body>
	
	<h1>GoPro</h1>

	<a href="${pageContext.request.contextPath}/gopro/turnOn">Turn On</a>
	<br/>
	<a href="${pageContext.request.contextPath}/gopro/turnOff">Turn Off</a>
	<br/>
	<a href="${pageContext.request.contextPath}/gopro/startCapture">Start Capture</a>
	<br/>
	<a href="${pageContext.request.contextPath}/gopro/stopCapture">Stop Capture</a>	
	<br/>

</body>
</html>