package kr.co.bapsang.backend_project.repository;

import kr.co.bapsang.backend_project.entity.StoreEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface StoreRepository extends CrudRepository<StoreEntity, Long> {
    StoreEntity findByStoreNo(Long storeNo);
    List<StoreEntity> findAllByStoreNm(String storeNm);
}
