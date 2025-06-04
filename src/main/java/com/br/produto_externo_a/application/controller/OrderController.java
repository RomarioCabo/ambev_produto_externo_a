package com.br.produto_externo_a.application.controller;

import com.br.produto_externo_a.domain.order.OrderRequest;
import com.br.produto_externo_a.domain.order.status.StatusResponse;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.tags.Tags;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Tags(@Tag(name = "Pedido", description = "Pedido REST Controller"))
public interface OrderController {

    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "Pedido em processamento.",
                    content = @Content(
                            mediaType = APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = StatusResponse.class)
                    )
            ),
    })
    @PostMapping(
            value = "pedido",
            consumes = APPLICATION_JSON_VALUE,
            produces = APPLICATION_JSON_VALUE
    )
    ResponseEntity<StatusResponse> sendOrder(@RequestBody(required = false) OrderRequest request);
}
