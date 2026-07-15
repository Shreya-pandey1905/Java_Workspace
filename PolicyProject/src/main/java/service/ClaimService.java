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

    private static void processClaim() {
        System.out.println("Enter Claim ID to process: ");
        String claimId = sc.next();
        Claim claim = CLAIM_SERVICE.findClaimById(claimId);

        if (claim == null) {
            System.out.println("Claim not found.");
            return;
        }

        Status status = CLAIM_SERVICE.processClaim(claimId);
        System.out.println("Claim processed. Current status: " + status);
        System.out.printf("Approved amount: %.2f%n", claim.getApprovedAmount());
        if (!claim.getRejectionReason().isBlank()) {
            System.out.println("Reason: " + claim.getRejectionReason());
        }
    }
    private final ClaimProcessor claimProcessor;

}
