window.addEventListener('DOMContentLoaded', () => {
	const clearForm = document.querySelector('#cartClearForm');
	if (clearForm) {
		clearForm.addEventListener('submit', (e) => {
			if (!confirm('장바구니를 비우시겠습니까?')) e.preventDefault();
		});
	}

	document.querySelectorAll('.del-form').forEach((form) => {
		form.addEventListener('submit', (e) => {
			if (!confirm('이 상품을 삭제하시겠습니까?')) e.preventDefault();
		});
	});
});
