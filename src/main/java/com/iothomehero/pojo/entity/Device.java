package com.iothomehero.pojo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Device {
    private Long id;
    private String name;
    private Short type;
    private String userId;
    private Short switchStatus;
    private String text;

}
