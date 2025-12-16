<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>

<c:set var="ctx" value="${pageContext.request.contextPath}" />
<c:set var="errors" value="${errors}" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입 | DECA DIVE</title>

<link rel="stylesheet" href="${ctx}/resources/css/layout.css">
<link rel="stylesheet" href="${ctx}/resources/css/member.css">
<script src="${ctx}/resources/js/member.js"></script>
</head>

<!-- 첫 에러 필드를 data 속성으로 내려보냄 (서버에서 아이디 중복 등 발생 시 사용) -->
<body data-first-error="${firstErrorField}">
	<header>
		<jsp:include page="/include/header.jsp" />
	</header>

	<section>
		<div class="form-card">
			<h2>회원가입</h2>

			<!-- 전역 에러 (아이디 중복 등 서버에서만 알 수 있는 에러) -->
			<c:if test="${not empty errors.global}">
				<div class="form-error global-error">${errors.global}</div>
			</c:if>

			<form name="registerForm" action="${ctx}/member/register.do"
				method="post" onsubmit="return validateRegisterForm(event);">

				<!-- 아이디 -->
				<label>아이디 *</label> <input type="text" name="id"
					placeholder="영소문자, 숫자 4~20자" value="${form.id}"
					class="form-input${not empty errors.id ? ' field-error' : ''}" />
				<div class="form-error">
					<c:out value="${errors.id}" />
				</div>

				<!-- 비밀번호 -->
				<label>비밀번호 *</label> <input type="password" name="password"
					placeholder="8~20자"
					class="form-input${not empty errors.password ? ' field-error' : ''}" />
				<div class="form-error">
					<c:out value="${errors.password}" />
				</div>

				<!-- 비밀번호 확인 -->
				<label>비밀번호 확인 *</label> <input type="password" name="passwordCheck"
					placeholder="비밀번호를 다시 입력"
					class="form-input${not empty errors.passwordCheck ? ' field-error' : ''}" />
				<div class="form-error">
					<c:out value="${errors.passwordCheck}" />
				</div>

				<!-- 이름 -->
				<label>이름 *</label> <input type="text" name="name"
					value="${form.name}"
					class="form-input${not empty errors.name ? ' field-error' : ''}" />
				<div class="form-error">
					<c:out value="${errors.name}" />
				</div>

				<!-- 이메일 -->
				<label>이메일</label> <input type="text" name="email"
					placeholder="예: deca@dive.com" value="${form.email}"
					class="form-input${not empty errors.email ? ' field-error' : ''}" />
				<div class="form-error">
					<c:out value="${errors.email}" />
				</div>

				<!-- 전화번호 -->
				<label>전화번호 *</label> <input type="text" name="phone"
					placeholder="예: 01012345678"
					value="${form.phone}"
					class="form-input${not empty errors.phone ? ' field-error' : ''}" />
				<div class="form-error">
					<c:out value="${errors.phone}" />
				</div>


				<button type="submit" class="btn-submit">회원가입</button>
			</form>

			<div class="form-bottom-link">
				이미 계정이 있나요? <a href="${ctx}/member/loginForm.do">로그인</a>
			</div>
		</div>
	</section>

	<footer>
		<jsp:include page="/include/footer.jsp" />
	</footer>

</body>
</html>
