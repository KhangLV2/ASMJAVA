package com.example.ASM.service;

import com.example.ASM.model.DongSP;
import com.example.ASM.repository.DongSPRepository;

import java.util.List;
import java.util.UUID;

public class DongSPService {
    DongSPRepository dongSPRepository = new DongSPRepository();

    public List<DongSP> getAll(){
        return dongSPRepository.getAll();
    }

    public void addDongSP(DongSP dongSP){
        dongSPRepository.addDongSP(dongSP);
    }

    public void updateDongSP(DongSP dongSP){
        dongSPRepository.updateDongSP(dongSP);
    }

    public void deleteDongSP(DongSP dongSP){
        dongSPRepository.deleteDongSP(dongSP);
    }

    public DongSP getDongSPById(String id){
        return dongSPRepository.getDongSPById(id);
    }
}
