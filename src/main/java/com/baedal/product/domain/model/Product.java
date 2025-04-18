package com.baedal.product.domain.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "product_entity") // 테이블 이름 명시 (선택)
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;

    private Long storeId;
    private String category;
    private String name;
    private int price;
    private String productPictureUrl;
}