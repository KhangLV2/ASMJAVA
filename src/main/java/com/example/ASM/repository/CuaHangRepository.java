package com.example.ASM.repository;

import com.example.ASM.model.CuaHang;
import com.example.ASM.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class CuaHangRepository {

    public List<CuaHang> getAll(){
        List<CuaHang> listCuaHang = new ArrayList<>();
        try(Session session = HibernateUtil.getFACTORY().openSession()){
            listCuaHang = session.createQuery("from CuaHang ").list();
        }catch (Exception e){
            e.printStackTrace();
        }
        return listCuaHang;
    }

    public void addCuaHang(CuaHang cuaHang){
        Transaction transaction = null;
        try(Session session = HibernateUtil.getFACTORY().openSession()){
            transaction = session.beginTransaction();
            session.save(cuaHang);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
            transaction.rollback();
        }
    }

    public void updateCuaHang(CuaHang cuaHang){
        Transaction transaction = null;
        try(Session session = HibernateUtil.getFACTORY().openSession()){
            transaction = session.beginTransaction();
            session.saveOrUpdate(cuaHang);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
            transaction.rollback();
        }
    }

    public void deleteCuaHang(CuaHang cuaHang){
        Transaction transaction = null;
        try(Session session = HibernateUtil.getFACTORY().openSession()){
            transaction = session.beginTransaction();
            session.delete(cuaHang);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
            transaction.rollback();
        }
    }

    public CuaHang getCuaHangById(String id){
        CuaHang cuaHang = new CuaHang();
        try(Session session = HibernateUtil.getFACTORY().openSession()){
            Query query = session.createQuery("from CuaHang where id = :id");
            query.setParameter("id", id);
            cuaHang = (CuaHang) query.getSingleResult();
            return cuaHang;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
