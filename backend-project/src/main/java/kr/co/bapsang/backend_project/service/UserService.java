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

    public ResponseEntity createUser(UserDto dto) {
        UserEntity newUser = new UserEntity();
        newUser.setUserNo(dto.getUserNo());
        newUser.setUserNm(dto.getUserNm());
        newUser.setUserCnt(dto.getUserCnt());
        newUser.setPassword(dto.getPassword());
        userRepository.save(newUser);

        return new ResponseEntity(HttpStatus.OK);
    }

    public boolean authenticateUser(Long userNo, String password) {
        UserEntity userEntity = userRepository.findByUserNo(userNo);

        return userEntity != null && userEntity.getPassword().equals(password);
    }

    public boolean duplicateCheck(Long userNo) {
        return userRepository.existsByUserNo(userNo);
    }
}
