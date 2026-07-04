package model;

public class VehileClaim extends Claim {
    public VehileClaim(String claimID, Policy policy, double claimAmount) {
        super(claimID, policy, claimAmount);

    }

    @Override
    public String getClaimType() {
        return "Vehicle Claim";
    }
}
