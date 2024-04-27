package kr.co.thecommerce.user.service;

import javax.transaction.Transactional;
import kr.co.thecommerce.user.controller.data.UserPageRequest;
import kr.co.thecommerce.user.controller.data.UserSignUpRequest;
import kr.co.thecommerce.user.core.exception.ConflictException;
import kr.co.thecommerce.user.domain.User;
import kr.co.thecommerce.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;

    public Page<User> getUsers(UserPageRequest userPageRequest) {
        Pageable userPageable = PageRequest.of(
                userPageRequest.getOffset(),
                userPageRequest.getLimit(),
                userPageRequest.getSortMethod().getSort()
        );

        return userRepository.findAll(userPageable);
    }

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
