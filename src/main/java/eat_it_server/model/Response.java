package eat_it_server.model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Response {
    private String loginStatus;

    public Response(String loginStatus) {
        this.loginStatus = loginStatus;
    }
}
