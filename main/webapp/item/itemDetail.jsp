<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<c:set var="ctx" value="${pageContext.request.contextPath}" />
<c:set var="item" value="${item}" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${item.name} | DECA DIVE</title>

<link rel="stylesheet" href="${ctx}/resources/css/layout.css">
<link rel="stylesheet" href="${ctx}/resources/css/item.css">
</head>
<body>
<header>
    <jsp:include page="/include/header.jsp" />
</header>

<section class="item-detail-section">

    <div class="item-detail-main">

        <!-- ========== 이미지 카드 ========== -->
        <div class="item-detail-image">
            <img src="${ctx}${item.imagePath}" alt="${item.name}">
        </div>

        <!-- ========== 정보 영역 ========== -->
        <div class="item-detail-info">

            <div class="item-detail-meta">
                <span class="meta-era">${item.era}</span>
                <span class="meta-dot">•</span>
                <span class="meta-category">${item.category}</span>
            </div>

            <h2 class="item-detail-name">${item.name}</h2>

            <div class="item-detail-price">
                <strong><c:out value="${item.price}" /></strong> 원
            </div>

            <!-- 수량 + 버튼 -->
            <form action="${ctx}/cart/add.do" method="post" class="item-detail-form">
                <input type="hidden" name="itemNo" value="${item.itemNo}" />

                <div class="item-detail-qty-row">
                    <span class="qty-label">수량</span>

                    <div class="qty-control">
                        <button type="button" class="qty-btn" onclick="changeQty(-1)">-</button>
                        <input type="number" id="qty" name="quantity" value="1" min="1">
                        <button type="button" class="qty-btn" onclick="changeQty(1)">+</button>
                    </div>
                </div>

                <div class="item-detail-actions">
                    <button type="submit" class="btn-cart">장바구니</button>
                    <button type="button" class="btn-buy" onclick="alert('결제는 추후 구현 예정입니다');">
                        바로 구매
                    </button>
                </div>
            </form>

        </div>
    </div>

    <!-- 아래 한 줄 설명 -->
    <div class="item-detail-desc">
        <p>
            <c:out value="${item.description}" />
        </p>
    </div>

</section>

<footer>
    <jsp:include page="/include/footer.jsp" />
</footer>

<script>
function changeQty(delta) {
    const input = document.getElementById('qty');
    let v = parseInt(input.value || '1', 10);
    v = v + delta;
    if (v < 1) v = 1;
    input.value = v;
}
</script>

</body>
</html>
