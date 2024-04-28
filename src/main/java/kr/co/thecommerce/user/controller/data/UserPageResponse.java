package kr.co.thecommerce.user.controller.data;

import java.util.List;
import kr.co.thecommerce.user.domain.SortMethod;
import kr.co.thecommerce.user.domain.User;
import lombok.Getter;
import org.springframework.data.domain.Page;

@Getter
public class UserPageResponse {

    private final int page;

    private final int pageSize;

    private final SortMethod sortMethod;

    private final List<UserResponse> users;

    public UserPageResponse(Page<User> users, SortMethod sortMethod) {
        page = users.getPageable().getPageNumber();
        pageSize = users.getPageable().getPageSize();
        this.sortMethod = sortMethod;
        this.users = users.map(UserResponse::new).toList();
    }
}
