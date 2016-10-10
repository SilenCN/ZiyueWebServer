package com.woc.wocChat.server.user.Request;

import com.woc.wocChat.server.user.Service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * <pr>
 *     link:http://localhost:8080/User/ModifySign?UserId=&Sign=
 *     UserId:用户ｉｄ号　int
 *     Sign:用户修改的Sign  string
 *
 *     return turn/false;
 * </pr>
 *
 * Created by silen on 16-10-10.
 */
@WebServlet("/User/ModifySign")
public class ModifySignServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().print(UserService.modifySign(Integer.parseInt(req.getParameterValues("UserId")[0]), req.getParameterValues("Sign")[0]));
    }
}
