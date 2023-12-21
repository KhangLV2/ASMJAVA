package com.example.ASM.service;

import com.example.ASM.model.ChiTietSP;
import com.example.ASM.repository.ChiTietSPRepository;

import java.util.List;
import java.util.UUID;

public class ChiTietSPService {
    ChiTietSPRepository chiTietSPRepository = new ChiTietSPRepository();

    public List<ChiTietSP> getAll(){
        return chiTietSPRepository.getAll();
    }

    public List<ChiTietSP> getAllSize(){
        return chiTietSPRepository.getAllSize();
    }

    public void addChiTietSP(ChiTietSP chiTietSP){
        chiTietSPRepository.addChiTietSP(chiTietSP);
    }

    public void updateChiTietSP(ChiTietSP chiTietSP){
        chiTietSPRepository.updateChiTietSP(chiTietSP);
    }

    public void deleteChiTietSP(ChiTietSP chiTietSP){
        chiTietSPRepository.deleteChiTietSP(chiTietSP);
    }

    public ChiTietSP getChiTietSPById(String id){
        return chiTietSPRepository.getChiTietSPById(id);
    }

    public ChiTietSP getChiTietSPByIdSP(String idSP, Integer size){
        return chiTietSPRepository.getChiTietSPByIdSP(idSP, size);
    }

}
