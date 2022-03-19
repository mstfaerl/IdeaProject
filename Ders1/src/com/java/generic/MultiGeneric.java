/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.java.generic;

/**
 *
 * @author m07er
 */
public class MultiGeneric<Tx, Ty> {

    private Tx tx;
    private Ty ty;

    public MultiGeneric(Tx tx, Ty ty) {
        this.tx = tx;
        this.ty = ty;
    }

    public Tx getTx() {
        return tx;
    }

    public void setTx(Tx tx) {
        this.tx = tx;
    }

    public Ty getTy() {
        return ty;
    }

    public void setTy(Ty ty) {
        this.ty = ty;
    }

    public void dataTypes() {
        System.out.println(tx.getClass().getName() + "\n" + ty.getClass().getName());
    }
}
