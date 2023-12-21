package com.example.ASM.service;

import com.example.ASM.model.NSX;
import com.example.ASM.repository.NSXRepository;

import java.util.List;
import java.util.UUID;

public class NSXService {
    NSXRepository nsxRepository = new NSXRepository();

    public List<NSX> getAll(){
        return  nsxRepository.getAll();
    }

    public void addNSX(NSX nsx){
        nsxRepository.addNSX(nsx);
    }

    public void updateNSX(NSX nsx){
        nsxRepository.updateNSX(nsx);
    }

    public void deleteNSX(NSX nsx){
        nsxRepository.deleteNSX(nsx);
    }

    public NSX getNSXById(String id){
        return nsxRepository.getNSXById(id);
    }
}
