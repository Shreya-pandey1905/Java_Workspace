package model;

public class Transfer {
    public int id;
    private  final long sender_account;
    private  final long receiver_account;
    private  final Status status;

    public long getSender_account() {
        return sender_account;
    }

    public int getId() {
        return id;
    }

    public long getReceiver_account() {
        return receiver_account;
    }

    public Status getStatus() {
        return status;
    }


    public Transfer(long sender_account, long receiver_account, Status status) {

        this.sender_account = sender_account;
        this.receiver_account = receiver_account;
        this.status = status;
    }
}