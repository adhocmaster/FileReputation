package com.file.probabilitydistribution;

import java.util.Map;
import java.util.TreeMap;

import org.apache.commons.math3.distribution.ParetoDistribution;
import org.apache.commons.math3.distribution.ZipfDistribution;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class SampleValueHistogram extends ApplicationFrame {

	private static final long serialVersionUID = 1L;

	private enum Distribution{
		Pareto, Zipf
	}
	
	private static final int numOfFile = 100;
	private static final int numOfSample = 1000;
	
	public SampleValueHistogram( String applicationTitle, Distribution distribution ) {

		super(applicationTitle);
		draw( distribution );
	}

	private CategoryDataset createDataset() {
		
		ZipfDistribution zipf = new ZipfDistribution( numOfFile, 1 );
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
		
		ParetoDistribution pareto = new ParetoDistribution( 1, 2 );
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
		
		JFreeChart barChart = ChartFactory.createBarChart( "Zipf", "Category", "Score", dataset, PlotOrientation.VERTICAL, true, true, false);

		ChartPanel chartPanel = new ChartPanel(barChart);
		chartPanel.setPreferredSize(new java.awt.Dimension(560, 367));
		setContentPane(chartPanel);

	}

	public static void main(String[] args) {

		SampleValueHistogram chart = new SampleValueHistogram( "Data frequency", Distribution.Zipf );
		chart.createDataset();
		chart.pack();
		RefineryUtilities.centerFrameOnScreen(chart);
		chart.setVisible(true);
	}
}
