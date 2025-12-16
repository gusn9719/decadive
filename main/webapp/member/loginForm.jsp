<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>

<c:set var="ctx" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 | DECA DIVE</title>

<!-- 공통 레이아웃 -->
<link rel="stylesheet" href="${ctx}/resources/css/layout.css">
<!-- 회원 전용 스타일 -->
<link rel="stylesheet" href="${ctx}/resources/css/member.css">

</head>
<body>
	<header>
		<jsp:include page="/include/header.jsp" />
	</header>

	<section>
		<div class="form-card">
			<h2>로그인</h2>

			<form action="${ctx}/member/login.do" method="post">
				<label>아이디</label> <input type="text" name="id" required class="form-input"/> <label>비밀번호</label>
				<input type="password" name="password" required class="form-input"/>

				<!-- 로그인 실패 메시지 -->
				<c:if test="${not empty msg}">
					<div class="form-error">${msg}</div>
				</c:if>

				<button type="submit" class="btn-submit">로그인</button>
			</form>

			<div class="form-bottom-link">
				계정이 없나요? <a href="${ctx}/member/registerForm.do">회원가입</a>
			</div>
		</div>
	</section>

	<footer>
		<jsp:include page="/include/footer.jsp" />
	</footer>
</body>
</html>
