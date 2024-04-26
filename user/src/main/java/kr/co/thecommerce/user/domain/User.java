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
}
