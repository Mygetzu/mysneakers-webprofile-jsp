package servlet.admin.produk;

import controller.ProdukController;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "EditProdukServlet", urlPatterns = "/administrator/produk/edit")
public class EditProdukServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ProdukController produkController = new ProdukController();
        try {
            if (produkController.editProduk(request, response)) {
                System.out.println("Test");
                response.sendRedirect("/administrator/produk");
            }else{
                System.out.println("Failed");
                response.sendRedirect("/administrator/produk/edit?id=" + request.getParameter("id"));
            }
        } catch (Exception e) {
            getServletContext().log(e.getMessage());
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = this.getServletContext().
                getRequestDispatcher("/pages/admin/produk/edit.jsp");
        dispatcher.forward(request, response);
    }
}
