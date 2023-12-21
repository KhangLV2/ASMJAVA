package com.example.ASM.repository;

import com.example.ASM.model.MauSac;
import org.hibernate.Session;
import com.example.ASM.util.HibernateUtil;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class MauSacRepository {

    public List<MauSac> getAll(){
        List<MauSac> listMauSac = new ArrayList<>();
        try (Session session = HibernateUtil.getFACTORY().openSession()){
            listMauSac = session.createQuery("from MauSac ").list();
        }catch (Exception e){
            e.printStackTrace();
        }
        return listMauSac;
    }

    public void addMauSac(MauSac mauSac){
        Transaction transaction = null;
        try(Session session = HibernateUtil.getFACTORY().openSession()){
            transaction = session.beginTransaction();
            session.save(mauSac);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
            transaction.rollback();
        }
    }

    public void updateMauSac(MauSac mauSac){
        Transaction transaction = null;
        try(Session session = HibernateUtil.getFACTORY().openSession()){
            transaction = session.beginTransaction();
            session.saveOrUpdate(mauSac);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
            transaction.rollback();
        }
    }

    public void deleteMauSac(MauSac mauSac){
        Transaction transaction = null;
        try(Session session = HibernateUtil.getFACTORY().openSession()){
            transaction = session.beginTransaction();
            session.delete(mauSac);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
            transaction.rollback();
        }
    }

    public MauSac getMauSacById(String id){
        MauSac mauSac = new MauSac();
        try(Session session = HibernateUtil.getFACTORY().openSession()){
            Query query = session.createQuery("from MauSac where id = :id");
            query.setParameter("id", id);
            mauSac = (MauSac) query.getSingleResult();
            return mauSac;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }


    public List<MauSac> paging(int pageNumber,int pageSize ){
        List<MauSac> list = new ArrayList<>();
        Transaction transaction = null;
//        int pageNumber = 1;
//        int pageSize = 6;
        try (Session session = HibernateUtil.getFACTORY().openSession()){
            transaction = session.beginTransaction();
            Query query = session.createQuery("from MauSac ");

            // Thiết lập phân trang
            query.setFirstResult((pageNumber - 1) * pageSize);
            query.setMaxResults(pageSize);

            // Thực hiện truy vấn và nhận danh sách kết quả
            list = query.getResultList();
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
            transaction.rollback();
        }
        return list;
    }
}
