package edu.errors;

import java.math.BigDecimal;

// Very important for business- therefore checked (extends Exception)
public class InvalidTransferException extends Exception{
    public InvalidTransferException(BigDecimal transfer){
        super("Cannot transfer zero or less funds. Was: " + transfer);
    }

    public InvalidTransferException(BigDecimal account, BigDecimal transfer){
        super("Cannot transfer more money than account has." +
                " Has: " + account +
                " Wants to transfer: " + transfer);
    }
}
