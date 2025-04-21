package kr.co.bapsang.backend_project.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class StoreDto {
    private Long STORE_NO;
    private String STORE_NM;
    private String STORE_LOC;
}
