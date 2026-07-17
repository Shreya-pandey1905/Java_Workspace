package org.example;

public class Main {
    static void main() {
        Customer cst1=new RegularCustomer(200);
        Customer cst2=new PremiumCustomer(200);

        if(cst1 instanceof RegularCustomer rcst)
        {
            System.out.println(rcst.amount-(rcst.amount)* rcst.discount());
        }
        if (cst2 instanceof PremiumCustomer rcst){
            System.out.println(rcst.amount-(rcst.amount)*rcst.discount());
        }
    }
}
