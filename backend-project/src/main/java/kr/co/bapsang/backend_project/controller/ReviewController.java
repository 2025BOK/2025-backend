package kr.co.bapsang.backend_project.controller;

import jakarta.servlet.http.HttpServletRequest;
import kr.co.bapsang.backend_project.dto.ReviewDto;
import kr.co.bapsang.backend_project.entity.ReviewEntity;
import kr.co.bapsang.backend_project.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("review")
public class ReviewController {

    private final ReviewService reviewService;

    @PostMapping("{storeNo}/register")
    @CrossOrigin
    public ResponseEntity createReview(@RequestPart("dto") ReviewDto dto,
                                       @RequestPart(value="reviewImg", required=false) MultipartFile reviewImg,
                                       @PathVariable Long storeNo,
                                       HttpServletRequest request) throws IOException {

        // 이미지 변환 (Multipart -> String)
        String originalFileName = reviewImg.getOriginalFilename();
        String saveFileName = createSaveFileName(originalFileName);

        // 서버에 파일 저장(img 폴더)
        reviewImg.transferTo(new File(getFullPath(saveFileName)));

        // DB에 정보 저장
        return reviewService.createReview(dto, storeNo, "/resources/static/img" + saveFileName, request);
    }

    private String createSaveFileName(String originalFileName) {
        String ext = extractExt(originalFileName);
        String uuid = UUID.randomUUID().toString();
        return uuid + "." + ext;
    }

    private String extractExt(String originalFileName) {
        int pos = originalFileName.lastIndexOf(".");
        return originalFileName.substring(pos + 1);
    }

    private String getFullPath(String saveFileName) {
        return "/resources/static/img" + saveFileName;
    }

    @PutMapping("{reviewNo}")
    @CrossOrigin
    public ResponseEntity updateReview(@PathVariable Long reviewNo, @RequestBody ReviewDto dto) {
        return reviewService.updateReview(reviewNo, dto);
    }

    @DeleteMapping("{reviewNo}")
    @CrossOrigin
    public ResponseEntity deleteReview(@PathVariable Long reviewNo) {
        return reviewService.deleteReview(reviewNo);
    }

    @GetMapping("{storeNo}")
    @CrossOrigin
    public ResponseEntity<List> getReviewList(@RequestParam Long storeNo) {
        return reviewService.readReviewList(storeNo);
    }

    @GetMapping("{reviewNo}")
    @CrossOrigin
    public ResponseEntity<ReviewEntity> getReview(@PathVariable Long reviewNo) {
        return reviewService.readReview(reviewNo);
    }

}
