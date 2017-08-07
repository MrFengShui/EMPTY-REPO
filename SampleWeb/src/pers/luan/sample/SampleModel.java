package pers.luan.sample;

public class SampleModel {

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
		return "SampleModel [sampleID=" + sampleID + ", sampleName=" + sampleName + "]";
	}
	
}
