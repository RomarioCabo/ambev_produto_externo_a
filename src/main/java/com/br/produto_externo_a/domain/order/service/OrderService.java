package com.br.produto_externo_a.domain.order.service;

import com.br.produto_externo_a.domain.order.OrderRequest;
import com.br.produto_externo_a.domain.order.status.StatusResponse;

public interface OrderService {

    StatusResponse sendOrder(OrderRequest order);
}
