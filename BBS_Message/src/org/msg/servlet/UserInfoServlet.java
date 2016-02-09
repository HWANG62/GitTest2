package org.msg.servlet;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.msg.dao.UserInfoDao;
import org.msg.entity.UserInfo;

public class UserInfoServlet extends HttpServlet{//wanghao
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4557768135795534445L;

	protected String reg(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String userName=request.getParameter("uname");
		String pwd=request.getParameter("pwd");
		String email=request.getParameter("email");
		UserInfo user=new UserInfo();
		user.setUserName(userName);
		user.setPassword(pwd);
		user.setEmail(email);
		
		UserInfoDao uid=new UserInfoDao();
		String pageName="";
		if(uid.regUserInfo(user)>0){
			request.setAttribute("regInfo", "success");
			pageName="index.jsp";
		}else{
			request.setAttribute("regInfo", "fail");
			pageName="register.jsp";
		}
		return pageName;
	}
	
	protected String login(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String userName=request.getParameter("uname");
		String pwd=request.getParameter("upwd");
		UserInfo user=new UserInfo();
		user.setUserName(userName);
		user.setPassword(pwd);
		
		UserInfoDao uid=new UserInfoDao();
		List<UserInfo> users=uid.getUsers(user, null);//
		String pageName=""; 
		if(users!=null && users.size()>0){
			request.getSession().setAttribute("user",users.get(0));
			pageName="msg?method=list";
			//request.getRequestDispatcher("main.jsp").forward(request, response);
		}else{
			request.setAttribute("error", "error");
			//request.getRequestDispatcher("index.jsp").forward(request, response);
			pageName="index.jsp";
		}		
		return pageName;
	}
	
	protected String send(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String sendto=request.getParameter("sendto");
		String title=request.getParameter("title");
		request.setAttribute("senduser", sendto);
		request.setAttribute("title", title);
		
		UserInfoDao uid=new UserInfoDao();
		UserInfo user=(UserInfo)request.getSession().getAttribute("user");
		user.setPassword(null);
		List<UserInfo> except=uid.getUsers(user, "except");//
		request.setAttribute("except", except);//
		return "send_msg.jsp";
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			
		String action=request.getParameter("action");//得到 reg
		try {
			Method method=this.getClass().getDeclaredMethod(action, new Class[]{HttpServletRequest.class,HttpServletResponse.class});//调用reg这个方法
			String page=(String)method.invoke(this, new Object[]{request,response});//reg这个方法最后返回的什么
			request.getRequestDispatcher(page).forward(request, response);//转发到哪个jsp page
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {	
		doGet(req, resp);
	}
	
}
