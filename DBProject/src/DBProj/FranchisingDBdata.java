package DBProj;

public class FranchisingDBdata {
	private String fID;
	private String fName;
	private String fLocation;
	private String fOffice_Hours;
	private String fNumber;
	private String fPerformance;
	
	public String getfID() {
		return fID;
	}
	public void setfID(String fID) {
		this.fID = fID;
	}
	public String getfName() {
		return fName;
	}
	public void setfName(String fName) {
		this.fName = fName;
	}
	public String getfLocation() {
		return fLocation;
	}
	public void setfLocation(String fLocation) {
		this.fLocation = fLocation;
	}
	public String getfOffice_Hours() {
		return fOffice_Hours;
	}
	public void setfOffice_Hours(String fOffice_Hours) {
		this.fOffice_Hours = fOffice_Hours;
	}
	public String getfNumber() {
		return fNumber;
	}
	public void setfNumber(String fNumber) {
		this.fNumber = fNumber;
	}
	public String getfPerformance() {
		return fPerformance;
	}
	public void setfPerformance(String fPerformance) {
		this.fPerformance = fPerformance;
	}
	
	@Override
	public String toString() {
		return "FranchisingDBdata [fID=" + fID + ", fName=" + fName + ", fLocation=" + fLocation + ", fOffice_Hours="
				+ fOffice_Hours + ", fNumber=" + fNumber + ", fPerformance=" + fPerformance + "]";
	}

}
