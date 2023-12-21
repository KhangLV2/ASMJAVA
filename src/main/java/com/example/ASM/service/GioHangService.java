package com.example.ASM.service;

import com.example.ASM.model.GioHang;
import com.example.ASM.repository.GioHangRepository;

import java.util.List;

public class GioHangService {
    GioHangRepository gioHangRepository = new GioHangRepository();

    public List<GioHang> getAll(){
        return gioHangRepository.getAll();
    }

    public void addGioHang(GioHang gioHang){
        gioHangRepository.addGioHang(gioHang);
    }

    public void updateGioHang(GioHang gioHang){
        gioHangRepository.updateGioHang(gioHang);
    }

    public void deleteGioHang(GioHang gioHang){
        gioHangRepository.deleteGioHang(gioHang);
    }

    public GioHang getGioHangById(String id){
        return gioHangRepository.getGioHangById(id);
    }

    public GioHang getGioHangByIdKH(String idKH){
        return gioHangRepository.getGioHangByIdKH(idKH);
    }

    public Long getSoLuongGioHangByMaKH(String ma){
        return gioHangRepository.getSoLuongGioHangByMaKH(ma);
    }

    public void updateTrangThaiGioHangByIdKH(Integer tinhTrang, String idKH){
        gioHangRepository.updateTrangThaiGioHangByIdKH(tinhTrang, idKH);
    }
}
