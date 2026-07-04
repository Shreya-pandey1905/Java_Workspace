package model;

public class PropertyClaim extends Claim {
    public PropertyClaim(String claimID, Policy policy, double claimAmount) {
        super(claimID, policy, claimAmount);
    }

    @Override
    public String getClaimType() {
        return "Property Claim";
    }
}
