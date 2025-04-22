package kr.co.bapsang.backend_project.service;

import kr.co.bapsang.backend_project.dto.UserDto;
import kr.co.bapsang.backend_project.entity.UserEntity;
import kr.co.bapsang.backend_project.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    // USER - 회원가입
    public ResponseEntity createUser(UserDto dto) {
        UserEntity newUser = new UserEntity();
        newUser.setUserNo(dto.getUserNo());
        newUser.setUserNm(dto.getUserNm());
        newUser.setUserCnt(dto.getUserCnt());
        userRepository.save(newUser);

        return new ResponseEntity(HttpStatus.OK);
    }

    // USER - 중복체크
//    public ResponseEntity<Boolean> duplicateCheck(Long USER_NO) {
//        boolean isDuplicated = userRepository.existsByUSER_NO(USER_NO);
//
//        return new ResponseEntity<>(isDuplicated, HttpStatus.OK);
//    }
}
