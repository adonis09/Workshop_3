package pl.coderslab.controller;

import pl.coderslab.dao.ExerciseDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/deleteExercise")
public class DeleteExerciseServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ExerciseDao exerciseDao = new ExerciseDao();
        int idToDelete = Integer.parseInt(request.getParameter("deleteId"));
        exerciseDao.delete(idToDelete);
        response.sendRedirect("/exercisesList");

    }
}
