package org.leanpoker.player.entities;

import javax.print.attribute.IntegerSyntax;
import java.util.List;

/**
 * @author octavian
 * @since 25.04.2015
 */
public class Hand {
    private int rank;
    private int value;
    private int secondValue;
    private List<Integer> kickers;
    private List<Card> cardsUsed;
    private List<Card> cards;

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getSecondValue() {
        return secondValue;
    }

    public void setSecondValue(int secondValue) {
        this.secondValue = secondValue;
    }

    public List<Integer> getKickers() {
        return kickers;
    }

    public void setKickers(List<Integer> kickers) {
        this.kickers = kickers;
    }

    public List<Card> getCardsUsed() {
        return cardsUsed;
    }

    public void setCardsUsed(List<Card> cardsUsed) {
        this.cardsUsed = cardsUsed;
    }

    public List<Card> getCards() {
        return cards;
    }

    public void setCards(List<Card> cards) {
        this.cards = cards;
    }

    @Override
    public String toString() {
        return "Hand{" +
                "rank=" + rank +
                ", value=" + value +
                ", secondValue=" + secondValue +
                ", kickers=" + kickers +
                ", cardsUsed=" + cardsUsed +
                ", cards=" + cards +
                '}';
    }
}
