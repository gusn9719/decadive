<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<c:set var="ctx" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관리자 메뉴 | DECA DIVE</title>
<link rel="stylesheet" href="${ctx}/resources/css/layout.css">
<link rel="stylesheet" href="${ctx}/resources/css/member.css">
</head>
<body>

<header>
    <jsp:include page="/include/header.jsp"/>
</header>

<section>
    <div class="form-card">
        <h2>관리자 메뉴</h2>

        <ul class="form-section-list form-link-list admin-menu-list">
            <li><a href="${ctx}/admin/itemForm.do">상품 등록</a></li>
            <li><a href="#">상품 수정 / 삭제 (구현 예정)</a></li>
            <li><a href="#">회원 목록 보기 (구현 예정)</a></li>
            <li><a href="#">주문 목록 / 관리 (구현 예정)</a></li>
        </ul>
    </div>
</section>

<footer>
    <jsp:include page="/include/footer.jsp"/>
</footer>

</body>
</html>
