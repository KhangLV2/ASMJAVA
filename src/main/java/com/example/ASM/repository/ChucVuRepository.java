package com.example.ASM.repository;

import com.example.ASM.model.ChucVu;
import org.hibernate.Session;
import com.example.ASM.util.HibernateUtil;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ChucVuRepository {

    public List<ChucVu> getAll(){
        List<ChucVu> listChucVu = new ArrayList<>();
        try(Session session = HibernateUtil.getFACTORY().openSession()){
            listChucVu = session.createQuery("from ChucVu").list();
            System.out.println(listChucVu);
        }catch (Exception e){
            e.printStackTrace();
        }
        return listChucVu;
    }

    public void addChucVu(ChucVu chucVu){
        Transaction transaction = null;
        try(Session session = HibernateUtil.getFACTORY().openSession()){
            transaction = session.beginTransaction();
            session.save(chucVu);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
            transaction.rollback();
        }
    }

    public void updateChucVu(ChucVu chucVu){
        Transaction transaction = null;
        try(Session session = HibernateUtil.getFACTORY().openSession()){
            transaction = session.beginTransaction();
            session.saveOrUpdate(chucVu);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
            transaction.rollback();
        }
    }

    public void deleteChucVu(ChucVu chucVu){
        Transaction transaction = null;
        try(Session session = HibernateUtil.getFACTORY().openSession()){
            transaction = session.beginTransaction();
            session.delete(chucVu);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
            transaction.rollback();
        }
    }

    public ChucVu getChucVuById(String id){
        ChucVu chucVu = new ChucVu();
        try(Session session = HibernateUtil.getFACTORY().openSession()){
            Query query = session.createQuery("from ChucVu where id = :id");
            query.setParameter("id", id);
            chucVu = (ChucVu) query.getSingleResult();
            return chucVu;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

}
