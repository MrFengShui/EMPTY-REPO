package pers.luan.web.tool.chart;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import pers.luan.web.tool.Point2D;
import pers.luan.web.tool.Point3D;

public class DataCreator {

	private final int cycle;
	private final double min, max;
	
	public DataCreator(int cycle, double min, double max) {
		this.cycle = cycle;
		this.min = min;
		this.max = max;
	}

	public List<Double> createRandomData() {
		List<Double> list = new ArrayList<>();
		Random random = new Random();

		for (int i = 0; i < cycle; i ++) {
			double value = random.nextDouble() * (max - min + 1) + min;
			list.add(value);
		}
		
		return list;
	}
	
	public List<List<Double>> createRandomArray() {
		List<List<Double>> lists = new ArrayList<>();

		for (int i = 0; i < cycle; i ++) {
			List<Double> list = createRandomData();
			lists.add(list);
		}
		
		return lists;
	}
	
	public List<Point2D> createRandom2DPoints() {
		List<Point2D> list = new ArrayList<>();
		Random random = new Random();
		
		for (int i = 0; i < cycle; i ++) {
			double x = random.nextDouble() * (max - min + 1) + min;
			double y = random.nextDouble() * (max - min + 1) + min;
			Point2D point2D = new Point2D();
			point2D.setX(x);
			point2D.setY(y);
			list.add(point2D);
		}
		
		return list;
	}
	
	public List<Point3D> createRandom3DPoints() {
		List<Point3D> list = new ArrayList<>();
		Random random = new Random();
		
		for (int i = 0; i < cycle; i ++) {
			double x = random.nextDouble() * (max - min + 1) + min;
			double y = random.nextDouble() * (max - min + 1) + min;
			double z = random.nextDouble() * (max - min + 1) + min;
			Point3D point3D = new Point3D();
			point3D.setX(x);
			point3D.setY(y);
			point3D.setZ(z);
			list.add(point3D);
		}
		
		return list;
	}
	
}
