package kr.co.thecommerce.user.domain;

import kr.co.thecommerce.user.controller.data.UserSignUpRequest;
import static kr.co.thecommerce.user.domain.fixtures.UserFixtures.signUpRequest;
import static kr.co.thecommerce.user.domain.fixtures.UserFixtures.users;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

public class UserTest {

    @Test
    void 유저생성테스트_잘못된_비밀번호() {
        // 유저 정보가 주어졌을 때
        String id = "honggildong";
        String nickname = "홍박사님을 아세요";
        String name = "홍길동";

        // 비밀번호 정보가 올바르지 않으면
        String password = "hong";
        String mobileNumber = "010-1234-5678";
        String email = "hong@gmail.com";

        UserSignUpRequest signUpRequest = signUpRequest(id, password, nickname, name, mobileNumber, email);

        // IllegalStateException을 리턴한다.
        final IllegalStateException exception = assertThrows(IllegalStateException.class, () -> users(signUpRequest));

        assertThat(exception.getMessage()).isEqualTo("패스워드 패턴이 맞지 않습니다.");
    }

    @Test
    void 유저생성테스트_잘못된_전화번호() {
        // 유저 정보가 주어졌을 때
        String id = "honggildong";
        String nickname = "홍박사님을 아세요";
        String name = "홍길동";

        // 비밀번호 정보가 올바르지 않으면
        String password = "hong1234";
        String mobileNumber = "01012345678";
        String email = "hong@gmail.com";

        UserSignUpRequest signUpRequest = signUpRequest(id, password, nickname, name, mobileNumber, email);

        // IllegalStateException을 리턴한다.
        final IllegalStateException exception = assertThrows(IllegalStateException.class, () -> users(signUpRequest));

        assertThat(exception.getMessage()).isEqualTo("전화번호 패턴이 맞지 않습니다.");
    }

    @Test
    void 유저생성테스트_잘못된_이메일() {
        // 유저 정보가 주어졌을 때
        String id = "honggildong";
        String nickname = "홍박사님을 아세요";
        String name = "홍길동";

        // 비밀번호 정보가 올바르지 않으면
        String password = "hong1234";
        String mobileNumber = "010-1234-5678";
        String email = "hong.gmail.com";

        UserSignUpRequest signUpRequest = signUpRequest(id, password, nickname, name, mobileNumber, email);

        // IllegalStateException을 리턴한다.
        final IllegalStateException exception = assertThrows(IllegalStateException.class, () -> users(signUpRequest));

        assertThat(exception.getMessage()).isEqualTo("이메일 패턴이 맞지 않습니다.");
    }

    @Test
    void 유저생성테스트() {
        // 유저 정보가 주어졌을 때
        String id = "honggildong";
        String nickname = "홍박사님을 아세요";
        String name = "홍길동";

        // 비밀번호 정보가 올바르지 않으면
        String password = "hong1234";
        String mobileNumber = "010-1234-5678";
        String email = "hong@gmail.com";

        UserSignUpRequest signUpRequest = signUpRequest(id, password, nickname, name, mobileNumber, email);

        // 유저가 정상적으로 생성된다.
        final User user = users(signUpRequest);

        assertThat(user.getNickname()).isEqualTo("홍박사님을 아세요");
        assertThat(user.getName()).isEqualTo("홍길동");
        assertThat(user.getPassword()).isEqualTo("hong1234");
        assertThat(user.getMobileNumber()).isEqualTo("010-1234-5678");
        assertThat(user.getEmail()).isEqualTo("hong@gmail.com");
    }
}
