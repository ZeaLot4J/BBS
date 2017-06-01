package org.zealot.web.filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginCheckFilter implements Filter {
	private String redirectPage;

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		redirectPage = filterConfig.getInitParameter("redirectPage");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		if (redirectPage != null) {
			HttpServletRequest req = (HttpServletRequest) request;
			HttpServletResponse resp = (HttpServletResponse) response;
			HttpSession session = req.getSession();
			if(session.getAttribute("forumUser")==null){
				StringBuilder basePath = new StringBuilder();
				basePath.append(req.getScheme()).append("://").append(req.getServerName()).append(":").append(req.getServerPort()).append(req.getContextPath()).append("/");
				resp.setContentType("text/html;charset=utf-8");
				PrintWriter out = resp.getWriter();
				out.print("<script>location.href='"+basePath.toString()+redirectPage+"'</script>");
				out.flush();
				out.close();
				return;
			}
		}
		chain.doFilter(request, response);
	}

	@Override
	public void destroy() {

	}

}
