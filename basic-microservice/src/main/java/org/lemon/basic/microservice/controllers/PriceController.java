package org.lemon.basic.microservice.controllers;

import org.lemon.basic.microservice.model.SpotPrice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

@RestController
public class PriceController {

    @GetMapping("/{priceCode}")
    public SpotPrice getPrice(@PathVariable String priceCode) {
        return SpotPrice.builder()
                .priceCode(priceCode)
                .timeStamp(LocalDateTime.now())
                .value(ThreadLocalRandom.current().nextDouble(1000))
                .build();
    }
}
