<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
<head>
	 <meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">

<script type="text/javascript"> 
        var contextPath = "<%=request.getContextPath()%>";
</script>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>

<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" />
<link rel="stylesheet" type="text/css" 
    href="${pageContext.request.contextPath}/resources/css/bootstrap-theme.min.css" />
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/font-awesome.min.css" />
    
   
		<style>
.sui-cell {
	font-family: "Helvetica Neue", Helvetica, Arial, sans-serif;
}
</style>


		
<!--  link href="${pageContext.request.contextPath}/resources/css/signin.css"
	rel="stylesheet"-->

<title><tiles:insertAttribute name="title" ignore="true"></tiles:insertAttribute>
</title>
</head>
<body>

	<table>
		<tr>
			<td colspan="2" align="right">			
			<tiles:insertAttribute name="header"></tiles:insertAttribute>
			
			</td>
		</tr>
		<tr>
			<td colspan="2" align="center"><tiles:insertAttribute name="menu"></tiles:insertAttribute>
			</td>
		</tr>
		<tr>
			<td colspan="2" >
			<tiles:insertAttribute name="body"></tiles:insertAttribute>
			</td>
		</tr>
		<tr>
			<td colspan="2" align="center"><tiles:insertAttribute
					name="footer"></tiles:insertAttribute></td>
		</tr>
	</table>
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery-1.10.2.min.js"></script>
	
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>
	<script src="${pageContext.request.contextPath}/resources/js/docs.min.js"></script>
 
</body>
</html>
