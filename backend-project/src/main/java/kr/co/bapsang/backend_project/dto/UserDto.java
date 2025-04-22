package kr.co.bapsang.backend_project.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
@Getter
@Setter
public class UserDto {
    private Long userNo;
    private String userNm;
    private int userCnt;

}
