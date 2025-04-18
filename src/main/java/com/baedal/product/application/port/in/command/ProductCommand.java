package com.baedal.product.application.port.in.command;

import lombok.*;

public class ProductCommand {

    @Getter
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Request {
        private String name;
        private String category;
        private int price;
        private String productPictureUrl;
        private Long storeId;
    }

    @Getter
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Response {
        private Long productId;
        private String name;
        private String category;
        private int price;
        private Long storeId;
        private String productPictureUrl;
    }
}