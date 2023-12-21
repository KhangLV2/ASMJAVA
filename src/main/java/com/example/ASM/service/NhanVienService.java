package com.example.ASM.service;

import com.example.ASM.model.NhanVien;
import com.example.ASM.repository.NhanVienRepository;

import java.util.List;
import java.util.UUID;

public class NhanVienService {
    NhanVienRepository nhanVienRepository = new NhanVienRepository();

    public List<NhanVien> getAll(){
        return nhanVienRepository.getAll();
    }

    public void addNhanVien(NhanVien nhanVien){
        nhanVienRepository.addNhanVien(nhanVien);
    }

    public void updateNhanVien(NhanVien nhanVien){
        nhanVienRepository.updateNhanVien(nhanVien);
    }

    public void deleteNhanVien(NhanVien nhanVien){
        nhanVienRepository.deleteNhanVien(nhanVien);
    }

    public NhanVien getNhanVienById(String id){
        return nhanVienRepository.getNhanVienById(id);
    }
}
