# decadive

80~90년대 레트로/뉴트로 굿즈를 파는 쇼핑몰 웹 애플리케이션입니다. 1학년 2학기 기말 웹 프로젝트로, Spring 같은 프레임워크 없이 **서블릿 기반 MVC 프레임워크를 직접 구현**하여 상품 조회부터 장바구니, 회원 관리, 관리자 페이지까지의 전체 흐름을 만들었습니다.

## 주요 기능

- **상품**: 카테고리(80s/90s × comics/desk/fashion/tech/wall)별 목록/상세 조회
- **회원**: 회원가입, 로그인/로그아웃, 마이페이지
- **장바구니**: 담기, 목록 조회, 수량 변경, 삭제, 비우기
- **관리자**: 상품 등록/수정/삭제, 상품 관리 목록, 회원 목록, 주문 관리

## 기술 스택

| 영역 | 스택 |
|---|---|
| Language | Java |
| Web | Servlet, JSP, JSTL |
| MVC | 직접 구현한 Front Controller 패턴 (`DispatcherServlet` → `HandlerMapping` → `Controller`) |
| Persistence | MyBatis |
| DB | Oracle |

## 아키텍처 메모

일반적으로 Spring MVC가 대신 처리해주는 요청 라우팅을 `DispatcherServlet`, `HandlerMapping`, `Controller` 인터페이스로 직접 구성했습니다. URL과 컨트롤러의 매핑은 `bean.properties`에 다음과 같이 등록합니다.

```properties
/item/itemList.do   = kr.ac.kopo.item.controller.ItemListController
/cart/add.do        = kr.ac.kopo.cart.controller.CartAddController
/member/login.do    = kr.ac.kopo.member.controller.MemberLoginProcessController
```

`DispatcherServlet`이 들어오는 요청 URL을 이 매핑 정보로 찾아 해당 컨트롤러에 위임하고, 각 도메인(item/cart/member/admin)은 `controller → service → dao(mybatis) → vo` 계층으로 분리되어 있습니다.

## 실행 방법

1. Oracle DB 인스턴스 준비 후 접속 정보를 MyBatis 설정(`main/java/mybatis/config/mybatis-config.xml`)에 맞게 입력
2. Tomcat 등 서블릿 컨테이너에 WAR로 배포
3. `main/webapp/index.jsp`로 접속
