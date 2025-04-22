package kr.co.bapsang.backend_project.repository;

import kr.co.bapsang.backend_project.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository  extends CrudRepository<UserEntity, Long> {
    UserEntity findByUSER_NO(Long USER_NO);
    boolean existsByUSER_NO(Long userNo);
}
