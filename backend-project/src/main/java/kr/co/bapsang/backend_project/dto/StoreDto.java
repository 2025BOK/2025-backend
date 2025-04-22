package kr.co.bapsang.backend_project.dto;

public class StoreDto {
    private Long STORE_NO;
    private String STORE_NM;
    private String STORE_LOC;

    public StoreDto() {
    }

    public StoreDto(Long STORE_NO, String STORE_NM, String STORE_LOC) {
        this.STORE_NO = STORE_NO;
        this.STORE_NM = STORE_NM;
        this.STORE_LOC = STORE_LOC;
    }

    public Long getSTORE_NO() {
        return STORE_NO;
    }

    public String getSTORE_NM() {
        return STORE_NM;
    }

    public String getSTORE_LOC() {
        return STORE_LOC;
    }

    public void setSTORE_NO(Long STORE_NO) {
        this.STORE_NO = STORE_NO;
    }

    public void setSTORE_NM(String STORE_NM) {
        this.STORE_NM = STORE_NM;
    }

    public void setSTORE_LOC(String STORE_LOC) {
        this.STORE_LOC = STORE_LOC;
    }
}
