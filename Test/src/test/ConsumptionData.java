
package test;

import java.sql.Date;



public class ConsumptionData {
    
     public String houseId;
     public Date date;
     public double dailyCons;
     public double weeklyCons;
     public double totalCons = 0;

    public ConsumptionData(String houseId, Date date, double dailyCons, double weeklyCons, double totalCons) {
        this.houseId = houseId;
        this.date = date;
        this.dailyCons = dailyCons;
        this.weeklyCons = weeklyCons;
        this.totalCons = dailyCons + weeklyCons;
    }

    public String getHouseId() {
        return houseId;
    }

    public void setHouseId(String houseId) {
        this.houseId = houseId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getDailyCons() {
        return dailyCons;
    }

    public void setDailyCons(double dailyCons) {
        this.dailyCons = dailyCons;
    }

    public double getWeeklyCons() {
        return weeklyCons;
    }

    public void setWeeklyCons(double weeklyCons) {
        this.weeklyCons = weeklyCons;
    }

    public double getTotalCons() {
        return totalCons;
    }

    public void setTotalCons(double totalCons) {
        this.totalCons = totalCons;
    }
    
}
