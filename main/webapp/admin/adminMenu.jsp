<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>

<c:set var="ctx" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>DECA DIVE - 관리자 메뉴</title>

<link rel="stylesheet" href="${ctx}/resources/css/layout.css">
<link rel="stylesheet" href="${ctx}/resources/css/admin.css">
</head>
<body>

	<header>
		<jsp:include page="/include/header.jsp" />
	</header>

	<section class="admin-card admin-page">
		<h2>관리자 메뉴</h2>

		<ul style="line-height: 1.8;">
			<li><a href="${ctx}/admin/itemForm.do">상품 등록</a></li>
			<li><a href="${ctx}/admin/itemManageList.do">상품 수정 / 삭제</a></li>
			<li><a href="${ctx}/admin/memberList.do">회원 목록 보기</a></li>
			<li><a href="${ctx}/admin/orderManageList.do">주문 목록 / 관리</a></li>
		</ul>
	</section>

	<footer>
		<jsp:include page="/include/footer.jsp" />
	</footer>

</body>
</html>
