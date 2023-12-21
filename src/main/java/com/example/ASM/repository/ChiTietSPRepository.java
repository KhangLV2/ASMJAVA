package com.example.ASM.repository;

import com.example.ASM.model.ChiTietSP;
import com.example.ASM.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ChiTietSPRepository {

    public List<ChiTietSP> getAll(){
        List<ChiTietSP> listChiTietSP = new ArrayList<>();
        try(Session session = HibernateUtil.getFACTORY().openSession()){
            listChiTietSP = session.createQuery("from ChiTietSP order by idSP").list();
        }catch (Exception e){
            e.printStackTrace();
        }
        return listChiTietSP;
    }

    public List<ChiTietSP> getAllSize(){
        List<ChiTietSP> listChiTietSP = new ArrayList<>();
        try(Session session = HibernateUtil.getFACTORY().openSession()){
            listChiTietSP = session.createQuery("select distinct size from ChiTietSP ").list();
        }catch (Exception e){
            e.printStackTrace();
        }
        return listChiTietSP;
    }

    public void addChiTietSP(ChiTietSP chiTietSP){
        Transaction transaction = null;
        try(Session session = HibernateUtil.getFACTORY().openSession()){
            transaction = session.beginTransaction();
            session.save(chiTietSP);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
            transaction.rollback();
        }
    }

    public void updateChiTietSP(ChiTietSP chiTietSP){
        Transaction transaction = null;
        try(Session session = HibernateUtil.getFACTORY().openSession()){
            transaction = session.beginTransaction();
            session.saveOrUpdate(chiTietSP);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
            transaction.rollback();
        }
    }

    public void deleteChiTietSP(ChiTietSP chiTietSP){
        Transaction transaction = null;
        try(Session session = HibernateUtil.getFACTORY().openSession()){
            transaction = session.beginTransaction();
            session.delete(chiTietSP);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
            transaction.rollback();
        }
    }

    public ChiTietSP getChiTietSPById(String id){
        ChiTietSP chiTietSP = new ChiTietSP();
        try(Session session = HibernateUtil.getFACTORY().openSession()){
            Query query = session.createQuery("from ChiTietSP where id = :id");
            query.setParameter("id", id);
            chiTietSP = (ChiTietSP) query.getSingleResult();
            return chiTietSP;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public ChiTietSP getChiTietSPByIdSP(String idSP, Integer size){
        ChiTietSP chiTietSP = new ChiTietSP();
        try(Session session = HibernateUtil.getFACTORY().openSession()){
            Query query = session.createQuery("from ChiTietSP where idSP.id = :idSP and size = :size");
            query.setParameter("idSP", idSP);
            query.setParameter("size", size);
            chiTietSP = (ChiTietSP) query.getSingleResult();
            return chiTietSP;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
