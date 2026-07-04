package model;

public class VehiclePolicy extends Policy {

    public VehiclePolicy(String policyId, Customer customer, double sumInsuared, double premiumAmount) {
        super(policyId, customer, sumInsuared, premiumAmount);
    }

    @Override
    public String getPolicyType() {
        return "Vehicle";

    }

    @Override
    public double getCoverageAmount() {
        return 0.75;
    }
}
