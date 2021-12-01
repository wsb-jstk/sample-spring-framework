package com.capgemini.sample.sf.infrastructure.servlet;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class HelloWorldServlet extends HttpServlet {
    private String contextParam;

    private String servletInitParam;

    @Override
    public void init() {
        this.contextParam = getServletContext().getInitParameter("webInitParam");
        this.servletInitParam = getServletConfig().getInitParameter("servletInitValue");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/xml");
        final PrintWriter writer = resp.getWriter();
        writer.printf("<application>"//
                + "<servlet-context-init-param>%s</servlet-context-init-param>"//
                + "<servlet-init-param>%s</servlet-init-param>"//
                + "</application>", this.contextParam, this.servletInitParam);
    }
}
