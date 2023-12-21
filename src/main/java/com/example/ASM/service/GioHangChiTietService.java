package com.example.ASM.service;

import com.example.ASM.model.GHCT;
import com.example.ASM.model.GioHangChiTiet;
import com.example.ASM.repository.GioHangChiTietRepository;

import java.math.BigDecimal;
import java.util.List;

public class GioHangChiTietService {
    GioHangChiTietRepository gioHangChiTietRepository = new GioHangChiTietRepository();

    public List<GioHangChiTiet> getAll(){
        return gioHangChiTietRepository.getAll();
    }

    public void addGioHangChiTiet(GioHangChiTiet gioHangChiTiet){
        gioHangChiTietRepository.addGioHangChiTiet(gioHangChiTiet);
    }

    public void updateGioHangChiTiet(GioHangChiTiet gioHangChiTiet){
        gioHangChiTietRepository.updateGioHangChiTiet(gioHangChiTiet);
    }

    public void deleteGioHangChiTiet(GioHangChiTiet gioHangChiTiet){
        gioHangChiTietRepository.deleteGioHangChiTiet(gioHangChiTiet);
    }

    public GioHangChiTiet getGioHangChiTietById(String id){
        return gioHangChiTietRepository.getGioHangChiTietById(id);
    }

    public GioHangChiTiet getGioHangChiTietByIdCTSP(String idCTSP){
        return gioHangChiTietRepository.getGioHangChiTietByIdCTSP(idCTSP);
    }

    public void updateSoLuongGHCTByIdCTSP(String idCTSP, Integer soLuong, BigDecimal donGia){
        gioHangChiTietRepository.updateSoLuongGHCTByIdCTSP(idCTSP, soLuong, donGia);
    }

    public void updateTrangThaiGHCTByIdGioHang(Integer trangThai, String idGioHang){
        gioHangChiTietRepository.updateTrangThaiGHCTByIdGioHang(trangThai, idGioHang);
    }

    public List<GHCT> getAllByMaKH(String maKH){
        return gioHangChiTietRepository.getAllByMaKH(maKH);
    }

    public BigDecimal getDonGiaGioHangByMaKH(String maKH){
        return gioHangChiTietRepository.getDonGiaGioHangByMaKH(maKH);
    }
}
