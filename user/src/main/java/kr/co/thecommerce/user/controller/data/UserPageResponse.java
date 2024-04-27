package kr.co.thecommerce.user.controller.data;

import java.util.List;
import kr.co.thecommerce.user.domain.SortMethod;
import kr.co.thecommerce.user.domain.User;
import lombok.Getter;
import org.springframework.data.domain.Page;

@Getter
public class UserPageResponse {

    private final long offset;

    private final long limit;

    private final SortMethod sortMethod;

    private final List<UserResponse> users;

    public UserPageResponse(Page<User> users, SortMethod sortMethod) {
        offset = users.getPageable().getOffset() / 10;
        limit = users.getPageable().getPageSize();
        this.sortMethod = sortMethod;
        this.users = users.map(UserResponse::new).toList();
    }
}
