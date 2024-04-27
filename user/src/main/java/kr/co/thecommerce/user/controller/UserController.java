package kr.co.thecommerce.user.controller;

import javax.validation.Valid;
import kr.co.thecommerce.user.controller.data.UserPageRequest;
import kr.co.thecommerce.user.controller.data.UserPageResponse;
import kr.co.thecommerce.user.controller.data.UserResponse;
import kr.co.thecommerce.user.controller.data.UserSignUpRequest;
import kr.co.thecommerce.user.controller.data.UserUpdateRequest;
import kr.co.thecommerce.user.service.UserService;
import lombok.RequiredArgsConstructor;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.NO_CONTENT;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    @GetMapping("list")
    public UserPageResponse getUsers(@Valid UserPageRequest userPageRequest) {
        return new UserPageResponse(userService.getUsers(userPageRequest), userPageRequest.getSortMethod());
    }

    @ResponseStatus(CREATED)
    @PostMapping("join")
    public UserResponse signUp(@RequestBody UserSignUpRequest userSignUpRequest) {
        return new UserResponse(userService.signUp(userSignUpRequest));
    }

    @ResponseStatus(NO_CONTENT)
    @PatchMapping("{id}")
    public void update(@PathVariable String id, @RequestBody UserUpdateRequest userUpdateRequest) {
        userService.update(id, userUpdateRequest);
    }
}
