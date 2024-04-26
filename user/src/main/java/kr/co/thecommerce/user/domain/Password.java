package kr.co.thecommerce.user.domain;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.persistence.Embeddable;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor
public class Password {

    private static final String PASSWORD_REGEX = "^(?=.*[A-Za-z])(?=.*[0-9])[A-Za-z[0-9]]{6,10}$";

    private String password;

    protected Password(String password) {
        Pattern passwordPattern = Pattern.compile(PASSWORD_REGEX);
        Matcher passwordMatcher = passwordPattern.matcher(password);

        check(passwordMatcher.matches());

        this.password = password;
    }

    private void check(boolean isMatch) {
        if (!isMatch) {
            throw new IllegalStateException("패스워드 패턴이 맞지 않습니다.");
        }
    }
}
