package com.tempomate.pojo.entity.trigger;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TriLocation {
    private Integer id;
    private Short mode;
    private BigDecimal longitude;
    private BigDecimal latitude;
}
