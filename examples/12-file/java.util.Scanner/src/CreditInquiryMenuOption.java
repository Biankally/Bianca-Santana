public enum CreditInquiryMenuOption { 
    ZERO_BALANCE(1), 
    CREDIT_BALANCE(2), 
    DEBIT_BALANCE(3), 
    END(4); 
 
    private final int value; 
 
    private CreditInquiryMenuOption(int value) {
       this.value = value;
    }
 }
     