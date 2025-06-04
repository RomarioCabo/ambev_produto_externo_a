package com.br.produto_externo_a.application.controller.impl;

import com.br.produto_externo_a.application.controller.OrderController;
import com.br.produto_externo_a.domain.order.OrderRequest;
import com.br.produto_externo_a.domain.order.service.OrderService;
import com.br.produto_externo_a.domain.order.status.StatusResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class OrderControllerImpl implements OrderController {
    private final OrderService orderService;

    @Override
    public ResponseEntity<StatusResponse> sendOrder(OrderRequest request) {
        StatusResponse statusResponse = orderService.sendOrder(request);
        return ResponseEntity.ok(statusResponse);
    }
}
