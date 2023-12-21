package com.example.ASM.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import java.math.BigDecimal;
import java.util.UUID;

@Table(name = "ChiTietSP")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class ChiTietSP {
    @Id
    @Column(name = "Id")
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
        private String id;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "IdSP")
    private SanPham idSP;

    @ManyToOne
    @JoinColumn(name = "IdNsx")
    private NSX idNsx;

    @ManyToOne
    @JoinColumn(name = "IdMauSac")
    private MauSac idMauSac;

    @ManyToOne
    @JoinColumn(name = "IdDongSP")
    private DongSP idDongSP;

    @Column(name = "NamBH")
    private Integer namBH;

    @Column(name = "MoTa")
    private String moTa;

    @Column(name = "SoLuongTon")
    private Integer soLuongTon;

    @Column(name = "GiaNhap")
    private BigDecimal giaNhap;

    @Column(name = "GiaBan")
    private BigDecimal giaBan;

    @Column(name = "Size")
    private Integer size;

    @Column(name = "TrangThai")
    private Integer trangThai;
}
