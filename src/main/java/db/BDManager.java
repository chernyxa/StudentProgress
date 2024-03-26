package db;

import entity.Discipline;
import entity.Mark;
import entity.Student;
import entity.Term;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class BDManager {

    public static List<Student> getAllActiveStudents(){

        ArrayList<Student> students = new ArrayList<>();

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/students_41?user=root19&password=root19011994");
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select * from student where status = 1");
            while (rs.next()){
                Student student = new Student();
                student.setId(rs.getInt("id"));
                student.setSurname(rs.getString("surname"));
                student.setName(rs.getString("name"));
                student.setGroup(rs.getString("groupe"));
                student.setDate(rs.getDate("date"));
                students.add(student);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return students;
    }


    public static List<Term> getAllActiveTerms(){

        ArrayList<Term> terms = new ArrayList<>();

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/students_41?user=root19&password=root19011994");
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select * from term where status = 1");
            while (rs.next()){
                Term term = new Term();
                term.setId(rs.getInt("id"));
                term.setDuration(rs.getString("duration"));
                term.setTerm(rs.getString("term"));
                terms.add(term);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return terms;
    }


    public static List<Mark> getMarksByStudentAndTerm(String idStud, int idTerm){

        ArrayList<Mark> marks = new ArrayList<>();

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/students_41?user=root19&password=root19011994");
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT d.id, d.discipline, m.mark FROM mark as m\n" +
                    "left join term_discipline as td on m.id_term_disc = td.id\n" +
                    "left join discipline as d on td.id_discipline = d.id\n" +
                    "where m.id_student = '"+idStud+"' and td.id_term = '"+idTerm+"' and d.status = '1'");
            while (rs.next()){
                Mark mark = new Mark();
                Discipline discipline = new Discipline();
                discipline.setId(rs.getInt("id"));
                discipline.setDiscipline(rs.getString("discipline"));
                mark.setDiscipline(discipline);
                mark.setMark(rs.getInt("mark"));

                marks.add(mark);


            }

            if (marks.size() == 0) {
                 rs = stmt.executeQuery("SELECT * FROM term_discipline as td\n" +
                         "left join discipline as d on td.id_discipline = d.id\n" +
                         "where td.id_term = '"+idTerm+"' and d.status = '1'");
                while (rs.next()){
                    Mark mark = new Mark();
                    Discipline discipline = new Discipline();
                    discipline.setId(rs.getInt("id"));
                    discipline.setDiscipline(rs.getString("discipline"));
                    mark.setDiscipline(discipline);
                    mark.setMark(-1);

                    marks.add(mark);


                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return marks;
    }


    public static Term getTermById(String id){



        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/students_41?user=root19&password=root19011994");
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select * from term where status = 1 and id = " + id);
            while (rs.next()){
                Term term = new Term();
                term.setId(rs.getInt("id"));
                term.setDuration(rs.getString("duration"));
                term.setTerm(rs.getString("term"));
                return term;
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return null;
    }


    public static void createStudent(String surname, String name, String groupe, String date){

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/students_41?user=root19&password=root19011994");
            Statement stmt = conn.createStatement();
            stmt.execute("INSERT INTO `student` (`surname`, `name`, `groupe`, `date`) VALUES ('"+surname+"', '"+name+"', '"+groupe+"', '"+date+"');");

        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }

    public static void modifyStudent(String surname, String name, String groupe, String date, String id){

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/students_41?user=root19&password=root19011994");
            Statement stmt = conn.createStatement();
            stmt.execute("UPDATE `student` SET `surname` = '"+surname+"', `name` = '"+name+"', `groupe` = '"+groupe+"', `date` = '"+date+"' WHERE (`id` = '"+id+"');");

        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }

    public static Student getStudentById(String id){

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/students_41?user=root19&password=root19011994");
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select * from student where status = 1 and id = " + id);
            while (rs.next()){
                Student student = new Student();
                student.setId(rs.getInt("id"));
                student.setSurname(rs.getString("surname"));
                student.setName(rs.getString("name"));
                student.setGroup(rs.getString("groupe"));
                student.setDate(rs.getDate("date"));
                return student;
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return null;
    }

    public static void deleteStudent(String id){

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/students_41?user=root19&password=root19011994");
            Statement stmt = conn.createStatement();
            stmt.execute("UPDATE `student` SET `status` = '0' WHERE (`id` = '"+id+"');");

        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }


    public static ArrayList<Discipline> getAllActiveDisciplines() {
        ArrayList<Discipline> disciplines = new ArrayList<Discipline>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/students_41?user=root19&password=root19011994");
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery
                    ("select  * from `discipline` where `status` = '1'");
            while (rs.next()) {
                Discipline discipline = new Discipline();
                discipline.setDiscipline(rs.getString("name"));
                discipline.setId(rs.getInt("id"));
                disciplines.add(discipline);
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
        return disciplines;
    }

    public static void createNewDiscipline(String disc) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/students_41?user=root19&password=root19011994");
            Statement statement = conn.createStatement();
            statement.execute("INSERT INTO `discipline` (`name`) VALUES ('" + disc + "');");

        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    public static Discipline gerDisciplineById(String id) {
        Discipline discipline = new Discipline();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/students_41?user=root19&password=root19011994");
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery
                    ("SELECT * FROM students_progress.discipline where id = '" + id + "';");
            while (rs.next()) {

                discipline.setDiscipline(rs.getString("name"));
                discipline.setId(rs.getInt("id"));

            }


        } catch (Exception e) {
            e.printStackTrace();
        }
        return discipline;
    }

    public static void deleteDiscipline(String id) {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/students_41?user=root19&password=root19011994");

            Statement statement = conn.createStatement();
            statement.execute("UPDATE `discipline` SET `status` = '0' WHERE (`id` = '" + id + "');");


        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    public static void modifyDiscipline(String id, String disc) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/students_41?user=root19&password=root19011994");

            Statement statement = conn.createStatement();
            statement.execute("UPDATE `discipline` SET `name` = '" + disc + "' WHERE (`id` = '" + id + "')");

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static ArrayList<Discipline> getAllActiveDisciplinesByTerm(int idTerm) {
        ArrayList<Discipline> disciplines = new ArrayList<Discipline>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/students_41?user=root19&password=root19011994");

            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery
                    ("SELECT d.id, d.name FROM term_discipline as td" +
                            "left join discipline as d on td.id_discipline = d.id" +
                            "where td.id_term = '"+idTerm+"' " +
                            "and d.status = '1' ");
            while (rs.next()) {
                Discipline discipline = new Discipline();
                discipline.setDiscipline(rs.getString("name"));
                discipline.setId(rs.getInt("id"));
                disciplines.add(discipline);
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
        return disciplines;
    }


}
