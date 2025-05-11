package cancer.earlycancer.concroller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cancer.earlycancer.dao.EarlyCancerDAO;
import cancer.earlycancer.model.EarlyCancer;

/**
 * Servlet implementation class EarlyCancerServlet
 */
@WebServlet("/EarlyCancerServlet")
public class EarlyCancerServlet extends HttpServlet {
	 public static final long serialVersionUID = 1L;
	 public EarlyCancerDAO cancerDAO=new EarlyCancerDAO();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EarlyCancerServlet() {
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
		 String pid=request.getParameter("pid");
		 String pname=request.getParameter("Name");
		 String age=request.getParameter("age");
		 String sex=request.getParameter("sex");
		 String chr1p=request.getParameter("f1");
		 String chr1q=request.getParameter("f1");
		 String chr2p=request.getParameter("f3");
		 String chr2q=request.getParameter("f4");
		 String chr3p=request.getParameter("f5");
		 String chr3q=request.getParameter("f6");
		 String chr4p=request.getParameter("f7");
		 String chr4q=request.getParameter("f8");
		 String chr5p=request.getParameter("f9");
		 String chr5q=request.getParameter("f10");
		 String chr6p=request.getParameter("f11");
		 String chr6q=request.getParameter("f12");
		 String chr7p=request.getParameter("f13");
		 String chr7q=request.getParameter("f14");
		 String chr8p=request.getParameter("f15");
		 String chr8q=request.getParameter("f16");
		 String chr9p=request.getParameter("f17");
		 String chr9q=request.getParameter("f18");
		 String chr10p=request.getParameter("f19");
		 String chr10q=request.getParameter("f20");
		 String chr11p=request.getParameter("f21");
		 String chr11q=request.getParameter("f22");
		 String chr12p=request.getParameter("f23");
		 String chr12q=request.getParameter("f24");
		 String chr13q=request.getParameter("f25");
		 String chr14q=request.getParameter("f26");
		 String chr15q=request.getParameter("f27");
		 String chr16p=request.getParameter("f28");
		 String chr16q=request.getParameter("f29");
		 String chr17p=request.getParameter("f30");
		 String chr17q=request.getParameter("f31");
		 String chr18p=request.getParameter("f32");
		 String chr18q=request.getParameter("f33");
		 String chr19p=request.getParameter("f34");
		 String chr19q=request.getParameter("f35");
		 String chr20p=request.getParameter("f36");
		 String chr20q=request.getParameter("f37");
		 String chr21q=request.getParameter("f38");
		 String chr22q=request.getParameter("f39");
		 String PAScore=request.getParameter("f40");
		 String Fragment_Size=request.getParameter("f41");
		 String FractionOfMitochondrialGenome=request.getParameter("f42");
		 String GC_CorrectedFragmentRatioProfile=request.getParameter("f43");
		 String Coverage=request.getParameter("f44");
		 String BClass=request.getParameter("");
		 String LCancerType=request.getParameter("");
		 
		EarlyCancer earlyCancer=new EarlyCancer(); 
		earlyCancer.setPid(pid);
		earlyCancer.setPid(pname);
		earlyCancer.setAge(Integer.parseInt(age));
		earlyCancer.setSex(Integer.parseInt(sex));
		earlyCancer.setChr1p(Double.parseDouble(chr1p));
		earlyCancer.setChr1q(Double.parseDouble(chr1q));
		earlyCancer.setChr2p(Double.parseDouble(chr2p));
		earlyCancer.setChr2q(Double.parseDouble(chr2q));
		earlyCancer.setChr3p(Double.parseDouble(chr3p));
		earlyCancer.setChr3q(Double.parseDouble(chr3q));
		earlyCancer.setChr4p(Double.parseDouble(chr4q));
		earlyCancer.setChr4q(Double.parseDouble(chr4q));
		earlyCancer.setChr5p(Double.parseDouble(chr5q));
		earlyCancer.setChr5q(Double.parseDouble(chr5q));
		earlyCancer.setChr6p(Double.parseDouble(chr6q));
		earlyCancer.setChr6q(Double.parseDouble(chr6q));
		earlyCancer.setChr7p(Double.parseDouble(chr7q));
		earlyCancer.setChr7q(Double.parseDouble(chr7q));
		
		earlyCancer.setChr8p(Double.parseDouble(chr8p));
		earlyCancer.setChr8q(Double.parseDouble(chr8q));
		earlyCancer.setChr9p(Double.parseDouble(chr9p));
		earlyCancer.setChr9q(Double.parseDouble(chr9q));
		earlyCancer.setChr10p(Double.parseDouble(chr10p));
		earlyCancer.setChr10q(Double.parseDouble(chr10q));
		earlyCancer.setChr11p(Double.parseDouble(chr11p));
		earlyCancer.setChr11q(Double.parseDouble(chr11q));
		earlyCancer.setChr12p(Double.parseDouble(chr12p));
		earlyCancer.setChr12q(Double.parseDouble(chr12q));
		earlyCancer.setChr13q(Double.parseDouble(chr13q));
		earlyCancer.setChr14q(Double.parseDouble(chr14q));
		earlyCancer.setChr15q(Double.parseDouble(chr15q));
		earlyCancer.setChr16p(Double.parseDouble(chr16p));
		earlyCancer.setChr16q(Double.parseDouble(chr16q));
		
		earlyCancer.setChr17p(Double.parseDouble(chr17p));
		earlyCancer.setChr17q(Double.parseDouble(chr17q));
		earlyCancer.setChr18p(Double.parseDouble(chr18p));
		earlyCancer.setChr18q(Double.parseDouble(chr18q));
		earlyCancer.setChr19p(Double.parseDouble(chr19p));
		earlyCancer.setChr19q(Double.parseDouble(chr19q));
		earlyCancer.setChr20p(Double.parseDouble(chr20p));
		earlyCancer.setChr20q(Double.parseDouble(chr20q));
		earlyCancer.setChr21q(Double.parseDouble(chr21q));
		earlyCancer.setChr22q(Double.parseDouble(chr22q));
		earlyCancer.setPAScore(Double.parseDouble(PAScore));
		earlyCancer.setCoverage(Double.parseDouble(Coverage));
		earlyCancer.setFractionOfMitochondrialGenome(Double.parseDouble(FractionOfMitochondrialGenome));
		earlyCancer.setGC_CorrectedFragmentRatioProfile(Double.parseDouble(GC_CorrectedFragmentRatioProfile));
		earlyCancer.setFragment_Size(Double.parseDouble(Fragment_Size));
		
		try {
		  cancerDAO.binaryDetect();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		response.sendRedirect("/home.jsp");

		
		
		doGet(request, response);
	}

}
