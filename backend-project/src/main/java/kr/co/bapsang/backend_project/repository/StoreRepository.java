package kr.co.bapsang.backend_project.repository;

import kr.co.bapsang.backend_project.entity.StoreEntity;
import org.springframework.data.repository.CrudRepository;

public interface StoreRepository extends CrudRepository<StoreEntity, Long> {
    StoreEntity findBySTORE_NM(String STORE_NM);
}
