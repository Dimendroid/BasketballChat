package BasketballChat.BasketballChat.storage.user;


import BasketballChat.BasketballChat.dto.UserDto;
import BasketballChat.BasketballChat.model.user.User;

import java.util.List;

public interface UserStorage {
    User addUser(User user);
    void deleteUser(Long id);

    User getUserById(Long id);

    User updateUser(Long id, User user);

    List<User> searchUserBySurname(String surname);

    List<User> searchUserByName(String name);

    List<User> searchUserByCategoryPlayer(String categoryPlayer);
}
