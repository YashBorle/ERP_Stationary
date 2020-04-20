/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package erpPack;

/**
 *
 * @author LoveYou3000
 */
public class RequisitionForm {

    public int getReqId() {
        return reqId;
    }

    public void setReqId(int reqId) {
        this.reqId = reqId;
    }

    public String[] getItems() {
        return items;
    }

    public void setItems(String[] items) {
        this.items = items;
    }

    public String[] getQuantity() {
        return quantity;
    }

    public void setQuantity(String[] quantity) {
        this.quantity = quantity;
    }

    public String[] getRemark() {
        return remark;
    }

    public void setRemark(String[] remark) {
        this.remark = remark;
    }

    public String[] getSupplied() {
        return supplied;
    }

    public void setSupplied(String[] supplied) {
        this.supplied = supplied;
    }

    public boolean isIsPrinted() {
        return isPrinted;
    }

    public void setIsPrinted(boolean isPrinted) {
        this.isPrinted = isPrinted;
    }

    public boolean isIsFilled() {
        return isFilled;
    }

    public void setIsFilled(boolean isFilled) {
        this.isFilled = isFilled;
    }

    public RequisitionForm(int reqId, String[] items, String[] quantity, String[] remark, String[] supplied, boolean isPrinted, boolean isFilled) {
        this.reqId = reqId;
        this.items = items;
        this.quantity = quantity;
        this.remark = remark;
        this.supplied = supplied;
        this.isPrinted = isPrinted;
        this.isFilled = isFilled;
    }

    public RequisitionForm() {
    }


    private int reqId;
    private String[] items;
    private String[] quantity;
    private String[] remark;
    private String[] supplied;
    private boolean isPrinted;
    private boolean isFilled;

    
}
