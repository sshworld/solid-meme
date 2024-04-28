# Management

### Skills

- Java 8
- Spring Boot 2.7.5
- Mysql
- Flyway

### Naming

- 회원 : User

### Fetures

- 회원 가입
- 회원 목록 조회
- 회원 정보 수정

### 애플리케이션 실행 절차

#### 환경 세팅

- Mysql
    - scheme 생성
        - the-commerce
    - url
        - localhost:3306
    - username
        - root
    - password
        - 1234

#### Local Database setup with Docker

```$ docker pull mysql```

```$ docker run --name thecommerce -e MYSQL_ROOT_PASSWORD=1234 -d -p 3306:3306 mysql:latest```

```$ docker exec -it thecommerce bash```

```# mysql -u root -p```

```비밀번호 입력```

```mysql> CREATE SCHEMA the-commerce```

#### Application 실행 순서

1. git clone
2. BootRun

#### Swagger

- localhost:8080/swagger-ui/index.html 접속 후 사용

#### 구현 및 추가 설명

- 회원 목록 조회에서 요청 파라미터로 들어가는 sort 변수명을 sortMethod로 조정하였습니다.
- 도메인에 대한 validation 검사는 도메인 내에서 이루어질 수 있도록 구성하였습니다.
- 회원 수정의 응답 부분은 [PATCH Method](https://developer.mozilla.org/en-US/docs/Web/HTTP/Methods/PATCH)의 204 status code 반환을 고려하여 응답형태를 작성하지 않았습니다.


---

- 편의를 위해 create table sql을 작성하여 코드 내 flyway로 생성될 수 있도록 하였습니다.
- 편의를 위해 일부 데이터를 삽입하는 sql문을 작성하였습니다.
- 편한 환경 설정을 위해 database username, password는 간단하게 정하였습니다.
- 추가적으로 application yml도 환경변수 사용을 안하는 등 바로 실행할 수 있도록 구성하였습니다.
