package org.manipal.oops.proj.trade.model;

import java.util.Date;

import org.manipal.oops.proj.trade.loader.LoadContext;

public class TransactionEntry {
    
    public enum TransactionType {
        BUY,
        SELL
    }
    
    protected LoadContext context ;
    
    protected Date tradeDate;
    
    protected String scriptCode ;
    
    protected TransactionType transactionType ;
    
    protected int quantity ;
    
    protected float price ;
    
    protected double tradeValue ;
    
    protected String orderReference ;
    
    protected float brockarage ;
    
    protected float otherCharges ;

    public TransactionEntry(LoadContext context) {
        this.context = context;
    }

    public Date getTradeDate() {
        return tradeDate;
    }

    public void setTradeDate(Date tradeDate) {
        this.tradeDate = tradeDate;
    }

    public String getScriptCode() {
        return scriptCode;
    }

    public void setScriptCode(String scriptCode) {
        this.scriptCode = scriptCode;
    }

    public TransactionType getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(TransactionType transactionType) {
        this.transactionType = transactionType;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public double getTradeValue() {
        return tradeValue;
    }

    public void setTradeValue(double tradeValue) {
        this.tradeValue = tradeValue;
    }

    public String getOrderReference() {
        return orderReference;
    }

    public void setOrderReference(String orderReference) {
        this.orderReference = orderReference;
    }

    public float getBrockarage() {
        return brockarage;
    }

    public void setBrockarage(float brockarage) {
        this.brockarage = brockarage;
    }

    public float getOtherCharges() {
        return otherCharges;
    }

    public void setOtherCharges(float otherCharges) {
        this.otherCharges = otherCharges;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("TransactionEntry [context=");
        builder.append(context);
        builder.append(", tradeDate=");
        builder.append(tradeDate);
        builder.append(", scriptCode=");
        builder.append(scriptCode);
        builder.append(", transactionType=");
        builder.append(transactionType);
        builder.append(", quantity=");
        builder.append(quantity);
        builder.append(", price=");
        builder.append(price);
        builder.append(", tradeValue=");
        builder.append(tradeValue);
        builder.append(", orderReference=");
        builder.append(orderReference);
        builder.append(", brockarage=");
        builder.append(brockarage);
        builder.append(", otherCharges=");
        builder.append(otherCharges);
        builder.append("]");
        return builder.toString();
    }
}
