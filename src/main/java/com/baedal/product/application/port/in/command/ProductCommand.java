package com.baedal.product.application.port.in.command;

import lombok.Builder;
import lombok.Getter;

public class ProductCommand {

    @Getter
    @Builder
    public static class Request {
        private String name;
        private String category;
        private int price;
        private String productPictureUrl;
        private Long storeId;
    }

    @Getter
    @Builder
    public static class Response {
        private Long productId;
        private String name;
        private String category;
        private int price;
        private Long storeId;
        private String productPictureUrl;
    }
}