# Spring_practice

### - XSS(Cross Site Scripting)
- 웹 애플리케이션에서 많이 나타나는 취약점의 하나로 웹사이트 관리자가 아닌 이가 웹 페이지에 악성 스크립트를 삽입할 수 있는 취약점이다.
- 주로 여러 사용자가 보게 되는 전자 게시판에 악성 스크립트가 담긴 글을 올리는 형태로 이루어진다.
- 이 취약점으로 해커가 사용자의 정보(쿠키, 세션 등)를 탈취하거나, 자동으로 비정상적인 기능을 수행하게 하거나 할 수 있다. 주로 다른 웹사이트와 정보를 교환하는 식으로 작동한다.

###### - 대응 방안 
- script문장에 존재한 특수문자를 메타캐릭터로 변환시킨다.(필터 제작) 예(#  ---- &#35, &  ---- &#38)
- Contents 구문 사용
- Replace 구문 사용(Secure coding)
- 콘텐츠 보안 정책(CSP) 사용
- 쿠키의 보안 옵션 사용

### - CSRF(Cross-Site Request Forgery)
- 웹 애플리케이션 취약점 중 하나로 사용자가 자신의 의지와 무관하게 공격자가 의도한 행동을 해서 특정 웹페이지를 보안에 취약하게 한다거나 수정, 삭제 등의 작업을 하게 만드는 공격 방법이다.
- 권한을 도용당한 클라이언트가 가짜 요청을 서버에 전송(권한 도용)

###### - 대응 방안
- csrf 토큰 사용
- 사용자와 상호 처리 기능 적용
- 재인증 요구

### - XSS vs CSRF
- xss는 공격대상이 Client이고, CSRF는 Server이다.
- xss는 사이트변조나 백도어를 통해 클라이언트에 대한 악성공격을 한다.
- csrf는 요청을 위조하여 사용자의 권한을 이용해 서버에 대한 악성공격을 한다.

---

### - 트랜잭션
- 데이터베이스에서 하나의 논리적 기능을 수행하는 연산자들의 집합이다. 즉, 사용자의 의도에 따라 여러 개의 문장으로 구성된 트랜잭션은 반드시 동시에 실행(COMMIT) 되거나 취소(ROLLBACK)된다. 트랜잭션을 통해 작업의 단위를 결정함으로써 작업 결과의 신뢰성이 확보된다.

##### - 트랜잭션의 성질
- 원자성
  - 한 트랜잭션 내에서 실행한 작업들은 하나로 간주한다. 즉, 모두 성공 또는 실패.
- 일관성
  - 트랜잭션은 일관성 있는 데이터베이스 상태를 유지한다.
- 격릭성
  - 동시에 시행되는 트랜잭션들이 서로 영향을 미치지 않도록 격리해야한다.
- 지속성
  - 트랜잭션을 성공적으로 마치면 결과가 항상 저장되어야 한다.
- commit
- rollback
- auto commit
- lock

---

### - ACID

### - JDBC

### - DI(Dependency Injection)/IOC(Inversion of Control)
- 의존성 주입/ 제어의 역전
- bean
- container

### - 스프링 AOP

### - 동기, 비동기

### - JPA

### - 함수형 프로그래밍

### - 톰켓

### - log(로그)

### - application.properties

### - Optional 클래스

### - ORM


### - Controller/RestController
- modelAndView

### - 인덱스와 작동 원리

### - N + 1 문제

### - 데이터베이스의 구분(sql vs nosql)
