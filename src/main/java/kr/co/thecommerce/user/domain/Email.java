package kr.co.thecommerce.user.domain;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.persistence.Embeddable;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor
public class Email {

    private static final String EMAIL_REGEX = "^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$";

    private String email;

    protected Email(String email) {
        Pattern emailPattern = Pattern.compile(EMAIL_REGEX);
        Matcher emailMatcher = emailPattern.matcher(email);

        check(emailMatcher.matches());

        this.email = email;
    }

    private void check(boolean isMatch) {
        if (!isMatch) {
            throw new IllegalStateException("이메일 패턴이 맞지 않습니다.");
        }
    }
}
