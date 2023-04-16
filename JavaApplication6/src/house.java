
public class house {
    
    private String HouseID;
    private String Country;
    private String town;
    private String address;

    public house(String HouseID, String Country, String town, String address) {
        this.HouseID = HouseID;
        this.Country = Country;
        this.town = town;
        this.address = address;
    }

    public String getHouseID() {
        return HouseID;
    }

    public void setHouseID(String HouseID) {
        this.HouseID = HouseID;
    }

    public String getCountry() {
        return Country;
    }

    public void setCountry(String Country) {
        this.Country = Country;
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
    
    
    
}
