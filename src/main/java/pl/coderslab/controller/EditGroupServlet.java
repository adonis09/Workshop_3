package pl.coderslab.controller;

import pl.coderslab.dao.GroupDao;
import pl.coderslab.model.Group;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/editGroup")
public class EditGroupServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        GroupDao groupDao = new GroupDao();
        int editGroupId = Integer.parseInt(request.getParameter("editId"));
        Group group = groupDao.read(editGroupId);
        String editGroupNewName = request.getParameter("name");
        group.setName(editGroupNewName);
        groupDao.update(group);
        response.sendRedirect("/groupsList");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        GroupDao groupDao = new GroupDao();
        Group[] allGroups = groupDao.findAll();
        request.setAttribute("groups", allGroups);

        int idToEdit = Integer.parseInt(request.getParameter("editId"));
        Group groupToEdit = groupDao.read(idToEdit);
        request.setAttribute("editGroup", groupToEdit);
        getServletContext().getRequestDispatcher("/groupsList.jsp").forward(request, response);

    }
}
