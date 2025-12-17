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
<title>DECA DIVE - CART</title>

<link rel="stylesheet" href="${ctx}/resources/css/layout.css">
<link rel="stylesheet" href="${ctx}/resources/css/cart.css">
</head>
<body>

	<header>
		<jsp:include page="/include/header.jsp" />
	</header>

	<section class="cart-page">

		<div class="cart-header-line">
			<div class="cart-title">장바구니</div>
			<div class="cart-count-text">
				<c:out value="${fn:length(cartList)}" />
				개 상품
			</div>
		</div>

		<c:choose>
			<c:when test="${empty cartList}">
				<div class="cart-empty">
					장바구니가 비어 있습니다.
					<div>
						<a class="user-link" href="${ctx}/item/itemList.do">상품 보러가기</a>
					</div>
				</div>
			</c:when>

			<c:otherwise>

				<div class="cart-list">
					<c:set var="totalPrice" value="0" />

					<c:forEach var="c" items="${cartList}">
						<c:set var="subTotal" value="${c.price * c.quantity}" />
						<c:set var="totalPrice" value="${totalPrice + subTotal}" />

						<div class="cart-item">

							<img class="cart-thumb" src="${ctx}${c.imagePath}"
								alt="${c.itemName}" />

							<div class="cart-item-main">
								<div class="cart-item-name">
									<c:out value="${c.itemName}" />
								</div>
								<div class="cart-item-meta">
									<c:if test="${not empty c.description}">
										<c:out value="${c.description}" />
									</c:if>
								</div>
							</div>

							<div class="cart-item-qty-price">
								<div class="cart-item-price">
									단가:
									<fmt:formatNumber value="${c.price}" type="number" />
									원
								</div>

								<%-- 수량 변경 (CART-004) --%>
								<form class="qty-form" action="${ctx}/cart/cartUpdateQty.do"
									method="post">
									<input type="hidden" name="cartItemNo" value="${c.cartItemNo}" />
									<input class="qty-input" type="number" name="quantity" min="1"
										value="${c.quantity}" />
									<button class="qty-btn" type="submit">변경</button>
								</form>

								<div class="cart-item-subtotal">
									합계:
									<fmt:formatNumber value="${subTotal}" type="number" />
									원
								</div>

								<%-- 삭제 (CART-003) --%>
								<form class="del-form" action="${ctx}/cart/cartDelete.do"
									method="post">
									<input type="hidden" name="cartItemNo" value="${c.cartItemNo}" />
									<button class="del-btn" type="submit">삭제</button>
								</form>
							</div>

						</div>
					</c:forEach>
				</div>

				<div class="cart-total-box">
					<div class="cart-total-label">총 결제금액</div>
					<div class="cart-total-price">
						<fmt:formatNumber value="${totalPrice}" type="number" />
						원
					</div>
				</div>

				<div class="cart-actions">
					<%-- 비우기 (CART-005) --%>
					<form id="cartClearForm" action="${ctx}/cart/cartClear.do"
						method="post">
						<button class="btn-outline" type="submit">비우기</button>
					</form>

					<%-- 주문은 나중에 연결 --%>
					<a class="btn-primary" href="${ctx}/order/orderForm.do">주문하기</a>
				</div>

			</c:otherwise>
		</c:choose>

	</section>

	<footer>
		<jsp:include page="/include/footer.jsp" />
	</footer>
	<script src="${ctx}/resources/js/cart.js"></script>
</body>
</html>
