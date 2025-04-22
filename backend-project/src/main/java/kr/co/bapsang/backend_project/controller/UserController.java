package kr.co.bapsang.backend_project.controller;

import kr.co.bapsang.backend_project.dto.UserDto;
import kr.co.bapsang.backend_project.repository.UserRepository;
import kr.co.bapsang.backend_project.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("user")
public class UserController {

    private final UserService userService;
    private final UserRepository userRepository;

    @PostMapping("signup")
    @CrossOrigin
    public ResponseEntity createUser(@RequestBody UserDto dto) {
        return userService.createUser(dto);
    }
}
