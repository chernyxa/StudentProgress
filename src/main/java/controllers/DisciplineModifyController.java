package controllers;

import db.BDManager;
import entity.Discipline;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "DisciplineModifyController", urlPatterns = "/discipline-modify")
public class DisciplineModifyController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("hiddenModify");
        Discipline disc = BDManager.gerDisciplineById(id);
        req.setAttribute("disc", disc);
        req.getRequestDispatcher("WEB-INF/jsp/discipline-modify.jsp").forward(req,resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        String disc = req.getParameter("disc");
        if (disc == null || disc.equals("")){
            req.setAttribute("message","error");
            Discipline discipline = BDManager.gerDisciplineById(id);
            req.setAttribute("disc",discipline);
            req.getRequestDispatcher("WEB-INF/jsp/discipline-modify.jsp").forward(req,resp);

        }
        BDManager.modifyDiscipline(id,disc);
        resp.sendRedirect("/disciplines");

    }
}