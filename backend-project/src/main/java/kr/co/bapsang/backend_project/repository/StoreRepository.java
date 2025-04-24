package kr.co.bapsang.backend_project.repository;

import kr.co.bapsang.backend_project.entity.StoreEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StoreRepository extends CrudRepository<StoreEntity, Long> {
    StoreEntity findByStoreNo(Long storeNo);
    List<StoreEntity> findAllByStoreNm(String storeNm);

    @Query("SELECT s FROM StoreEntity s " +
            "WHERE (:type1 IS NULL OR s.reviewType1 = :type1) " +
            "AND (:type2 IS NULL OR s.reviewType2 = :type2)")
    List<StoreEntity> findByTypes(@Param("type1") Integer reviewType1,
                                  @Param("type2") Integer reviewType2);

}
