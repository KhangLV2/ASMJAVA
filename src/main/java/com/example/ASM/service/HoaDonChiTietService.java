package com.example.ASM.service;

import com.example.ASM.model.HoaDonChiTiet;
import com.example.ASM.repository.HoaDonChiTietRepository;

import java.math.BigDecimal;
import java.util.List;

public class HoaDonChiTietService {
    HoaDonChiTietRepository hoaDonChiTietRepository = new HoaDonChiTietRepository();

    public List<HoaDonChiTiet> getAll(){
        return hoaDonChiTietRepository.getAll();
    }

    public List<HoaDonChiTiet> getAllByIdHD(String idHD){
        return hoaDonChiTietRepository.getAllByIdHD(idHD);
    }

    public void addHoaDonChiTiet(HoaDonChiTiet hoaDonChiTiet){
        hoaDonChiTietRepository.addHoaDonChiTiet(hoaDonChiTiet);
    }

    public void updateHoaDonChiTiet(HoaDonChiTiet hoaDonChiTiet){
        hoaDonChiTietRepository.updateHoaDonChiTiet(hoaDonChiTiet);
    }

    public void deleteHoaDonChiTiet(HoaDonChiTiet hoaDonChiTiet){
        hoaDonChiTietRepository.deleteHoaDonChiTiet(hoaDonChiTiet);
    }

    public HoaDonChiTiet getHoaDonChiTietById(String id){
        return hoaDonChiTietRepository.getHoaDonChiTietById(id);
    }

    public BigDecimal getTongTienByIdHD(String idHD){
        return hoaDonChiTietRepository.getTongTienByIdHD(idHD);
    }

    public Long getSoLuongSanPhamByIdHD(String idHD){
        return hoaDonChiTietRepository.getSoLuongSanPhamByIdHD(idHD);
    }
}
