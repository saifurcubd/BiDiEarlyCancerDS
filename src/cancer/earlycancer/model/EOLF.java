package cancer.earlycancer.model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

import weka.classifiers.Classifier;
import weka.classifiers.Evaluation;
import weka.classifiers.meta.Bagging;
import weka.classifiers.trees.J48;
import weka.core.Attribute;
import weka.core.DenseInstance;
import weka.core.Instance;
import weka.core.Instances;

public class EOLF {
	public double[] bpred;
	public double blabel;
	
	public double[] lpred;
	public double llabel;

	public Evaluation binaryCancerEOLF() throws Exception {
		Instances dataset = new Instances(new BufferedReader(new FileReader(
				"/Users/Shared/Eclipse Projects/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/DiEarlyCancerDF/DNAFragmentationDataSetBinary11Test..arff")));
		System.out.println("For Binary Cancer");
		Classifier binaryModel = (Classifier) weka.core.SerializationHelper.read("/Users/Shared/Eclipse Projects/"
				+ ".metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/DiEarlyCancerDF/BinaryEOLF.model");
		Evaluation evaluation = eolf(dataset);
		Evaluation modelEva=new Evaluation(dataset);
		modelEva.evaluateModel(binaryModel, dataset);
		return modelEva;
	}

	public Evaluation localizeCancerEOLF() throws Exception {
		Instances dataset = new Instances(new BufferedReader(new FileReader(
				"/Users/Shared/Eclipse Projects/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/DiEarlyCancerDF/"
				+ "LocalizeDatadet.arff")));
		System.out.println("For Localize Cancer");
		/*
		Classifier LocalizeModel = (Classifier) weka.core.SerializationHelper.read("/Users/Shared/Eclipse Projects/"
				+ ".metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/DiEarlyCancerDF/FinalLocalize8849.model");
		*/
		dataset.setClassIndex(0);
		int trainSize = (int) Math.round(dataset.numInstances() * 70/ 100);
		int testSize = dataset.numInstances() - trainSize;
		dataset.randomize(new java.util.Random(42));
		Instances train = new Instances(dataset, 0, trainSize);
		Instances test = new Instances(dataset, trainSize, testSize);

		Bagging b=new Bagging();
	 //	-P 100 -S 7 -num-slots 1 -I 100 -W weka.classifiers.trees.RandomForest -- -P 100 -I 100 -num-slots 1 -K 0 -M 1.0 -V 0.001 -S 7
		b.setOptions(weka.core.Utils.splitOptions("-P 100 -S 7 -num-slots 1 -I 100 -W weka.classifiers.trees.RandomForest -- -P 100 -I 100 -num-slots 1 -K 0 -M 1.0 -V 0.001 -S 7"));
		b.buildClassifier(train);
		Evaluation lmodelEva=new Evaluation(dataset);
		lmodelEva.evaluateModel(b, test);
		return lmodelEva;
	}

