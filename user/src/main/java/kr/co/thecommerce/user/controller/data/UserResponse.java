package kr.co.thecommerce.user.controller.data;

import java.time.LocalDateTime;
import kr.co.thecommerce.user.domain.User;
import lombok.Getter;

@Getter
public class UserResponse {

    private final String id;

    private final String password;

    private final String nickname;

    private final String name;

    private final String mobileNumber;

    private final String email;

    private final LocalDateTime createdAt;

    private final LocalDateTime updatedAt;

    public UserResponse(User user) {
        id = user.getId();
        password = user.getPassword();
        nickname = user.getNickname();
        name = user.getName();
        mobileNumber = user.getMobileNumber();
        email = user.getEmail();
        createdAt = user.getCreatedAt();
        updatedAt = user.getUpdatedAt();
    }
}
