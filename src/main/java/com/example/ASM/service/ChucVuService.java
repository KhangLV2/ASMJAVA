package com.example.ASM.service;

import com.example.ASM.model.ChucVu;
import com.example.ASM.repository.ChucVuRepository;

import java.util.List;
import java.util.UUID;

public class ChucVuService {
    ChucVuRepository chucVuRepository = new ChucVuRepository();

    public List<ChucVu> getAll(){
        return chucVuRepository.getAll();
    }

    public void addChucVu(ChucVu chucVu){
        chucVuRepository.addChucVu(chucVu);
    }

    public void updateChucVu(ChucVu chucVu){
        chucVuRepository.updateChucVu(chucVu);
    }

    public void deleteChucVu(ChucVu chucVu){

        chucVuRepository.deleteChucVu(chucVu);
    }

    public ChucVu getChucVuById(String id){
        return chucVuRepository.getChucVuById(id);
    }
}
