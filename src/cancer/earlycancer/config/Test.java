package cancer.earlycancer.config;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import weka.core.Instances;

public class Test {
	private int id;
	private String name;
	
	public Test() throws FileNotFoundException, IOException {
		// TODO Auto-generated constructor stub
		this.setId(55932931);
		this.setName("RAHAMAN, Saifur");
		Instances dataset= new Instances(new BufferedReader(new FileReader("DNAFragmentationDataSetBinary11.arff")));
		//	System.out.println(dataset1.toSummaryString());
		 System.out.println("For Binary Cancer");
		 dataset.setClassIndex(0);
		 System.out.println(dataset.attribute(0));
	}
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public static void main(String[] args) throws FileNotFoundException, IOException {
		// TODO Auto-generated method stub
      new Test();
	}

}
