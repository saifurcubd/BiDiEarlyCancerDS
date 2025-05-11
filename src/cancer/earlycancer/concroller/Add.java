package cancer.earlycancer.concroller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Add
 */
@WebServlet("/Add.jsp")
public class Add extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private Integer getInt(String s) {
	    try {
	        Integer a = new Integer(s);
	        return a;
	    } catch (NumberFormatException e) {
	        return null;
	    }
	}

	public void serviceRequest(HttpServletRequest request,
	        HttpServletResponse response) throws ServletException, IOException     {

	    RequestDispatcher rd = request.getRequestDispatcher("/add.jsp");
	    rd.forward(request, response);

	    String no1 = request.getParameter("a");
	    String no2 = request.getParameter("b");
	    Integer one = getInt(no1);
	    Integer two = getInt(no2);

	    if (one != null && two != null) {
	        int result = one + two;
	        System.out.println(result);
	        request.setAttribute("result", result);

	    }

	}

	protected void doGet(HttpServletRequest request,
	        HttpServletResponse response) throws ServletException, IOException     {

	    System.out.println("get");
	    serviceRequest(request, response);
	}

	protected void doPost(HttpServletRequest request,
	        HttpServletResponse response) throws ServletException, IOException {

	    System.out.println("post");
	    serviceRequest(request, response);
	}

	}