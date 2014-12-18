<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
	
		<title>SPA Structure</title>
	
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<meta name="viewport" content="initial-scale=1.0, maximum-scale=1.0, user-scalable=0, width=device-width" />
		<meta name="apple-mobile-web-app-capable" content="yes" />
		
		<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap.css" type="text/css" />
		
		<script src="${pageContext.request.contextPath}/resources/js/lib/require.js" data-main="${pageContext.request.contextPath}/resources/js/config/require.config.js" type="text/javascript"></script>
	</head>
	
	<body>
		<div ui-view></div>
	</body>
</html>
