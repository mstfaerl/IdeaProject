/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.java.finals;

/**
 *
 * @author m07er
 */
 public final class Bank {
    
    private String bankName;
    private String bankAdress;

    public Bank() {
    }

    public Bank(String bankName, String bankAdress) {
        this.bankName = bankName;
        this.bankAdress = bankAdress;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getBankAdress() {
        return bankAdress;
    }

    public void setBankAdress(String bankAdress) {
        this.bankAdress = bankAdress;
    } 

}
