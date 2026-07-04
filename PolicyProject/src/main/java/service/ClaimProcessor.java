package service;

import model.Claim;
import model.Status;

public interface ClaimProcessor {
    Status  process(Claim claim);

}
