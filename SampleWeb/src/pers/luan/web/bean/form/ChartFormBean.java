package pers.luan.web.bean.form;

public class ChartFormBean {

	private Integer count;
	private Float minBound, maxBound;

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public Float getMinBound() {
		return minBound;
	}

	public void setMinBound(Float minBound) {
		this.minBound = minBound;
	}

	public Float getMaxBound() {
		return maxBound;
	}

	public void setMaxBound(Float maxBound) {
		this.maxBound = maxBound;
	}

	@Override
	public String toString() {
		return "ChartFormBean [count=" + count + ", minBound=" + minBound
						+ ", maxBound=" + maxBound + "]";
	}
	
}
