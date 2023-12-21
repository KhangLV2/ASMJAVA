package com.example.ASM.service;

import com.example.ASM.model.HoaDon;
import com.example.ASM.repository.HoaDonRepository;

import java.math.BigDecimal;
import java.util.List;

public class HoaDonService {
    HoaDonRepository hoaDonRepository = new HoaDonRepository();

    public List<HoaDon> getAll(){
        return hoaDonRepository.getAll();
    }

    public List<HoaDon> getAllByIdKH(String idKH){
        return hoaDonRepository.getAllByIdKH(idKH);
    }

    public void addHoaDon(HoaDon hoaDon){
        hoaDonRepository.addHoaDon(hoaDon);
    }

    public void updateHoaDon(HoaDon hoaDon){
        hoaDonRepository.updateHoaDon(hoaDon);
    }

    public void deleteHoaDon(HoaDon hoaDon){
        hoaDonRepository.deleteHoaDon(hoaDon);
    }

    public HoaDon getHoaDonById(String id){
        return hoaDonRepository.getHoaDonById(id);
    }

    public HoaDon getHoaDonByTinhTrang(Integer tinhTrang){
        return hoaDonRepository.getHoaDonByTinhTrang(tinhTrang);
    }

    public void updateTinhTrangHoaDon(Integer soLuong, BigDecimal tongTien){
        hoaDonRepository.updateTinhTrangHoaDon(soLuong, tongTien);
    }
}
