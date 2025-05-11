package cancer.earlycancer.model;



import java.util.Arrays;
import java.util.List;

import org.netlib.util.doubleW;

import be.cylab.java.roc.CurveCoordinates;
import cancer.earlycancer.concroller.ROC;
import weka.core.DenseInstance;
import weka.core.Instance;



public class EarlyCancerDF{
	//public double acc=0.0, sn=0.0,auc=0.0,fscore=0.0, prc=0.0;
	public double[] binaryMetric=new double[10];
	public double[] localizeMetric=new double[10];
	
	public EarlyCancerDF() {
		// TODO Auto-generated constructor stub
		new ESOM();
		new bRFE();
	}
	
	public void EarlyBinaryCancerDF() throws Exception {
		
		for (int i = 0; i < binaryMetric.length; i++) {
			binaryMetric[i]=0;
		}
		// TODO Auto-generated constructor stub
		/*
		 weka.classifiers.Evaluation evl =new EOLF().cancerEOLF();
	   // System.out.println(evl.toSummaryString());
		System.out.println(evl.toMatrixString());
		System.out.println(evl.getMetricsToDisplay());
		System.out.println(evl.toClassDetailsString());
		*/
		weka.classifiers.Evaluation result=new EOLF().binaryCancerEOLF();
		int n=result.predictions().size();
		double[] actual=new double[n];
		double[] predic=new double[n];
		String ps1=result.predictions().get(0).toString();
		String[] plist1=ps1.split("\\s");
		int noclass=plist1.length-4;
		//System.out.println(plist1.length);
		double[][] pro=new double[n][noclass];
					
					for (int i = 0; i < n; i++) {
						//System.out.println(rfevl.predictions().get(i));
						//System.out.println(evl.predictions().get(i));
						String ps=result.predictions().get(i).toString();
						//System.out.println(ps);
						String[] plist=ps.split("\\s");
						//System.out.println(plist.length);
						if(plist.length<7) {
							actual[i]=Double.parseDouble(plist[1]);
							predic[i]=Double.parseDouble(plist[2]);
							pro[i][0]=Double.parseDouble(plist[4]);
							pro[i][1]=Double.parseDouble(plist[5]);
							
						}
						else {
							actual[i]=Double.parseDouble(plist[1]);
							predic[i]=Double.parseDouble(plist[2]);
							for (int j = 4,k=0; j < plist.length; j++,k++) {
								pro[i][k]=Double.parseDouble(plist[j]);
							}
							

								
						}
						
									    //NOM: 6.0 6.0 1.0 6.598375308324326E-6 3.6547166745450646E-5 2.2385806391974E-5 2.9441977028248506E-5 4.5127690617743464E-5 5.138797354068844E-7 0.9998593851041728
					}
					
					if(pro[0].length<3) {
						double[] pred= new double[n];
			    		Arrays.fill(pred, 0);
						for (int i = 0; i < n; i++) {
							 pred[i]=pro[i][0];
						}
					     List<CurveCoordinates> cordinates=new ROC().BinaryROCCurve(pred, actual, "/Users/Shared/Eclipse Projects/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/DiEarlyCancerDF/BinaryRocCurve.png");
					}/*
					else {
					//	System.out.println(pro[0].length);
						String[] name={"Bile Duck Cancer","Breast Cancer","Colorectal Cancer","Gastric Cancer", "Lung Cancer", "Ovary Cancer","Pancreatic Cancer"};
						new ROC().GenerateMultiROCCurve(pro, actual, name, "MutiCurve.png");	
					}
					*/
					binaryMetric[0]=result.pctCorrect();//Acc
					binaryMetric[1]=result.areaUnderROC(0);//AUC
					binaryMetric[2]=result.truePositiveRate(0);//sensitivity
					binaryMetric[3]=result.fMeasure(0);//Fscore
					binaryMetric[4]=result.areaUnderROC(0);//PRC
					
	
	}
	
	
	public void EarlyLocalizeCancerDF() throws Exception {
		// TODO Auto-generated constructor stub
		for (int i = 0; i < localizeMetric.length; i++) {
			localizeMetric[i]=0;
		}
		
		/*
		 weka.classifiers.Evaluation evl =new EOLF().cancerEOLF();
	   // System.out.println(evl.toSummaryString());
		System.out.println(evl.toMatrixString());
		System.out.println(evl.getMetricsToDisplay());
		System.out.println(evl.toClassDetailsString());
		*/
		weka.classifiers.Evaluation result=new EOLF().localizeCancerEOLF();
		int n=result.predictions().size();
		double[] actual=new double[n];
		double[] predic=new double[n];
		String ps1=result.predictions().get(0).toString();
		String[] plist1=ps1.split("\\s");
		int noclass=plist1.length-4;
		//System.out.println(plist1.length);
		double[][] pro=new double[n][noclass];
					
					for (int i = 0; i < n; i++) {
						//System.out.println(rfevl.predictions().get(i));
						//System.out.println(evl.predictions().get(i));
						String ps=result.predictions().get(i).toString();
						//System.out.println(ps);
						String[] plist=ps.split("\\s");
						//System.out.println(plist.length);
						if(plist.length<7) {
							actual[i]=Double.parseDouble(plist[1]);
							predic[i]=Double.parseDouble(plist[2]);
							pro[i][0]=Double.parseDouble(plist[4]);
							pro[i][1]=Double.parseDouble(plist[5]);
							
						}
						else {
							actual[i]=Double.parseDouble(plist[1]);
							predic[i]=Double.parseDouble(plist[2]);
							for (int j = 4,k=0; j < plist.length; j++,k++) {
								pro[i][k]=Double.parseDouble(plist[j]);
								
							}

						}
						
									    //NOM: 6.0 6.0 1.0 6.598375308324326E-6 3.6547166745450646E-5 2.2385806391974E-5 2.9441977028248506E-5 4.5127690617743464E-5 5.138797354068844E-7 0.9998593851041728
					}
					
					if(pro[0].length<3) {
						double[] pred= new double[n];
			    		Arrays.fill(pred, 0);
						for (int i = 0; i < n; i++) {
							 pred[i]=pro[i][0];
						}
					}
					else {
					//	System.out.println(pro[0].length);
						String[] name={"Bile Duck Cancer","Breast Cancer","Colorectal Cancer","Gastric Cancer", "Lung Cancer", "Ovary Cancer","Pancreatic Cancer"};
						new ROC().GenerateMultiROCCurve(pro, actual, name, "/Users/Shared/Eclipse Projects/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/DiEarlyCancerDF/MutiCurve.png");	
					}
					localizeMetric[0]=result.pctCorrect();//acc
					localizeMetric[1]=result.weightedAreaUnderROC();//auc
					localizeMetric[2]=result.weightedFMeasure();//Fscore
					localizeMetric[3]=result.weightedAreaUnderPRC();//PRC
					
	
	}
	
	public double[] SystemMetric() throws Exception {
		EarlyLocalizeCancerDF();
		EarlyBinaryCancerDF();
		double[] metrics= new double[10];
		return metrics;
	}
	
	public void binaryPrediction(double[] inputData) {
		Instance inst = new DenseInstance(inputData.length) ;
		for (int i = 0; i < inputData.length; i++) {
			inst.setValue(i, inputData[i]);
		}
		System.out.println("The instance: " + inst);
		
	}
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Welcome to EarlyCancerDetection\n");
		//new EarlyCancerDF();
		//double[] data= {69,23.74312,-20.27,39.64,93.57,27.7,-11.38,-16.3,-8.72,-11.6,163};
		EarlyCancerDF ob=new EarlyCancerDF();
	//	ob.binaryPrediction(data);
			ob.EarlyBinaryCancerDF();
			System.out.println(ob.binaryMetric[1]);
		System.out.println("Binary EarlyCancerDetection done\n");
		ob.EarlyLocalizeCancerDF();
		System.out.println(ob.localizeMetric[1]);
		System.out.println("Localize EarlyCancerDetection done\n");

	}
	
	

}
