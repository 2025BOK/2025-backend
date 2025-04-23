package kr.co.bapsang.backend_project.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import kr.co.bapsang.backend_project.dto.UserDto;
import kr.co.bapsang.backend_project.entity.UserEntity;
import kr.co.bapsang.backend_project.repository.UserRepository;
import kr.co.bapsang.backend_project.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("user")
public class UserController {

    private final UserService userService;
    private final UserRepository userRepository;

    @PostMapping("signup")
    @CrossOrigin
    public ResponseEntity createUser(@RequestBody UserDto dto) {
        boolean isExits = userService.duplicateCheck(dto.getUserNo());

        if(isExits) {
            return new ResponseEntity(HttpStatus.CONFLICT);
        }
        else {
            return userService.createUser(dto);
        }
    }

    @PostMapping("login")
    @CrossOrigin
    public ResponseEntity login(@RequestBody UserDto dto, HttpServletRequest request) {
        boolean isAuthenticated = userService.authenticateUser(dto.getUserNo(), dto.getPassword());

        if(isAuthenticated) {
            UserEntity user = userRepository.findByUserNo(dto.getUserNo());

            HttpSession session = request.getSession();
            session.setAttribute("user", user);

            return new ResponseEntity(HttpStatus.OK);
        }
        else {
            return new ResponseEntity(HttpStatus.UNAUTHORIZED);
        }
    }

}
