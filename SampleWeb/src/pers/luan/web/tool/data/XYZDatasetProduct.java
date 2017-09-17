package pers.luan.web.tool.data;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.ArrayUtils;
import org.jfree.data.xy.DefaultXYZDataset;
import org.jfree.data.xy.XYZDataset;

import pers.luan.web.tool.Point3D;

public class XYZDatasetProduct extends DatasetProduct<XYZDataset> {

	private final List<List<Point3D>> lists;
	
	public XYZDatasetProduct(List<List<Point3D>> lists) {
		this.lists = lists;
	}

	@Override
	public XYZDataset createDataset() {
		DefaultXYZDataset dataset = new DefaultXYZDataset();
		int cycle = lists.size();

		for (int i = 0; i < cycle; i++) {
			List<Point3D> list = lists.get(i);
			List<Double> xList = new ArrayList<>();
			List<Double> yList = new ArrayList<>();
			List<Double> zList = new ArrayList<>();
			
			for (int j = 0; j < list.size(); j ++) {
				Point3D point3D = list.get(j);
				xList.add(point3D.getX());
				yList.add(point3D.getY());
				zList.add(point3D.getZ());
			}
			
			dataset.addSeries("Item_" + i, new double[][] {
				ArrayUtils.toPrimitive(xList.toArray(new Double[xList.size()])),
				ArrayUtils.toPrimitive(yList.toArray(new Double[yList.size()])),
				ArrayUtils.toPrimitive(zList.toArray(new Double[zList.size()]))
			});
		}

		return dataset;
	}

}
