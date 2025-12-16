// member.js

// -----------------------------
// 1) 서버에서 내려준 "첫 에러 필드" 포커스 (기존 기능 유지)
// -----------------------------
(function() {
	window.addEventListener('load', function() {
		var body = document.body;
		if (!body) return;

		var fieldName = body.getAttribute('data-first-error');
		if (!fieldName) return;

		var form = document.forms['registerForm'];
		if (!form) return;

		var field = form[fieldName];
		if (!field || typeof field.focus !== 'function') return;

		field.focus();
		if (typeof field.select === 'function') {
			field.select();   // 기존 값 있으면 전체 선택해서 수정 편하게
		}
	});
})();

// -----------------------------
// 2) 회원가입 폼 클라이언트 유효성 검사
//    - 아이디/비밀번호/이메일/전화번호 다 여기서 1차로 걸러줌
//    - 서버는 주로 "아이디 중복" 최종 체크용
// -----------------------------

// 모든 에러 초기화
function clearFormErrors(form) {
	// 에러 문구 비우기
	var errorElems = form.querySelectorAll('.form-error');
	errorElems.forEach(function(el) {
		el.textContent = '';
	});

	// 에러 테두리 제거
	var errorFields = form.querySelectorAll('.field-error');
	errorFields.forEach(function(field) {
		field.classList.remove('field-error');
	});
}

// 특정 필드에 에러 표시
function setFieldError(form, fieldName, message) {
	var field = form.elements[fieldName];
	if (!field) return;

	field.classList.add('field-error');

	// 바로 다음/다음다음 형제 중 .form-error 를 찾는다
	var errorEl = field.nextElementSibling;
	while (errorEl && !errorEl.classList.contains('form-error')) {
		errorEl = errorEl.nextElementSibling;
	}

	// 없으면 새로 생성
	if (!errorEl) {
		errorEl = document.createElement('div');
		errorEl.className = 'form-error';
		field.parentNode.insertBefore(errorEl, field.nextSibling);
	}

	errorEl.textContent = message;
}

// onsubmit 에서 호출할 함수
function validateRegisterForm(e) {
	var form = e && e.target && e.target.tagName === 'FORM'
		? e.target
		: document.forms['registerForm'];

	if (!form) return true;

	clearFormErrors(form);

	var id = form.id.value.trim();
	var password = form.password.value;
	var passwordCheck = form.passwordCheck.value;
	var name = form.name.value.trim();
	var email = form.email.value.trim();
	var phone = form.phone.value.trim();

	var hasError = false;
	var firstErrorField = null;

	function addError(fieldName, message) {
		hasError = true;
		if (!firstErrorField) firstErrorField = fieldName;
		setFieldError(form, fieldName, message);
	}

	// 아이디: 영소문자 + 숫자 4~20자
	if (!id) {
		addError('id', '아이디를 입력해주세요.');
	} else if (!/^[a-z0-9]{4,20}$/.test(id)) {
		addError('id', '아이디는 영소문자, 숫자 4~20자로 입력해주세요.');
	}

	// 비밀번호: 8~20자
	if (!password) {
		addError('password', '비밀번호를 입력해주세요.');
	} else if (password.length < 8 || password.length > 20) {
		addError('password', '비밀번호는 8~20자여야 합니다.');
	}

	// 비밀번호 확인
	if (!passwordCheck) {
		addError('passwordCheck', '비밀번호 확인을 입력해주세요.');
	} else if (password && password !== passwordCheck) {
		addError('passwordCheck', '비밀번호가 일치하지 않습니다.');
	}

	// 이름
	if (!name) {
		addError('name', '이름을 입력해주세요.');
	}

	// 이메일 (선택 입력, 있으면 형식 체크)
	if (email && !/^[^@\s]+@[^@\s]+\.[^@\s]+$/.test(email)) {
		addError('email', '이메일 형식이 올바르지 않습니다.');
	}

	// 전화번호 (선택 입력, 있으면 숫자 7~12자리)
	// 전화번호 (필수)
	if (!phone) {
		addError('phone', '전화번호를 입력해주세요.');
	} else if (!/^[0-9]{7,12}$/.test(phone)) {
		addError('phone', '전화번호는 숫자 7~12자리로 입력해주세요.');
	}


	if (hasError) {
		if (firstErrorField && form[firstErrorField]) {
			form[firstErrorField].focus();
		}
		if (e && typeof e.preventDefault === 'function') {
			e.preventDefault();   // 서버 전송 막기
		}
		return false;
	}

	// 여기까지 통과하면 서버로 submit (아이디 중복 등 최종 체크)
	return true;
}

// 전역에 노출 (onsubmit 에서 쓸 수 있게)
window.validateRegisterForm = validateRegisterForm;
