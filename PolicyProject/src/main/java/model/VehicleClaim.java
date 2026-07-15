package model;

public class VehicleClaim extends Claim {
    public VehicleClaim(String claimID, Policy policy, double claimAmount) {
        super(claimID, policy, claimAmount);

    }

    @Override
    public String getClaimType() {
        return "Vehicle Claim";
    }
}
