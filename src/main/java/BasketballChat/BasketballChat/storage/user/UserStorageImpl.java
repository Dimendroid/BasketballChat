package BasketballChat.BasketballChat.storage.user;

import BasketballChat.BasketballChat.exception.UserNotFoundException;
import BasketballChat.BasketballChat.model.user.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
@Slf4j
public class UserStorageImpl implements UserStorage {
    private Map<Long, User> users = new HashMap<>();
    private Long idGen = 1L;

    @Override
    public User addUser(User user) {
        user.setId(idGen);
        users.put(idGen, user);
        idGen++;
        log.info("user c id {} успешно добавлен", user.getId());
        return user;
    }

    @Override
    public void deleteUser(Long id) {
        userExist(id);
        users.remove(id);
        log.info("user c id {} успешно удален", id);
    }

    @Override
    public User getUserById(Long id) {
        userExist(id);
        log.info("User c id {} получен", id);
        return users.get(id);
    }

    @Override
    public User updateUser(Long id, User user) {
        userExist(id);
        User userFromStorage = users.get(id);
        user.setId(id);
        if (user.getName() == null) {
            user.setName(userFromStorage.getName());
        }
        if (user.getSurname() == null) {
            user.setSurname(userFromStorage.getSurname());
        }
        if (user.getCategoryPlayer() == null) {
            user.setCategoryPlayer(userFromStorage.getCategoryPlayer());
        }
        if (user.getWeight() == null) {
            user.setWeight(userFromStorage.getWeight());
        }
        if (user.getHeight() == null) {
            user.setHeight(userFromStorage.getHeight());
        }
        log.info("User c id {} успешно обновлен", id);
        return user;
    }

    public void userExist(Long userId) {
        if (!users.containsKey(userId)) {
            log.warn("User с таким id{} не найден", userId);
            throw new UserNotFoundException("User с таким id не найден");
        }
    }

    @Override
    public List<User> searchUserBySurname(String surname) {
//        log.info("список всех User c surname {} выведен", surname);
        return users.values().stream().filter(a -> a.getSurname().equalsIgnoreCase(surname)).collect(Collectors.toList());
    }

    @Override
    public List<User> searchUserByName(String name) {
//        log.info("список всех User с Name {} выведен", name);
        return users.values().stream().filter(a -> a.getName().equalsIgnoreCase(name)).collect(Collectors.toList());
    }

    @Override
    public List<User> searchUserByCategoryPlayer(String categoryPlayer) {
        return users.values().stream().filter(
                a -> a.getCategoryPlayer().toString().equalsIgnoreCase(categoryPlayer)).collect(Collectors.toList());
    }
}
