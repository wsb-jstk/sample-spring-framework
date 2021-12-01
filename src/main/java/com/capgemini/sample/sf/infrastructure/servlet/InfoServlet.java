package com.capgemini.sample.sf.infrastructure.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Some general information about JSP
 */
@WebServlet(urlPatterns = {"/info"}, name = "InfoServlet")
public class InfoServlet extends HttpServlet {

    /**
     * @see <a href="http://localhost:8080/mvc/info">Info</a>
     */
    @Override
    protected void doGet(final HttpServletRequest request, final HttpServletResponse response) throws IOException,
            ServletException {
        request.getRequestDispatcher("/WEB-INF/info.jsp")
                .include(request, response);
    }

}
