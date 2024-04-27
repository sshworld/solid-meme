package kr.co.thecommerce.user.controller.data;

import javax.validation.constraints.Min;
import kr.co.thecommerce.user.domain.SortMethod;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class UserPageRequest {

    @Min(0)
    private int offset;

    @Min(1)
    private int limit;

    private SortMethod sortMethod;
}
