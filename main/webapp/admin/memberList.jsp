<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>

<c:set var="ctx" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>DECA DIVE - 회원 목록</title>

<link rel="stylesheet" href="${ctx}/resources/css/layout.css">
<link rel="stylesheet" href="${ctx}/resources/css/admin.css">
</head>
<body>

	<header>
		<jsp:include page="/include/header.jsp" />
	</header>

	<section class="admin-card admin-page">
		<h2 class="admin-title">회원 목록</h2>

		<div class="admin-table-wrap">
			<table class="admin-table admin-member-table">
				<thead>
					<tr>
						<th class="col-id">ID</th>
						<th class="col-name">이름</th>
						<th class="col-email">이메일</th>
						<th class="col-phone">전화번호</th>
						<th class="col-type">구분</th>
						<th class="col-date">가입일</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="m" items="${memberList}">
						<tr>
							<td class="col-id"><c:out value="${m.id}" /></td>
							<td class="col-name"><c:out value="${m.name}" /></td>
							<td class="col-email"><c:out value="${m.email}" /></td>
							<td class="col-phone"><c:out value="${m.phone}" /></td>
							<td class="col-type"><c:choose>
									<c:when test="${m.type == 1}">
										<span class="admin-role">관리자</span>
									</c:when>
									<c:otherwise>일반</c:otherwise>
								</c:choose></td>
							<td class="col-date"><c:out value="${m.regDate}" /></td>
						</tr>
					</c:forEach>

					<c:if test="${empty memberList}">
						<tr>
							<td colspan="6" class="admin-empty">회원이 없습니다.</td>
						</tr>
					</c:if>
				</tbody>
			</table>
		</div>
	</section>

	<footer>
		<jsp:include page="/include/footer.jsp" />
	</footer>

</body>
</html>
