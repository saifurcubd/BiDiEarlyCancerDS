package cancer.earlycancer.concroller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TestServlet
 */
@WebServlet("/TestServlet")
public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		try {
			String hid=request.getParameter("hid");
			String name=request.getParameter("name");
			String hide=request.getParameter("hide");
			if(name!=null && hid!=null) {
				name="server: "+name;
				hid="server: "+hid;
				hide="server: "+hide;
			}
			else {
				out.println("<script type=\"text/javascript\">");
				 out.println("alert('Please enter the all values');");
				 out.println("</script>");
				 response.sendRedirect("detecrtion.jsp");
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
