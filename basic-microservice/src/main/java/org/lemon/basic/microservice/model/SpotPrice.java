package org.lemon.basic.microservice.model;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class SpotPrice {
    private String priceCode;
    private LocalDateTime timeStamp;
    private Double value;
}
