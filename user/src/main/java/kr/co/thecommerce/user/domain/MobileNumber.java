package kr.co.thecommerce.user.domain;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.persistence.Embeddable;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor
public class MobileNumber {

    private static final String MOBILE_NUMBER_REGEX = "^01(?:0|1)-(\\\\d{4})-(\\\\d{4})";

    private String mobileNumber;

    protected MobileNumber(String mobileNumber) {
        Pattern mobileNumberPattern = Pattern.compile(MOBILE_NUMBER_REGEX);
        Matcher mobileNumberMatcher = mobileNumberPattern.matcher(mobileNumber);

        check(mobileNumberMatcher.matches());

        this.mobileNumber = mobileNumber;
    }

    private void check(boolean isMatch) {
        if (!isMatch) {
            throw new IllegalStateException("전화번호 패턴이 맞지 않습니다.");
        }
    }
}
