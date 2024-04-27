package kr.co.thecommerce.user.controller.data;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class UserSignUpRequest {

    private String id;

    private String password;

    private String nickname;

    private String name;

    private String mobileNumber;

    private String email;
}
