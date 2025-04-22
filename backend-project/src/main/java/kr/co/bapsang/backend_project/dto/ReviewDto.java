package kr.co.bapsang.backend_project.dto;

import java.time.LocalDateTime;

public class ReviewDto {
    private Long REVIEW_NO;
    private float REVIEW_RATE;
    private String REVIEW_IMG;
    private String REVIEW_CTN;
    private int REVIEW_TYPE1;
    private int REVIEW_TYPE2;
    private LocalDateTime REVIEW_DATE;
    private Long USER_NO;
    private Long STORE_NO;

    public ReviewDto() {
    }

    public ReviewDto(Long REVIEW_NO, float REVIEW_RATE, String REVIEW_IMG, String REVIEW_CTN, int REVIEW_TYPE1, int REVIEW_TYPE2, LocalDateTime REVIEW_DATE, Long USER_NO, Long STORE_NO) {
        this.REVIEW_NO = REVIEW_NO;
        this.REVIEW_RATE = REVIEW_RATE;
        this.REVIEW_IMG = REVIEW_IMG;
        this.REVIEW_CTN = REVIEW_CTN;
        this.REVIEW_TYPE1 = REVIEW_TYPE1;
        this.REVIEW_TYPE2 = REVIEW_TYPE2;
        this.REVIEW_DATE = REVIEW_DATE;
        this.USER_NO = USER_NO;
        this.STORE_NO = STORE_NO;
    }

    public Long getREVIEW_NO() {
        return REVIEW_NO;
    }

    public float getREVIEW_RATE() {
        return REVIEW_RATE;
    }

    public String getREVIEW_IMG() {
        return REVIEW_IMG;
    }

    public String getREVIEW_CTN() {
        return REVIEW_CTN;
    }

    public int getREVIEW_TYPE1() {
        return REVIEW_TYPE1;
    }

    public int getREVIEW_TYPE2() {
        return REVIEW_TYPE2;
    }

    public LocalDateTime getREVIEW_DATE() {
        return REVIEW_DATE;
    }

    public Long getUSER_NO() {
        return USER_NO;
    }

    public Long getSTORE_NO() {
        return STORE_NO;
    }

    public void setREVIEW_NO(Long REVIEW_NO) {
        this.REVIEW_NO = REVIEW_NO;
    }

    public void setREVIEW_RATE(float REVIEW_RATE) {
        this.REVIEW_RATE = REVIEW_RATE;
    }

    public void setREVIEW_IMG(String REVIEW_IMG) {
        this.REVIEW_IMG = REVIEW_IMG;
    }

    public void setREVIEW_CTN(String REVIEW_CTN) {
        this.REVIEW_CTN = REVIEW_CTN;
    }

    public void setREVIEW_TYPE1(int REVIEW_TYPE1) {
        this.REVIEW_TYPE1 = REVIEW_TYPE1;
    }

    public void setREVIEW_TYPE2(int REVIEW_TYPE2) {
        this.REVIEW_TYPE2 = REVIEW_TYPE2;
    }

    public void setREVIEW_DATE(LocalDateTime REVIEW_DATE) {
        this.REVIEW_DATE = REVIEW_DATE;
    }

    public void setUSER_NO(Long USER_NO) {
        this.USER_NO = USER_NO;
    }

    public void setSTORE_NO(Long STORE_NO) {
        this.STORE_NO = STORE_NO;
    }
}
