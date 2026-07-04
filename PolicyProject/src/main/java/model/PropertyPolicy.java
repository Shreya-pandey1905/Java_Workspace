package model;

public class PropertyPolicy extends Policy {
    public PropertyPolicy(String policyId, Customer customer, double sumInsuared, double premiumAmount) {
        super(policyId, customer, sumInsuared, premiumAmount);
    }

    @Override
    public String getPolicyType() {
        return "Property";

    }

    @Override
    public double getCoverageAmount() {
        return 0.80;
    }
}
