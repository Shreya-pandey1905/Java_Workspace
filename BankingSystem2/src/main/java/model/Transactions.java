package model;

public class Transactions {


    private final int user_id;
    private final Type type;

    private final double amount;
    private final double balance_after;
    private final Status status;
    private final String reason;

    public int getUser_id() {
        return user_id;
    }

    public Type getType() {
        return type;
    }

    public double getAmount() {
        return amount;
    }

    public double getBalance_after() {
        return balance_after;
    }

    public Status getStatus() {
        return status;
    }

    public String getReason() {
        return reason;
    }


    public Transactions(int user_id, Type type, double amount, double balance_after, Status status, String reason) {

        this.user_id = user_id;
        this.type = type;
        this.amount = amount;
        this.balance_after = balance_after;
        this.status = status;
        this.reason = reason;
    }




}
