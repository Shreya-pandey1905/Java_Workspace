package org.example.TransactionLimit;

public class LimitExceeded extends RuntimeException {

    public LimitExceeded(String message)
    {
        super(message);
    }
}
