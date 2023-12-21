package com.example.ASM.servlet;

import com.example.ASM.model.*;
import com.example.ASM.repository.GioHangChiTietRepository;
import com.example.ASM.service.*;
import com.example.ASM.util.UtilInfo;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import javax.swing.*;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@WebServlet(name = "BanHangServlet", value = {
        "/store/xoa-san-pham",
        "/store/trang-chu",
        "/store/detail-ctsp",
        "/store/dang-nhap",
        "/store/dang-ky",
        "/store/dang-xuat",
        "/store/cong-so-luong",
        "/store/tru-so-luong",
        "/store/them-gio-hang",
        "/store/gio-hang",
        "/store/thanh-toan",
        "/store/chon-san-pham",
        "/store/lich-su-mua-hang",
        "/store/chi-tiet-hoa-don",
})
public class BanHangServlet extends HttpServlet {
    SanPhamService sanPhamService = new SanPhamService();
    ChiTietSPService chiTietSPService = new ChiTietSPService();
    KhachHangService khachHangService = new KhachHangService();
    GioHangService gioHangService = new GioHangService();
    GioHangChiTietService gioHangChiTietService = new GioHangChiTietService();
    HoaDonService hoaDonService = new HoaDonService();
    HoaDonChiTietService hoaDonChiTietService = new HoaDonChiTietService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if(uri.contains("/trang-chu")){
            this.trangChu(request, response);
        }else if(uri.contains("/dang-nhap")){
            request.getRequestDispatcher("/views-banhang/dangNhap.jsp").forward(request, response);
        }else if(uri.contains("/dang-ky")){
            request.getRequestDispatcher("/views-banhang/dangKy.jsp").forward(request, response);
        }else if(uri.contains("/dang-xuat")){
            UtilInfo.tenTK = null;
            this.trangChu(request, response);
        }else if(uri.contains("/gio-hang")){
            this.gioHang(request, response);
        }else if(uri.contains("/detail-ctsp")){
            this.detailChiTietSP(request, response);
        }else if(uri.contains("/cong-so-luong")){
            this.congSoLuong(request, response);
        }else if(uri.contains("/tru-so-luong")){
            this.truSoLuong(request, response);
        }else if(uri.contains("/xoa-san-pham")){
            this.xoaSanPhamGioHang(request, response);
        }else if(uri.contains("/chon-san-pham")){
            this.chonSanPhamThanhToan(request, response);
        }else if(uri.contains("/lich-su-mua-hang")){
            this.lichSuMuaHang(request, response);
        }else if(uri.contains("/chi-tiet-hoa-don")){
            this.chiTietHoaDon(request, response);
        }
    }

    private void chiTietHoaDon(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //Lấy ra thông tin khách hàng đăng nhập
        String ma = UtilInfo.tenTK;
        KhachHang khachHang = khachHangService.getKhachHangByMa(ma);
        request.setAttribute("khachHang", khachHang);

        if(khachHang == null){
            //Lấy số lượng sản phẩm trong giỏ hàng theo mã KH
            Long soLuongGH = gioHangService.getSoLuongGioHangByMaKH(ma);
            request.setAttribute("soLuongGH", soLuongGH);
            request.getRequestDispatcher("/views-banhang/chiTietHoaDon.jsp").forward(request, response);
        }else {
            //Lấy số lượng sản phẩm trong giỏ hàng theo mã KH
            Long soLuongGH = gioHangService.getSoLuongGioHangByMaKH(ma);
            request.setAttribute("soLuongGH", soLuongGH);

            //Lấy danh sách hóa đơn chi tiết theo idHD
            String idHD = request.getParameter("idHD");
            List<HoaDonChiTiet> listHoaDonChiTiet = hoaDonChiTietService.getAllByIdHD(idHD);
            request.setAttribute("listHoaDonChiTiet", listHoaDonChiTiet);

            request.getRequestDispatcher("/views-banhang/chiTietHoaDon.jsp").forward(request, response);
        }
    }

    private void lichSuMuaHang(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //Lấy ra thông tin khách hàng đăng nhập
        String ma = UtilInfo.tenTK;
        KhachHang khachHang = khachHangService.getKhachHangByMa(ma);
        request.setAttribute("khachHang", khachHang);

        if(khachHang == null){
            //Lấy số lượng sản phẩm trong giỏ hàng theo mã KH
            Long soLuongGH = gioHangService.getSoLuongGioHangByMaKH(ma);
            request.setAttribute("soLuongGH", soLuongGH);
            request.getRequestDispatcher("/views-banhang/lichSuMuaHang.jsp").forward(request, response);
        }else {
            //Lấy số lượng sản phẩm trong giỏ hàng theo mã KH
            Long soLuongGH = gioHangService.getSoLuongGioHangByMaKH(ma);
            request.setAttribute("soLuongGH", soLuongGH);

            //Lấy danh sách hóa đơn theo idKH
            List<HoaDon> listHoaDon = hoaDonService.getAllByIdKH(khachHang.getId());
            request.setAttribute("listHoaDon", listHoaDon);

            request.getRequestDispatcher("/views-banhang/lichSuMuaHang.jsp").forward(request, response);
        }


    }

    private void chonSanPhamThanhToan(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String idCTSP = request.getParameter("idCTSP");
        GioHangChiTiet gioHangChiTiet = gioHangChiTietService.getGioHangChiTietByIdCTSP(idCTSP);
        BigDecimal donGia = gioHangChiTiet.getDonGia();
        request.setAttribute("donGia", donGia);
        response.sendRedirect("/store/gio-hang");
    }

    private void xoaSanPhamGioHang(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String idCTSP = request.getParameter("idCTSP");
        GioHangChiTiet gioHangChiTiet = gioHangChiTietService.getGioHangChiTietByIdCTSP(idCTSP);
        gioHangChiTietService.deleteGioHangChiTiet(gioHangChiTiet);
        response.sendRedirect("/store/gio-hang");
    }

    private void truSoLuong(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ChiTietSP chiTietSP = chiTietSPService.getChiTietSPByIdSP(UtilInfo.idSP, 40);
        List<ChiTietSP> listSize = chiTietSPService.getAllSize();
        //Lấy ra tên tài khoản
        String ma = UtilInfo.tenTK;
        KhachHang khachHang = khachHangService.getKhachHangByMa(ma);
        Integer sl = Integer.parseInt(request.getParameter("sl"));

        ChiTietSPSoLuong ctspSL = new ChiTietSPSoLuong();
        ctspSL.setSoLuong(sl-1);
        if(ctspSL.getSoLuong() == 0){
            ctspSL.setSoLuong(1);
        }

        //Lấy số lượng sản phẩm trong giỏ hàng theo mã KH
        Long soLuongGH = gioHangService.getSoLuongGioHangByMaKH(ma);
        request.setAttribute("soLuongGH", soLuongGH);

        request.setAttribute("ctspSL", ctspSL);
        request.setAttribute("khachHang", khachHang);
        request.setAttribute("listSize", listSize);
        request.setAttribute("chiTietSP", chiTietSP);
        request.getRequestDispatcher("/views-banhang/chiTietSanPham.jsp").forward(request, response);
    }

    private void congSoLuong(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ChiTietSP chiTietSP = chiTietSPService.getChiTietSPByIdSP(UtilInfo.idSP, 40);
        List<ChiTietSP> listSize = chiTietSPService.getAllSize();
        //Lấy ra tên tài khoản
        String ma = UtilInfo.tenTK;
        KhachHang khachHang = khachHangService.getKhachHangByMa(ma);
        Integer sl = Integer.parseInt(request.getParameter("sl"));

        ChiTietSPSoLuong ctspSL = new ChiTietSPSoLuong();
        ctspSL.setSoLuong(sl+1);

        //Lấy số lượng sản phẩm trong giỏ hàng theo mã KH
        Long soLuongGH = gioHangService.getSoLuongGioHangByMaKH(ma);
        request.setAttribute("soLuongGH", soLuongGH);

        request.setAttribute("ctspSL", ctspSL);
        request.setAttribute("khachHang", khachHang);
        request.setAttribute("listSize", listSize);
        request.setAttribute("chiTietSP", chiTietSP);
        request.getRequestDispatcher("/views-banhang/chiTietSanPham.jsp").forward(request, response);
    }

    private void gioHang(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //Lấy ra tên tài khoản
        String ma = UtilInfo.tenTK;
        KhachHang khachHang = khachHangService.getKhachHangByMa(ma);

        //Lấy số lượng sản phẩm trong giỏ hàng theo mã KH
        Long soLuongGH = gioHangService.getSoLuongGioHangByMaKH(ma);
        request.setAttribute("soLuongGH", soLuongGH);

        //Lấy danh sách giỏ hàng chi tiết
        List<GHCT> listGHCT = gioHangChiTietService.getAllByMaKH(ma);
        request.setAttribute("listGHCT", listGHCT);

        //Lấy tổng tiền trong giỏ
        DecimalFormat dmf = new DecimalFormat("#,###.##");
        BigDecimal tongTien = gioHangChiTietService.getDonGiaGioHangByMaKH(ma);
        if(tongTien==null){
            tongTien = new BigDecimal(0);
        }
        request.setAttribute("tongTien", dmf.format(tongTien));

        request.setAttribute("khachHang", khachHang);
        request.getRequestDispatcher("/views-banhang/gioHang.jsp").forward(request, response);
    }

    private void detailChiTietSP(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idSP = request.getParameter("idSP");
        ChiTietSP chiTietSP = chiTietSPService.getChiTietSPByIdSP(idSP, 40);
        List<ChiTietSP> listSize = chiTietSPService.getAllSize();

        //Lưu lại idSP
        UtilInfo.idSP = idSP;

        //Lấy ra tên tài khoản
        String ma = UtilInfo.tenTK;
        KhachHang khachHang = khachHangService.getKhachHangByMa(ma);

        //Lấy số lượng sản phẩm trong giỏ hàng theo mã KH
        Long soLuongGH = gioHangService.getSoLuongGioHangByMaKH(ma);
        request.setAttribute("soLuongGH", soLuongGH);

        // Sét số lượng
        ChiTietSPSoLuong ctspSL = new ChiTietSPSoLuong();
        ctspSL.setSoLuong(1);

        request.setAttribute("ctspSL", ctspSL);
        request.setAttribute("khachHang", khachHang);
        request.setAttribute("listSize", listSize);
        request.setAttribute("chiTietSP", chiTietSP);
        request.getRequestDispatcher("/views-banhang/chiTietSanPham.jsp").forward(request, response);
    }

    private void trangChu(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //Lấy ra thông tin khách hàng đăng nhập
        String ma = UtilInfo.tenTK;
        KhachHang khachHang = khachHangService.getKhachHangByMa(ma);
        request.setAttribute("khachHang", khachHang);

        //Lấy số lượng sản phẩm trong giỏ hàng theo mã KH
        Long soLuongGH = gioHangService.getSoLuongGioHangByMaKH(ma);
        request.setAttribute("soLuongGH", soLuongGH);

        List<SanPhamList> listSPL = sanPhamService.getAllSPList();
        request.setAttribute("listSPL", listSPL);
        request.getRequestDispatcher("/views-banhang/trangChu.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            String uri = request.getRequestURI();
            if(uri.contains("/dang-nhap")){
                this.dangNhap(request, response);
            }else if(uri.contains("/dang-ky")){
                this.dangKy(request, response);
            }else if(uri.contains("/them-gio-hang")){
                this.themGioHang(request, response);
            }else if(uri.contains("/thanh-toan")){
                this.thanhToan(request, response);
            }
    }

    private void thanhToan(HttpServletRequest request, HttpServletResponse response) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            LocalDate ngayHienTai = LocalDate.now();
            //Lấy ra thông tin khách hàng đăng nhập
            String ma = UtilInfo.tenTK;
            KhachHang khachHang = khachHangService.getKhachHangByMa(ma);
            request.setAttribute("khachHang", khachHang);

            //Tạo hóa đơn
            HoaDon hoaDon = new HoaDon();
            hoaDon.setIdKH(khachHang);
            hoaDon.setNgayTao(sdf.parse(ngayHienTai+""));
            hoaDon.setNgayThanhToan(sdf.parse(ngayHienTai+""));
            hoaDon.setTinhTrang(0);
            hoaDon.setTenNguoiNhan(khachHang.getTen());
            hoaDon.setDiaChi(khachHang.getDiaChi() + khachHang.getThanhPho());
            hoaDon.setSdt(khachHang.getSdt());
            hoaDonService.addHoaDon(hoaDon);

            //Tìm hóa đơn có trạng thái là 0 -> Ném vào chiTietHD
            HoaDon hoaDonTinhTrang0 = hoaDonService.getHoaDonByTinhTrang(0);

            //Tạo HoaDonChiTiet
            HoaDonChiTiet hoaDonChiTiet = new HoaDonChiTiet();
            List<GHCT> listGHCT = gioHangChiTietService.getAllByMaKH(ma);
            for (GHCT ghct : listGHCT){
                ChiTietSP chiTietSP = chiTietSPService.getChiTietSPById(ghct.getIdCTSP());
                hoaDonChiTiet.setIdHoaDon(hoaDonTinhTrang0);
                hoaDonChiTiet.setIdChiTietSP(chiTietSP);
                hoaDonChiTiet.setSoLuong(ghct.getSoLuong());
                hoaDonChiTiet.setDonGia(ghct.getDonGia());
                hoaDonChiTietService.addHoaDonChiTiet(hoaDonChiTiet);
            }

            //Lấy số lượng sản phẩm trong hóa đơn chi tiết
            Long slSP = hoaDonChiTietService.getSoLuongSanPhamByIdHD(hoaDonTinhTrang0.getId());
            Integer soLuongSP = Integer.parseInt(String.valueOf(slSP));

            //Lấy tổng tiền sản phẩm trong hóa đơn chi tiết
            BigDecimal tongTien = hoaDonChiTietService.getTongTienByIdHD(hoaDonTinhTrang0.getId());

            //Tạo HoaDonChiTiet xong update lại tình trạng HoaDon -> 1, update lại số lượng và tổng tiền
            hoaDonService.updateTinhTrangHoaDon(soLuongSP, tongTien);

            //update trạng thái giỏ hàng chi tiết
            //Get giỏ hàng theo idKH
            GioHang gioHang = gioHangService.getGioHangByIdKH(khachHang.getId());
            //update giỏ hàng chi tiết theo idGioHang
            gioHangChiTietService.updateTrangThaiGHCTByIdGioHang(1, gioHang.getId());

            response.sendRedirect("/store/trang-chu");

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private void themGioHang(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        KhachHang khachHang = khachHangService.getKhachHangByMa(UtilInfo.tenTK);
        List<GioHang> listGioHang = gioHangService.getAll();
        for (GioHang gioHang : listGioHang){
            if(khachHang==null){
                //ko tìm thấy thì cho đăng nhập và tạo mới giỏ hàng
                request.getRequestDispatcher("/views-banhang/dangNhap.jsp").forward(request, response);
            }else if(gioHang.getIdKH().getId().equals(khachHang.getId())){
                //Nếu tìm thấy giỏ hàng trùng với idKH thì thêm sản phẩm vào giỏ
                Integer size = Integer.parseInt(request.getParameter("size"));
                Integer soLuong = Integer.parseInt(request.getParameter("ctspSL"));

                ChiTietSPSoLuong ctspSL = new ChiTietSPSoLuong();
                ctspSL.setSoLuong(soLuong);
                ChiTietSP chiTietSP = chiTietSPService.getChiTietSPByIdSP(UtilInfo.idSP, size);

                GioHang gioHangNew = gioHangService.getGioHangById(gioHang.getId());

                List<GioHangChiTiet> listGHCT = gioHangChiTietService.getAll();
                if(listGHCT.isEmpty()){
                    GioHangChiTiet gioHangChiTiet = new GioHangChiTiet();
                    gioHangChiTiet.setIdGioHang(gioHangNew);
                    gioHangChiTiet.setIdChiTietSP(chiTietSP);
                    gioHangChiTiet.setSoLuong(ctspSL.getSoLuong());
                    //Đơn giá = số lượng * đơn giá
                    BigDecimal donGia = chiTietSP.getGiaBan().multiply(new BigDecimal(ctspSL.getSoLuong()));
                    gioHangChiTiet.setDonGia(donGia);
                    gioHangChiTiet.setTrangThai(0);

                    gioHangChiTietService.addGioHangChiTiet(gioHangChiTiet);
                    detailChiTietSP(request, response);
                    break;
                }else {
                    boolean check = false;
                    for (GioHangChiTiet ghct : listGHCT){
                        if(ghct.getIdChiTietSP().getId().equals(chiTietSP.getId()) && ghct.getTrangThai()==0){
                            check = true;
                            break;
                        }
                    }
                    if(check){
                        BigDecimal donGia = chiTietSP.getGiaBan().multiply(new BigDecimal(ctspSL.getSoLuong()));
                        gioHangChiTietService.updateSoLuongGHCTByIdCTSP(chiTietSP.getId(), ctspSL.getSoLuong(), donGia);
                        break;
                    }else {
                        GioHangChiTiet gioHangChiTiet = new GioHangChiTiet();
                        gioHangChiTiet.setIdGioHang(gioHangNew);
                        gioHangChiTiet.setIdChiTietSP(chiTietSP);
                        gioHangChiTiet.setSoLuong(ctspSL.getSoLuong());
                        //Đơn giá = số lượng * đơn giá
                        BigDecimal donGia = chiTietSP.getGiaBan().multiply(new BigDecimal(ctspSL.getSoLuong()));
                        gioHangChiTiet.setDonGia(donGia);
                        gioHangChiTiet.setTrangThai(0);

                        gioHangChiTietService.addGioHangChiTiet(gioHangChiTiet);
                        break;
                    }
                }
            }
        }
        detailChiTietSP(request, response);
    }

    private void dangKy(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        LocalDate ngayHienTai = LocalDate.now();
        String ma = request.getParameter("ma");
        String ten = request.getParameter("ten");
        String sdt = request.getParameter("sdt");
        String diaChi = request.getParameter("diaChi");
        String thanhPho = request.getParameter("thanhPho");
        String matKhau = request.getParameter("matKhau");
        UtilInfo.tenTK = ma;

        KhachHang khachHang = new KhachHang();
        khachHang.setMa(ma);
        khachHang.setTen(ten);
        khachHang.setSdt(sdt);
        khachHang.setDiaChi(diaChi);
        khachHang.setThanhPho(thanhPho);
        khachHang.setMatKhau(matKhau);

        khachHangService.addKhachHang(khachHang);
        request.setAttribute("khachHang", khachHang);

        List<SanPhamList> listSPL = sanPhamService.getAllSPList();
        request.setAttribute("listSPL", listSPL);

        try {
            GioHang gioHang = new GioHang();
            gioHang.setIdKH(khachHang);
            gioHang.setNgayTao(sdf.parse(ngayHienTai+""));
            gioHang.setTenNguoiNhan(khachHang.getTen());
            gioHang.setDiaChi(khachHang.getDiaChi());
            gioHang.setSdt(khachHang.getSdt());
            gioHang.setTinhTrang(0);
            gioHangService.addGioHang(gioHang);
        }catch (Exception e){
            e.printStackTrace();
        }

        //Lấy số lượng sản phẩm trong giỏ hàng theo mã KH
        Long soLuongGH = gioHangService.getSoLuongGioHangByMaKH(ma);
        request.setAttribute("soLuongGH", soLuongGH);
        request.getRequestDispatcher("/views-banhang/trangChu.jsp").forward(request, response);
    }

    private void dangNhap(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String tenTK = request.getParameter("ma");
        String matKhau = request.getParameter("matKhau");
        LocalDate ngayHienTai = LocalDate.now();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        KhachHang khachHang = new KhachHang();
        khachHang.setMa(tenTK);
        khachHang.setMatKhau(matKhau);

        int result = khachHangService.xacThucTaiKhoan(khachHang);
        if(result == 1){
            KhachHang khachHangDetail = khachHangService.getKhachHangByMa(tenTK);
            request.setAttribute("khachHang", khachHangDetail);
            List<SanPhamList> listSPL = sanPhamService.getAllSPList();
            request.setAttribute("listSPL", listSPL);
            UtilInfo.tenTK = tenTK;

            //Lấy số lượng sản phẩm trong giỏ hàng theo mã KH
            Long soLuongGH = gioHangService.getSoLuongGioHangByMaKH(tenTK);
            request.setAttribute("soLuongGH", soLuongGH);

            List<GioHang> listGioHang = gioHangService.getAll();
            boolean check = false;
            for (GioHang gh : listGioHang){
                if(gh.getIdKH().getId().equals(khachHangDetail.getId())){
                    check = true;
                    break;
                }
            }

            if(check){
                request.getRequestDispatcher("/views-banhang/trangChu.jsp").forward(request, response);
            }else {
                try {
                    GioHang gioHang = new GioHang();
                    gioHang.setIdKH(khachHangDetail);
                    gioHang.setTenNguoiNhan(khachHangDetail.getTen());
                    gioHang.setDiaChi(khachHangDetail.getDiaChi());
                    gioHang.setNgayTao(sdf.parse(ngayHienTai+""));
                    gioHang.setSdt(khachHangDetail.getSdt());
                    gioHang.setTinhTrang(0);

                    gioHangService.addGioHang(gioHang);
                    request.getRequestDispatcher("/views-banhang/trangChu.jsp").forward(request, response);
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }else {
            KhachHang khachHangDetail = khachHangService.getKhachHangByMa(tenTK);
            request.setAttribute("khachHang", khachHangDetail);
            request.getRequestDispatcher("/views-banhang/dangNhap.jsp").forward(request, response);
        }
    }
}
