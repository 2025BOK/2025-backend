package kr.co.bapsang.backend_project.controller;

import kr.co.bapsang.backend_project.dto.StoreDto;
import kr.co.bapsang.backend_project.entity.StoreEntity;
import kr.co.bapsang.backend_project.repository.StoreRepository;
import kr.co.bapsang.backend_project.service.StoreService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("store")
public class StoreController {

    private final StoreService storeService;
    private StoreRepository storeRepository;

    @PostMapping("register")
    @CrossOrigin
    public ResponseEntity createStore(@RequestBody StoreDto dto) {
        return storeService.createStore(dto);
    }

    @PutMapping("{storeNo}")
    @CrossOrigin
    public ResponseEntity updateStore(@PathVariable Long storeNo, @RequestBody StoreDto dto) {
        return storeService.updateStore(storeNo, dto);
    }

    @DeleteMapping("{storeNo}")
    @CrossOrigin
    public ResponseEntity deleteStore(@PathVariable Long storeNo) {
        return storeService.deleteStore(storeNo);
    }

    @GetMapping
    @CrossOrigin
    public ResponseEntity<List> getStoreList(@RequestBody String storeNm) {
        return storeService.readStoreList(storeNm);
    }

    @GetMapping("{storeNo}")
    @CrossOrigin
    public ResponseEntity<StoreEntity> getStore(@PathVariable Long storeNo) {
        return storeService.readStore(storeNo);
    }

    @PostMapping("search")
    @CrossOrigin
    public ResponseEntity<?> searchStore(@RequestBody Map<String, Integer> request) {
        Integer reviewType1 = request.get("reviewType1");
        Integer reviewType2 = request.get("reviewType2");

        return storeService.searchStore(reviewType1, reviewType2);
    }

}
