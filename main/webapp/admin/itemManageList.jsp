<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt"%>

<c:set var="ctx" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>DECA DIVE - 상품 수정/삭제</title>

<link rel="stylesheet" href="${ctx}/resources/css/layout.css">
<link rel="stylesheet" href="${ctx}/resources/css/admin.css">
</head>
<body>

	<header>
		<jsp:include page="/include/header.jsp" />
	</header>

	<section class="admin-list-wrap">
		<div class="admin-list-header">
			<div class="admin-list-title">상품 수정 / 삭제</div>
			<div class="admin-list-sub">등록된 상품을 수정하거나 삭제할 수 있습니다.</div>
		</div>

		<table class="admin-table">
			<thead>
				<tr>
					<th class="col-no">번호</th>
					<th class="col-name">상품명</th>
					<th class="col-era">연대</th>
					<th class="col-cat">카테고리</th>
					<th class="col-price">가격</th>
					<th class="col-action">관리</th>
				</tr>
			</thead>

			<tbody>
				<c:choose>
					<c:when test="${empty itemList}">
						<tr>
							<td class="admin-empty" colspan="6">등록된 상품이 없습니다.</td>
						</tr>
					</c:when>

					<c:otherwise>
						<c:forEach var="i" items="${itemList}">
							<tr>
								<td><c:out value="${i.itemNo}" /></td>
								<td><c:out value="${i.name}" /></td>
								<td><c:out value="${i.era}" /></td>
								<td><c:out value="${i.category}" /></td>
								<td><fmt:formatNumber value="${i.price}" type="number" /> 원</td>
								<td>
									<a class="admin-btn" href="${ctx}/admin/itemEditForm.do?itemNo=${i.itemNo}">수정</a>

									<form class="admin-inline-form" action="${ctx}/admin/itemDelete.do" method="post">
										<input type="hidden" name="itemNo" value="${i.itemNo}" />
										<button class="admin-btn admin-btn-danger" type="submit">삭제</button>
									</form>
								</td>
							</tr>
						</c:forEach>
					</c:otherwise>
				</c:choose>
			</tbody>
		</table>

		<div class="admin-back-row">
			<a class="admin-back-link" href="${ctx}/admin/adminMenu.do">← 관리자 메뉴</a>
		</div>
	</section>

	<footer>
		<jsp:include page="/include/footer.jsp" />
	</footer>

</body>
</html>
