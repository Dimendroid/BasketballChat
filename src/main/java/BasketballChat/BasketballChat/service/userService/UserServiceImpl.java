package BasketballChat.BasketballChat.service.userService;

import BasketballChat.BasketballChat.dto.UserDto;
import BasketballChat.BasketballChat.mapper.UserMapper;
import BasketballChat.BasketballChat.model.user.User;
import BasketballChat.BasketballChat.storage.user.UserStorage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    private final UserStorage userStorage;

    @Autowired
    public UserServiceImpl(UserStorage userStorage) {
        this.userStorage = userStorage;
    }

    @Override
    public UserDto addUser(UserDto userDto) {
        User user = UserMapper.userDtoToUser(userDto);
        return UserMapper.userToUserDto(userStorage.addUser(user));
    }

    @Override
    public void deleteUser(Long id) {
        userStorage.deleteUser(id);
    }

    @Override
    public UserDto getUserById(Long id) {
        return UserMapper.userToUserDto(userStorage.getUserById(id));
    }

    @Override
    public UserDto updateUser(Long id, UserDto userDto) {
        User user = UserMapper.userDtoToUser(userDto);
        return UserMapper.userToUserDto(user);
    }


    @Override
    public List<UserDto> searchUser(String surname, String name, String categoryPlayer) {
        List<UserDto> list = new ArrayList<>();
        if (surname != null) {
            list.addAll(UserMapper.ListUserToListUserDto(userStorage.searchUserBySurname(surname)));
        }
        if (name != null && list.isEmpty()) {
            list.addAll(UserMapper.ListUserToListUserDto(userStorage.searchUserByName(name)));
        } else if (name != null) {
            List<UserDto> temp = list.stream().filter(
                    a -> a.getName().equalsIgnoreCase(name)).toList();
            list.clear();
            list.addAll(temp);
        }
        if (categoryPlayer != null && list.isEmpty()) {
            list.addAll(UserMapper.ListUserToListUserDto(userStorage.searchUserByCategoryPlayer(categoryPlayer)));
        } else if (categoryPlayer != null) {
            List<UserDto> temp = list.stream().filter(
                    a -> a.getCategoryPlayer().toString().equalsIgnoreCase(categoryPlayer)).toList();
            list.clear();
            list.addAll(temp);
        }
        return list.stream().distinct().collect(Collectors.toList());
    }
}