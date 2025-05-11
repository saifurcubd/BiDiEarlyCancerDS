<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<form action="<%=request.getContextPath()%>/Add.jsp" method="get">
		<table>
			<tr>
				<td>B</td>
				<td><input type="text" name="a" /></td>
			</tr>
			<tr>
				<td>A</td>
				<td><input type="text" name="b" /></td>
			</tr>
			<tr>
				<td>Result:</td>
				<c:choose>
					<c:when test="${request.result ne null}">
						<td><input type="text" name="result"
							value="${request.result}" /></td>
					</c:when>
					<c:otherwise>

					</c:otherwise>
				</c:choose>

			</tr>
		</table>
		<input type="submit" value="add" />



	</form>

</body>
</html>