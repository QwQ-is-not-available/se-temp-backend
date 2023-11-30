package com.tempomate.pojo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Log {
    private Integer id;
    private String userId;
    private LocalDateTime time;
    private Integer routineId;
}
