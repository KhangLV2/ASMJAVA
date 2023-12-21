package com.example.ASM.repository;

import com.example.ASM.model.ChiTietSP;
import com.example.ASM.model.DongSP;
import com.example.ASM.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class DongSPRepository {

    public List<DongSP> getAll(){
        List<DongSP> listDongSP = new ArrayList<>();
        try(Session session = HibernateUtil.getFACTORY().openSession()){
            listDongSP = session.createQuery("from  DongSP ").list();
        }catch (Exception e){
            e.printStackTrace();
        }
        return listDongSP;
    }

    public void addDongSP(DongSP dongSP){
        Transaction transaction = null;
        try(Session session = HibernateUtil.getFACTORY().openSession()){
            transaction = session.beginTransaction();
            session.save(dongSP);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
            transaction.rollback();
        }
    }

    public void updateDongSP(DongSP dongSP){
        Transaction transaction = null;
        try(Session session = HibernateUtil.getFACTORY().openSession()){
            transaction = session.beginTransaction();
            session.saveOrUpdate(dongSP);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
            transaction.rollback();
        }
    }

    public void deleteDongSP(DongSP dongSP){
        Transaction transaction = null;
        try(Session session = HibernateUtil.getFACTORY().openSession()){
            transaction = session.beginTransaction();
            session.delete(dongSP);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
            transaction.rollback();
        }
    }

    public DongSP getDongSPById(String id){
        DongSP dongSP = new DongSP();
        try(Session session = HibernateUtil.getFACTORY().openSession()){
            Query query = session.createQuery("from DongSP where id = :id");
            query.setParameter("id", id);
            dongSP = (DongSP) query.getSingleResult();
            return dongSP;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
