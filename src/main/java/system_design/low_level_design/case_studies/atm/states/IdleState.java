package system_design.low_level_design.case_studies.atm.states;

import system_design.low_level_design.case_studies.atm.ATM;
import system_design.low_level_design.case_studies.atm.Card;

public class IdleState extends ATMState {

    @Override
    public void insertCard(ATM atm, Card card) {
        System.out.println("Card is inserted");
        atm.setCurrentATMState(new HasCardState());
    }
}


