package com.tddkata.financial;

public class Money implements Expression {
    protected int amount;
    protected String currency;

    public Money(Integer amount, String currency) {
        this.amount = amount;
        this.currency = currency;
    }

    public Money reduce(Bank bank, String to) {
        int rate = bank.rate(currency, to);
        return new Money(amount/rate, to);
    }

    public Expression plus(Expression addend) {
        return new Sum(this, addend);
    }

    public Expression times(int multiplier) {
        return new Money(amount * multiplier, currency);
    }

    public String currency() {
        return currency;
    }

    public static Money dollar(Integer amount) {
        return new Money(amount, "USD");
    }

    public static Money franc(Integer amount) {
        return new Money(amount, "CHF");
    }

    public boolean equals(Object other) {
        Money money = (Money) other;
        return amount == money.amount
                && currency().equals(money.currency());
    }

    public String toString() {
        return amount + " " + currency;
    }
}
