package com.file.probabilitydistribution;

import java.awt.Font;
import java.awt.event.WindowEvent;
import java.util.Map;
import java.util.TreeMap;

import javax.swing.JFrame;

import org.apache.commons.math3.distribution.ParetoDistribution;
import org.apache.commons.math3.distribution.ZipfDistribution;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class SampleValueHistogram extends ApplicationFrame {

	private static final long serialVersionUID = 1L;
	
	private static int numOfFile = 100;
	private static int numOfSample = 1000;
	private static double param1 = 1;
	private static double param2 = 2;
	private static JFrame frame = null;
	
	
	public SampleValueHistogram( String applicationTitle, Distribution distribution ) {

		super(applicationTitle);
		draw( distribution );
	}

	public SampleValueHistogram( String applicationTitle, Distribution distribution, JFrame frame, double param1, double param2, int numOfFile, int numOfSample ) {

		this( applicationTitle, distribution );
		this.frame = frame;
		this.param1 = param1;
		this.param2 = param2;
		this.numOfFile = numOfFile;
		this.numOfSample = numOfSample;
		
		draw( distribution );
	}

	private CategoryDataset createDataset() {
		
		ZipfDistribution zipf = new ZipfDistribution( numOfFile, param2 );
		Map<Integer, Integer> freq = new TreeMap<>();
		final DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		
		for( int i = 1; i<=numOfSample; i++) {
			
			int rand = zipf.sample();
			freq.put( rand, freq.getOrDefault( rand, 0 ) + 1 );
		}
		
		for( int key : freq.keySet() ) {
			
			dataset.addValue( freq.get(key), "", String.valueOf( key ) );
		}

		return dataset;
	}
	
	private CategoryDataset createDataseetParteo() {
		
		ParetoDistribution pareto = new ParetoDistribution( param1, param2 );
		Map<Long, Integer> freq = new TreeMap<>();
		final DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		
		for( int i = 1; i<=numOfSample; i++) {
			
			long rand = Math.round( pareto.sample() ) % numOfFile;
			
			freq.put( rand, freq.getOrDefault( rand, 0 ) + 1 );
		}
		
		for( Long key : freq.keySet() ) {
			
			dataset.addValue( freq.get(key), "", String.valueOf( key ) );
		}

		return dataset;
	}

	private void draw( Distribution distribution ) {

		CategoryDataset dataset = null; 
		
		if( distribution == Distribution.Pareto )
			dataset = createDataseetParteo();
		else if( distribution == Distribution.Zipf )
			dataset = createDataset();
		
		JFreeChart barChart = ChartFactory.createBarChart( distribution.name(), "File Id", "Num Of Download", dataset, PlotOrientation.VERTICAL, true, true, false);

		ChartPanel chartPanel = new ChartPanel(barChart);
		chartPanel.setPreferredSize(new java.awt.Dimension(560, 367));
		
		CategoryAxis domainAxis = barChart.getCategoryPlot().getDomainAxis();
		Font domainFont = new Font( "Tahoma", Font.PLAIN, 5 );
		domainAxis.setTickLabelFont(domainFont);
		domainAxis.setLowerMargin( 0 );
		domainAxis.setUpperMargin( 0 );
		
		setContentPane(chartPanel);
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);

	}
	
	@Override
	public void windowClosing(WindowEvent e) {
		
		if( frame != null )
			frame.setVisible( true );
		
		this.dispose();
	}

	public static void main(String[] args) {

		SampleValueHistogram chart = new SampleValueHistogram( "Download frequency", Distribution.Zipf );
		chart.pack();
		RefineryUtilities.centerFrameOnScreen(chart);
		chart.setVisible(true);
	}
}
