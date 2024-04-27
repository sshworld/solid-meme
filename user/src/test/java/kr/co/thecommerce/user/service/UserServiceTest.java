package kr.co.thecommerce.user.service;

import java.util.List;
import javax.transaction.Transactional;
import kr.co.thecommerce.user.controller.data.UserSignUpRequest;
import kr.co.thecommerce.user.domain.User;
import static kr.co.thecommerce.user.domain.fixtures.UserFixtures.signUpRequest;
import kr.co.thecommerce.user.repository.UserRepository;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@ActiveProfiles("test")
@SpringBootTest
public class UserServiceTest {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceTest(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Test
    @Transactional
    void 유저생성_테스트() {
        // 회원 정보를 입력하고
        String id = "honggildong";
        String nickname = "홍박사님을 아세요";
        String name = "홍길동";
        String password = "hong1234";
        String mobileNumber = "010-1234-5678";
        String email = "hong@gmail.com";

        UserSignUpRequest signUpRequest = signUpRequest(id, password, nickname, name, mobileNumber, email);

        UserService userService = new UserService(userRepository);

        // 유저를 생성한다면
        userService.signUp(signUpRequest);

        // 정상적으로 유저가 생성된다.
        List<User> users = userRepository.findAll();

        assertThat(users.size()).isEqualTo(1);
        assertThat(users.get(0).getId()).isEqualTo("honggildong");
    }
}
