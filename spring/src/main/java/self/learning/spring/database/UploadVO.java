package self.learning.spring.database;

import java.util.Date;

public class UploadVO {

	private long id;
	private String registryName;
	private String formName;
	private long siteId;
	private long facilityId;
	private long ehrUploadId;
	private String ehrUploadFile;
	private Date ehrUploadDate;
	private long ehrUploadBy;
	
	public String getRegistryName() {
		return registryName;
	}
	public String getFormName() {
		return formName;
	}
	public long getSiteId() {
		return siteId;
	}
	public long getFacilityId() {
		return facilityId;
	}
	public long getEhrUploadId() {
		return ehrUploadId;
	}
	public String getEhrUploadFile() {
		return ehrUploadFile;
	}
	public Date getEhrUploadDate() {
		return ehrUploadDate;
	}
	public long getEhrUploadBy() {
		return ehrUploadBy;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getId() {
		return id;
	}
	public void setRegistryName(String registryName) {
		this.registryName = registryName;
	}
	public void setFormName(String formName) {
		this.formName = formName;
	}
	public void setSiteId(long siteId) {
		this.siteId = siteId;
	}
	public void setFacilityId(long facilityId) {
		this.facilityId = facilityId;
	}
	public void setEhrUploadId(long ehrUploadId) {
		this.ehrUploadId = ehrUploadId;
	}
	public void setEhrUploadFile(String ehrUploadFile) {
		this.ehrUploadFile = ehrUploadFile;
	}
	public void setEhrUploadDate(Date ehrUploadDate) {
		this.ehrUploadDate = ehrUploadDate;
	}
	
	public void setEhrUploadBy(long ehrUploadBy) {
		this.ehrUploadBy = ehrUploadBy;
	}
	
	@Override
	public String toString() {
		return "UploadVO [id=" + id + ", registryName=" + registryName
				+ ", formName=" + formName + ", siteId=" + siteId
				+ ", facilityId=" + facilityId + ", ehrUploadId=" + ehrUploadId
				+ ", ehrUploadFile=" + ehrUploadFile + ", ehrUploadDate="
				+ ehrUploadDate + ", ehrUploadBy=" + ehrUploadBy + "]";
	}
}
