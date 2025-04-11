package system_design.low_level_design.case_studies.atm;

public class User {

    Card card;
    UserBankAccount bankAccount;

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }
}
