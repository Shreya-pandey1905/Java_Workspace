package model;

public class HealthClaim extends Claim {


    public HealthClaim(String claimID, Policy policy, double claimAmount) {

        super(claimID, policy, claimAmount);
    }

    @Override
    public String getClaimType() {

        return "Health Claim";
    }
}
