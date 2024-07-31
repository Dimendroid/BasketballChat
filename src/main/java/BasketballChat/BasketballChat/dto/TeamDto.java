package BasketballChat.BasketballChat.dto;

import BasketballChat.BasketballChat.model.user.User;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class TeamDto {
    Long id;
    List<User> users = new ArrayList<>();
    String name;
}
