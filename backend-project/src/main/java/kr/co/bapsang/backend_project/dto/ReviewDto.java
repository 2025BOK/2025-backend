package kr.co.bapsang.backend_project.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@Getter
@Setter
public class ReviewDto {
    private Long reviewNo;
    private float reviewRate;
    private String reviewImg;
    private String reviewCtn;
    private int reviewType1;
    private int reviewType2;
    private LocalDateTime reviewDate;
    private Long userNo;
    private Long storeNo;

    public ReviewDto(Long reviewNo, float reviewRate, String reviewImg, String reviewCtn, int reviewType1, int reviewType2) {
        this.reviewNo = reviewNo;
        this.reviewRate = reviewRate;
        this.reviewImg = reviewImg;
        this.reviewCtn = reviewCtn;
        this.reviewType1 = reviewType1;
        this.reviewType2 = reviewType2;
    }
}
