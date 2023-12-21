package com.example.ASM.service;

import com.example.ASM.model.MauSac;
import com.example.ASM.repository.MauSacRepository;

import java.util.List;
import java.util.UUID;

public class MauSacService {
    MauSacRepository mauSacRepository = new MauSacRepository();

    public List<MauSac> getAll(){
        return mauSacRepository.getAll();
    }

    public void addMauSac(MauSac mauSac){
        mauSacRepository.addMauSac(mauSac);
    }

    public void updateMauSac(MauSac mauSac){
        mauSacRepository.updateMauSac(mauSac);
    }

    public void deleteMauSac(MauSac mauSac){
        mauSacRepository.deleteMauSac(mauSac);
    }

    public MauSac getMauSacById(String id){
        return mauSacRepository.getMauSacById(id);
    }

}
