<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>

<c:set var="ctx" value="${pageContext.request.contextPath}" />
<c:set var="member" value="${member}" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>마이페이지 | DECA DIVE</title>
<link rel="stylesheet" href="${ctx}/resources/css/layout.css">
<link rel="stylesheet" href="${ctx}/resources/css/member.css">
</head>
<body>

<header>
    <jsp:include page="/include/header.jsp" />
</header>

<section>
    <div class="form-card">
        <h2>마이페이지</h2>

        <p class="form-greeting">
            <strong>${member.name}</strong> 님 안녕하세요.
        </p>

        <ul class="form-section-list">
            <li>아이디 : ${member.id}</li>
            <li>이메일 : ${member.email}</li>
            <li>전화번호 : ${member.phone}</li>
        </ul>

        <hr class="form-section-divider" />

        <ul class="form-section-list form-link-list">
            <li><a href="#">내 정보 수정 (준비 중)</a></li>
            <li><a href="#">내 주문 목록 보기 (준비 중)</a></li>
            <li><a href="#">회원 탈퇴 (준비 중)</a></li>
        </ul>
    </div>
</section>

<footer>
    <jsp:include page="/include/footer.jsp" />
</footer>

</body>
</html>
