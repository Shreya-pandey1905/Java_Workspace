package service;

import model.Claim;
import model.Status;

import model.Policy;

public class SimpleClaimProcessor implements  ClaimProcessor{
    @Override
    public Status process(Claim claim) {
         Policy policy = claim.getPolicy();
         if (claim.getClaimAmount()<=0){
             claim.reject("Claim amount should be greater than 0");
             return claim.getStatus();
         }

         if (claim.getClaimAmount()>=policy.getSumInsuared()){
             claim.reject("claim amount cannot exceed");
             return claim.getStatus();
         }
         double approvedAmount=claim.getClaimAmount()*policy.getCoverageAmount();
         claim.approve(policy.getPremiumAmount());
         return claim.getStatus() ;

    }
}
