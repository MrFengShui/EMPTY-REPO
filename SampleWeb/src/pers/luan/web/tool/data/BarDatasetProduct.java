package pers.luan.web.tool.data;

import java.util.List;

import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

public class BarDatasetProduct extends DatasetProduct<CategoryDataset> {

	private final List<Double> list;

	public BarDatasetProduct(List<Double> list) {
		this.list = list;
	}

	@Override
	public CategoryDataset createDataset() {
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		
		for (int i = 0; i < list.size(); i ++) {
			dataset.addValue(list.get(i), "Item_" + i, "");
		}
		
		return dataset;
	}

}
