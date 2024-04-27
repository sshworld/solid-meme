package kr.co.thecommerce.user.controller.data;

import lombok.Getter;

@Getter
public class UserUpdateRequest {

    private String password;

    private String nickname;

    private String name;

    private String mobileNumber;

    private String email;
}
