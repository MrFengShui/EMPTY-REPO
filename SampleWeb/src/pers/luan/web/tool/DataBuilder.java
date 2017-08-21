package pers.luan.web.tool;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DataBuilder {

	public static List<Float> createRandomData(int cycle) {
		List<Float> list = new ArrayList<>();
		Random random = new Random();
		
		if (cycle == -1) {
			cycle = random.nextInt(8) + 1;
		}

		for (int i = 0; i < cycle; i ++) {
			list.add(random.nextFloat() * 100);
		}
		
		return list;
	}
	
	@SuppressWarnings("unchecked")
	public static List<Float>[] createRandomArray(int cycle) {
		List<List<Float>> lists = new ArrayList<>();
		Random random = new Random();
		
		if (cycle == -1) {
			cycle = random.nextInt(8) + 1;
		}
		
		for (int i = 0; i < cycle; i ++) {
			List<Float> list = createRandomData(cycle);
			lists.add(list);
		}
		
		return lists.toArray(new ArrayList[]{});
	}
	
}
