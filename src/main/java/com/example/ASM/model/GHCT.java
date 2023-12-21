package com.example.ASM.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor

public class GHCT {
    private String idKH;
    private String idCTSP;
    private String img;
    private String tenSP;
    private String tenMS;
    private BigDecimal donGia;
    private Integer size;
    private Integer soLuong;
    private Integer trangThai;
}
