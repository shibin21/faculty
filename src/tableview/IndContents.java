package tableview;

import javafx.beans.property.SimpleStringProperty;

public  class IndContents{
	SimpleStringProperty date;
	SimpleStringProperty prd1;
	SimpleStringProperty prd2;
	SimpleStringProperty prd3;
	SimpleStringProperty prd4;
	SimpleStringProperty prd5;
	SimpleStringProperty prd6;
	
	IndContents(String date, String Prd1,String Prd2,String Prd3,String Prd4,String Prd5,String Prd6) {
		this.date = new SimpleStringProperty(date);
		this.prd1 = new SimpleStringProperty(Prd1);
		this.prd2 = new SimpleStringProperty(Prd2);
		this.prd3 = new SimpleStringProperty(Prd3);
		this.prd4 = new SimpleStringProperty(Prd4);
		this.prd5 = new SimpleStringProperty(Prd5);
		this.prd6 = new SimpleStringProperty(Prd6);
	}
	public String getDate() {
        return date.get();
    }
    public void setDate(String fName) {
        date.set(fName);
    }
        
    public String getPrd1() {
        return prd1.get();
    }
    public void setPrd1(String fName) {
        prd1.set(fName);
    }

    public String getPrd2() {
        return prd2.get();
    }
    public void setPrd2(String fName) {
        prd2.set(fName);
    }
    public String getPrd3() {
        return prd3.get();
    }
    public void setPrd3(String fName) {
        prd3.set(fName);
    }
    public String getPrd4() {
        return prd4.get();
    }
    public void setPrd4(String fName) {
        prd4.set(fName);
    }
    public String getPrd5() {
        return prd5.get();
    }
    public void setPrd5(String fName) {
        prd5.set(fName);
    }
    public String getPrd6() {
        return prd6.get();
    }
    public void setPrd6(String fName) {
        prd6.set(fName);
    }
}