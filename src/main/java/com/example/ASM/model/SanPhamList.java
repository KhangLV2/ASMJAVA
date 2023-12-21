package com.example.ASM.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class SanPhamList {
    private String id;
    private String tenSP;
    private String img;
    private BigDecimal giaBan;
    private String tenMau;
}
