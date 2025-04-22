package kr.co.bapsang.backend_project.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
@Getter
@Setter
public class StoreDto {
    private Long storeNo;
    private String storeNm;
    private String storeLoc;

}
