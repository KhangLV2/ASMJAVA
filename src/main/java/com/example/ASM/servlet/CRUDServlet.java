package com.example.ASM.servlet;

import com.example.ASM.model.*;
import com.example.ASM.service.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import javax.swing.*;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@WebServlet(name = "CRUDServlet", value = {
        "/chuc-vu/hien-thi", "/chuc-vu/detail", "/chuc-vu/add", "/chuc-vu/update", "/chuc-vu/delete",
        "/mau-sac/hien-thi", "/mau-sac/detail", "/mau-sac/add", "/mau-sac/update", "/mau-sac/delete",
        "/cua-hang/hien-thi", "/cua-hang/detail", "/cua-hang/add", "/cua-hang/update", "/cua-hang/delete",
        "/dongSP/hien-thi", "/dongSP/detail", "/dongSP/add", "/dongSP/update", "/dongSP/delete",
        "/khach-hang/hien-thi", "/khach-hang/detail", "/khach-hang/add", "/khach-hang/update", "/khach-hang/delete",
        "/nsx/hien-thi", "/nsx/detail", "/nsx/add", "/nsx/update", "/nsx/delete",
        "/san-pham/hien-thi", "/san-pham/detail", "/san-pham/add", "/san-pham/update", "/san-pham/delete",
        "/nhan-vien/hien-thi", "/nhan-vien/detail", "/nhan-vien/add", "/nhan-vien/update", "/nhan-vien/delete",
        "/chi-tiet-sp/hien-thi", "/chi-tiet-sp/detail", "/chi-tiet-sp/add", "/chi-tiet-sp/update", "/chi-tiet-sp/delete",
})
public class CRUDServlet extends HttpServlet {
    ChucVuService chucVuService = new ChucVuService();
    MauSacService mauSacService = new MauSacService();
    CuaHangService cuaHangService = new CuaHangService();
    DongSPService dongSPService = new DongSPService();
    KhachHangService khachHangService = new KhachHangService();
    NSXService nsxService = new NSXService();
    SanPhamService sanPhamService = new SanPhamService();
    NhanVienService nhanVienService = new NhanVienService();
    ChiTietSPService chiTietSPService = new ChiTietSPService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if(uri.contains("/chuc-vu/hien-thi")){
            this.getAllChucVu(request, response);
        }else if(uri.contains("/mau-sac/hien-thi")){
            this.getAllMauSac(request, response);
        }else if(uri.contains("/cua-hang/hien-thi")){
            this.getAllCuaHang(request, response);
        }else if(uri.contains("/dongSP/hien-thi")){
            this.getAllDongSP(request, response);
        }else if(uri.contains("/khach-hang/hien-thi")){
            this.getAllKhachHang(request, response);
        }else if(uri.contains("/nsx/hien-thi")){
            this.getAllNSX(request, response);
        }else if(uri.contains("/san-pham/hien-thi")){
            this.getAllSanPham(request, response);
        }else if(uri.contains("/nhan-vien/hien-thi")){
            this.getAllNhanVien(request, response);
        }else if(uri.contains("/chi-tiet-sp/hien-thi")){
            this.getAllChiTietSP(request, response);
        }else if(uri.contains("/chuc-vu/detail")){
            this.detailChucVu(request, response);
        }else if(uri.contains("/mau-sac/detail")){
            this.detailMauSac(request, response);
        }else if(uri.contains("/cua-hang/detail")){
            this.detailCuaHang(request, response);
        }else if(uri.contains("/dongSP/detail")){
            this.detailDongSP(request, response);
        }else if(uri.contains("/khach-hang/detail")){
            this.detailKhachHang(request, response);
        }else if(uri.contains("/nsx/detail")){
            this.detailNSX(request, response);
        }else if(uri.contains("/san-pham/detail")){
            this.detailSanPham(request, response);
        }else if(uri.contains("/nhan-vien/detail")){
            this.detailNhanVien(request, response);
        }else if(uri.contains("/chi-tiet-sp/detail")){
            this.detailChiTietSP(request, response);
        }else if(uri.contains("/chuc-vu/delete")){
            this.deleteChucVu(request, response);
        }else if(uri.contains("/mau-sac/delete")){
            this.deleteMauSac(request, response);
        }else if(uri.contains("/cua-hang/delete")){
            this.deleteCuaHang(request, response);
        }else if(uri.contains("/dongSP/delete")){
            this.deleteDongSP(request, response);
        }else if(uri.contains("/khach-hang/delete")){
            this.deleteKhachHang(request, response);
        }else if(uri.contains("/nsx/delete")){
            this.deleteNSX(request, response);
        }else if(uri.contains("/san-pham/delete")){
            this.deleteSanPham(request, response);
        }else if(uri.contains("/nhan-vien/delete")){
            this.deleteNhanVien(request, response);
        }else if(uri.contains("/chi-tiet-sp/delete")){
            this.deleteChiTietSP(request, response);
        }
    }

    private void deleteChiTietSP(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String id = request.getParameter("id");
        ChiTietSP chiTietSP = chiTietSPService.getChiTietSPById(id);
        chiTietSPService.deleteChiTietSP(chiTietSP);
        response.sendRedirect("/chi-tiet-sp/hien-thi");
    }

    private void deleteNhanVien(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String id = request.getParameter("id");
        NhanVien nhanVien = nhanVienService.getNhanVienById(id);
        nhanVienService.deleteNhanVien(nhanVien);
        response.sendRedirect("/nhan-vien/hien-thi");
    }

    private void deleteSanPham(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String id = request.getParameter("id");
        SanPham sanPham = sanPhamService.getSanPhamById(id);
        sanPhamService.deleteSanPham(sanPham);
        response.sendRedirect("/san-pham/hien-thi");
    }

    private void deleteNSX(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String id = request.getParameter("id");
        NSX nsx = nsxService.getNSXById(id);
        nsxService.deleteNSX(nsx);
        response.sendRedirect("/nsx/hien-thi");
    }

    private void deleteKhachHang(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String id = request.getParameter("id");
        KhachHang khachHang = khachHangService.getKhachHangById(id);
        khachHangService.deleteKhachHang(khachHang);
        response.sendRedirect("/khach-hang/hien-thi");
    }

    private void deleteDongSP(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String id = request.getParameter("id");
        DongSP dongSP = dongSPService.getDongSPById(id);
        dongSPService.deleteDongSP(dongSP);
        response.sendRedirect("/dongSP/hien-thi");
    }

    private void deleteCuaHang(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String id = request.getParameter("id");
        CuaHang cuaHang = cuaHangService.getCuaHangById(id);
        cuaHangService.deleteCuaHang(cuaHang);
        response.sendRedirect("/cua-hang/hien-thi");
    }

    private void deleteMauSac(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String id = request.getParameter("id");
        MauSac mauSac = mauSacService.getMauSacById(id);
        mauSacService.deleteMauSac(mauSac);
        response.sendRedirect("/mau-sac/hien-thi");
    }

    private void detailChiTietSP(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<DongSP> listDongSP = dongSPService.getAll();
        List<SanPham> listSanPham = sanPhamService.getAll();
        List<MauSac> listMauSac = mauSacService.getAll();
        List<NSX> listNSX = nsxService.getAll();

        String id = request.getParameter("id");
        ChiTietSP chiTietSP = chiTietSPService.getChiTietSPById(id);
        request.setAttribute("chiTietSP", chiTietSP);
        request.setAttribute("listDongSP", listDongSP);
        request.setAttribute("listSanPham", listSanPham);
        request.setAttribute("listMauSac", listMauSac);
        request.setAttribute("listNsx", listNSX);
        request.getRequestDispatcher("/views-chitietsp/updateChiTietSP.jsp").forward(request, response);
    }

    private void detailNhanVien(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<ChucVu> listChucVu = chucVuService.getAll();
        List<CuaHang> listCuaHang = cuaHangService.getAll();
        String id = request.getParameter("id");
        NhanVien nhanVien = nhanVienService.getNhanVienById(id);
        request.setAttribute("listChucVu", listChucVu);
        request.setAttribute("listCuaHang", listCuaHang);
        request.setAttribute("nhanVien", nhanVien);
        request.getRequestDispatcher("/views-nhanvien/updateNhanVien.jsp").forward(request, response);
    }

    private void detailSanPham(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        SanPham sanPham = sanPhamService.getSanPhamById(id);
        request.setAttribute("sanPham", sanPham);
        request.getRequestDispatcher("/views-sanpham/updateSanPham.jsp").forward(request, response);
    }

    private void detailNSX(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        NSX nsx = nsxService.getNSXById(id);
        request.setAttribute("nsx", nsx);
        request.getRequestDispatcher("/views-nsx/updateNSX.jsp").forward(request, response);
    }

    private void detailKhachHang(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            String id = request.getParameter("id");
            KhachHang khachHang = khachHangService.getKhachHangById(id);
            request.setAttribute("khachHang", khachHang);
            request.getRequestDispatcher("/views-khachhang/updateKhachHang.jsp").forward(request, response);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private void detailDongSP(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        DongSP dongSP = dongSPService.getDongSPById(id);
        request.setAttribute("dongSP", dongSP);
        request.getRequestDispatcher("/views-dongsp/updateDongSP.jsp").forward(request, response);
    }

    private void detailCuaHang(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        CuaHang cuaHang = cuaHangService.getCuaHangById(id);
        request.setAttribute("cuaHang", cuaHang);
        request.getRequestDispatcher("/views-cuahang/updateCuaHang.jsp").forward(request, response);
    }

    private void detailMauSac(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        MauSac mauSac = mauSacService.getMauSacById(id);
        request.setAttribute("mauSac", mauSac);
        request.getRequestDispatcher("/views-mausac/updateMauSac.jsp").forward(request, response);
    }

    private void deleteChucVu(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String id = request.getParameter("id");
        ChucVu chucVu = chucVuService.getChucVuById(id);
        chucVuService.deleteChucVu(chucVu);
        response.sendRedirect("/chuc-vu/hien-thi");
    }

    private void getAllChiTietSP(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<ChiTietSP> listChiTietSP = chiTietSPService.getAll();
        List<SanPham> listSanPham = sanPhamService.getAll();
        List<DongSP> listDongSP = dongSPService.getAll();
        List<NSX> listNsx = nsxService.getAll();
        List<MauSac> listMauSac = mauSacService.getAll();
        request.setAttribute("listChiTietSP", listChiTietSP);
        request.setAttribute("listSanPham", listSanPham);
        request.setAttribute("listDongSP", listDongSP);
        request.setAttribute("listNsx", listNsx);
        request.setAttribute("listMauSac", listMauSac);
        request.getRequestDispatcher("/views-chitietsp/listChiTietSP.jsp").forward(request, response);
    }

    private void getAllNhanVien(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<NhanVien> listNhanVien = nhanVienService.getAll();
        List<ChucVu> listChucVu = chucVuService.getAll();
        List<CuaHang> listCuaHang = cuaHangService.getAll();
        request.setAttribute("listNhanVien", listNhanVien);
        request.setAttribute("listChucVu", listChucVu);
        request.setAttribute("listCuaHang", listCuaHang);
        request.getRequestDispatcher("/views-nhanvien/listNhanVien.jsp").forward(request, response);
    }

    private void detailChucVu(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        ChucVu chucVuDetail = chucVuService.getChucVuById(id);
        request.setAttribute("chucVu", chucVuDetail);
        request.getRequestDispatcher("/views-chucvu/updateChucVu.jsp").forward(request, response);
    }

    private void getAllSanPham(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<SanPham> listSanPham = sanPhamService.getAll();
        request.setAttribute("listSanPham", listSanPham);
        request.getRequestDispatcher("/views-sanpham/listSanPham.jsp").forward(request, response);
    }

    private void getAllNSX(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<NSX> listNSX = nsxService.getAll();
        request.setAttribute("listNSX", listNSX);
        request.getRequestDispatcher("/views-nsx/listNSX.jsp").forward(request, response);
    }

    private void getAllKhachHang(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<KhachHang> listKhachHang = khachHangService.getAll();
        request.setAttribute("listKhachHang", listKhachHang);
        request.getRequestDispatcher("/views-khachhang/listKhachHang.jsp").forward(request, response);
    }

    private void getAllDongSP(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<DongSP> listDongSP = dongSPService.getAll();
        request.setAttribute("listDongSP", listDongSP);
        request.getRequestDispatcher("/views-dongsp/listDongSP.jsp").forward(request, response);
    }

    private void getAllCuaHang(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<CuaHang> listCuaHang = cuaHangService.getAll();
        request.setAttribute("listCuaHang", listCuaHang);
        request.getRequestDispatcher("/views-cuahang/listCuaHang.jsp").forward(request, response);
    }

    private void getAllMauSac(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<MauSac> listMauSac = mauSacService.getAll();
        request.setAttribute("listMauSac", listMauSac);
        request.getRequestDispatcher("/views-mausac/listMauSac.jsp").forward(request, response);
    }

    private void getAllChucVu(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<ChucVu> listChucVu = chucVuService.getAll();
        request.setAttribute("listChucVu", listChucVu);
        request.getRequestDispatcher("/views-chucvu/listChucVu.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if(uri.contains("/chuc-vu/add")){
            this.addChucVu(request, response);
        }else if(uri.contains("/mau-sac/add")){
            this.addMauSac(request, response);
        }else if(uri.contains("/cua-hang/add")){
            this.addCuaHang(request, response);
        }else if(uri.contains("/dongSP/add")){
            this.addDongSP(request, response);
        }else if(uri.contains("/khach-hang/add")){
            this.addKhachHang(request, response);
        }else if(uri.contains("/nsx/add")){
            this.addNSX(request, response);
        }else if(uri.contains("/san-pham/add")){
            this.addSanPham(request, response);
        }else if(uri.contains("/nhan-vien/add")){
            this.addNhanVien(request, response);
        }else if(uri.contains("/chi-tiet-sp/add")){
            this.addChiTietSP(request, response);
        }else if(uri.contains("/chuc-vu/update")){
            this.updateChucVu(request, response);
        }else if(uri.contains("/mau-sac/update")){
            this.updateMauSac(request, response);
        }else if(uri.contains("/cua-hang/update")){
            this.updateCuaHang(request, response);
        }else if(uri.contains("/dongSP/update")){
            this.updateDongSP(request, response);
        }else if(uri.contains("/khach-hang/update")){
            this.updateKhachHang(request, response);
        }else if(uri.contains("/nsx/update")){
            this.updateNSX(request, response);
        }else if(uri.contains("/san-pham/update")){
            this.updateSanPham(request, response);
        }else if(uri.contains("/nhan-vien/update")){
            this.updateNhanVien(request, response);
        }else if(uri.contains("/chi-tiet-sp/update")){
            this.updateChiTietSP(request, response);
        }
    }

    private void updateNhanVien(HttpServletRequest request, HttpServletResponse response) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String id = request.getParameter("id");
            String ma = request.getParameter("ma");
            String ten = request.getParameter("ten");
            String tenDem = request.getParameter("tenDem");
            String ho = request.getParameter("ho");
            String gioiTinh = request.getParameter("gioiTinh");
            Date ngaySinh = sdf.parse(request.getParameter("ngaySinh"));
            String diaChi = request.getParameter("diaChi");
            String sdt = request.getParameter("sdt");
            String matKhau = request.getParameter("matKhau");
            String idCH = request.getParameter("idCH");
            CuaHang cuaHang = new CuaHang();
            cuaHang.setId(idCH);
            String idCV = request.getParameter("idCV");
            ChucVu chucVu = new ChucVu();
            chucVu.setId(idCV);
            Integer trangThai = Integer.parseInt(request.getParameter("trangThai"));

            NhanVien nhanVien = new NhanVien(id, ma, ten, tenDem, ho, gioiTinh, ngaySinh, diaChi, sdt, matKhau, cuaHang, chucVu, trangThai);
            nhanVienService.updateNhanVien(nhanVien);
            response.sendRedirect("/nhan-vien/hien-thi");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private void updateChiTietSP(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String id = request.getParameter("id");
        String idDongSP = request.getParameter("idDongSP");
        String idSanPham = request.getParameter("idSanPham");
        String idMauSac = request.getParameter("idMauSac");
        String idNsx = request.getParameter("idNsx");
        Integer namBH = Integer.parseInt(request.getParameter("namBH"));
        String moTa = request.getParameter("moTa");
        Integer soLuong = Integer.parseInt(request.getParameter("soLuong"));
        BigDecimal giaNhap = new BigDecimal(request.getParameter("giaNhap"));
        BigDecimal giaBan = new BigDecimal(request.getParameter("giaBan"));
        Integer size = Integer.parseInt(request.getParameter("size"));

        DongSP dongSP = new DongSP();
        dongSP.setId(idDongSP);
        SanPham sanPham = new SanPham();
        sanPham.setId(idSanPham);
        MauSac mauSac = new MauSac();
        mauSac.setId(idMauSac);
        NSX nsx = new NSX();
        nsx.setId(idNsx);

        ChiTietSP chiTietSP = new ChiTietSP(id, sanPham, nsx,mauSac, dongSP,namBH, moTa, soLuong, giaNhap, giaBan, size, 1);
        chiTietSPService.updateChiTietSP(chiTietSP);
        response.sendRedirect("/chi-tiet-sp/hien-thi");
    }

    private void updateSanPham(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String id = request.getParameter("id");
        String ma = request.getParameter("ma");
        String ten = request.getParameter("ten");
        String img = request.getParameter("img");

        SanPham sanPham = new SanPham(id, ma, ten, img);
        sanPhamService.updateSanPham(sanPham);
        response.sendRedirect("/san-pham/hien-thi");
    }

    private void updateNSX(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String id = request.getParameter("id");
        String ma = request.getParameter("ma");
        String ten = request.getParameter("ten");
        NSX nsx = new NSX(id, ma, ten);
        nsxService.updateNSX(nsx);
        response.sendRedirect("/nsx/hien-thi");
    }

    private void updateKhachHang(HttpServletRequest request, HttpServletResponse response) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String id = request.getParameter("id");
            String ma = request.getParameter("ma");
            String ten = request.getParameter("ten");
            String tenDem = request.getParameter("tenDem");
            String ho = request.getParameter("ho");
            Date ngaySinh = sdf.parse(request.getParameter("ngaySinh"));
            String sdt = request.getParameter("sdt");
            String diaChi = request.getParameter("diaChi");
            String thanhPho = request.getParameter("thanhPho");
            String quocGia = request.getParameter("quocGia");
            String matKhau = request.getParameter("matKhau");

            KhachHang khachHang = new KhachHang(id, ma, ten, tenDem, ho, ngaySinh, sdt, diaChi, thanhPho, quocGia, matKhau);
            khachHangService.updateKhachHang(khachHang);
            response.sendRedirect("/khach-hang/hien-thi");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private void updateDongSP(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String id = request.getParameter("id");
        String ma = request.getParameter("ma");
        String ten =  request.getParameter("ten");

        DongSP dongSP = new DongSP(id, ma, ten);
        dongSPService.updateDongSP(dongSP);
        response.sendRedirect("/dongSP/hien-thi");
    }

    private void updateCuaHang(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String id = request.getParameter("id");
        String ma = request.getParameter("ma");
        String ten = request.getParameter("ten");
        String diaChi = request.getParameter("diaChi");
        String thanhPho = request.getParameter("thanhPho");
        String quocGia = request.getParameter("quocGia");

        CuaHang cuaHang = new CuaHang(id, ma, ten, diaChi, thanhPho, quocGia);

        cuaHangService.updateCuaHang(cuaHang);
        response.sendRedirect("/cua-hang/hien-thi");
    }

    private void updateMauSac(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String id = request.getParameter("id");
        String ma = request.getParameter("ma");
        String ten = request.getParameter("ten");

        MauSac mauSac = new MauSac(id, ma, ten);
        mauSacService.updateMauSac(mauSac);
        response.sendRedirect("/mau-sac/hien-thi");
    }

    private void updateChucVu(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String id = request.getParameter("id");
        String ma = request.getParameter("ma");
        String ten = request.getParameter("ten");

        ChucVu chucVu = new ChucVu(id, ma, ten);
        chucVuService.updateChucVu(chucVu);
        response.sendRedirect("/chuc-vu/hien-thi");
    }

    private void addChiTietSP(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String idDongSP = request.getParameter("idDongSP");
        String idSanPham = request.getParameter("idSanPham");
        String idMauSac = request.getParameter("idMauSac");
        String idNsx = request.getParameter("idNsx");
        Integer namBH = Integer.parseInt(request.getParameter("namBH"));
        String moTa = request.getParameter("moTa");
        Integer soLuong = Integer.parseInt(request.getParameter("soLuong"));
        BigDecimal giaNhap = new BigDecimal(request.getParameter("giaNhap"));
        BigDecimal giaBan = new BigDecimal(request.getParameter("giaBan"));
        Integer size = Integer.parseInt(request.getParameter("size"));

        DongSP dongSP = new DongSP();
        dongSP.setId(idDongSP);
        SanPham sanPham = new SanPham();
        sanPham.setId(idSanPham);
        MauSac mauSac = new MauSac();
        mauSac.setId(idMauSac);
        NSX nsx = new NSX();
        nsx.setId(idNsx);

        ChiTietSP chiTietSP = new ChiTietSP(null, sanPham, nsx,mauSac, dongSP,namBH, moTa, soLuong, giaNhap, giaBan, size, 1);
        chiTietSPService.addChiTietSP(chiTietSP);
        response.sendRedirect("/chi-tiet-sp/hien-thi");
    }

    private void addNhanVien(HttpServletRequest request, HttpServletResponse response) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String ma = request.getParameter("ma");
            String ten = request.getParameter("ten");
            String tenDem = request.getParameter("tenDem");
            String ho = request.getParameter("ho");
            String gioiTinh = request.getParameter("gioiTinh");
            Date ngaySinh = sdf.parse(request.getParameter("ngaySinh"));
            String diaChi = request.getParameter("diaChi");
            String sdt = request.getParameter("sdt");
            String matKhau = request.getParameter("matKhau");
            String idCH = request.getParameter("idCH");
            CuaHang cuaHang = new CuaHang();
            cuaHang.setId(idCH);
            String idCV = request.getParameter("idCV");
            ChucVu chucVu = new ChucVu();
            chucVu.setId(idCV);
            Integer trangThai = Integer.parseInt(request.getParameter("trangThai"));

            NhanVien nhanVien = new NhanVien(null, ma, ten, tenDem, ho, gioiTinh, ngaySinh, diaChi, sdt, matKhau, cuaHang, chucVu, trangThai);
            nhanVienService.addNhanVien(nhanVien);
            response.sendRedirect("/nhan-vien/hien-thi");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private void addSanPham(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String ma = request.getParameter("ma");
        String ten = request.getParameter("ten");
        String img = request.getParameter("img");

        SanPham sanPham = new SanPham(null, ma, ten, img);
        sanPhamService.addSanPham(sanPham);
        response.sendRedirect("/san-pham/hien-thi");
    }

    private void addNSX(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String ma = request.getParameter("ma");
        String ten = request.getParameter("ten");
        NSX nsx = new NSX(null, ma, ten);
        nsxService.addNSX(nsx);
        response.sendRedirect("/nsx/hien-thi");
    }

    private void addKhachHang(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String ma = request.getParameter("ma");
            String ten = request.getParameter("ten");
            String tenDem = request.getParameter("tenDem");
            String ho = request.getParameter("ho");
            Date ngaySinh = sdf.parse(request.getParameter("ngaySinh"));
            String sdt = request.getParameter("sdt");
            String diaChi = request.getParameter("diaChi");
            String thanhPho = request.getParameter("thanhPho");
            String quocGia = request.getParameter("quocGia");
            String matKhau = request.getParameter("matKhau");

            KhachHang khachHang = new KhachHang();
            khachHang.setMa(ma);
            khachHang.setTen(ten);
            khachHang.setTenDem(tenDem);
            khachHang.setHo(ho);
            khachHang.setNgaySinh(ngaySinh);
            khachHang.setSdt(sdt);
            khachHang.setDiaChi(diaChi);
            khachHang.setThanhPho(thanhPho);
            khachHang.setQuocGia(quocGia);
            khachHang.setMatKhau(matKhau);

            khachHangService.addKhachHang(khachHang);
            response.sendRedirect("/khach-hang/hien-thi");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private void addDongSP(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String ma = request.getParameter("ma");
        String ten =  request.getParameter("ten");

        DongSP dongSP = new DongSP();
        dongSP.setMa(ma);
        dongSP.setTen(ten);
        dongSPService.addDongSP(dongSP);
        response.sendRedirect("/dongSP/hien-thi");
    }

    private void addCuaHang(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String ma = request.getParameter("ma");
        String ten = request.getParameter("ten");
        String diaChi = request.getParameter("diaChi");
        String thanhPho = request.getParameter("thanhPho");
        String quocGia = request.getParameter("quocGia");

        CuaHang cuaHang = new CuaHang();
        cuaHang.setMa(ma);
        cuaHang.setTen(ten);
        cuaHang.setDiaChi(diaChi);
        cuaHang.setThanhPho(thanhPho);
        cuaHang.setQuocGia(quocGia);

        cuaHangService.addCuaHang(cuaHang);
        response.sendRedirect("/cua-hang/hien-thi");
    }

    private void addMauSac(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String ma = request.getParameter("ma");
        String ten = request.getParameter("ten");

        MauSac mauSac = new MauSac();
        mauSac.setMa(ma);
        mauSac.setTen(ten);
        mauSacService.addMauSac(mauSac);
        response.sendRedirect("/mau-sac/hien-thi");
    }

    private void addChucVu(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String ma = request.getParameter("ma");
        String ten = request.getParameter("ten");

        ChucVu chucVu = new ChucVu();
        chucVu.setMa(ma);
        chucVu.setTen(ten);
        chucVuService.addChucVu(chucVu);
        response.sendRedirect("/chuc-vu/hien-thi");
    }
}
