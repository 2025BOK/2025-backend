package kr.co.bapsang.backend_project.repository;

import kr.co.bapsang.backend_project.entity.ReviewEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ReviewReposiroty extends CrudRepository<ReviewEntity, Long> {
    ReviewEntity findByReviewNo(Long reviewNo);
    List<ReviewEntity> findByStoreEntity_StoreNo(Long storeNo);
}
