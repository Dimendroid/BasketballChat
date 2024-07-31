package BasketballChat.BasketballChat.service.userService;

import BasketballChat.BasketballChat.dto.UserDto;
import BasketballChat.BasketballChat.model.user.User;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;


public interface UserService {
    UserDto addUser(UserDto userDto);
    void deleteUser(Long id);

    UserDto getUserById(Long id);

    UserDto updateUser(Long id, UserDto userDto);
    List<UserDto> searchUser(String surname, String name, String categoryPlayer);
}
