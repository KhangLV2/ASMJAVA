package com.example.ASM.repository;

import com.example.ASM.model.GHCT;
import com.example.ASM.model.GioHang;
import com.example.ASM.model.GioHangChiTiet;
import com.example.ASM.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class GioHangChiTietRepository {

    public List<GioHangChiTiet> getAll(){
        List<GioHangChiTiet> listGioHangChiTiet = new ArrayList<>();
        try(Session session = HibernateUtil.getFACTORY().openSession()){
            listGioHangChiTiet = session.createQuery("from GioHangChiTiet ").list();
        }catch (Exception e){
            e.printStackTrace();
        }
        return listGioHangChiTiet;
    }

    public static List<GHCT> getAllByMaKH(String maKH){
        List<GHCT> listGHCT = new ArrayList<>();
        try(Session session = HibernateUtil.getFACTORY().openSession()){
            String hql = "select new com.example.ASM.model.GHCT(gh.idKH.id, ghct.idChiTietSP.id ,ghct.idChiTietSP.idSP.img, ghct.idChiTietSP.idSP.ten, ghct.idChiTietSP.idMauSac.ten, ghct.donGia, ghct.idChiTietSP.size, ghct.soLuong, ghct.trangThai)" +
                    " from com.example.ASM.model.GioHangChiTiet ghct" +
                    " join com.example.ASM.model.GioHang gh" +
                    " on gh.id = ghct.idGioHang.id" +
                    " where gh.idKH.ma = :maKH and ghct.trangThai = 0";
            Query query = session.createQuery(hql);
            query.setParameter("maKH", maKH);
            listGHCT = query.list();
        }catch (Exception e){
            e.printStackTrace();
        }
        return listGHCT;
    }

    public void addGioHangChiTiet(GioHangChiTiet gioHangChiTiet){
        Transaction transaction = null;
        try(Session session = HibernateUtil.getFACTORY().openSession()){
            transaction = session.beginTransaction();
            session.save(gioHangChiTiet);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
            transaction.rollback();
        }
    }

    public void updateGioHangChiTiet(GioHangChiTiet gioHangChiTiet){
        Transaction transaction = null;
        try(Session session = HibernateUtil.getFACTORY().openSession()){
            transaction = session.beginTransaction();
            session.saveOrUpdate(gioHangChiTiet);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
            transaction.rollback();
        }
    }

    public void deleteGioHangChiTiet(GioHangChiTiet gioHangChiTiet){
        Transaction transaction = null;
        try(Session session = HibernateUtil.getFACTORY().openSession()){
            transaction = session.beginTransaction();
            session.delete(gioHangChiTiet);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
            transaction.rollback();
        }
    }

    public GioHangChiTiet getGioHangChiTietById(String id){
        GioHangChiTiet gioHangChiTiet = new GioHangChiTiet();
        try(Session session = HibernateUtil.getFACTORY().openSession()){
            Query query = session.createQuery("from GioHangChiTiet where id = :id");
            query.setParameter("id", id);
            gioHangChiTiet = (GioHangChiTiet) query.getSingleResult();
            return gioHangChiTiet;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public GioHangChiTiet getGioHangChiTietByIdCTSP(String idCTSP){
        GioHangChiTiet gioHangChiTiet = new GioHangChiTiet();
        try(Session session = HibernateUtil.getFACTORY().openSession()){
            Query query = session.createQuery("from GioHangChiTiet where idChiTietSP.id = :idCTSP and trangThai = 0");
            query.setParameter("idCTSP", idCTSP);
            gioHangChiTiet = (GioHangChiTiet) query.getSingleResult();
            return gioHangChiTiet;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public static void updateSoLuongGHCTByIdCTSP(String idCTSP, Integer soLuong, BigDecimal donGia){
        Transaction transaction = null;
        try(Session session = HibernateUtil.getFACTORY().openSession()){
            transaction = session.beginTransaction();
            Query query = session.createQuery("update GioHangChiTiet set soLuong = soLuong + :soLuong, donGia = donGia + :donGia " +
                    " where idChiTietSP.id = :idCTSP");
            query.setParameter("idCTSP", idCTSP);
            query.setParameter("soLuong", soLuong);
            query.setParameter("donGia", donGia);
            query.executeUpdate();
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
            transaction.rollback();
        }
    }

    public static BigDecimal getDonGiaGioHangByMaKH(String ma){
        BigDecimal donGia = null;
        try(Session session = HibernateUtil.getFACTORY().openSession()){
            String hql = "select sum(ghct.donGia) from com.example.ASM.model.GioHang gh" +
                    " join com.example.ASM.model.GioHangChiTiet ghct" +
                    " on gh.id = ghct.idGioHang.id" +
                    " where gh.idKH.ma = :ma and ghct.trangThai = 0";

            Query query = session.createQuery(hql);
            query.setParameter("ma", ma);
            donGia = (BigDecimal) query.uniqueResult();
            return donGia;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public static void updateTrangThaiGHCTByIdGioHang(Integer trangThai, String idGioHang){
        Transaction transaction = null;
        try(Session session = HibernateUtil.getFACTORY().openSession()){
            transaction = session.beginTransaction();
            Query query = session.createQuery("update GioHangChiTiet set trangThai = :trangThai where idGioHang.id = :idGioHang");
            query.setParameter("trangThai", trangThai);
            query.setParameter("idGioHang", idGioHang);
            query.executeUpdate();
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
            transaction.rollback();
        }
    }
}
