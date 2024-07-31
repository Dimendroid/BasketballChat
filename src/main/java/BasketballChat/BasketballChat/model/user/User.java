package BasketballChat.BasketballChat.model.user;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.Duration;
import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@FieldDefaults(level=AccessLevel.PRIVATE)
public class User {
     Long id;
     String name;
     String surname;
     Integer weight;
     Integer height;
     LocalDate birthday;
     CategoryPlayer categoryPlayer;

     public Integer getAge(){
          return (int)Duration.between(LocalDate.now().atStartOfDay(),birthday.atStartOfDay()).toDays();
     }
}
