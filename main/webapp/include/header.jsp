<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>

<c:set var="ctx" value="${pageContext.request.contextPath}" />

<header class="site-header">
	<!-- 로고 -->
	<div class="logo-area">
		<a href="${ctx}/item/itemList.do" class="logo"> DECA<span>DIVE</span>
		</a>
	</div>

	<!-- 연대 GNB -->
	<nav class="gnb">
		<a href="${ctx}/item/itemList.do" class="gnb-link">ALL</a> <a
			href="${ctx}/item/itemList.do?era=80s" class="gnb-link">80s</a> <a
			href="${ctx}/item/itemList.do?era=90s" class="gnb-link">90s</a> <a
			href="${ctx}/item/itemList.do?era=00s" class="gnb-link">00s</a>
	</nav>

	<!-- 검색 + 유저 메뉴 -->
	<div class="header-right">

		<!-- 검색 박스 -->
		<form action="${ctx}/item/itemList.do" method="get" class="search-box">
			<input type="text" name="keyword" placeholder="상품명으로 검색" />
			<button type="submit">검색</button>
		</form>

		<!-- 로그인/로그아웃/장바구니/관리자 -->
		<div class="user-menu">
			<c:choose>
				<%-- 로그인 안 한 경우 --%>
				<c:when test="${empty sessionScope.loginMember}">
					<span class="user-state">Guest</span>
					<a href="${ctx}/cart/cartList.do" class="user-link">장바구니</a>
					<a href="${ctx}/member/loginForm.do" class="user-link">로그인</a>
					<a href="${ctx}/member/registerForm.do" class="user-link">회원가입</a>
				</c:when>

				<%-- 로그인 한 경우 --%>
				<c:otherwise>
					<c:set var="loginMember" value="${sessionScope.loginMember}" />

					<%-- 장바구니 --%>
					<a href="${ctx}/cart/cartList.do" class="user-link">장바구니</a>

					<%-- 일반 회원 / 관리자 이름 영역 --%>
					<c:choose>
						<%-- 관리자 --%>
						<c:when test="${loginMember.type == 1}">
							<a href="${ctx}/admin/adminMenu.do" class="user-link admin">관리자</a>
						</c:when>

						<%-- 일반 회원 --%>
						<c:otherwise>
							<a href="${ctx}/member/mypage.do" class="user-link">
								${loginMember.name} </a>
						</c:otherwise>
					</c:choose>

					<%-- 공통 로그아웃 --%>
					<a href="${ctx}/member/logout.do" class="user-link">로그아웃</a>
				</c:otherwise>
			</c:choose>
		</div>
	</div>
</header>
