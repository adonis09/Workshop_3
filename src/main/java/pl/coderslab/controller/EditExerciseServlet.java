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

@WebServlet("/editExercise")
public class EditExerciseServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ExerciseDao exerciseDao = new ExerciseDao();
        int editExerciseId = Integer.parseInt(request.getParameter("editId"));
        Exercise exercise = exerciseDao.read(editExerciseId);
        String editExerciseNewName = request.getParameter("title");
        String editExerciseNewDescription = request.getParameter("description");
        exercise.setTitle(editExerciseNewName);
        exercise.setDescription(editExerciseNewDescription);
        exerciseDao.update(exercise);
        response.sendRedirect("/exercisesList");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ExerciseDao exerciseDao = new ExerciseDao();
        List<Exercise> allExercises = exerciseDao.findAll();
        request.setAttribute("exercises", allExercises);

        int idToEdit = Integer.parseInt(request.getParameter("editId"));
        Exercise exerciseToEdit = exerciseDao.read(idToEdit);
        request.setAttribute("editExercise", exerciseToEdit);
        getServletContext().getRequestDispatcher("/exercisesList.jsp").forward(request, response);

    }
}
