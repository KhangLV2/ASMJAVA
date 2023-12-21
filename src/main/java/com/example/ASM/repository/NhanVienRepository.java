package com.example.ASM.repository;

import com.example.ASM.model.NhanVien;
import com.example.ASM.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class NhanVienRepository {

    public List<NhanVien> getAll(){
        List<NhanVien> listNhanVien = new ArrayList<>();
        try(Session session = HibernateUtil.getFACTORY().openSession()){
            listNhanVien = session.createQuery("from NhanVien").list();
        }catch (Exception e){
            e.printStackTrace();
        }
        return listNhanVien;
    }

    public void addNhanVien(NhanVien nhanVien){
        Transaction transaction = null;
        try(Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.save(nhanVien);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
            transaction.rollback();
        }
    }

    public void updateNhanVien(NhanVien nhanVien){
        Transaction transaction = null;
        try(Session session = HibernateUtil.getFACTORY().openSession()){
            transaction = session.beginTransaction();
            session.saveOrUpdate(nhanVien);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
            transaction.rollback();
        }
    }

    public void deleteNhanVien(NhanVien nhanVien){
        Transaction transaction = null;
        try(Session session = HibernateUtil.getFACTORY().openSession()){
            transaction = session.beginTransaction();
            session.delete(nhanVien);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
            transaction.rollback();
        }
    }

    public NhanVien getNhanVienById(String id){
        NhanVien nhanVien = new NhanVien();
        try(Session session = HibernateUtil.getFACTORY().openSession()){
            Query query = session.createQuery("from NhanVien where id = :id");
            query.setParameter("id", id);
            nhanVien = (NhanVien) query.getSingleResult();
            return nhanVien;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
