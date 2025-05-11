package cancer.earlycancer.concroller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import be.cylab.java.roc.CurveCoordinates;
import be.cylab.java.roc.Point;
import be.cylab.java.roc.Utils;

public class ROC {
	
	    private List<Point> points;
	    private double positive_examples_number;
	    private double negative_examples_number;

	    /**
	     * Constructor of ROC object.
	     * Take arrays as argument
	     *
	     * @param score      double[]
	     * @param true_alert boolean[]
	     */
	    public void callROC(final double[] score, final double[] true_alert) {
	        points = new ArrayList<>();
	        if (score.length != true_alert.length) {
	            throw new IllegalStateException(
	                    "Score array and true alert array must be the same size");
	        }
	        for (int i = 0; i < score.length; i++) {
	            Point point = new Point(score[i], true_alert[i]);
	            points.add(point);
	        }
	        Collections.sort(points);
	        positive_examples_number = Utils.countPositiveExamples(this.points);
	        negative_examples_number = Utils.countNegativeExamples(this.points);
	    }

	
	    public final List<CurveCoordinates> computeRocPoints() {
	        int true_positive = 0;
	        int false_positive = 0;
	        List<CurveCoordinates> roc_points = new ArrayList<>();
	        double previous_score = Double.NEGATIVE_INFINITY;
	        for (Point point : this.points) {
	            if (point.getScore() != previous_score) {
	                double true_detection = (double) true_positive
	                        / positive_examples_number;
	                double false_alarm = (double) false_positive
	                        / negative_examples_number;
	                roc_points.add(
	                        new CurveCoordinates(false_alarm, true_detection));
	                previous_score = point.getScore();
	            }
	            if (point.getTrueAlert() == 1) {
	                true_positive++;
	            } else {
	                false_positive++;
	            }
	        }
	        double true_detection = true_positive
	                / (double) positive_examples_number;
	        double false_alarm = false_positive / (double) negative_examples_number;
	        roc_points.add(new CurveCoordinates(true_detection, false_alarm));
	        return roc_points;
	    }

	    /**
	     * Method to generate coordinates of all points in the Roc space.
	     * It also generates the Roc curve.
	     */

	    public final List<CurveCoordinates> BinaryROCCurve(final double[] pred, final double[] tl, final String filename) {
	    	boolean[] true_alert = new boolean[tl.length];
	    	for (int i = 0; i < tl.length; i++) {
				if(tl[i]==0.0)
					true_alert[i]=false;
				else 
					true_alert[i]=true;
			}
	    	callROC(pred, tl);
	        List<CurveCoordinates> roc_coordinates = this.computeRocPoints();
	        double[] true_detection = new double[roc_coordinates.size()];
	        double[] false_alarm = new double[roc_coordinates.size()];
	        for (int i = 0; i < roc_coordinates.size(); i++) {
	            true_detection[i] = roc_coordinates.get(i).getYAxis();
	            false_alarm[i] = roc_coordinates.get(i).getXAxis();
	        }
	        Curve.generateCurve(true_detection, false_alarm, filename);
	        return roc_coordinates;
	    }
	    
