/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;


public class adminHouseData {
    private String houseID;
    private String country;
    private String town;
    private String address;
    private String owner;
    
    public adminHouseData(String houseID, String country, String town, String address, String owner) {
        this.houseID = houseID;
        this.country = country;
        this.town = town;
        this.address = address;
        this.owner = owner;
    }

    public String gethouseID() {
        return houseID;
    }

  

    public String getcountry() {
        return country;
    }

  

    public String gettown() {
        return town;
    }



    public String getaddress() {
        return address;
    }



    public String getowner() {
        return owner;
    }


    
}
