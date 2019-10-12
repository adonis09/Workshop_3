package pl.coderslab.controller;

import pl.coderslab.dao.GroupDao;
import pl.coderslab.model.Group;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/groupsList")
public class GroupsListServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        GroupDao groupDao = new GroupDao();
        String groupName = request.getParameter("name");
        Group group = new Group(groupName);
        groupDao.create(group);
        response.sendRedirect("/groupsList");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        GroupDao groupDao = new GroupDao();
        Group[] allGroups = groupDao.findAll();
        request.setAttribute("groups", allGroups);

        getServletContext().getRequestDispatcher("/groupsList.jsp").forward(request, response);

    }
}