	    public final void GenerateMultiROCCurve(final double[][] p, double[] a, final String[] cName,final String filename) {
	    	double[][] y=new double[p.length][cName.length];
	    	for (int i = 0; i < p.length; i++) {
				for (int j = 0; j <cName.length; j++) {
					y[i][j]=0;
				}
			}
	    	for (int i = 0; i < a.length; i++) {
					y[i][(int)a[i]]=1;
			}
	    	
	    	double[][] xcord=new double[cName.length][p.length+1];
	    	double[][] ycord= new double[cName.length][p.length+1];
	    	/*
	    	for (int i = 0; i < p.length+1; i++) {
	    		Arrays.fill(xcord[i], 0.0);
		    	Arrays.fill(ycord[i], 0.0);
			}
			*/
	    	
	    	
	    	for (int i = 0; i < cName.length; i++) {
	    		double[] pred= new double[a.length];
	    		Arrays.fill(pred, 0);
	    		double[] le= new double[a.length];
	    		Arrays.fill(le, 0);
	    		for (int j = 0; j < a.length; j++) {
					pred[j]=p[j][i];
					le[j]=y[j][i];
			    }
		    	callROC(pred, le);
		    	List<CurveCoordinates> roc_coordinates = this.computeRocPoints();
		    	int cos=roc_coordinates.size();
			    double[] true_detection = new double[roc_coordinates.size()];
			    double[] false_alarm = new double[roc_coordinates.size()];
			    for(int k = 0; k < roc_coordinates.size(); k++) {
			            true_detection[k] = roc_coordinates.get(k).getYAxis();
			            false_alarm[k] = roc_coordinates.get(k).getXAxis();
			            //xcord[k][0]=roc_coordinates.get(k).getXAxis();
			            //ycord[k][0]=roc_coordinates.get(k).getYAxis();

			     }
			    //transposeMatrix(xcord);
			    for (int j = 0; j < false_alarm.length; j++) {
					//System.out.print(false_alarm[j]+" - ");
					xcord[i][j]=false_alarm[j];
				}
			    
			    
			    for (int j = 0; j < false_alarm.length; j++) {
					//System.out.print(true_detection[j]+" * ");
					ycord[i][j]=true_detection[j];
				}

			      
			}
	  
			    for (int j = 0; j < 11; j++) {
					//System.out.print(xcord[0][j]+", ");
			    }
			
			    for (int j = 0; j < 11; j++) {
				//	System.out.print(ycord[0][j]+", ");
			    }
	    	  Curve.MultiCurve(xcord, ycord, cName, filename); 
	        
	    }

	    /**
	     * Method to compute the AUC value of a ROC object.
	     *
	     * @return
	     */
	    public final double computeAUC() {
	        int false_positive = 0;
	        int true_positive = 0;
	        int previous_false_positive = 0;
	        int previous_true_positive = 0;
	        double area = 0;
	        double previous_score = Double.NEGATIVE_INFINITY;
	        for (Point point : this.points) {
	            if (point.getScore() != previous_score) {
	                area = area + this.trapezoidArea(
	                        false_positive,
	                        previous_false_positive,
	                        true_positive,
	                        previous_true_positive);
	                previous_score = point.getScore();
	                previous_false_positive = false_positive;
	                previous_true_positive = true_positive;
	            }
	            if (point.getTrueAlert() == 1) {
	                true_positive++;
	            } else {
	                false_positive++;
	            }
	        }
	        area = area + this.trapezoidArea(
	                false_positive,
	                previous_false_positive,
	                true_positive,
	                previous_true_positive);
	        return (area / (positive_examples_number * negative_examples_number));
	    }

	    private double trapezoidArea(final double x1,
	                                 final double x2,
	                                 final double y1,
	                                 final double y2) {
	        double base = Math.abs(x1 - x2);
	        double height_average = (y1 + y2) / 2;
	        return (base * height_average);
	    }


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 double[][] a = new double[10][3];
		    double[][] b = new double[10][3];
		    //Generate elements
		    for (int i = 0; i < a.length; i++) {
		    	for (int j = 0; j <3; j++) {
		    		a[i][j] = Math.random();
			        b[i][j] = Math.random();
				}
		        
		    }
			//Creation of array true_alert
		    String[] name= {"Saifur", "Tania","Sonia"};
		    double[] score = new double[10];
		    //Generate elements
		    for (int i = 0; i < score.length; i++) {
		        score[i] = Math.random();
		    }
			//Creation of array true_alert
		    double[] true_alert = {1,0,0,1,0,1,0,1,0,1};
		    double[] alert = {1,2,0,2,1,2,0,1,0,1};
		    List<CurveCoordinates> cordinates=new ROC().BinaryROCCurve(score, true_alert, "BinaryRocCurve.png");
		    new ROC().GenerateMultiROCCurve(a, alert, name, "MutiCurve.png");

	}
	public void transposeMatrix(double[][] a) {
        for(int i=0 ; i<a.length; i++) { 
            for(int j=0 ; j<i ; j++) {
                double temp = a[i][j];
                a[i][j] = a[j][i];
                a[j][i] = temp;
            }
        }
}

}
