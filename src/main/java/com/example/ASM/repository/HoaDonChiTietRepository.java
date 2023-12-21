package com.example.ASM.repository;

import com.example.ASM.model.HoaDon;
import com.example.ASM.model.HoaDonChiTiet;
import com.example.ASM.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class HoaDonChiTietRepository {

    public List<HoaDonChiTiet> getAll(){
        List<HoaDonChiTiet> listHoaDonChiTiet = new ArrayList<>();
        try(Session session = HibernateUtil.getFACTORY().openSession()){
            listHoaDonChiTiet = session.createQuery("from HoaDonChiTiet ").list();
        }catch (Exception e){
            e.printStackTrace();
        }
        return listHoaDonChiTiet;
    }

    public List<HoaDonChiTiet> getAllByIdHD(String idHD){
        List<HoaDonChiTiet> listHoaDonChiTiet = new ArrayList<>();
        try(Session session = HibernateUtil.getFACTORY().openSession()){
            Query query = session.createQuery("from HoaDonChiTiet where idHoaDon.id = :idHD");
            query.setParameter("idHD", idHD);
            listHoaDonChiTiet = query.list();
            return listHoaDonChiTiet;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public void addHoaDonChiTiet(HoaDonChiTiet hoaDonChiTiet){
        Transaction transaction = null;
        try(Session session = HibernateUtil.getFACTORY().openSession()){
            transaction = session.beginTransaction();
            session.save(hoaDonChiTiet);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
            transaction.rollback();
        }
    }

    public void updateHoaDonChiTiet(HoaDonChiTiet hoaDonChiTiet){
        Transaction transaction = null;
        try(Session session = HibernateUtil.getFACTORY().openSession()){
            transaction = session.beginTransaction();
            session.saveOrUpdate(hoaDonChiTiet);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
            transaction.rollback();
        }
    }

    public void deleteHoaDonChiTiet(HoaDonChiTiet hoaDonChiTiet){
        Transaction transaction = null;
        try(Session session = HibernateUtil.getFACTORY().openSession()){
            transaction = session.beginTransaction();
            session.delete(hoaDonChiTiet);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
            transaction.rollback();
        }
    }

    public HoaDonChiTiet getHoaDonChiTietById(String id){
        HoaDonChiTiet hoaDonChiTiet = new HoaDonChiTiet();
        try(Session session = HibernateUtil.getFACTORY().openSession()){
            Query query = session.createQuery("from HoaDonChiTiet where id = :id");
            query.setParameter("id", id);
            hoaDonChiTiet = (HoaDonChiTiet) query.getSingleResult();
            return hoaDonChiTiet;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public static BigDecimal getTongTienByIdHD(String idHD){
        BigDecimal tongTien = null;
        try(Session session = HibernateUtil.getFACTORY().openSession()){
            String hql = "select sum (donGia) from HoaDonChiTiet where idHoaDon.id = :idHD";
            Query query = session.createQuery(hql);
            query.setParameter("idHD", idHD);
            tongTien = (BigDecimal) query.uniqueResult();
            return tongTien;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public static Long getSoLuongSanPhamByIdHD(String idHD){
        Long soLuong = null;
        try(Session session = HibernateUtil.getFACTORY().openSession()){
            String hql = "select sum (soLuong) from HoaDonChiTiet where idHoaDon.id = :idHD";
            Query query = session.createQuery(hql);
            query.setParameter("idHD", idHD);
            soLuong = (Long) query.uniqueResult();
            return soLuong;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
