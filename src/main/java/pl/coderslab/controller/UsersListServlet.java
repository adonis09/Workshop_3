package pl.coderslab.controller;

import pl.coderslab.dao.GroupDao;
import pl.coderslab.dao.UserDao;
import pl.coderslab.model.Group;
import pl.coderslab.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/usersList")
public class UsersListServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        UserDao userDao = new UserDao();
        String userName = request.getParameter("name");
        String userEmail = request.getParameter("email");
        String userPassword = request.getParameter("password");
        int userGroup = Integer.parseInt(request.getParameter("group"));
        User user = new User(userName, userEmail, userPassword, userGroup);
        userDao.create(user);
        response.sendRedirect("/usersList");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        GroupDao groupDao = new GroupDao();
        List<Group> allGroups = groupDao.findAll();
        request.setAttribute("groups", allGroups);

        UserDao userDao = new UserDao();
        List<User> allUsers = userDao.findAll();
        request.setAttribute("users", allUsers);
        getServletContext().getRequestDispatcher("/usersList.jsp").forward(request, response);

    }
}
