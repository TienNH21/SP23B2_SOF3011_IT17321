package controllers.admin;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import view_model.QLKhachHang;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet({
    "/khach-hang/index",    // GET
    "/khach-hang/create",   // GET
    "/khach-hang/edit",     // GET
    "/khach-hang/delete",   // GET
    "/khach-hang/store",    // POST
    "/khach-hang/update",   // POST
})
public class KhachHangServlet extends HttpServlet {
    private ArrayList<QLKhachHang> list = new ArrayList<>();
    @Override
    protected void doGet(
        HttpServletRequest request,
        HttpServletResponse response
    ) throws ServletException, IOException {
        this.create(request, response);
    }

    @Override
    protected void doPost(
        HttpServletRequest request,
        HttpServletResponse response
    ) throws ServletException, IOException {
        this.store(request, response);
    }

    protected void create(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        request.getRequestDispatcher("/views/khach_hang/create.jsp")
            .forward(request, response);
    }

    protected void index(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
//        request.getRequestDispatcher("/views/khach_hang/index.jsp")
//                .forward(request, response);
    }

    protected void store(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        String ma = request.getParameter("ma");
        String ho = request.getParameter("ma");
        String ten_dem = request.getParameter("ma");
        String ten = request.getParameter("ma");
        String ngay_sinh = request.getParameter("ma");
        String sdt = request.getParameter("ma");
        String dia_chi = request.getParameter("ma");
        String mat_khau = request.getParameter("ma");
        String quoc_gia = request.getParameter("ma");
        String thanh_pho = request.getParameter("ma");
        QLKhachHang qlkh = new QLKhachHang(ma, ho, ten_dem, ten, ngay_sinh, sdt, dia_chi, mat_khau, quoc_gia, thanh_pho);

        // Tạo ArrayList & thêm vào
        list.add(qlkh);
    }
}
