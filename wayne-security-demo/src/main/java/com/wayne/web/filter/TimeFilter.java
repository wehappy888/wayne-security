package com.wayne.web.filter;

import org.springframework.stereotype.Component;

import javax.servlet.*;
import java.io.IOException;

/**
 * @author waynewang
 */
@Component
public class TimeFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) {
        System.out.println("my time filter init");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("my time filter start");
        long start = System.currentTimeMillis();
        filterChain.doFilter(servletRequest, servletResponse);
        long end = System.currentTimeMillis();
        System.out.println("my time filter 耗时：" + (end - start));
        System.out.println("my time filter end");
    }

    @Override
    public void destroy() {
        System.out.println("my time filter destroy");
    }
}
