package BasketballChat.BasketballChat.controller;

import BasketballChat.BasketballChat.dto.UserDto;
import BasketballChat.BasketballChat.service.userService.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<UserDto> addUser(@RequestBody UserDto userDto) {
        log.info("получен POST запрос на добавление user c id {}", userDto.getId());
        return new ResponseEntity<>(userService.addUser(userDto), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable Long id) {
        log.info("получен DELETE запрос на удаление User c id {}", id);
        userService.deleteUser(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getUser(@PathVariable Long id) {
        log.info("получен GET запрос на получение User c id {}", id);
        return new ResponseEntity<>(userService.getUserById(id), HttpStatus.OK);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<UserDto> updateUser(@PathVariable Long id, @RequestBody UserDto userDto) {
        log.info("получен PATCH запрос на обновление User c id {}", id);
        return new ResponseEntity<>(userService.updateUser(id, userDto), HttpStatus.OK);
    }
    @GetMapping("/search")
    public ResponseEntity<List<UserDto>> searchUser(@RequestParam(required = false) String surname,
                                                    @RequestParam(required = false) String name,
                                                    @RequestParam(required = false) String categoryPlayer) {
        log.info("получен GET запрос на поиск User surname {}, name {}, categoryPlayer {}",surname,name,categoryPlayer);
        return new ResponseEntity<>(userService.searchUser(surname,name,categoryPlayer),HttpStatus.OK);
    }
}
