package org.leanpoker.player.entities;

/**
 * @author octavian
 * @since 25.04.2015
 */
public class Card {
    private String rank;
    private String suit;

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public String getSuit() {
        return suit;
    }

    public void setSuit(String suit) {
        this.suit = suit;
    }
}
