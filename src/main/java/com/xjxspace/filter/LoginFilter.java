package com.xjxspace.filter;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import com.xjxspace.mapper.UserMapper;
import com.xjxspace.model.User;
import com.xjxspace.util.Common;
@WebFilter
public class LoginFilter  implements Filter {

	@Autowired
	private UserMapper userMapper;


	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		 // 获得在下面代码中要用的request,response,session对象
		  HttpServletRequest req = (HttpServletRequest) request;
		  HttpServletResponse res = (HttpServletResponse) response;
		  HttpSession session = req.getSession();
		  // 获得用户请求的URI
		  String path = req.getRequestURI();
		  // 从session里取员工工号信息
		  Map<String,Object> param= Common.getReqParamMap(req);
		  String userName = (String)param.get("username");
		  String password = (String)param.get("password");
		  List<User> users = null;
		  if(userName!=null){
			  Map<String,Object> params = new HashMap<String,Object>();
			  params.put("userName", userName);
			   users = userMapper.getUserByUserName(params);  
		  }
		 
		
		 
		  // 登陆页面无需过滤
		  if(path.equals("/")) {
			  chain.doFilter(request, response); 
		  }else if(path.indexOf("css")>-1||path.indexOf("js")>-1){
			  chain.doFilter(request, response); 
		  }else{
			  if(Common.isLogin(req)){
				  chain.doFilter(request, response);  
			  }else if(users!=null&&users.size()!=0&&password!=null&&password.equals(users.get(0).getPassword())){
				  	Common.putLoginFlagIntoSession(req);
					 chain.doFilter(request, response);
				 }
			  else {
					  res.sendRedirect("/"); 
			  }  
		  }
		  
		 
	}

	@Override
	public void destroy() {
		
	}



}
