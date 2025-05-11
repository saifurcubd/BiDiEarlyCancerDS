package cancer.earlycancer.concroller;

import java.io.IOException;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cancer.earlycancer.dao.DataInput;
import weka.core.Instance;

/**
 * Servlet implementation class Reset
 */
@WebServlet("/Reset")
public class Reset extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Reset() {
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
		if (request.getParameter("Reset") != null) {
			DataInput dataInput=new DataInput();
	          for(int i=0; i<dataInput.fin.length;i++)
	        	 dataInput.fin[i]=0;
        }
		else {
			DataInput dataInput= new DataInput();
			Random ran=new Random();
			try{
				dataInput.dataRead();
				int a=ran.nextInt(400);
				//System.out.println("id:"+a);
				Instance ins=dataInput.dataset.instance(a);
				dataInput.fin=ins.toDoubleArray();
				dataInput.defaultValues();
				
			}catch(Exception e){
			}
		    
		}
        request.getRequestDispatcher("/WEB-INF/detection.jsp").forward(request, response);
		doGet(request, response);
	}

}
