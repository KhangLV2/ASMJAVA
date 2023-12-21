package com.example.ASM.service;

import com.example.ASM.model.KhachHang;
import com.example.ASM.repository.KhachHangRepository;

import java.util.List;
import java.util.UUID;

public class KhachHangService {
    KhachHangRepository khachHangRepository = new KhachHangRepository();

    public List<KhachHang> getAll(){
        return khachHangRepository.getAll();
    }

    public void addKhachHang (KhachHang khachHang){
        khachHangRepository.addKhachHang(khachHang);
    }

    public void updateKhachHang (KhachHang khachHang){
        khachHangRepository.updateKhachHang(khachHang);
    }

    public void deleteKhachHang (KhachHang khachHang){
        khachHangRepository.deleteKhachHang(khachHang);
    }

    public KhachHang getKhachHangById(String id){
        return khachHangRepository.getKhachHangById(id);
    }

    public KhachHang getKhachHangByMa(String ma){
        return khachHangRepository.getKhachHangByMa(ma);
    }

    public Integer xacThucTaiKhoan(KhachHang khachHang){
        KhachHang khachHangCanXacThuc = khachHangRepository.xacThucTaiKhoan(khachHang.getMa());
        if(khachHangCanXacThuc != null){
            String matKhau = khachHang.getMatKhau();
            if(khachHangCanXacThuc.getMatKhau().equals(matKhau)){
                return 1; //Đúng tài khoản
            }else {
                return -1; //Sai mật khẩu
            }
        }
        return 0; //Sai tên tài khoản
    }
}
