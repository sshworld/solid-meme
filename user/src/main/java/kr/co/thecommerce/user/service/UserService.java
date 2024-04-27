package kr.co.thecommerce.user.service;

import javax.transaction.Transactional;
import kr.co.thecommerce.user.controller.data.UserSignUpRequest;
import kr.co.thecommerce.user.core.exception.ConflictException;
import kr.co.thecommerce.user.domain.User;
import kr.co.thecommerce.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;

    @Transactional
    public User signUp(UserSignUpRequest userSignUpRequest) {
        checkConflict(userSignUpRequest.getId());
        User user = new User(userSignUpRequest);

        return userRepository.save(user);
    }

    private void checkConflict(String id) {
        userRepository.findById(id).ifPresent(user -> {
            throw new ConflictException("이미 존재하는 아이디 입니다.");
        });
    }
}
