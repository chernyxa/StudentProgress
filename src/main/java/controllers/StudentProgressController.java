package controllers;

import db.BDManager;
import entity.Mark;
import entity.Student;
import entity.Term;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

@WebServlet(name = "StudentProgressController", urlPatterns = "/student-progress")
public class StudentProgressController extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String idStud = req.getParameter("hiddenIdToProgress");
        Student student = BDManager.getStudentById(idStud);
        req.setAttribute("student", student);

        List<Term> terms = BDManager.getAllActiveTerms();
        req.setAttribute("terms", terms);


        Term selectedTerm = null;

        if(req.getParameter("idSelectedTerm") == null){

            selectedTerm = BDManager.getTermById(req.getParameter("idSelectedTerm"));

        }else {

            selectedTerm = terms.get(0);

        }

        req.setAttribute("selectedTerm", selectedTerm);

        List<Mark> marks = BDManager.getMarksByStudentAndTerm(idStud, selectedTerm.getId());
        req.setAttribute("marks", marks);



        double summMarks = 0;
        for (Mark m: marks){
            summMarks = summMarks + m.getMark();


        }
        double avarage = summMarks / marks.size();
        req.setAttribute("avarage", avarage);


        req.getRequestDispatcher("WEB-INF/student-progress.jsp").forward(req, resp);
    }
}
