
package test;

public class houseData {
    
    public String houseID;

    public String country;
    
    public String town;
    
    public String address;
    
    public String Owner;
    

    public houseData(String houseID, String country, String town, String address, String Owner) {
        this.houseID = houseID;
        this.country = country;
        this.town = town;
        this.address = address;
        this.Owner = Owner;
        
    }

 
    public String getHouseID() {
        return houseID;
    }

    public void setHouseID(String houseID) {
        this.houseID = houseID;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getOwner() {
        return Owner;
    }

    public void setOwner(String Owner) {
        this.Owner = Owner;
    }
    
    
    
}