	public static Evaluation eolf(Instances dataset) throws Exception {
		dataset.setClassIndex(0);
		System.out.println(dataset.attribute(0));
		Random rand = new Random(44);
		int folds = 10;

		/*
		 * //weka.classifiers.meta.Bagging -P 100 -S 1 -num-slots 1 -I 250 -W
		 * weka.classifiers.rules.DTNB -- -X 1 -E auc //
		 * scheme.setOptions(weka.core.Utils.splitOptions("-C 1.0 -L 0.0010 -P 1.0E-12
		 * -N 0 -V -1 -W 1 -K
		 * //\"weka.classifiers.functions.supportVector.PolyKernel -C 250007 -E 1.0\""))
		 * ; String[] options=new String[2]; options[0]="-X"; options[1]="1";
		 * options[0]="-E"; options[1]="auc";
		 * 
		 * 
		 * String[] bop=new String[2]; bop[0]="-P"; bop[1]="100"; bop[0]="-S";
		 * bop[1]="1"; bop[0]="-num-slots"; bop[1]="1"; bop[0]="-I"; bop[1]="10";
		 * 
		 * //System.out.println(bop);
		 * 
		 * 
		 * OptimalModel model=new OptimalModel(); model.setOptions(options);
		 * //model.setOptions(weka.core.Utils.splitOptions("-X 1 -E auc"));
		 */
		Bagging b = new Bagging();
	//	b.setOptions(weka.core.Utils.splitOptions(
		//		"-P 100 -S 1 -num-slots 1 -I 250 -W cancer.earlycancer.model.OptimalModel -- -X 1 -E auc"));
		/*
		 * model.setOptions(options);
		 * //model.setOptions(weka.core.Utils.splitOptions("-X 1 -E auc"));
		 * 
		 * Bagging b=new Bagging();
		 * 
		 * b.setClassifier(model); b.setOptions(bop);
		 * 
		 * b.setNumIterations(250); b.setBagSizePercent(100); b.setBatchSize("100");
		 * //b.buildClassifier(dataset);
		 */
		// b.setOptions(weka.core.Utils.splitOptions("-P 100 -S 1 -num-slots 1 -I 250 -W
		// "+model+""));
		// -C 1.0 -L 0.001 -P 1.0E-12 -N 0 -V -1 -W 1 -K
		// "weka..................................... ..PolyKernel -E 1.0 -C 250007"
		// -calibrator "weka.classifiers.functions.Logistic -R 1.0E-8 -M -1
		// -num-decimal-places 4""
		// (\"-C 1.0 -L 0.001 -P 1.0E-12 -N 0 -V -1 -W 1 -K
		// \\\"weka.classifiers.functions.supportVector.PolyKernel -C 250007 -E
		// 1.0\\\"\");

		// b.buildClassifier(dataset);
		Evaluation evl = new Evaluation(dataset);
		evl.crossValidateModel(b, dataset, folds, rand);
		// System.out.println("AUC="+evl.areaUnderROC(newdata.classIndex()));
		return evl;

	}

	public void binaryPrediction(double[] inputData) throws Exception {
		Instances dataset = new Instances(new BufferedReader(new FileReader("/Users/Shared/Eclipse Projects/"
				+ ".metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/DiEarlyCancerDF/DNAFragmentationDataSetBinary11.arff")));
		System.out.println("For Binary Cancer");
		dataset.setClassIndex(0);
		Bagging b = new Bagging();
		//b.setOptions(weka.core.Utils.splitOptions("-P 100 -S 1 -num-slots 1 -I 250 -W cancer.earlycancer.model.OptimalModel -- -X 1 -E auc"));
		Instance in=dataset.get(400);
		System.out.println(in);
		for (int i = 1; i < inputData.length+1; i++) {
			in.setValue(i, inputData[i-1]);
		 }
		 //b.buildClassifier(dataset);
		 Classifier model=(Classifier) weka.core.SerializationHelper.read("/Users/Shared/Eclipse Projects/"
					+ ".metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/DiEarlyCancerDF/BinaryEarlyCancerDF.model");
		 this.blabel=model.classifyInstance(in);
		 this.bpred=model.distributionForInstance(in);
	}
	
