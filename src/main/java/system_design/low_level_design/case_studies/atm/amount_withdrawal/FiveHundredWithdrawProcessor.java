package system_design.low_level_design.case_studies.atm.amount_withdrawal;

import system_design.low_level_design.case_studies.atm.ATM;

public class FiveHundredWithdrawProcessor extends CashWithdrawProcessor{

    public FiveHundredWithdrawProcessor(CashWithdrawProcessor nextCashWithdrawProcessor){
        super(nextCashWithdrawProcessor);
    }

    public void withdraw(ATM atm, int remainingAmount){

        int required =  remainingAmount/500;
        int balance = remainingAmount%500;

        if(required <= atm.getNoOfFiveHundredNotes()) {
            atm.deductFiveHundredNotes(required);
        }
        else if(required > atm.getNoOfFiveHundredNotes()) {
            atm.deductFiveHundredNotes(atm.getNoOfFiveHundredNotes());
            balance = balance + (required-atm.getNoOfFiveHundredNotes()) * 500;
        }

        if(balance != 0){
            super.withdraw(atm, balance);
        }
    }
}


