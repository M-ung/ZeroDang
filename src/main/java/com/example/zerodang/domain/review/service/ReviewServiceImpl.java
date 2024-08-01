package com.example.zerodang.domain.review.service;

import com.example.zerodang.domain.product.service.ProductService;
import com.example.zerodang.domain.review.dto.request.ReviewRequestDTO;
import com.example.zerodang.domain.review.dto.response.ReviewResponseDTO;
import com.example.zerodang.domain.review.entity.Review;
import com.example.zerodang.domain.reviewKeyword.entity.ReviewKeyword;
import com.example.zerodang.domain.review.mapper.ReviewMapper;
import com.example.zerodang.domain.review.repository.ReviewRepository;
import com.example.zerodang.domain.reviewKeyword.service.ReviewKeywordService;
import com.example.zerodang.domain.user.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
@Slf4j
public class ReviewServiceImpl implements ReviewService {
    private final ReviewRepository reviewRepository;
    private final ReviewKeywordService reviewKeywordService;
    private final UserService userService;
    private final ProductService productService;
    private final ReviewMapper reviewMapper;

    @Override
    public ReviewResponseDTO.ReviewDetailDTO save(ReviewRequestDTO.ReviewSaveDTO reviewSaveDTO, Long userId) {
        Review review = reviewMapper.toReviewEntity(reviewSaveDTO, productService.getProduct_id(reviewSaveDTO.getProductId()), userService.getUser_Id(userId));
        reviewRepository.save(review);

        List<ReviewKeyword> reviewKeywordList = reviewKeywordService.saveReviewKeywords(review);
        return reviewMapper.toReviewDetailDTO(review, reviewKeywordList);
    }

    @Override
    public ReviewResponseDTO.ReviewFindAllDTO findAllByProductId(Long productId) {
        return null;
    }
}
