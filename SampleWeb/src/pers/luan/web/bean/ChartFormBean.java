package pers.luan.web.bean;

public class ChartFormBean {

	private Integer count, minBound, maxBound;

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public Integer getMinBound() {
		return minBound;
	}

	public void setMinBound(Integer minBound) {
		this.minBound = minBound;
	}

	public Integer getMaxBound() {
		return maxBound;
	}

	public void setMaxBound(Integer maxBound) {
		this.maxBound = maxBound;
	}

	@Override
	public String toString() {
		return "ChartFormBean [minBound=" + minBound + ", maxBound="
						+ maxBound + "]";
	}
	
}
