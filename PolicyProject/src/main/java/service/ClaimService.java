package service;

import model.Claim;
import model.Status;

import java.util.ArrayList;
import java.util.List;

public class ClaimService {
    private final List<Claim> claims ;

    public ClaimService(ClaimProcessor claimProcessor) {
        this.claims= new ArrayList<>();
        this.claimProcessor = claimProcessor;
    }

    public void addClaim (Claim claim){
         claims.add(claim);
    }
    public Claim findClaimById(String claimID){
        for (Claim i:claims){
            if (i.getClaimID().equalsIgnoreCase(claimID)){
                return i;
            }else {
                return null;
            }
        }
    }

    public Status processClaim(String claimId){
      Claim claims1=  findClaimById(claimId);
        if (claims1==null){
            throw new IllegalArgumentException(claimId + "Not found");

        }
        return claimProcessor.process(claims1);
    }

    private final ClaimProcessor claimProcessor;

}
