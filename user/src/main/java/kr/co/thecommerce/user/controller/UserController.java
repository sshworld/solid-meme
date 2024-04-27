package kr.co.thecommerce.user.controller;

import kr.co.thecommerce.user.controller.data.UserResponse;
import kr.co.thecommerce.user.controller.data.UserSignUpRequest;
import kr.co.thecommerce.user.service.UserService;
import lombok.RequiredArgsConstructor;
import static org.springframework.http.HttpStatus.CREATED;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("api/user")
@RequiredArgsConstructor
@RestController
public class UserController {

    private final UserService userService;

    @ResponseStatus(CREATED)
    @PostMapping("join")
    public UserResponse signUp(@RequestBody UserSignUpRequest userSignUpRequest) {
        return new UserResponse(userService.signUp(userSignUpRequest));
    }
}
