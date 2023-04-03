package model.user.buyer;

import model.request.Request;

public class BalanceIncrease extends Request {
    private String cardNumber;
    private String PassWord;
    private String cvv2;
    private double balanceIncrease;

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getPassWord() {
        return PassWord;
    }

    public void setPassWord(String passWord) {
        PassWord = passWord;
    }

    public String getCvv2() {
        return cvv2;
    }

    public void setCvv2(String cvv2) {
        this.cvv2 = cvv2;
    }

    public double getBalanceIncrease() {
        return balanceIncrease;
    }

    public void setBalanceIncrease(double balanceIncrease) {
        this.balanceIncrease = balanceIncrease;
    }

    public BalanceIncrease(String cardNumber, String passWord, String cvv2, double balanceIncrease) {
        super();
        this.cardNumber = cardNumber;
        PassWord = passWord;
        this.cvv2 = cvv2;
        this.balanceIncrease = balanceIncrease;
    }

    @Override
    public String toString() {
        return "\nBalance Increase Request: " +
                "\ncardNumber='" + cardNumber + '\'' +
                "\nPassWord='" + PassWord + '\'' +
                "\ncvv2='" + cvv2 + '\'' +
                "\nbalanceIncrease='" + balanceIncrease + '\'';
    }
}
