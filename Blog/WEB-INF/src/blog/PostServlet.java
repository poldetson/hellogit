package blog;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PostServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		perform(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		perform(request, response);
	}
	
	private void perform(HttpServletRequest request,
			HttpServletResponse response)
			throws ServletException, IOException {
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		Topic topic = new Topic();
		topic.setTitle(title);
		topic.setContent(content);
		
		BlogController ctrl = BlogController.getInstance();
		ctrl.postTopic(topic);
		
		request.getRequestDispatcher("/read").forward(request, response);
	}
}
