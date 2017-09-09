package pers.luan.web.tool.chart;

import java.util.List;

import org.jfree.data.category.CategoryDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYZDataset;

import pers.luan.web.tool.Point2D;
import pers.luan.web.tool.Point3D;

public class DatasetFactory {

	private List<Double> list;
	private List<List<Double>> lists;
	private List<List<Point2D>> xyLists;
	private List<List<Point3D>> xyzLists;
	
	public DatasetFactory(List<Double> list, List<List<Double>> lists, List<List<Point2D>> xyLists, List<List<Point3D>> xyzLists) {
		this.list = list;
		this.lists = lists;
		this.xyLists = xyLists;
		this.xyzLists = xyzLists;
	}

	public static enum ChartType {
		BAR_TYPE, LINE_TYPE, AREA_TYPE, XY_TYPE, XYZ_TYPE, PIE_TYPE, 
		RING_TYPE, OHLC_TYPE;
	}

	public CategoryDataset produceBarData() {
		DatasetProduct<CategoryDataset> product = new BarDatasetProduct(list);
		return product.createDataset();
	}
	
	public CategoryDataset produceLineData() {
		DatasetProduct<CategoryDataset> product = new LineDatasetProduct(lists);
		return product.createDataset();
	}
	
	public CategoryDataset produceAreaData() {
		DatasetProduct<CategoryDataset> product = new LineDatasetProduct(lists);
		return product.createDataset();
	}
	
	public PieDataset producePieData() {
		DatasetProduct<PieDataset> product = new PieDatasetProduct(list);
		return product.createDataset();
	}
	
	public PieDataset produceRingData() {
		DatasetProduct<PieDataset> product = new PieDatasetProduct(list);
		return product.createDataset();
	}
	
	public XYDataset produceXYData() {
		DatasetProduct<XYDataset> product = new XYDatasetProduct(xyLists);
		return product.createDataset();
	}
	
	public XYZDataset produceXYZData() {
		DatasetProduct<XYZDataset> product = new XYZDatasetProduct(xyzLists);
		return product.createDataset();
	}

}
