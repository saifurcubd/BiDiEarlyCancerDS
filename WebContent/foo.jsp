<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%String hid="hiden masg";
String n;
n=(String)request.getAttribute("msg");%>
	<form action="${pageContext.request.contextPath}/foo.jsp" method="post">
		<input type="text" name="name" value="${fn:escapeXml(param.name)}">
		<h1>${fn:escapeXml(param.name)}</h1>
		<br /> <input type="hidden" name="hid" value="<%=hid%>">
		<h1>${fn:escapeXml(param.hid)}</h1>
		<br /> <input type="submit" name="submit">

	</form>

</body>
</html>