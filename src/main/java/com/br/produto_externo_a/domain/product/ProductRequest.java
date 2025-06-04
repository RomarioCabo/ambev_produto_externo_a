package com.br.produto_externo_a.domain.product;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ProductRequest {
    @JsonProperty("product_id")
    private UUID id;
    private String name;
    private BigDecimal price;
    private Integer quantity;
}