	public void LocalizePrediction(double[] inputData) throws Exception {
		Instances dataset = new Instances(new BufferedReader(new FileReader("/Users/Shared/Eclipse Projects/"
				+ ".metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/DiEarlyCancerDF/LocalizeDatadet.arff")));
		System.out.println("For Binary Cancer");
		//'Colorectal Cancer',69,0,23.74312,-20.27,-18.19,25.09,26.2,-102.97,24.14,-17.9,-33.11,-13.32,-42.14,3.9,7.19,39.64,32.59,
		//-72.09,93.57,13.16,23.03,-13.87,-19.62,19.58,27.7,52.78,42.8,196.21,-33.87,-18.31,-6.22,-19.94,-11.38,-16.3,-25.22,-27.27,
		//-0.54,-7.89,26.07,25.47,-8.72,-11.6,163,0.1972,0.5268,'0.05\%',1.86
		dataset.setClassIndex(0);
		Bagging b = new Bagging();
		//b.setOptions(weka.core.Utils.splitOptions("-P 100 -S 1 -num-slots 1 -I 250 -W cancer.earlycancer.model.OptimalModel -- -X 1 -E auc"));
		Instance in=dataset.get(300);
		
		System.out.println(in);
		for (int i = 1; i < inputData.length; i++) {
			in.setValue(i, inputData[i-1]);
		 }
		System.out.println(in);
		// b.buildClassifier(dataset);
		Classifier cls = (Classifier) weka.core.SerializationHelper.read("/Users/Shared/Eclipse Projects/"
						+ ".metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/DiEarlyCancerDF/FinalLocalize8849.model");
		cls.classifyInstance(in);
		 this.llabel=cls.classifyInstance(in);
		 this.lpred=cls.distributionForInstance(in);
		// this.llabel=b.classifyInstance(in);
		// this.lpred=b.distributionForInstance(in);
	}

	public static void main(String arg[]) throws Exception {
		EOLF el=new EOLF();
		Bagging b=new Bagging();
		Instances dataset= new Instances(new BufferedReader(new FileReader("/Users/Shared/Eclipse Projects/"
				+ ".metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/DiEarlyCancerDF/DNAFragmentationDataSetBinary11.arff")));
		dataset.setClassIndex(0);
		//b.setOptions(weka.core.Utils.splitOptions("-P 100 -S 1 -num-slots 1 -I 250 -W cancer.earlycancer.model.OptimalModel -- -X 1 -E auc"));
	    
		double[] data= {69,23.74312,-20.27,39.64,93.57,27.7,-11.38,-16.3,-8.72,-11.6,163};
		Instance in=dataset.get(300);
		System.out.println(in);
		for (int i = 1; i < data.length+1; i++) {
			in.setValue(i, data[i-1]);
		 }
		
		/*
		 // create copy
		Instance inst = new DenseInstance(data.length) ;
		for (int i = 1; i < data.length; i++) {
			inst.setValue(i, data[i]);
		 }
		 
		Instance in = new DenseInstance(data.length);
		in.setValue(new Attribute("Age at Diagnosis").index(), data[0]);
		in.setValue(new Attribute("PA Score").index(), data[1]);
		in.setValue(new Attribute("chr1p").index(), data[2]);
		in.setValue(new Attribute("chr7p"), data[3]);
	    in.setValue(new Attribute("chr8q"), data[4]);
						in.setValue(new Attribute("chr11q"), data[5]);
								in.setValue(new Attribute("chr17p"), data[6]);
										in.setValue(new Attribute("chr17q"),data[7]);
												in.setValue(new Attribute("chr21q"), data[8]);
											in.setValue(new Attribute("chr22q"), data[9]);
																in.setValue(new Attribute("Fragment_Size(bp)"), data[10]);
																
		 dataset.add(in);													in.setClassValue("Cancer");
		 */
		 //dataset.add(inst);
		 Instances labeled = new Instances(dataset);
		 b.buildClassifier(labeled);
		 double la=b.classifyInstance(in);
		 double[] bp=b.distributionForInstance(in);
		 System.out.println(la);
		 System.out.println(in);
		 System.out.println(bp[0]);
		 System.out.println(bp[1]);
		 
		 EOLF lob=new EOLF();
		 lob.LocalizePrediction(data);
		 System.out.println(lob.llabel);
		 for (int i = 0; i < lob.lpred.length; i++) {
			 System.out.println(lob.lpred[i]);
		}
		 
		 
	//	 el.binaryPrediction(data);
		// System.out.println(el.binaryPrediction(data)[0]);
	}

}
