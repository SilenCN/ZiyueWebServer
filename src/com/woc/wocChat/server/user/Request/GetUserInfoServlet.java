package com.woc.wocChat.server.user.Request;

import com.google.gson.Gson;
import com.woc.wocChat.server.user.Service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * <pr>
 *     link:http://localhost:8080/User/GetUserInfo?UserId=
 * </pr>
 *
 * Created by silen on 16-10-11.
 */
@WebServlet("/User/GetUserInfo")
public class GetUserInfoServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().print(new Gson().toJson(UserService.getUserInfo(Integer.parseInt(req.getParameterValues("UserId")[0]))));
    }
}
