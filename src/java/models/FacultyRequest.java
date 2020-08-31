/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author LoveYou3000
 */
public class FacultyRequest {
    int idrequest;
    String facultyName;
    String reqDate;
    String item;
    int quantity;
    String remarks;

    public FacultyRequest() {
    }

    public FacultyRequest(int idrequest, String facultyName, String reqDate, String item, int quantity, String remarks) {
        this.idrequest = idrequest;
        this.facultyName = facultyName;
        this.reqDate = reqDate;
        this.item = item;
        this.quantity = quantity;
        this.remarks = remarks;
    }

    public int getIdrequest() {
        return idrequest;
    }

    public void setIdrequest(int idrequest) {
        this.idrequest = idrequest;
    }

    public String getFacultyName() {
        return facultyName;
    }

    public void setFacultyName(String facultyName) {
        this.facultyName = facultyName;
    }

    public String getReqDate() {
        return reqDate;
    }

    public void setReqDate(String reqDate) {
        this.reqDate = reqDate;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
    
    
    
    
}
