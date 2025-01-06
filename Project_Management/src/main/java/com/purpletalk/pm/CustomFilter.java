package com.purpletalk.pm;
import java.io.IOException;

import org.apache.log4j.Logger;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;

public class CustomFilter implements Filter {

	private static final Logger logger = Logger.getLogger(CustomFilter.class);
  //  private static final org.slf4j.Logger logger = LoggerFactory.getLogger(CustomFilter.class.getName());
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
      
    	logger.info("Request received at: {}"+ request.getRemoteAddr());
     
        chain.doFilter(request, response);

   
        logger.info("Response sent to: {}"+ request.getRemoteAddr());
    }
}
