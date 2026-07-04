package model;

public class HealthPolicy extends Policy {
    public HealthPolicy(String policyId, Customer customer, double sumInsuared, double premiumAmount) {
        super(policyId, customer, sumInsuared, premiumAmount);
    }

    @Override
    public String getPolicyType() {
        return "Health";
    }

    @Override
    public double getCoverageAmount() {
        return 0.90;
    }
}
