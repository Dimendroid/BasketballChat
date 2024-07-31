package BasketballChat.BasketballChat.dto;

import BasketballChat.BasketballChat.model.user.CategoryPlayer;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@EqualsAndHashCode
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserDto {
    Long id;
    String name;
    String surname;
    Integer weight;
    Integer height;
    LocalDate birthday;
    CategoryPlayer categoryPlayer;
}
