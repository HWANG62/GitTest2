package org.msg.servlet;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.msg.dao.MessageDao;
import org.msg.entity.Message;
import org.msg.entity.UserInfo;

public class MessageServlet extends HttpServlet{//qweqeqeq

	/**
	 * 
	 */
	private static final long serialVersionUID = 8398779904465520405L;

	protected String list(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		MessageDao md=new MessageDao();		
		HttpSession session=request.getSession();//����session
		UserInfo user=(UserInfo)session.getAttribute("user");//�õ�name����ֵ
		String page="index.jsp";
		if(user!=null){
			List<Message> list=md.getMessagesBySendTo(user.getUserName());
			request.setAttribute("messages", list);
			page="main.jsp";
		}
		return page;
	}
	
	protected String delete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String msgid=request.getParameter("msgid");
		MessageDao md=new MessageDao();
		if(md.deleteMsg(msgid)>0){
			return "msg?method=list";
		}
		return "";
	}
	
	protected String send(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		
		Message msg=new Message();
		msg.setSendTo(request.getParameter("sendto"));//�����û�		
		msg.setMsgContent(request.getParameter("msgcontent"));//��Ϣ����
		msg.setTitle(request.getParameter("msgtitle"));//��Ϣ����
		HttpSession session=request.getSession();
		UserInfo user=(UserInfo)session.getAttribute("user");
		msg.setUserName(user.getUserName());//�����û�
		MessageDao md=new MessageDao();
		if(md.insertMsg(msg)>0){//����			
			return "user?action=send";
		}
		return "";
	}
	
	protected String read(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String msgid=request.getParameter("msgid");
		MessageDao  md=new MessageDao();
		Message msg=md.getMessageById(msgid);//��ѯ��Ϣ
		request.setAttribute("msg", msg);//
		md.updateState(msgid);//�޸�״̬			
		return "read_msg.jsp";
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String methodName=request.getParameter("method");
		try {
			Method method=this.getClass().getDeclaredMethod(methodName, new Class[]{HttpServletRequest.class,HttpServletResponse.class});
			String page=(String)method.invoke(this, new Object []{request,response});
			request.getRequestDispatcher(page).forward(request, response);
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
