
package test;

import java.sql.Date;


public class ProductionData {
    public String houseId;
    public Date date;
    public double dailyProd;
    public double weeklyProd;
    public double totalProd = 0;

    public ProductionData(String houseId, Date date, double dailyProd, double weeklyProd,double totalProd) {
        this.houseId = houseId;
        this.date = date;
        this.dailyProd = dailyProd;
        this.weeklyProd = weeklyProd;
        this.totalProd = dailyProd + weeklyProd;
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

    public double getDailyProd() {
        return dailyProd;
    }

    public void setDailyProd(double dailyProd) {
        this.dailyProd = dailyProd;
    }

    public double getWeeklyProd() {
        return weeklyProd;
    }

    public void setWeeklyProd(double weeklyProd) {
        this.weeklyProd = weeklyProd;
    }

    public double getTotalProd() {
        return totalProd;
    }

    public void setTotalProd(double totalProd) {
        this.totalProd = totalProd;
    }
    
    
}
