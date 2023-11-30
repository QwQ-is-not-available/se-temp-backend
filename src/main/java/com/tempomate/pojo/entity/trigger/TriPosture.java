package com.tempomate.pojo.entity.trigger;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TriPosture {
    private Integer id;
    private Short mode;

    private Double  leftTopX;
    private Double leftTopY;
    private Double rightBottomX;
    private Double rightBottomY;

    private String ip;
}
