package pers.luan.web.tool.chart;

import java.util.List;

import org.jfree.data.time.Day;
import org.jfree.data.time.ohlc.OHLCSeries;
import org.jfree.data.time.ohlc.OHLCSeriesCollection;
import org.jfree.data.xy.OHLCDataset;

public class OHLCChartProduct extends DatasetProduct<OHLCDataset> {

	private final DataCreator creator;
	private final List<List<Double>> lists;
	
	public OHLCChartProduct(DataCreator creator, List<List<Double>> lists) {
		super();
		this.creator = creator;
		this.lists = lists;
	}

	@Override
	public OHLCDataset createDataset() {
		OHLCSeriesCollection dataset = new OHLCSeriesCollection();
		
		for (int i = 0; i < lists.size(); i ++) {
			OHLCSeries series = new OHLCSeries("Item_" + i);
			List<Double> item = lists.get(i);
			List<Double> list = creator.createRandomData();

			for (int j = 0; j < item.size(); j++) {
				series.add(new Day(), j, list.get(j), item.get(j), j + 1);
			}

			dataset.addSeries(series);
		}
		
		return dataset;
	}

}
