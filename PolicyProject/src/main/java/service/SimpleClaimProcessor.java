package service;

import model.Status;
import model.Claim;
import model.Policy;
public class SimpleClaimProcessor implements ClaimProcessor
{

    @Override
    public Status process(Claim claim) {
        // TODO Auto-generated method stub
        Policy policy = claim.getPolicy();
        if(claim.getClaimAmount() <=0)
        {
            claim.reject("Claimed amount should be greater than 0");
            return claim.getStatus();

        }
        if(claim.getClaimAmount()> policy.getSumInsuared())
        {
            claim.reject("Claim amount can't exceed by policy sum insured");
            return claim.getStatus();
        }
        double approvedAmount = claim.getClaimAmount()*policy.getCoverageAmount();
        claim.approve(approvedAmount);
        return claim.getStatus();

    }

}
