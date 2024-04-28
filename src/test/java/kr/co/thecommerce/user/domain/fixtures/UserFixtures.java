package kr.co.thecommerce.user.domain.fixtures;

import kr.co.thecommerce.user.controller.data.UserSignUpRequest;
import kr.co.thecommerce.user.domain.User;

public class UserFixtures {

    public static User users(UserSignUpRequest signUpRequest) {
        return new User(signUpRequest);
    }

    public static UserSignUpRequest signUpRequest(String id, String password, String nickName, String name, String mobileNumber, String email) {
        return new UserSignUpRequest(id, password, nickName, name, mobileNumber, email);
    }
}
