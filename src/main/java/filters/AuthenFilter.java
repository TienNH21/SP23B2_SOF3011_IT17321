package filters;

import domain_models.NhanVien;
import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebFilter({
    "/khach-hang/*",
})
public class AuthenFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(
        ServletRequest request,
        ServletResponse response,
        FilterChain chain
    ) throws ServletException, IOException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        HttpSession session = req.getSession();
        NhanVien nv = (NhanVien) session.getAttribute("nv");

        if (nv == null) {
            res.sendRedirect("/SP23B2_SOF3011_IT17321_war_exploded/login");
        } else {
            chain.doFilter(request, response);
        }
    }
}
