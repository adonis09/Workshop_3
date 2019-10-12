package pl.coderslab.controller;

import pl.coderslab.dao.ExerciseDao;
import pl.coderslab.dao.SolutionDao;
import pl.coderslab.dao.UserDao;
import pl.coderslab.model.Exercise;
import pl.coderslab.model.Solution;
import pl.coderslab.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/solutionDetails")
public class SolutionDetailsServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));
        SolutionDao solutionDao = new SolutionDao();
        Solution solution = solutionDao.read(id);
        request.setAttribute("pickedSolution", solution);

        ExerciseDao exerciseDao = new ExerciseDao();
        Exercise exercise = exerciseDao.read(solution.getExerciseId());
        request.setAttribute("pickedExercise", exercise);

        UserDao userDao = new UserDao();
        User user = userDao.read(solution.getUserId());
        request.setAttribute("pickedUser", user);

        getServletContext().getRequestDispatcher("/solutionDetails.jsp").forward(request, response);

    }
}
