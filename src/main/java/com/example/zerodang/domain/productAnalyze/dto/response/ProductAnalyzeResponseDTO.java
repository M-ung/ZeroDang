package com.example.zerodang.domain.productAnalyze.dto.response;

import com.example.zerodang.domain.product.entity.Product;
import com.example.zerodang.domain.product.entity.ProductCategory;
import com.example.zerodang.domain.reviewKeyword.entity.Keyword;
import com.example.zerodang.domain.sweetener.entity.Sweetener;
import com.example.zerodang.domain.user.entity.User;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

public class ProductAnalyzeResponseDTO {
    @Data
    @AllArgsConstructor
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    @Builder
    public static class ProductAnalyzeSaveDTO {
        private Long productAnalyzeId;
        private User user;
        private Product product;
    }
    @Data
    @AllArgsConstructor
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    @Builder
    public static class ProductAnalyzeFindDetailDTO {
        private Long productId;
        private String productName;
        private ProductCategory productCategory;
        private String productImageUrl;
        private int productMl;
        private List<Sweetener> sweetenerList;
        private List<Keyword> keywordList;
        private float carbohydrateG;
        private float sugarG;
        private float proteinG;
        private float fatG;
        private float saturatedFatG;
        private float transFatG;
        private float cholesterolG;
        private float sodiumG;
    }
    @Data
    @AllArgsConstructor
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    @Builder
    public static class ProductAnalyzeResultDTO {
        private List<ProductAnalyzeFindDetailDTO> productAnalyzeFindDetailDTOList;
        private String sweetenerAnalyze;
        private String resultComment;
    }
}
