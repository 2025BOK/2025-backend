package kr.co.bapsang.backend_project.repository;

import kr.co.bapsang.backend_project.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository  extends CrudRepository<UserEntity, Long> {
    UserEntity findByUserNo(Long userNo);
    boolean existsByUserNo(Long userNo);
}
