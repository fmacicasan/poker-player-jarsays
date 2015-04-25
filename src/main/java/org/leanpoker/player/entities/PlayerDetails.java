package org.leanpoker.player.entities;

import java.util.List;

/**
 * @author octavian
 * @since 25.04.2015
 */
public class PlayerDetails {
    private int id;
    private String name;
    private String status;
    private String version;
    private int stack;
    private int bet;
    private List<Card> holeCards;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public int getStack() {
        return stack;
    }

    public void setStack(int stack) {
        this.stack = stack;
    }

    public int getBet() {
        return bet;
    }

    public void setBet(int bet) {
        this.bet = bet;
    }

    public List<Card> getHoleCards() {
        return holeCards;
    }

    public void setHoleCards(List<Card> holeCards) {
        this.holeCards = holeCards;
    }

    @Override
    public String toString() {
        return "PlayerDetails{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", status='" + status + '\'' +
                ", version='" + version + '\'' +
                ", stack=" + stack +
                ", bet=" + bet +
                ", holeCards=" + holeCards +
                '}';
    }
}
