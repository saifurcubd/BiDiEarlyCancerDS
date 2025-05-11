package cancer.earlycancer.dao;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;

import weka.classifiers.Evaluation;
import weka.core.Instance;
import weka.core.Instances;
import weka.filters.supervised.instance.StratifiedRemoveFolds;

public class DataInput {
	public Instances dataset;
	public double[] fin= {0};
	public int insnum=0;
	public String pid;
	public String sex;
	public String age;
	Random ran=new Random();
	
	public void dataRead() throws FileNotFoundException, IOException {
		dataset= new Instances(new BufferedReader(new FileReader
				("/Users/Shared/Eclipse Projects/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/DiEarlyCancerDF/DiEarlyCancerDSFullDataInput.arff")));
		System.out.println("For Binary Cancer");
		dataset.setClassIndex(0);
		//System.out.println(dataset.attribute(0));
	}
	public void defaultValues() throws FileNotFoundException, IOException {
		this.dataRead();
		insnum=ran.nextInt(420);
		//System.out.println("id:"+a);
		Instance ins=dataset.instance(insnum);
		fin=ins.toDoubleArray();
	    //for string value
		this.pid=ins.stringValue(0);
		System.out.println(pid);
	    this.sex=ins.stringValue(2);//sex
	    if(ins.stringValue(2).equals("F"))
	    this.sex="0";
	    else 
	    	this.sex="1";
	    int a=(int)fin[1];
	    this.age=String.valueOf(a);
	}
	

	public static void main(String[] args) throws FileNotFoundException, IOException {
		// TODO Auto-generated method stub
		DataInput dataInput= new DataInput();
		dataInput.defaultValues();
		System.out.println("id:"+dataInput.insnum);
        for(int i = 0; i < dataInput.fin.length-1; i++) {
	      System.out.print(dataInput.fin[i]+" ");
		}
	}

}
