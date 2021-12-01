<%@ page isErrorPage="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<body>
<ol>
    <li>Java scriptlet `${fn:escapeXml("<% %>")}`. Example: <% (new java.io.PrintWriter(out)).write("test"); %></li>
    <li>JSP expressions `${fn:escapeXml("<%= %>")}`. Example: <%= java.time.LocalDateTime.now().toString() %>
    </li>
    <li>JSP directives `&lt;%@ %&gt;`</li>
    <li>Java Expression Language (EL)`${fn:escapeXml("${}")}`. Example:
        <ul>
            <li>web.xml context-params: ${initParam.webInitParam} (same
                sa <%= application.getInitParameter("webInitParam") %>)
            </li>
            <li>${3+5}</li>
            <li>${1==2}</li>
            <li>Query string (values after '?' in URI) ${pageContext.request.queryString}</li>
        </ul>
        <a href="https://www.tutorialspoint.com/jsp/jsp_expression_language.htm">More info</a>
    </li>
</ol>
</body>
</html>
