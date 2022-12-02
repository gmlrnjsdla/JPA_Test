<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	[회원 이름 검색 결과]
	<hr>
	<c:forEach items="${searchDtos}" var="dto">
		학번 : ${dto.hakbun}<br>
		이름 : ${dto.name}<br>
		나이 : ${dto.age}<br>
		학년 : ${dto.grade}<br>
		비고 : ${dto.etc}<br>
		<hr>
	</c:forEach>
	
</body>
</html>