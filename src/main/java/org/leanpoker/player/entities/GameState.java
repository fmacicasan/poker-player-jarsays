package org.leanpoker.player.entities;

import java.util.List;

/**
 * @author octavian
 * @since 25.04.2015
 */
public class GameState {
    private String tournamentId;
    private String gameId;
    private int round;
    private int betIndex;
    private int smallBlind;
    private int currentBuyIn;
    private int pot;
    private int minimumRaise;
    private int dealer;
    private int orbits;
    private int inAction;
    private List<PlayerDetails> players;
    private List<Card> communityCards;

    public String getTournamentId() {
        return tournamentId;
    }

    public void setTournamentId(String tournamentId) {
        this.tournamentId = tournamentId;
    }

    public String getGameId() {
        return gameId;
    }

    public void setGameId(String gameId) {
        this.gameId = gameId;
    }

    public int getRound() {
        return round;
    }

    public void setRound(int round) {
        this.round = round;
    }

    public int getBetIndex() {
        return betIndex;
    }

    public void setBetIndex(int betIndex) {
        this.betIndex = betIndex;
    }

    public int getSmallBlind() {
        return smallBlind;
    }

    public void setSmallBlind(int smallBlind) {
        this.smallBlind = smallBlind;
    }

    public int getCurrentBuyIn() {
        return currentBuyIn;
    }

    public void setCurrentBuyIn(int currentBuyIn) {
        this.currentBuyIn = currentBuyIn;
    }

    public int getPot() {
        return pot;
    }

    public void setPot(int pot) {
        this.pot = pot;
    }

    public int getMinimumRaise() {
        return minimumRaise;
    }

    public void setMinimumRaise(int minimumRaise) {
        this.minimumRaise = minimumRaise;
    }

    public int getDealer() {
        return dealer;
    }

    public void setDealer(int dealer) {
        this.dealer = dealer;
    }

    public int getOrbits() {
        return orbits;
    }

    public void setOrbits(int orbits) {
        this.orbits = orbits;
    }

    public int getInAction() {
        return inAction;
    }

    public void setInAction(int inAction) {
        this.inAction = inAction;
    }

    public List<PlayerDetails> getPlayers() {
        return players;
    }

    public void setPlayers(List<PlayerDetails> players) {
        this.players = players;
    }

    public List<Card> getCommunityCards() {
        return communityCards;
    }

    public void setCommunityCards(List<Card> communityCards) {
        this.communityCards = communityCards;
    }

    @Override
    public String toString() {
        return "GameState{" +
                "tournamentId='" + tournamentId + '\'' +
                ", gameId='" + gameId + '\'' +
                ", round=" + round +
                ", betIndex=" + betIndex +
                ", smallBlind=" + smallBlind +
                ", currentBuyIn=" + currentBuyIn +
                ", pot=" + pot +
                ", minimumRaise=" + minimumRaise +
                ", dealer=" + dealer +
                ", orbits=" + orbits +
                ", inAction=" + inAction +
                ", players=" + players +
                ", communityCards=" + communityCards +
                '}';
    }
}
