package com.example.ASM.service;

import com.example.ASM.model.SanPham;
import com.example.ASM.model.SanPhamList;
import com.example.ASM.repository.SanPhamRepository;

import java.util.List;
import java.util.UUID;

public class SanPhamService {
    SanPhamRepository sanPhamRepository = new SanPhamRepository();

    public List<SanPham> getAll(){
        return sanPhamRepository.getAll();
    }

    public void addSanPham(SanPham sanPham){
        sanPhamRepository.addSanPham(sanPham);
    }

    public void updateSanPham(SanPham sanPham){
        sanPhamRepository.updateSanPham(sanPham);
    }

    public void deleteSanPham(SanPham sanPham){
        sanPhamRepository.deleteSanPham(sanPham);
    }

    public SanPham getSanPhamById(String id){
        return sanPhamRepository.getSanPhamById(id);
    }

    public List<SanPhamList> getAllSPList(){
        return sanPhamRepository.getAllSPList();
    }
}
