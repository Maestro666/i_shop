package ua.com.fok.servlet;

import ua.com.fok.domain.Bucket;
import ua.com.fok.service.BucketService;
import ua.com.fok.service.impl.BucketServiceImplementation;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/bucket")
public class BucketController extends HttpServlet {

    private BucketService bucketService = BucketServiceImplementation.getBucketService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String productId = request.getParameter("productId");

        HttpSession session = request.getSession();
        Integer userId = (Integer)session.getAttribute("userId");

        Bucket bucket = new Bucket(userId, Integer.parseInt(productId), new Date());
        bucketService.create(bucket);


        response.setContentType("text");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write("Success");
    }


    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String bucketId = request.getParameter("bucketId");
        bucketService.delete(Integer.parseInt(bucketId));

        response.setContentType("text");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write("Success");
    }

}
