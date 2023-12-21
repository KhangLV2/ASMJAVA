package com.example.ASM.repository;

import com.example.ASM.model.NSX;
import com.example.ASM.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class NSXRepository {

    public List<NSX> getAll(){
        List<NSX> listNsx = new ArrayList<>();
        try(Session session = HibernateUtil.getFACTORY().openSession()){
            listNsx = session.createQuery("from  NSX ").list();
        }catch (Exception e){
            e.printStackTrace();
        }
        return listNsx;
    }

    public void addNSX(NSX nsx){
        Transaction transaction = null;
        try(Session session = HibernateUtil.getFACTORY().openSession()){
            transaction = session.beginTransaction();
            session.save(nsx);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
            transaction.rollback();
        }
    }

    public void updateNSX(NSX nsx){
        Transaction transaction = null;
        try(Session session = HibernateUtil.getFACTORY().openSession()){
            transaction = session.beginTransaction();
            session.saveOrUpdate(nsx);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
            transaction.rollback();
        }
    }

    public void deleteNSX(NSX nsx){
        Transaction transaction = null;
        try(Session session = HibernateUtil.getFACTORY().openSession()){
            transaction = session.beginTransaction();
            session.delete(nsx);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
            transaction.rollback();
        }
    }

    public NSX getNSXById(String id){
        NSX nsx = new NSX();
        try(Session session = HibernateUtil.getFACTORY().openSession()){
            Query query = session.createQuery("from NSX where id = :id");
            query.setParameter("id", id);
            nsx = (NSX) query.getSingleResult();
            return nsx;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
