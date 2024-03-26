package controllers;

import db.BDManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "DeleteStudentsController", urlPatterns = "/delete-students")
public class DeleteStudentsController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String ids = req.getParameter("hiddenStudDelete");
        String[] missId = ids.split("-");
        for (String id : missId) {
            BDManager.deleteStudent(id);
        }
        resp.sendRedirect("/students");
    }
}