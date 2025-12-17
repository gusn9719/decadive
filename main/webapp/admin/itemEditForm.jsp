<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>

<c:set var="ctx" value="${pageContext.request.contextPath}" />
<c:set var="item" value="${item}" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>DECA DIVE - 상품 수정</title>

<link rel="stylesheet" href="${ctx}/resources/css/layout.css">
<link rel="stylesheet" href="${ctx}/resources/css/admin.css">
</head>
<body>

	<header>
		<jsp:include page="/include/header.jsp" />
	</header>

	<section class="admin-card admin-page">
		<h2>상품 수정</h2>

		<form action="${ctx}/admin/itemUpdate.do" method="post"
			class="admin-form">
			<input type="hidden" name="itemNo" value="${item.itemNo}" />

			<div class="admin-form-row">
				<label class="admin-label">상품명</label> <input class="admin-input"
					type="text" name="name" value="${item.name}" required />
			</div>

			<div class="admin-form-row">
				<label class="admin-label">가격</label> <input class="admin-input"
					type="number" name="price" min="0" value="${item.price}" required />
			</div>

			<div class="admin-form-row">
				<label class="admin-label">연대</label> <select class="admin-select"
					name="era" required>
					<option value="80s" ${item.era == '80s' ? 'selected' : ''}>80s</option>
					<option value="90s" ${item.era == '90s' ? 'selected' : ''}>90s</option>
					<option value="00s" ${item.era == '00s' ? 'selected' : ''}>00s</option>
				</select>
			</div>

			<div class="admin-form-row">
				<label class="admin-label">카테고리</label> <select class="admin-select"
					name="category" required>
					<option value="WALL" ${item.category == 'WALL' ? 'selected' : ''}>WALL</option>
					<option value="DESK" ${item.category == 'DESK' ? 'selected' : ''}>DESK</option>
					<option value="TECH" ${item.category == 'TECH' ? 'selected' : ''}>TECH</option>
					<option value="COMICS"
						${item.category == 'COMICS' ? 'selected' : ''}>COMICS</option>
					<option value="FASHION"
						${item.category == 'FASHION' ? 'selected' : ''}>FASHION</option>
				</select>
			</div>

			<div class="admin-form-row">
				<label class="admin-label">짧은 문구(선택)</label>
				<textarea class="admin-textarea" name="description" rows="3"
					placeholder="(없어도 됨)">${item.description}</textarea>
			</div>

			<div class="admin-form-actions">
				<a class="admin-btn" href="${ctx}/admin/itemManageList.do">목록</a>
				<button class="admin-btn admin-btn-primary" type="submit">수정
					저장</button>
			</div>
		</form>
	</section>

	<footer>
		<jsp:include page="/include/footer.jsp" />
	</footer>

</body>
</html>
