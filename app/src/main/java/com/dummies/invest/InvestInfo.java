package com.dummies.invest;

public class InvestInfo {
    String name;
   String invtype;
    String rate;

    InvestInfo(String name, String invtype, String rate) {
        this.name = name;
       this.invtype = invtype;
    this.rate = rate;



    }


    public String getName() {
        return name;
    }

    public String getInvtype() {
        return invtype;
    }
}








