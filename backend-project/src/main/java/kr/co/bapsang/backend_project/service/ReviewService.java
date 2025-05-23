package kr.co.bapsang.backend_project.service;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import kr.co.bapsang.backend_project.dto.ReviewDto;
import kr.co.bapsang.backend_project.entity.ReviewEntity;
import kr.co.bapsang.backend_project.entity.StoreEntity;
import kr.co.bapsang.backend_project.entity.UserEntity;
import kr.co.bapsang.backend_project.repository.ReviewReposiroty;
import kr.co.bapsang.backend_project.repository.StoreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ReviewService {

    private final ReviewReposiroty reviewRepository;
    private final StoreRepository storeRepository;

    public ResponseEntity<?> createReview(ReviewDto dto, Long storeNo, String reviewImg, HttpServletRequest request) {
        // 1. 유저 정보 확인
        HttpSession session = request.getSession(false);
        UserEntity user = (UserEntity) session.getAttribute("user");

        if(user == null) {
            return new ResponseEntity<>("로그인이 필요합니다.", HttpStatus.UNAUTHORIZED);
        }

        // 2. 스토어 정보 확인
        StoreEntity store = storeRepository.findByStoreNo(storeNo);

        // 3. newReview 세팅
        ReviewEntity newReview = new ReviewEntity();
        newReview.setReviewNo(dto.getReviewNo());
        newReview.setReviewRate(dto.getReviewRate());
        newReview.setReviewImg(reviewImg);
        newReview.setReviewCtn(dto.getReviewCtn());
        newReview.setReviewType1(dto.getReviewType1());
        newReview.setReviewType2(dto.getReviewType2());
        newReview.setReviewDate(dto.getReviewDate());

        newReview.setUserEntity(user);
        newReview.setStoreEntity(store);
        reviewRepository.save(newReview);

        // 4. 스토어 reviewType 세팅
        store.setReviewType1(dto.getReviewType1());
        store.setReviewType1(dto.getReviewType2());
        storeRepository.save(store);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    public ResponseEntity updateReview(Long reviewNo, ReviewDto dto) {
        Optional<ReviewEntity> targetEntity = Optional.ofNullable(reviewRepository.findByReviewNo(reviewNo));
        if(targetEntity.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        ReviewEntity reviewEntity = targetEntity.get();
        reviewEntity.setReviewRate(dto.getReviewRate());
        reviewEntity.setReviewCtn(dto.getReviewCtn());
        reviewEntity.setReviewType1(dto.getReviewType1());
        reviewEntity.setReviewType2(dto.getReviewType2());
        reviewRepository.save(reviewEntity);

        return new ResponseEntity(HttpStatus.OK);
    }

    public ResponseEntity deleteReview(Long reviewNo) {
        Optional<ReviewEntity> targetEntity = Optional.ofNullable(reviewRepository.findByReviewNo(reviewNo));
        if(targetEntity.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        reviewRepository.delete(targetEntity.get());

        return new ResponseEntity(HttpStatus.OK);
    }

    public ResponseEntity<List> readReviewList(Long storeNo) {
        Iterator<ReviewEntity> iterator = (Iterator<ReviewEntity>) reviewRepository.findByStoreEntity_StoreNo(storeNo);
        List<ReviewDto> reviewDtoList = new ArrayList<>();

        while(iterator.hasNext()) {
            ReviewEntity reviewEntity = iterator.next();
            reviewDtoList.add(new ReviewDto(
                    reviewEntity.getReviewNo(),
                    reviewEntity.getReviewRate(),
                    reviewEntity.getReviewImg(),
                    reviewEntity.getReviewCtn(),
                    reviewEntity.getReviewType1(),
                    reviewEntity.getReviewType2()
            ));
        }

        return new ResponseEntity<>(reviewDtoList, HttpStatus.OK);
    }

    public ResponseEntity<ReviewEntity> readReview(Long reviewNo) {
        Optional<ReviewEntity> targetEntity = Optional.ofNullable(reviewRepository.findByReviewNo(reviewNo));
        if(targetEntity.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        ReviewEntity reviewEntity = targetEntity.get();

        return new ResponseEntity<>(reviewEntity, HttpStatus.OK);
    }

}
