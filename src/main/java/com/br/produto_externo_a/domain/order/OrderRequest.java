package com.br.produto_externo_a.domain.order;

import com.br.produto_externo_a.domain.product.ProductRequest;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class OrderRequest {
    @JsonProperty("order_id")
    private UUID id;
    private List<ProductRequest> products;
}
