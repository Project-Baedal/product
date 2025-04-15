package com.baedal.product.domain.model;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;


import java.sql.Timestamp;

@Getter
@Builder
public class Product {
    private Long productId;
    private Long storeId;
    private String category;
    private String name;
    private int price;
    private String productPictureUrl;
}