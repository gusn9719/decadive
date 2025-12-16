<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt"%>

<c:set var="ctx" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>데카 다이브 - 상품 리스트</title>

<link rel="stylesheet" href="${ctx}/resources/css/layout.css">
<link rel="stylesheet" href="${ctx}/resources/css/item.css">
</head>
<body>
	<header>
		<jsp:include page="/include/header.jsp" />
	</header>

	<section class="item-page">

		<!-- ===== 제목 : 선택된 연대에 따라 텍스트 변경 ===== -->
		<c:choose>
			<c:when test="${empty param.era}">
				<div class="item-page-title">전체 상품</div>
			</c:when>
			<c:otherwise>
				<div class="item-page-title">${param.era}상품</div>
			</c:otherwise>
		</c:choose>

		<!-- ===== 필터 패널 (ERA + CATEGORY 같이) ===== -->
		<div class="item-filter-panel">

			<!-- ERA -->
			<div class="filter-row">
				<span class="filter-label-pill">ERA</span>

				<div class="filter-chips">
					<c:url var="eraAllUrl" value="/item/itemList.do" />
					<a href="${eraAllUrl}"
						class="filter-chip ${empty param.era ? 'active' : ''}"> ALL </a>

					<c:url var="era80Url" value="/item/itemList.do">
						<c:param name="era" value="80s" />
						<c:if test="${not empty param.category}">
							<c:param name="category" value="${param.category}" />
						</c:if>
					</c:url>
					<a href="${era80Url}"
						class="filter-chip ${param.era == '80s' ? 'active' : ''}"> 80s
					</a>

					<c:url var="era90Url" value="/item/itemList.do">
						<c:param name="era" value="90s" />
						<c:if test="${not empty param.category}">
							<c:param name="category" value="${param.category}" />
						</c:if>
					</c:url>
					<a href="${era90Url}"
						class="filter-chip ${param.era == '90s' ? 'active' : ''}"> 90s
					</a>

					<c:url var="era00Url" value="/item/itemList.do">
						<c:param name="era" value="00s" />
						<c:if test="${not empty param.category}">
							<c:param name="category" value="${param.category}" />
						</c:if>
					</c:url>
					<a href="${era00Url}"
						class="filter-chip ${param.era == '00s' ? 'active' : ''}"> 00s
					</a>
				</div>
			</div>

			<!-- CATEGORY -->
			<div class="filter-row">
				<span class="filter-label-pill">CATEGORY</span>

				<div class="filter-chips">
					<!-- 공통 베이스 URL (era 유지) -->
					<c:url var="categoryBaseUrl" value="/item/itemList.do">
						<c:if test="${not empty param.era}">
							<c:param name="era" value="${param.era}" />
						</c:if>
					</c:url>

					<!-- ALL -->
					<a href="${categoryBaseUrl}"
						class="filter-chip ${empty param.category ? 'active' : ''}">
						ALL </a>

					<!-- WALL -->
					<c:url var="wallUrl" value="/item/itemList.do">
						<c:if test="${not empty param.era}">
							<c:param name="era" value="${param.era}" />
						</c:if>
						<c:param name="category" value="WALL" />
					</c:url>
					<a href="${wallUrl}"
						class="filter-chip ${param.category == 'WALL' ? 'active' : ''}">
						WALL </a>

					<!-- DESK -->
					<c:url var="deskUrl" value="/item/itemList.do">
						<c:if test="${not empty param.era}">
							<c:param name="era" value="${param.era}" />
						</c:if>
						<c:param name="category" value="DESK" />
					</c:url>
					<a href="${deskUrl}"
						class="filter-chip ${param.category == 'DESK' ? 'active' : ''}">
						DESK </a>

					<!-- TECH -->
					<c:url var="techUrl" value="/item/itemList.do">
						<c:if test="${not empty param.era}">
							<c:param name="era" value="${param.era}" />
						</c:if>
						<c:param name="category" value="TECH" />
					</c:url>
					<a href="${techUrl}"
						class="filter-chip ${param.category == 'TECH' ? 'active' : ''}">
						TECH </a>

					<!-- COMICS -->
					<c:url var="comicsUrl" value="/item/itemList.do">
						<c:if test="${not empty param.era}">
							<c:param name="era" value="${param.era}" />
						</c:if>
						<c:param name="category" value="COMICS" />
					</c:url>
					<a href="${comicsUrl}"
						class="filter-chip ${param.category == 'COMICS' ? 'active' : ''}">
						COMICS </a>

					<!-- FASHION -->
					<c:url var="fashionUrl" value="/item/itemList.do">
						<c:if test="${not empty param.era}">
							<c:param name="era" value="${param.era}" />
						</c:if>
						<c:param name="category" value="FASHION" />
					</c:url>
					<a href="${fashionUrl}"
						class="filter-chip ${param.category == 'FASHION' ? 'active' : ''}">
						FASHION </a>
				</div>
			</div>
		</div>

		<!-- ===== 상품 카드 리스트 ===== -->
		<div class="item-list">
			<c:forEach var="item" items="${itemList}">
				<div class="item-card"
					onclick="location.href='${ctx}/item/itemDetail.do?itemNo=${item.itemNo}'">

					<img class="item-thumb" src="${ctx}${item.imagePath}"
						alt="${item.name}" />

					<div class="item-text">
						<div class="item-name">
							<c:out value="${item.name}" />
						</div>
						<div class="item-meta">${item.era}· ${item.category}</div>
						<div class="item-price">
							<fmt:formatNumber value="${item.price}" type="number" />
							원
						</div>
					</div>
				</div>
			</c:forEach>
		</div>
	</section>

	<footer>
		<jsp:include page="/include/footer.jsp" />
	</footer>
</body>
</html>
