package com.example.zerodang.domain.review.service;

import com.example.zerodang.domain.review.dto.request.ReviewRequestDTO;
import com.example.zerodang.domain.review.dto.response.ReviewResponseDTO;

public interface ReviewService {
    /** 리뷰 저장 **/
    ReviewResponseDTO.ReviewSaveDTO save(ReviewRequestDTO.ReviewSaveDTO reviewSaveDTO);

    /** 상품별 리뷰 전체 조회 **/
    ReviewResponseDTO.ReviewFindAllDTO findAllByProductId(Long productId);
}