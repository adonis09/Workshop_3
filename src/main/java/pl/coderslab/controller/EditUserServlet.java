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

@WebServlet("/editUser")
public class EditUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        UserDao userDao = new UserDao();
        int editUserId = Integer.parseInt(request.getParameter("editId"));
        User user = userDao.read(editUserId);
        String editUserNewName = request.getParameter("name");
        String editUserNewEmail = request.getParameter("email");
        String editUserNewPassword = request.getParameter("password");
        String groupIdString = (request.getParameter("groupId"));
        int editUserNewGroupId = Integer.parseInt(groupIdString);
        user.setUserName(editUserNewName);
        user.setEmail(editUserNewEmail);
        user.setPassword(editUserNewPassword);
        user.setUserGroupId(editUserNewGroupId);
        userDao.update(user);
        response.sendRedirect("/usersList");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        GroupDao groupDao = new GroupDao();
        Group[] allGroups = groupDao.findAll();
        request.setAttribute("groups", allGroups);

        UserDao userDao = new UserDao();
        User[] allUsers = userDao.findAll();
        request.setAttribute("users", allUsers);

        int idToEdit = Integer.parseInt(request.getParameter("editId"));
        User userToEdit = userDao.read(idToEdit);
        request.setAttribute("editUser", userToEdit);
        getServletContext().getRequestDispatcher("/usersList.jsp").forward(request, response);

    }
}
