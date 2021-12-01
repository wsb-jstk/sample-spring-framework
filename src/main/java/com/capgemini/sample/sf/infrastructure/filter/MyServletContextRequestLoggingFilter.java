package com.capgemini.sample.sf.infrastructure.filter;

import org.springframework.stereotype.Component;
import org.springframework.web.filter.AbstractRequestLoggingFilter;
import org.springframework.web.filter.CommonsRequestLoggingFilter;
import org.springframework.web.filter.ServletContextRequestLoggingFilter;

/**
 * It uses INFO as a default (opposite to {@link CommonsRequestLoggingFilter}
 * which uses DEBUG<br>
 *
 * @see AbstractRequestLoggingFilter
 * @see AbstractRequestLoggingFilter#createMessage
 * @see CommonsRequestLoggingFilter
 * @see ServletContextRequestLoggingFilter
 */
@Component
class MyServletContextRequestLoggingFilter extends ServletContextRequestLoggingFilter {

    @Override
    protected void initFilterBean() {
        this.setIncludeClientInfo(true);
        this.setIncludeHeaders(true);
        this.setIncludePayload(true);
        this.setIncludeQueryString(true);
    }

}
