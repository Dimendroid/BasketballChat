package BasketballChat.BasketballChat.dto;

import BasketballChat.BasketballChat.model.game.Mode;
import BasketballChat.BasketballChat.model.game.SkillPlayer;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@FieldDefaults(level = AccessLevel.PRIVATE)
public class GameDto {
    Long id;
    LocalDateTime date;
    String address;
    SkillPlayer skillPlayer;
    Mode mode;
}
