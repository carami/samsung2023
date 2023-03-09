package sample;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

/**
 * Servlet Filter implementation class HelloFilter
 */
@WebFilter("/*")
public class HelloFilter implements Filter {

    public HelloFilter() {
      System.out.println("HelloFilter 생성자");
    }
	
	public void destroy() {
		System.out.println("destroy 실행");
	}


	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println("doFilter 전 (요청이 들어가기 전에 실행) ");
		request.setCharacterEncoding("utf-8");
		
		chain.doFilter(request, response);
		System.out.println("doFilter 후 (응답이 들어가기 전에 실행) ");
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("HelloFilter init 실행");
	}

}
