package kr.co.bapsang.backend_project.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@Getter
@Setter
public class ReviewDto {
    private Long revieNo;
    private float reviewRate;
    private String revieImg;
    private String revieCtn;
    private int reviewType1;
    private int reviewType2;
    private LocalDateTime reviewDate;
    private Long userNo;
    private Long storeNo;

}
