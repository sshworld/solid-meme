package kr.co.thecommerce.user.domain;

import java.time.LocalDateTime;
import static java.time.LocalDateTime.now;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import kr.co.thecommerce.user.controller.data.UserSignUpRequest;
import kr.co.thecommerce.user.controller.data.UserUpdateRequest;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

@Entity(name = "users")
@Getter
@NoArgsConstructor
public class User {

    @Id
    private String id;

    @Embedded
    private Password password;

    private String nickname;

    private String name;

    @Embedded
    private MobileNumber mobileNumber;

    @Embedded
    private Email email;

    @CreatedDate
    private LocalDateTime createdAt;

    @LastModifiedDate
    private LocalDateTime updatedAt;

    public User(UserSignUpRequest userSignUpRequest) {
        id = userSignUpRequest.getId();
        password = new Password(userSignUpRequest.getPassword());
        nickname = userSignUpRequest.getNickname();
        name = userSignUpRequest.getName();
        mobileNumber = new MobileNumber(userSignUpRequest.getMobileNumber());
        email = new Email(userSignUpRequest.getEmail());
        createdAt = now();
    }

    public void update(UserUpdateRequest userUpdateRequest) {
        password = userUpdateRequest.getPassword() == null ? password : new Password(userUpdateRequest.getPassword());
        nickname = userUpdateRequest.getNickname() == null ? nickname : userUpdateRequest.getNickname();
        name = userUpdateRequest.getName() == null ? name : userUpdateRequest.getName();
        mobileNumber = userUpdateRequest.getMobileNumber() == null ? mobileNumber : new MobileNumber(userUpdateRequest.getMobileNumber());
        email = userUpdateRequest.getEmail() == null ? email : new Email(userUpdateRequest.getEmail());
        updatedAt = now();
    }

    public String getPassword() {
        return password.getPassword();
    }

    public String getMobileNumber() {
        return mobileNumber.getMobileNumber();
    }

    public String getEmail() {
        return email.getEmail();
    }
}
