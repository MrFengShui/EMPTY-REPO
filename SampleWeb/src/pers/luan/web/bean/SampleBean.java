package pers.luan.web.bean;

public class SampleBean {

	private Integer sampleID;
	private String sampleName;
	
	public Integer getSampleID() {
		return sampleID;
	}
	
	public void setSampleID(Integer sampleID) {
		this.sampleID = sampleID;
	}
	
	public String getSampleName() {
		return sampleName;
	}
	
	public void setSampleName(String sampleName) {
		this.sampleName = sampleName;
	}

	@Override
	public String toString() {
		return "SampleBean [sampleID=" + sampleID + ", sampleName=" + sampleName + "]";
	}
	
}
