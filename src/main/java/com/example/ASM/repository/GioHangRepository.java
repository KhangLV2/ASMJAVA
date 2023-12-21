package com.example.ASM.repository;

import com.example.ASM.model.GioHang;
import com.example.ASM.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class GioHangRepository {

    public static List<GioHang> getAll(){
        List<GioHang> listGioHang = new ArrayList<>();
        try(Session session = HibernateUtil.getFACTORY().openSession()){
            listGioHang = session.createQuery("from GioHang ").list();
        }catch (Exception e){
            e.printStackTrace();
        }
        return listGioHang;
    }

    public void addGioHang(GioHang gioHang){
        Transaction transaction = null;
        try(Session session = HibernateUtil.getFACTORY().openSession()){
            transaction = session.beginTransaction();
            session.save(gioHang);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
            transaction.rollback();
        }
    }

    public void updateGioHang(GioHang gioHang){
        Transaction transaction = null;
        try(Session session = HibernateUtil.getFACTORY().openSession()){
            transaction = session.beginTransaction();
            session.saveOrUpdate(gioHang);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
            transaction.rollback();
        }
    }

    public void deleteGioHang(GioHang gioHang){
        Transaction transaction = null;
        try(Session session = HibernateUtil.getFACTORY().openSession()){
            transaction = session.beginTransaction();
            session.delete(gioHang);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
            transaction.rollback();
        }
    }

    public GioHang getGioHangById(String id){
        GioHang gioHang =  new GioHang();
        try(Session session = HibernateUtil.getFACTORY().openSession()){
            Query query = session.createQuery("from GioHang where id = :id");
            query.setParameter("id", id);
            gioHang = (GioHang) query.getSingleResult();
            return gioHang;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public static GioHang getGioHangByIdKH(String idKH){
        GioHang gioHang =  new GioHang();
        try(Session session = HibernateUtil.getFACTORY().openSession()){
            Query query = session.createQuery("from GioHang where idKH.id = :idKH");
            query.setParameter("idKH", idKH);
            gioHang = (GioHang) query.getSingleResult();
            return gioHang;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public static Long getSoLuongGioHangByMaKH(String ma){
        Long soLuong = null;
        try(Session session = HibernateUtil.getFACTORY().openSession()){
            String hql = "select count(*) from com.example.ASM.model.GioHang gh" +
                    " join com.example.ASM.model.GioHangChiTiet ghct" +
                    " on gh.id = ghct.idGioHang.id" +
                    " where gh.idKH.ma = :ma and ghct.trangThai = 0";

            Query query = session.createQuery(hql);
            query.setParameter("ma", ma);
            soLuong = (Long) query.uniqueResult();
            return soLuong;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public static void updateTrangThaiGioHangByIdKH(Integer tinhTrang, String idKH){
        Transaction transaction = null;
        try(Session session = HibernateUtil.getFACTORY().openSession()){
            transaction = session.beginTransaction();
            Query query = session.createQuery("update GioHang set tinhTrang = :tinhTrang where idKH.id = :idKH and tinhTrang = 0");
            query.setParameter("tinhTrang", tinhTrang);
            query.setParameter("idKH", idKH);
            query.executeUpdate();
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
            transaction.rollback();
        }
    }

}
