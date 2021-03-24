package com.syrisa.dockerprojectforspringboot.entity.impl;

import com.syrisa.dockerprojectforspringboot.entity.Entity;
import lombok.*;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Order implements Entity {
    private UUID id;
    private LocalDate createdAt;
    private long userId;
    private double total;

}
