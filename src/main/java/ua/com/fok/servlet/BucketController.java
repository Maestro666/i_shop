package ua.com.fok.servlet;

import ua.com.fok.domain.Bucket;
import ua.com.fok.domain.Product;
import ua.com.fok.domain.User;
import ua.com.fok.service.BucketService;
import ua.com.fok.service.ProductService;
import ua.com.fok.service.UserService;
import ua.com.fok.service.impl.BucketServiceImplementation;
import ua.com.fok.service.impl.ProductServiceImplementation;
import ua.com.fok.service.impl.UserServiceImplementation;

import java.io.IOException;
import java.util.Date;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/bucket")
public class BucketController extends HttpServlet {

    private	BucketService bucketService = BucketServiceImplementation.getBucketService();
    private ProductService productService = ProductServiceImplementation.getProductService();
    private UserService userService = UserServiceImplementation.getUserService();


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String productId = request.getParameter("productId");

        Product product = productService.read(Integer.parseInt(productId));

        HttpSession session = request.getSession();
        Integer userId = (Integer)session.getAttribute("userId");
        User user = userService.read(userId);


        Bucket bucket = new Bucket();
        bucket.setId(UUID.randomUUID().toString());
        bucket.setProduct(product);
        bucket.setUser(user);
        bucket.setPurchaseDate(new Date());

        bucketService.create(bucket);


        response.setContentType("text");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write("Success");
    }


    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String bucketId = request.getParameter("bucketId");
        bucketService.delete(Integer.parseInt(bucketId));

        response.setContentType("text");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write("Success");
    }


}
