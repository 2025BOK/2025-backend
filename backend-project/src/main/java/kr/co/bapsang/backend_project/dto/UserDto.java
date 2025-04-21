package kr.co.bapsang.backend_project.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class UserDto {
    private Long USER_NO;
    private String USER_NM;
    private int USER_CNT;
}
