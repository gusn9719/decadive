<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>

<c:set var="ctx" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 등록 | DECA DIVE</title>

<link rel="stylesheet" href="${ctx}/resources/css/layout.css">
<link rel="stylesheet" href="${ctx}/resources/css/member.css">
<%-- 폼 기본 버튼/폰트 --%>
<link rel="stylesheet" href="${ctx}/resources/css/admin.css">
<%-- 관리자 전용 스타일 --%>

</head>
<body>
	<header>
		<jsp:include page="/include/header.jsp" />
	</header>

	<section>
		<div class="admin-card">
			<h2>상품 등록</h2>

			<c:if test="${not empty errorMsg}">
				<div class="admin-error">${errorMsg}</div>
			</c:if>

			<!-- 파일 업로드 때문에 enctype 필수 -->
			<form action="${ctx}/admin/itemRegister.do" method="post"
				enctype="multipart/form-data">

				<!-- 연대 -->
				<label>연대</label> <select name="era" required>
					<option value="80s" ${param.era == '80s' ? 'selected' : ''}>80s</option>
					<option value="90s" ${param.era == '90s' ? 'selected' : ''}>90s</option>
					<option value="00s" ${param.era == '00s' ? 'selected' : ''}>00s</option>
				</select>

				<!-- 카테고리 -->
				<label>카테고리</label> <select name="category" required>
					<option value="WALL">WALL</option>
					<option value="DESK">DESK</option>
					<option value="FASHION">FASHION</option>
					<option value="TECH">TECH</option>
					<option value="COMICS">COMICS</option>
				</select>

				<!-- 상품명 -->
				<label>상품명</label> <input type="text" name="name" required />

				<!-- 가격 -->
				<label>가격</label> <input type="number" name="price" min="0"
					step="100" required />

				<!-- 대표 이미지 -->
				<label>대표 이미지</label> <input type="file" name="imageFile"
					accept="image/*" required />

				<!-- 상품 설명 -->
				<label>상품 설명</label>
				<textarea name="description"
					placeholder="간단한 설명을 적어주세요. (레트로 감성 한 줄이라도 OK)"></textarea>

				<button type="submit" class="btn-submit">등록하기</button>
			</form>
		</div>
	</section>

	<footer>
		<jsp:include page="/include/footer.jsp" />
	</footer>
</body>
</html>
