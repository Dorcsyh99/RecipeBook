import hu.alkfejl.controller.ReceptController;
import hu.alkfejl.dao.ReceptDaoImpl;
import hu.alkfejl.dao.Receptdao;
import hu.alkfejl.model.Recept;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/recipe")
public class ListRecipeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        res.setContentType("text/html");
        Receptdao dao = new ReceptDaoImpl();
        PrintWriter pw = res.getWriter();

        for(Recept r : dao.Osszes()){
            pw.println(r.getNev());
        }

        List<Recept> receptek = ReceptController.getInstance().Osszes();
        req.setAttribute("receptek", receptek);
        req.getRequestDispatcher("index.jsp").forward(req, res);
    }
}
