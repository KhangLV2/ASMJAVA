package com.example.ASM.repository;

import com.example.ASM.model.DongSP;
import com.example.ASM.model.KhachHang;
import com.example.ASM.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class KhachHangRepository {

    public List<KhachHang> getAll(){
        List<KhachHang> listKhachHang = new ArrayList<>();
        try(Session session = HibernateUtil.getFACTORY().openSession()){
            listKhachHang = session.createQuery("from KhachHang ").list();
        }catch (Exception e){
            e.printStackTrace();
        }
        return listKhachHang;
    }

    public void addKhachHang(KhachHang khachHang){
        Transaction transaction = null;
        try(Session session = HibernateUtil.getFACTORY().openSession()){
            transaction = session.beginTransaction();
            session.save(khachHang);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
            transaction.rollback();
        }
    }

    public void updateKhachHang(KhachHang khachHang){
        Transaction transaction = null;
        try(Session session = HibernateUtil.getFACTORY().openSession()){
            transaction = session.beginTransaction();
            session.saveOrUpdate(khachHang);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
            transaction.rollback();
        }
    }

    public void deleteKhachHang(KhachHang khachHang){
        Transaction transaction = null;
        try(Session session = HibernateUtil.getFACTORY().openSession()){
            transaction = session.beginTransaction();
            session.delete(khachHang);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
            transaction.rollback();
        }
    }

    public KhachHang getKhachHangById(String id){
        KhachHang khachHang = new KhachHang();
        try(Session session = HibernateUtil.getFACTORY().openSession()){
            Query query = session.createQuery("from KhachHang where id = :id");
            query.setParameter("id", id);
            khachHang = (KhachHang) query.getSingleResult();
            return khachHang;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public KhachHang getKhachHangByMa(String ma){
        KhachHang khachHang = new KhachHang();
        try(Session session = HibernateUtil.getFACTORY().openSession()){
            Query query = session.createQuery("from KhachHang where ma = :ma");
            query.setParameter("ma", ma);
            khachHang = (KhachHang) query.getSingleResult();
            return khachHang;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public KhachHang xacThucTaiKhoan(String ma){
        List<KhachHang> listKhachHang = getAll();
        KhachHang khachHangCanTim = null;
        for (KhachHang khachHang : listKhachHang){
            if(khachHang.getMa().equals(ma)){
                khachHangCanTim = khachHang;
            }
        }
        return khachHangCanTim;
    }
}
