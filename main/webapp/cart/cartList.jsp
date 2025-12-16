<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt"%>
<%@ taglib prefix="fn" uri="jakarta.tags.functions"%>


<c:set var="ctx" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>장바구니 | DECA DIVE</title>

<link rel="stylesheet" href="${ctx}/resources/css/layout.css">
<link rel="stylesheet" href="${ctx}/resources/css/item.css">
<%-- 카드 느낌 유지용 --%>
<link rel="stylesheet" href="${ctx}/resources/css/cart.css">
</head>
<body>

	<header>
		<jsp:include page="/include/header.jsp" />
	</header>

	<section>
		<div class="cart-page">

			<!-- 상단 제목 + 개수 -->
			<div class="cart-header-line">
				<div class="cart-title">장바구니</div>
				<c:if test="${not empty cartList}">
					<div class="cart-count-text">
						총 <b>${fn:length(cartList)}</b>개 상품
					</div>
				</c:if>
			</div>

			<!-- 비어 있을 때 -->
			<c:if test="${empty cartList}">
				<div class="cart-empty">
					장바구니가 비어 있습니다.<br /> <a href="${ctx}/item/itemList.do"
						class="user-link">상품 보러가기</a>
				</div>
			</c:if>

			<!-- 리스트 있을 때 -->
			<c:if test="${not empty cartList}">
				<c:set var="total" value="0" />

				<div class="cart-list">
					<c:forEach var="item" items="${cartList}">
						<div class="cart-item">
							<%-- 썸네일 --%>
							<img class="cart-thumb"
								onclick="location.href='${ctx}/item/itemDetail.do?itemNo=${item.itemNo}'"
								src="${ctx}${item.imagePath}" alt="${item.itemName}" />

							<%-- 가운데 정보 --%>
							<div class="cart-item-main">
								<div class="cart-item-name">
									<c:out value="${item.itemName}" />
								</div>
								<%-- <div class="cart-item-meta">상품번호 #${item.description}</div> --%>
							</div>

							<%-- 오른쪽 수량/가격 --%>
							<div class="cart-item-qty-price">
								<div class="cart-item-qty">수량: ${item.quantity}</div>
								<div class="cart-item-price">
									단가:
									<fmt:formatNumber value="${item.price}" type="number" />
									원
								</div>
								<div class="cart-item-subtotal">
									<fmt:formatNumber value="${item.price * item.quantity}"
										type="number" />
									원
								</div>
							</div>
						</div>

						<c:set var="total" value="${total + (item.price * item.quantity)}" />
					</c:forEach>
				</div>

				<%-- 합계 박스 --%>
				<div class="cart-total-box">
					<div class="cart-total-label">총 결제 예정 금액</div>
					<div class="cart-total-price">
						<fmt:formatNumber value="${total}" type="number" />
						원
					</div>
				</div>

				<%-- 버튼들 --%>
				<div class="cart-actions">
					<a href="${ctx}/item/itemList.do" class="btn-outline">계속 쇼핑하기</a> <a
						href="${ctx}/order/checkout.do" class="btn-primary">주문하기</a>
				</div>
			</c:if>

		</div>
	</section>

	<footer>
		<jsp:include page="/include/footer.jsp" />
	</footer>

</body>
</html>
