<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>

<c:set var="ctx" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="${ctx}/resources/css/layout.css">
</head>

<body>
	<header>
		<jsp:include page="/include/header.jsp" />
	</header>

	<h1>메인 페이지</h1>
	<footer>
		<jsp:include page="/include/footer.jsp" />
	</footer>
</body>
</html>