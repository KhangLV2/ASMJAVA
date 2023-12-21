package com.example.ASM.repository;

import com.example.ASM.model.ChiTietSP;
import com.example.ASM.model.SanPham;
import com.example.ASM.model.SanPhamList;
import com.example.ASM.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class SanPhamRepository {

    public List<SanPham> getAll(){
        List<SanPham> listSanPham = new ArrayList<>();
        try(Session session = HibernateUtil.getFACTORY().openSession()){
            listSanPham = session.createQuery("from SanPham ").list();
        }catch (Exception e){
            e.printStackTrace();
        }
        return listSanPham;
    }

    public void addSanPham(SanPham sanPham){
        Transaction transaction = null;
        try(Session session = HibernateUtil.getFACTORY().openSession()){
            transaction = session.beginTransaction();
            session.save(sanPham);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
            transaction.rollback();
        }
    }

    public void updateSanPham(SanPham sanPham){
        Transaction transaction = null;
        try(Session session = HibernateUtil.getFACTORY().openSession()){
            transaction = session.beginTransaction();
            session.saveOrUpdate(sanPham);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
            transaction.rollback();
        }
    }

    public void deleteSanPham(SanPham sanPham){
        Transaction transaction = null;
        try(Session session = HibernateUtil.getFACTORY().openSession()){
            transaction = session.beginTransaction();
            session.delete(sanPham);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
            transaction.rollback();
        }
    }

    public SanPham getSanPhamById(String id){
        SanPham sanPham = new SanPham();
        try(Session session = HibernateUtil.getFACTORY().openSession()){
            Query query = session.createQuery("from SanPham where id = :id");
            query.setParameter("id", id);
            sanPham = (SanPham) query.getSingleResult();
            return sanPham;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public static List<SanPhamList> getAllSPList(){
        List<SanPhamList> listSPL = new ArrayList<>();
        try(Session session = HibernateUtil.getFACTORY().openSession()){
            String hql = "select distinct new com.example.ASM.model.SanPhamList(sp.id, sp.ten, sp.img, ctsp.giaBan, ms.ten) " +
                    " from com.example.ASM.model.SanPham sp " +
                    " join com.example.ASM.model.ChiTietSP ctsp " +
                    " On sp.id = ctsp.idSP.id" +
                    " join com.example.ASM.model.MauSac ms" +
                    " ON ms.id = ctsp.idMauSac.id";

            Query query = session.createQuery(hql);
            listSPL = query.list();
        }catch (Exception e){
            e.printStackTrace();
        }
        return listSPL;
    }

}
