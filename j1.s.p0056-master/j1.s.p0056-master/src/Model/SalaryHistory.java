/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.Date;

/**
 *
 * @author anhnb
 */
public class SalaryHistory {
    private String status;
    private Date date;

    public SalaryHistory() {
    }

    public SalaryHistory(String status, Date date) {
        this.status = status;
        this.date = date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "SalaryHistory{" + "status=" + status + ", date=" + date + '}';
    }
    
    
}
