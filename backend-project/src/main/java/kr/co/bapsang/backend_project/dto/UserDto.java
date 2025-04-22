package kr.co.bapsang.backend_project.dto;

public class UserDto {
    private Long USER_NO;
    private String USER_NM;
    private int USER_CNT;

    public UserDto() {

    }

    public UserDto(Long USER_NO, String USER_NM, int USER_CNT) {
        this.USER_NO = USER_NO;
        this.USER_NM = USER_NM;
        this.USER_CNT = USER_CNT;
    }

    public Long getUSER_NO() {
        return USER_NO;
    }

    public String getUSER_NM() {
        return USER_NM;
    }

    public int getUSER_CNT() {
        return USER_CNT;
    }

    public void setUSER_NO(Long USER_NO) {
        this.USER_NO = USER_NO;
    }

    public void setUSER_NM(String USER_NM) {
        this.USER_NM = USER_NM;
    }

    public void setUSER_CNT(int USER_CNT) {
        this.USER_CNT = USER_CNT;
    }
}
