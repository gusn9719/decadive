<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>

<c:set var="ctx" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>DECA DIVE - 주문 관리</title>
<link rel="stylesheet" href="${ctx}/resources/css/layout.css">
<link rel="stylesheet" href="${ctx}/resources/css/admin.css">
</head>
<body>

	<header><jsp:include page="/include/header.jsp" /></header>

	<section class="admin-card">
		<h2>주문 목록 / 관리</h2>
		<div style="text-align: center; color: #777;">(구현 예정)</div>
	</section>

	<footer><jsp:include page="/include/footer.jsp" /></footer>

</body>
</html>
