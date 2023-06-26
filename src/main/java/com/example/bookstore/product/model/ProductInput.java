package com.example.bookstore.product.model;

import com.example.bookstore.product.entity.ProductType;
import lombok.Data;
import lombok.ToString;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Data
@ToString
@Valid
public class ProductInput {

    @NotNull(message = "상품명은 필수로 입력해야 합니다.")
    private String productName;

    @NotNull(message = "제품 타입은 필수로 입력해야 합니다.")
    private ProductType productType;

    @NotNull(message = "가격은 필수로 입력해야 합니다.")
    private Long price;

    @NotNull(message = "판매가격은 필수로 입력해야 합니다.")
    private Long salePrice;

    private String productDetail;

    @NotNull(message = "제고 수량은 필수로 입력해야 합니다.")
    @Min(value = 0)
    Long stock;

    @NotNull(message = "등록일은 필수로 입력해야 합니다.")
    private LocalDateTime regDate;

}
