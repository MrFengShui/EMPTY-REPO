package pers.luan.web.tool;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DataBuilder {

	public static List<Float> createRandomData(int cycle, float min, float max) {
		List<Float> list = new ArrayList<>();
		Random random = new Random();
		
		if (cycle == -1) {
			cycle = random.nextInt(8) + 1;
		}

		for (int i = 0; i < cycle; i ++) {
			list.add(random.nextFloat() * (max - min + 1) + min);
		}
		
		return list;
	}
	
	@SuppressWarnings("unchecked")
	public static List<Float>[] createRandomArray(int cycle, float min, float max) {
		List<List<Float>> lists = new ArrayList<>();
		Random random = new Random();
		
		if (cycle == -1) {
			cycle = random.nextInt(8) + 1;
		}
		
		for (int i = 0; i < cycle; i ++) {
			List<Float> list = createRandomData(cycle, min, max);
			lists.add(list);
		}
		
		return lists.toArray(new ArrayList[]{});
	}
	
}
