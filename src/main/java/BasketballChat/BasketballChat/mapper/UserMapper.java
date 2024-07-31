package BasketballChat.BasketballChat.mapper;

import BasketballChat.BasketballChat.dto.UserDto;
import BasketballChat.BasketballChat.model.user.User;
import lombok.experimental.UtilityClass;

import java.util.List;
import java.util.stream.Collectors;

@UtilityClass
public class UserMapper {
    public UserDto userToUserDto(User user) {
        return new UserDto(user.getId(),
                user.getName(),
                user.getSurname(),
                user.getWeight(),
                user.getHeight(),
                user.getBirthday(),
                user.getCategoryPlayer());
    }

    public User userDtoToUser(UserDto userDto) {
        return new User(userDto.getId(),
                userDto.getName(),
                userDto.getSurname(),
                userDto.getWeight(),
                userDto.getHeight(),
                userDto.getBirthday(),
                userDto.getCategoryPlayer());
    }

    public List<User> ListUserDtoToListUser(List<UserDto> userDtoList) {
        return userDtoList.stream().map(UserMapper::userDtoToUser).collect(Collectors.toList());
    }

    public List<UserDto> ListUserToListUserDto(List<User> userList) {
        return userList.stream().map(UserMapper::userToUserDto).collect(Collectors.toList());
    }
}
