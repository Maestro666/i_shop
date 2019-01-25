package ua.com.fok.servlet;

import com.google.gson.Gson;
import ua.com.fok.domain.User;
import ua.com.fok.dto.UserLogin;
import ua.com.fok.service.UserService;
import ua.com.fok.service.impl.UserServiceImplementation;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private UserService userService = UserServiceImplementation.getUserService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        String email = request.getParameter("email");
        String password = request.getParameter("password");

        User user = userService.getUserByEmail(email);

        if (user != null && user.getPassword().equals(password)) {
            HttpSession session = request.getSession(true);
            session.setAttribute("userId", user.getId());
            session.setAttribute("role", user.getRole());

            UserLogin userLogin = new UserLogin();
            userLogin.destinationUrl = "cabinet.jsp";
            userLogin.userEmail = user.getEmail();
            String json = new Gson().toJson(userLogin);
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write(json);
        }
    }

}
