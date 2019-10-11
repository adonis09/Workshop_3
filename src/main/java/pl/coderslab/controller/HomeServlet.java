package pl.coderslab.controller;

import pl.coderslab.dao.SolutionDao;
import pl.coderslab.model.Solution;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/")
public class HomeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Solution solution = new Solution();
        SolutionDao solutionDao = new SolutionDao();
        String solutionsNumber = getServletContext().getInitParameter("number-solutions");
        Solution[] solutions = solutionDao.findRecent(Integer.parseInt(solutionsNumber));

        request.setAttribute("solutions", solutions);

        getServletContext().getRequestDispatcher("/home.jsp").forward(request, response);

    }
}
