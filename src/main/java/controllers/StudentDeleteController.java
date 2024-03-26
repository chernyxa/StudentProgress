package controllers;

import db.BDManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "StudentDeleteController",urlPatterns = "/student-delete")
public class StudentDeleteController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idsToDelete = req.getParameter("hiddenIdsToDelete");
        String[] ids = idsToDelete.split(" ");

        for (String id: ids){
            BDManager.deleteStudent(id);
        }

        resp.sendRedirect("/students");
    }
}
