package model;

public abstract class Claim {
    private final String claimID;
    private final Policy policy;
    private final double claimAmount;
    private  Status status;

    private  double approvedAmount;
    private  String rejectionReason;

    public Claim(String claimID, Policy policy, double claimAmount) {
        this.claimID = claimID;
        this.policy = policy;
        this.claimAmount = claimAmount;
        this.status = Status.REGISTERED;
        this.approvedAmount = approvedAmount;
        this.rejectionReason = null;
    }

    public abstract String getClaimType();
    public void getSummary(){

    }
    public void approve(double amt){
        this.status=Status.APPROVED;
        this.approvedAmount=amt;
        this.rejectionReason="";
    }
    public void reject(String reason){
        this.status=Status.REJECTED;
        this.approvedAmount=0;
        this.rejectionReason=reason;
    }

    public double getApprovedAmount() {
        return approvedAmount;
    }

    public void setApprovedAmount(double approvedAmount) {
        this.approvedAmount = approvedAmount;
    }

    public String getClaimID() {
        return claimID;
    }

    public Policy getPolicy() {
        return policy;
    }

    public double getClaimAmount() {
        return claimAmount;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getRejectionReason() {
        return rejectionReason;
    }

    public void setRejectionReason(String rejectionReason) {
        this.rejectionReason = rejectionReason;
    }



}

