package BasketballChat.BasketballChat.model.game;

import lombok.*;
import lombok.experimental.FieldDefaults;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Game {
    Long id;
    LocalDateTime date;
    String address;
    SkillPlayer skillPlayer;
    Mode mode;
}
