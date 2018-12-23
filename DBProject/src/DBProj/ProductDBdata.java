package DBProj;

public class ProductDBdata {
	private String pID;
	private String pName;
	private String pPrice;
	
	public String getpID() {
		return pID;
	}
	public void setpID(String pID) {
		this.pID = pID;
	}
	public String getpName() {
		return pName;
	}
	public void setpName(String pName) {
		this.pName = pName;
	}
	public String getpPrice() {
		return pPrice;
	}
	public void setpPrice(String pPrice) {
		this.pPrice = pPrice;
	}
	@Override
	public String toString() {
		return "ProductDBdata [pID=" + pID + ", pName=" + pName + ", pPrice=" + pPrice + "]";
	}

}
