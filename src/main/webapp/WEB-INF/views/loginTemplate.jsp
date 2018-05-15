<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">

<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" />
<link href="${pageContext.request.contextPath}/resources/css/signin.css"
	rel="stylesheet">
<title><tiles:insertAttribute name="title" ignore="true"></tiles:insertAttribute>
</title>
</head>
<body>
	<table>
		<tr>
			<td align="right"><tiles:insertAttribute name="header"></tiles:insertAttribute></td>
		</tr>
		<tr>
			<td align="center"><tiles:insertAttribute name="body"></tiles:insertAttribute>
			</td>
		</tr>
		<tr>
			<td align="center"><tiles:insertAttribute name="footer"></tiles:insertAttribute></td>
		</tr>
	</table>
</body>
</html>
