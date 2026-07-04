package model;

public abstract class Policy {
private final String policyId;
private final Customer customer ;

    public double getSumInsuared() {
        return sumInsuared;
    }

    public double getPremiumAmount() {
        return premiumAmount;
    }

    public String getPolicyId() {
        return policyId;
    }

    public Customer getCustomer() {
        return customer;
    }

    private final double sumInsuared;
private final double premiumAmount;

public Policy(String policyId,Customer customer,double sumInsuared, double premiumAmount){
    this.policyId=policyId;
    this.customer=customer;
    this.sumInsuared=sumInsuared;
    this.premiumAmount=premiumAmount;

}

    public abstract String getPolicyType();
    public abstract double getCoverageAmount();

}


