package pers.luan.web.tool.data;

import java.util.List;

import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

public class LineDatasetProduct extends DatasetProduct<CategoryDataset> {

	private final List<List<Double>> lists;

	public LineDatasetProduct(List<List<Double>> lists) {
		this.lists = lists;
	}

	@Override
	public CategoryDataset createDataset() {
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		int cycle = lists.size();
		
		for (int i = 0; i < cycle; i ++) {
			List<Double> item = lists.get(i);
			String label = "Item_" + i;
			
			for (int j = 0; j < item.size(); j++) {
				dataset.addValue(item.get(j), label, "Item_" + j);
			}
		}
		
		return dataset;
	}

}
