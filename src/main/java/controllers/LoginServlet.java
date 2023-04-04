package controllers;

import domain_models.NhanVien;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import repositories.NhanVienRepository;

import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private NhanVienRepository nvRepo;
    public LoginServlet()
    {
        this.nvRepo = new NhanVienRepository();
    }

    @Override
    protected void doGet(
        HttpServletRequest req,
        HttpServletResponse resp
    ) throws ServletException, IOException {
        req.setAttribute("view", "login.jsp");
        req.getRequestDispatcher("/views/layout.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(
        HttpServletRequest req,
        HttpServletResponse resp
    ) throws ServletException, IOException {
        String ma = req.getParameter("ma");
        String matKhau = req.getParameter("matKhau");
        NhanVien nv = this.nvRepo.login(ma, matKhau);
        HttpSession session = req.getSession();

        if (nv == null) {
            session.setAttribute("errorMessage", "Sai tài khoản/mật khẩu");
            resp.sendRedirect("/SP23B2_SOF3011_IT17321_war_exploded/login");
        } else {
            session.setAttribute("nv", nv);
            resp.sendRedirect("/SP23B2_SOF3011_IT17321_war_exploded/khach-hang/index");
        }
    }
}
