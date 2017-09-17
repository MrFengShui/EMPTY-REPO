package pers.luan.web.tool.data;

import java.util.List;

import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;

public class PieDatasetProduct extends DatasetProduct<PieDataset> {

	private final List<Double> list;
	
	public PieDatasetProduct(List<Double> list) {
		this.list = list;
	}

	@Override
	public PieDataset createDataset() {
		DefaultPieDataset dataset = new DefaultPieDataset();
		int cycle = list.size();

		for (int i = 0; i < cycle; i++) {
			dataset.setValue("Item_" + i, list.get(i));
		}

		return dataset;
	}

}
