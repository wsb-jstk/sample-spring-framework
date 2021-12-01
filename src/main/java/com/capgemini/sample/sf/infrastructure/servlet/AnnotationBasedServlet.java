package com.capgemini.sample.sf.infrastructure.servlet;


import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Example of Servlet which is not mentioned in web.xml, but it has
 * {@link WebServlet} instead (available since Servlet API 3.0)
 *
 * @see <a href="http://localhost:8080/mvc/annotation-based">Example</a>
 */
@WebServlet(urlPatterns = {"/annotation-based", "*.do"}, //
        name = "AnnotationBasedServlet", //
        initParams = { //
                @WebInitParam(name = "servletInitValue",
                        value = "This is an init param provided in annotation")//
        })
@WebInitParam(name = "InitParamInAnnotation2", value = "This param is set as standalone annotation")
public class AnnotationBasedServlet extends HttpServlet {

    private String contextParam;

    private String servletInitParam;

    @Override
    public void init() {
        this.contextParam = getServletContext().getInitParameter("webInitParam");
        this.servletInitParam = getServletConfig().getInitParameter("servletInitValue");
    }

    /**
     * @see <a href=
     * "http://localhost:8080/tomcat9/annotation-based?name=John">Example 1</a>
     * @see <a href="http://localhost:8080/mvc/annotation-based">Example 2</a>
     * @see <a href="http://localhost:8080/mvc/abc.do">Example 3</a>
     */
    @Override
    protected void doGet(final HttpServletRequest request, final HttpServletResponse response) throws IOException {
        final String name = request.getParameter("name");
        if (name == null) {
            response.setContentType("text/html");
            final PrintWriter writer = response.getWriter();
            writer.write("Missing RequestParam 'name'. Please send it by clicking the link: <a href='?name=John'>John</a>");
        } else {
            response.setContentType("text/xml");
            final PrintWriter writer = response.getWriter();
            writer.printf("<application>" + "<name>Hello %s</name>"
                            + "<servlet-context-init-param>%s</servlet-context-init-param>"
                            + "<servlet-init-param>%s</servlet-init-param>" + "</application>",
                    name,
                    this.contextParam,
                    this.servletInitParam);
        }
    }

}
