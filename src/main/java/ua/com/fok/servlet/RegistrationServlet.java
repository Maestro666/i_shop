package ua.com.fok.servlet;

import ua.com.fok.domain.User;
import ua.com.fok.domain.UserRole;
import ua.com.fok.service.UserService;
import ua.com.fok.service.impl.UserServiceImplementation;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RegistrationServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private UserService userService = UserServiceImplementation.getUserService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        String email = request.getParameter("email");
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String password = request.getParameter("password");

        if (!email.isEmpty() && !firstName.isEmpty() && !lastName.isEmpty() && !password.isEmpty()) {
            userService.create(new User( email, firstName, lastName, UserRole.USER.toString(), password));
        }

        response.setContentType("text/plain");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write("Success");
    }

}
