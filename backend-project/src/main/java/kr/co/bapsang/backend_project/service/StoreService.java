package kr.co.bapsang.backend_project.service;

import kr.co.bapsang.backend_project.dto.StoreDto;
import kr.co.bapsang.backend_project.entity.StoreEntity;
import kr.co.bapsang.backend_project.repository.StoreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StoreService {

    private final StoreRepository storeRepository;

    public ResponseEntity createStore(StoreDto dto) {
        StoreEntity newStore = new StoreEntity();
        newStore.setStoreNo(dto.getStoreNo());
        newStore.setStoreNm(dto.getStoreNm());
        newStore.setStoreLoc(dto.getStoreLoc());
        storeRepository.save(newStore);

        return new ResponseEntity(HttpStatus.CREATED);
    }

    public ResponseEntity updateStore(Long storeNo, StoreDto dto) {
        Optional<StoreEntity> targetEntity = Optional.ofNullable(storeRepository.findByStoreNo(storeNo));
        if(targetEntity.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        StoreEntity storeEntity = targetEntity.get();
        storeEntity.setStoreNm(dto.getStoreNm());
        storeEntity.setStoreLoc(dto.getStoreLoc());
        storeRepository.save(storeEntity);

        return new ResponseEntity(HttpStatus.OK);
    }

    public ResponseEntity deleteStore(Long storeNo) {
        Optional<StoreEntity> targetEntity = Optional.ofNullable(storeRepository.findByStoreNo(storeNo));
        if(targetEntity.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        storeRepository.delete(targetEntity.get());

        return new ResponseEntity(HttpStatus.OK);
    }

    public ResponseEntity<List> readStoreList(String storeNm) {
        Iterator<StoreEntity> iterator = (Iterator<StoreEntity>) storeRepository.findAllByStoreNm(storeNm);
        List<StoreDto> storeDtoList = new ArrayList<>();

        while(iterator.hasNext()) {
            StoreEntity storeEntity = iterator.next();
            storeDtoList.add(new StoreDto(
                    storeEntity.getStoreNo(),
                    storeEntity.getStoreNm(),
                    storeEntity.getStoreLoc()
            ));
        }

        return new ResponseEntity<>(storeDtoList, HttpStatus.OK);
    }

    public ResponseEntity<StoreEntity> readStore(Long storeNo) {
        Optional<StoreEntity> targetEntity = Optional.ofNullable(storeRepository.findByStoreNo(storeNo));
        if(targetEntity.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        StoreEntity storeEntity = targetEntity.get();

        return new ResponseEntity<>(storeEntity, HttpStatus.OK);
    }

}
