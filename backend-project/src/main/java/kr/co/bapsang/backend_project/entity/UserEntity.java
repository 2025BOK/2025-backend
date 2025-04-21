package kr.co.bapsang.backend_project.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@RequiredArgsConstructor
@Getter
@Setter
public class UserEntity {
    @Id
    private Long USER_NO; // 사용자 PK(행번)

    private String USER_NM; // 사용자 이름
    private int USER_CNT; // 리뷰 작성수

    @OneToMany(
            targetEntity = ReviewEntity.class,
            fetch = FetchType.LAZY,
            mappedBy = "userEntity"
    )
    private List<ReviewEntity> reviewEntityList = new ArrayList<>();

}
