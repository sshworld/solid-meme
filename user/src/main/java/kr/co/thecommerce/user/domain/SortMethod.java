package kr.co.thecommerce.user.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.data.domain.Sort;

@AllArgsConstructor
@Getter
public enum SortMethod {
    SUBSCRIPTION(Sort.by("createdAt").ascending()),

    NAME(Sort.by("name").ascending()),
    ;

    private final Sort sort;
}
