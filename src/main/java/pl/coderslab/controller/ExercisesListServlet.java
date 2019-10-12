package pl.coderslab.controller;

import pl.coderslab.dao.ExerciseDao;
import pl.coderslab.model.Exercise;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/exercisesList")
public class ExercisesListServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ExerciseDao exerciseDao = new ExerciseDao();
        String exerciseTitle = request.getParameter("title");
        String exerciseDescription = request.getParameter("description");
        Exercise exercise = new Exercise(exerciseTitle, exerciseDescription);
        exerciseDao.create(exercise);
        response.sendRedirect("/exercisesList");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ExerciseDao exerciseDao = new ExerciseDao();
        List<Exercise> allExercises = exerciseDao.findAll();
        request.setAttribute("exercises", allExercises);
        getServletContext().getRequestDispatcher("/exercisesList.jsp").forward(request, response);

    }
}
