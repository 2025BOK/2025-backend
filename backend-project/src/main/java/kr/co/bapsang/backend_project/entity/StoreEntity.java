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
public class StoreEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long storeNo; // 가게 PK

    private String storeNm; // 가게 이름
    private String storeLoc; // 가게 위치

    @OneToMany(
        targetEntity = ReviewEntity.class,
            fetch = FetchType.LAZY,
            mappedBy = "storeEntity"
    )
    private List<ReviewEntity> reviewEntityList = new ArrayList<>();
}
