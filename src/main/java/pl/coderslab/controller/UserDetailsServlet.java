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

@WebServlet("/userDetails")
public class UserDetailsServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        UserDao userDao = new UserDao();
        int userId = Integer.parseInt(request.getParameter("id"));
        User user = userDao.read(userId);
        request.setAttribute("user", user);

        SolutionDao solutionDao = new SolutionDao();
        Solution[] allUsersSolutions = solutionDao.findAllByUserId(userId);
        request.setAttribute("solutions", allUsersSolutions);

        ExerciseDao exerciseDao = new ExerciseDao();
        Exercise[] allExercises = exerciseDao.findAll();
        request.setAttribute("exercises", allExercises);

        getServletContext().getRequestDispatcher("/userDetails.jsp").forward(request, response);

    }
}
