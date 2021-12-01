package com.capgemini.sample.sf.infrastructure.filter;

import org.springframework.stereotype.Component;
import org.springframework.web.filter.AbstractRequestLoggingFilter;
import org.springframework.web.filter.CommonsRequestLoggingFilter;
import org.springframework.web.filter.ServletContextRequestLoggingFilter;

/**
 * It uses DEBUG as a default (opposite to
 * {@link ServletContextRequestLoggingFilter} which uses INFO<br>
 * <p>
 * Sample message:
 *
 * <pre>
 * After request [GET /hello/world, client=0:0:0:0:0:0:0:1, headers=[host:"localhost:8080", connection:"keep-alive", cache-control:"max-age=0",
 * upgrade-insecure-requests:"1", user-agent:"Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/84.0.4147.135
 * Safari/537.36", accept:"text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng;q=0.8,application/signed-exchange;v=b3;q=0.9",
 * sec-fetch-site:"none", sec-fetch-mode:"navigate", sec-fetch-user:"?1", sec-fetch-dest:"document", accept-encoding:"gzip, deflate, br",
 * accept-language:"pl-PL,pl;q=0.9,de-DE;q=0.8,de;q=0.7,en-US;q=0.6,en;q=0.5", cookie:"XDEBUG_SESSION=XDEBUG_ECLIPSE; PHPSESSID=jtg118e1jh0f15j30rilcjn042;
 * page-filter-box-display=1; dateSelected=2020-08-16; field-filter-display=0"]]
 * </pre>
 *
 * @see AbstractRequestLoggingFilter
 * @see AbstractRequestLoggingFilter#createMessage
 * @see CommonsRequestLoggingFilter
 * @see ServletContextRequestLoggingFilter
 */
@Component
public class MyCommonsRequestLoggingFilter extends CommonsRequestLoggingFilter {

    @Override
    protected void initFilterBean() {
        this.setIncludeClientInfo(true);
        this.setIncludeHeaders(true);
        this.setIncludePayload(true);
        this.setIncludeQueryString(true);
    }

}
