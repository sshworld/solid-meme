package kr.co.thecommerce.user.core.exception;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class ConflictException extends RuntimeException {

    public ConflictException(String message) {
        super(message);
    }
}
