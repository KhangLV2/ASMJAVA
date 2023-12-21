package com.example.ASM.service;

import com.example.ASM.model.CuaHang;
import com.example.ASM.repository.CuaHangRepository;

import java.util.List;
import java.util.UUID;

public class CuaHangService {
    CuaHangRepository cuaHangRepository = new CuaHangRepository();

    public List<CuaHang> getAll(){
        return cuaHangRepository.getAll();
    }

    public void addCuaHang (CuaHang cuaHang){
        cuaHangRepository.addCuaHang(cuaHang);
    }

    public void updateCuaHang (CuaHang cuaHang){
        cuaHangRepository.updateCuaHang(cuaHang);
    }

    public void deleteCuaHang (CuaHang cuaHang){
        cuaHangRepository.deleteCuaHang(cuaHang);
    }

    public CuaHang getCuaHangById(String id){
        return cuaHangRepository.getCuaHangById(id);
    }
}
