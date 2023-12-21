package com.example.ASM.repository;

import com.example.ASM.model.HoaDon;
import com.example.ASM.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class HoaDonRepository {

    public List<HoaDon> getAll(){
        List<HoaDon> listHoaDon = new ArrayList<>();
        try(Session session = HibernateUtil.getFACTORY().openSession()){
            listHoaDon = session.createQuery("from HoaDon").list();
        }catch (Exception e){
            e.printStackTrace();
        }
        return listHoaDon;
    }

    public List<HoaDon> getAllByIdKH(String idKH){
        List<HoaDon> listHoaDon = new ArrayList<>();
        try(Session session = HibernateUtil.getFACTORY().openSession()){
            Query query = session.createQuery(" from HoaDon where idKH.id = :idKH order by ngayThanhToan desc ");
            query.setParameter("idKH", idKH);
            listHoaDon = query.list();
            return listHoaDon;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public void addHoaDon(HoaDon hoaDon){
        Transaction transaction = null;
        try(Session session = HibernateUtil.getFACTORY().openSession()){
            transaction = session.beginTransaction();
            session.save(hoaDon);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void updateHoaDon(HoaDon hoaDon){
        Transaction transaction = null;
        try(Session session = HibernateUtil.getFACTORY().openSession()){
            transaction = session.beginTransaction();
            session.saveOrUpdate(hoaDon);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void deleteHoaDon(HoaDon hoaDon){
        Transaction transaction = null;
        try(Session session = HibernateUtil.getFACTORY().openSession()){
            transaction = session.beginTransaction();
            session.delete(hoaDon);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public HoaDon getHoaDonById(String id){
        HoaDon hoaDon = new HoaDon();
        try(Session session = HibernateUtil.getFACTORY().openSession()){
            Query query = session.createQuery("from HoaDon where id = :id");
            query.setParameter("id", id);
            hoaDon = (HoaDon) query.getSingleResult();
            return hoaDon;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public HoaDon getHoaDonByTinhTrang(Integer tinhTrang){
        HoaDon hoaDon = new HoaDon();
        try(Session session = HibernateUtil.getFACTORY().openSession()){
            Query query = session.createQuery("from HoaDon where tinhTrang = :tinhTrang");
            query.setParameter("tinhTrang", tinhTrang);
            hoaDon = (HoaDon) query.getSingleResult();
            return hoaDon;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public static void updateTinhTrangHoaDon(Integer soLuong, BigDecimal tongTien){
        Transaction transaction = null;
        try(Session session = HibernateUtil.getFACTORY().openSession()){
            transaction = session.beginTransaction();
            Query query = session.createQuery("update HoaDon set tinhTrang = 1, soLuong = :soLuong, tongTien = :tongTien  where tinhTrang = 0");
            query.setParameter("soLuong", soLuong);
            query.setParameter("tongTien", tongTien);
            query.executeUpdate();
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
            transaction.rollback();
        }
    }

}
