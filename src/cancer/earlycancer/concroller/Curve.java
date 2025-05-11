package cancer.earlycancer.concroller;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import org.knowm.xchart.BitmapEncoder;
import org.knowm.xchart.XYChart;
import org.knowm.xchart.XYChartBuilder;
import org.knowm.xchart.XYSeries;
import org.knowm.xchart.style.lines.SeriesLines;
import org.knowm.xchart.style.markers.SeriesMarkers;

import be.cylab.java.roc.CurveCoordinates;
import be.cylab.java.roc.Point;
import be.cylab.java.roc.Statistics;

public class Curve {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	    double[][] a = new double[10][3];
	    double[][] b = new double[10][3];
	    //Generate elements
	    Random rn = new Random();
	    for (int i = 0; i < a.length; i++) {
	    	for (int j = 0; j <3; j++) {
	    		a[i][j] = Math.random();
		        b[i][j] =rn.nextInt(2 - 0 + 1) + 0;
			}
	        
	    }
		//Creation of array true_alert
	    String[] name= {"Saifur", "Tania","Sonia"};
	    new Curve().MultiCurve(a, b, name, "MutiCurveTest5.png");

		

	}

    public static int countPositiveExamples(final List<Point> points) {
        int positive_examples = 0;
        for (Point point : points) {
            if (point.getTrueAlert() == 1) {
                positive_examples++;
            }
        }
        return positive_examples;
    }

    /**
     * Count the number of negative elements (false) in a list of Point.
     *
     * @param points List<Point>
     * @return
     */
    public static int countNegativeExamples(final List<Point> points) {
        int negative_examples = 0;
        for (Point point : points) {
            if (point.getTrueAlert() == 0) {
                negative_examples++;
            }
        }
        return negative_examples;
    }

    /**
     * Method to save RocCoordinates list in a CSV file.
     *
     * @param elements List<RocCoordinates>
     * @param filepath String
     */
    

    static CurveCoordinates interpolationPoint(final Statistics actual,
                                               final Statistics next) {
        double interp_recall = (next.getRecall() - actual.getRecall()) / 2;
        double x = (Math.abs(next.getTruePositiveCounter()
                - actual.getTruePositiveCounter())) / 2.0;
        double denom_denom = ((next.getFalsePositiveCounter()
                - actual.getFalsePositiveCounter())
                / (double) (next.getTruePositiveCounter()
                - actual.getTruePositiveCounter())) * x;
        if (Double.isNaN(denom_denom)) {
            denom_denom = 0.0;
        }
        double denom = actual.getTruePositiveCounter()
                + x
                + actual.getFalsePositiveCounter() + denom_denom;
        double interp_prec = (actual.getTruePositiveCounter() + x)
                / denom;
        CurveCoordinates p = new CurveCoordinates(
                actual.getRecall() + interp_recall, interp_prec);
        return p;
    }

    /**
     * Method to generate curve P-R and save it in a PNG file.
     * @param x
     * @param y
     * @param filename
     * @param y_dotted_position
     */
    static void generateCurve(final double[] x,
                              final double[] y,
                              final String filename,
                              final double y_dotted_position) {
        String title = "P-R Curve";
        String x_axis = "Recall";
        String y_axis = "Precision";
        XYChart chart = new XYChartBuilder().width(600).height(400)
                .title(title).xAxisTitle(x_axis).yAxisTitle(y_axis)
                .build();

        double[] dotted_x = new double[]{0, 1};
        double[] dotted_y = new double[]{y_dotted_position, y_dotted_position};
        XYSeries dotted = chart.addSeries("Random Classification",
                dotted_x, dotted_y);
        dotted.setLineStyle(SeriesLines.DASH_DASH);
        dotted.setMarker(SeriesMarkers.NONE);

        //Set up graph to visualize P-R curve
        XYSeries pr = chart.addSeries("P-R curve", x, y);
        pr.setMarker(SeriesMarkers.NONE);
        //Save graph as PNG
        try {
            BitmapEncoder.saveBitmapWithDPI(chart,
                    filename,
                    BitmapEncoder.BitmapFormat.PNG,
                    300);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Method to generate curve ROC and save it in a PNG file.
     * @param x
     * @param y
     * @param filename
     */
    
    static void generateCurve(final double[] x,
                              final double[] y,
                              final String filename) {
        String title = "Cancer Detection ROC Curve";
        String x_axis = "False Alerm";
        String y_axis = "True Detection";
        XYChart chart = new XYChartBuilder().width(600).height(400)
                .title(title).xAxisTitle(x_axis).yAxisTitle(y_axis)
                .build();

        //Set up graph to visualize random classification.
        double[] dotted_x = new double[]{0, 1};
        double[] dotted_y = new double[]{0, 1};
        XYSeries dotted = chart.addSeries("Base Line",
                dotted_x, dotted_y);
        dotted.setLineStyle(SeriesLines.DASH_DASH);
        dotted.setMarker(SeriesMarkers.NONE);

        //Set up graph to visualize P-R curve
        XYSeries pr = chart.addSeries("ROC curve", x, y);
        pr.setMarker(SeriesMarkers.NONE);
        try {
            BitmapEncoder.saveBitmapWithDPI(chart,
                    filename,
                    BitmapEncoder.BitmapFormat.PNG,
                    300);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
  
    
    static void MultiCurve(final double[][] x, final double[][] y, final String[] cName, final String filename) {
		String title = "Cancer Detection ROC Curve";
		String x_axis = "False Alerm";
		String y_axis = "True Detection";
		XYChart chart = new XYChartBuilder().width(600).height(400)
		.title(title).xAxisTitle(x_axis).yAxisTitle(y_axis)
		.build();
		
		//Set up graph to visualize random classification.
		double[] dotted_x = new double[]{0, 1};
		double[] dotted_y = new double[]{0, 1};
		XYSeries dotted = chart.addSeries("Base Line",
		dotted_x, dotted_y);
		dotted.setLineStyle(SeriesLines.DASH_DASH);
		dotted.setMarker(SeriesMarkers.NONE);
		
		//Set up graph to visualize P-R curve
		for (int i = 0; i < x.length; i++) {
			for (int j = 0; j < cName.length; j++) {
				
			}
		}
		for (int i = 0; i < cName.length; i++) {
			XYSeries pr = chart.addSeries(cName[i], x[i], y[i]);
			pr.setMarker(SeriesMarkers.NONE);
		}
		
		try {
		BitmapEncoder.saveBitmapWithDPI(chart,
		  filename,
		  BitmapEncoder.BitmapFormat.PNG,
		  300);
		} catch (IOException e) {
		e.printStackTrace();
		}
	 }

    
}

