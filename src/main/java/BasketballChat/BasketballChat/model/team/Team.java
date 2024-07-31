package BasketballChat.BasketballChat.model.team;

import BasketballChat.BasketballChat.model.user.User;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Team {
    Long id;
    List<User> users = new ArrayList<>();
//    Map<Long,User> users=new HashMap<>();
    String name;

}
