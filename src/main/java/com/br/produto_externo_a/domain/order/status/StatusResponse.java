package com.br.produto_externo_a.domain.order.status;

import com.br.produto_externo_a.domain.enums.Status;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class StatusResponse {
    private Status status;
    private LocalDateTime time;
}
