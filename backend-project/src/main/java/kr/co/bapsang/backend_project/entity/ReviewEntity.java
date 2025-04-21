package kr.co.bapsang.backend_project.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@RequiredArgsConstructor
@Getter
@Setter
public class ReviewEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long REVIEW_NO; // 리뷰 PK

    private float REVIEW_RATE; // 리뷰 평점
    private String REVIEW_IMG; // 리뷰 사진
    private String REVIEW_CTN; // 리뷰 내용
    private int REVIEW_TYPE1; // 리뷰 조건1(음식 종류)
    private int REVIEW_TYPE2; // 리뷰 조건2(분위기)
    private LocalDateTime REVIEW_DATE; // 리뷰 작성일

    @ManyToOne(
            targetEntity = UserEntity.class,
            fetch = FetchType.LAZY
    )
    private UserEntity userEntity;

    @ManyToOne(
            targetEntity = StoreEntity.class,
            fetch = FetchType.LAZY
    )
    private StoreEntity storeEntity;
}
