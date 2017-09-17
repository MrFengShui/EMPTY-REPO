package pers.luan.web.tool.data;

import java.util.List;

import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import pers.luan.web.tool.Point2D;

public class XYDatasetProduct extends DatasetProduct<XYDataset> {

	private final List<List<Point2D>> lists;
	
	public XYDatasetProduct(List<List<Point2D>> lists) {
		this.lists = lists;
	}

	@Override
	public XYDataset createDataset() {
		XYSeriesCollection dataset = new XYSeriesCollection();
		int cycle = lists.size();

		for (int i = 0; i < cycle; i++) {
			XYSeries series = new XYSeries("Item_" + i);
			List<Point2D> list = lists.get(i);

			for (int j = 0; j < list.size(); j++) {
				Point2D point2D = list.get(j);
				series.add(point2D.getX(), point2D.getY());
			}
			
			dataset.addSeries(series);
		}

		return dataset;
	}

}
