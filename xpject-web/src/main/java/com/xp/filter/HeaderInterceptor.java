package com.xp.filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class HeaderInterceptor implements HandlerInterceptor{

	private String[] filterName = new String[]{"/login"};
	private String project = "/xpject-web";		//映射到域名上时，改为空
	
	/**
	 * 进入Header方法之前执行
	 * 一般用于身份验证，授权
	 * 应用场景，false:拦截请求，true放行
	 */
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		String requestURI=request.getRequestURI();
		//String tokenStr=request.getParameter("token");
		
		//通行证
		if(isUrl(filterName, requestURI)){
			return true;
		}
		
		//获取Session
        HttpSession session = request.getSession();  
        String username = (String)session.getAttribute("username");
		//String username = request.getParameter("username");  
		
        if(username != null && username.length() > 0){//登录用户存在放行
            return true;
        }
        //不符合条件的，跳转到登录界面  
        //request.getRequestDispatcher("/web/login.html").forward(request, response);
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        String loginPage = project + "/admin/login.html";
         
        StringBuilder builder = new StringBuilder();
        builder.append("<script type=\"text/javascript\">");
        //builder.append("alert('网页过期，请重新登录！');");
        builder.append("window.location.href='");
        builder.append(loginPage);
        builder.append("';");
        builder.append("</script>");
        out.print(builder.toString());
		return false;
	}

	/**进入Header 方法之后，返回modelAndView之前执行
	 * 应用场景，将公用的模型数据在这里穿到视图等等
	 */
	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
	}

	/**
	 * 执行Header完成之后执行
	 * 应用场景，日志处理等。
	 */
	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		
	}

	
	// 检测到没有token，直接返回不验证
    public void dealErrorReturn(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,Object obj){
        String json = (String)obj;
        PrintWriter writer = null;
        httpServletResponse.setCharacterEncoding("UTF-8");
        httpServletResponse.setContentType("text/html; charset=utf-8");
        try {
            writer = httpServletResponse.getWriter();
            writer.print(json);

        } catch (IOException ex) {
            //logger.error("response error",ex);
        } finally {
            if (writer != null)
                writer.close();
        }
    }
    
    private boolean isUrl(String[] filterName,String url){
    	for (int i = 0; i < filterName.length; i++) {
    		String string = filterName[i];
    		if(url.indexOf(string) >= 0){
    			return true;
    		}
		}
    	return false;
    }
}
