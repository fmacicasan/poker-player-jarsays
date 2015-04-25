package org.leanpoker.player;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.leanpoker.player.entities.Card;
import org.leanpoker.player.entities.GameState;
import org.leanpoker.player.entities.PlayerDetails;

public class BetLogic {
	
	private int chipsAvailable = 0;
	private GameState gameState;
	private List<Card> cards;
	private int bet;
	private int currentBuyIn;
	private int minRaise;
	
	
	public BetLogic(GameState gameState) {
		this.gameState = gameState;
		
		init(gameState);
	}

	private void init(GameState gameState) {
		int ourId = gameState.getInAction();
		PlayerDetails player = gameState.getPlayers().get(ourId);
		chipsAvailable = player.getStack();
		cards = player.getHoleCards();
		bet = player.getBet();
		currentBuyIn = gameState.getCurrentBuyIn();
		minRaise = gameState.getMinimumRaise();
		
		StringBuilder sb = new StringBuilder(player.getName() + " cards:");
		for (Card card : cards) {
			sb.append("  " + card);
		}
		System.out.println(sb.toString());
	}

	public int calculate() {
		int noPlayers = gameState.getPlayers().size();
		int noCommunityCards = gameState.getCommunityCards().size();
		
		if (noCommunityCards < 3) {
			Card card1 = cards.get(0);
			Card card2 = cards.get(1);
			if (hasChanceToWin(card1, card2)) {
				return call();
			} else {
				System.out.println("No chanche to win " + card1.getRank() + "  " + card2.getRank());
				return 0;
			}
		}
		
		int rankId = getRankId();
		
		if (rankId < 1) {
			System.out.println("rankId<1 currentBuyIn=" + currentBuyIn + " bet=" + bet + " minRaise="+minRaise);
			return 0;
		}
		
		if (noPlayers > 4) {
			if (rankId < 2) {
				System.out.println("rankId<2 currentBuyIn=" + currentBuyIn + " bet=" + bet + " minRaise="+minRaise);
				return 0;
			}
		}
		
		if (rankId < 2 && chipsAvailable < call()) {
			System.out.println("rankId<2 chipsAvailable < minRaise currentBuyIn=" + currentBuyIn + " bet=" + bet + " minRaise="+minRaise + "chipsAvailable=" + chipsAvailable);
			return 0;
		}
		
		if (rankId > 2) return raise(0);
		
		return call();
	}

	private int getRankId() {
		List<Card> allCards = new ArrayList<Card>();
		allCards.addAll(cards);
		allCards.addAll(gameState.getCommunityCards());
		
		int rankId = 0;
		try {
			Ranking.getBestHand(allCards).getRank();
		} catch (IOException e) {
			e.printStackTrace();
			rankId = 0;
		}
		return rankId;
	}
	
	private boolean hasChanceToWin(Card card1, Card card2) {
		String rank1 = card1.getRank();
		String rank2 = card2.getRank();
	
		if (isGreatRank(rank1) || isGreatRank(rank2)) return true;
		if (rank1.equals(rank2)) return true;
		
		return false;
	}

	private boolean isGreatRank(String rank) {
		Set<String> goodRanks = new HashSet<String>();
		goodRanks.add("10");
		goodRanks.add("J");
		goodRanks.add("Q");
		goodRanks.add("K");
		goodRanks.add("A");
		
		return goodRanks.contains(rank.toUpperCase());
	}

	private int call() {
		int callAmount = currentBuyIn - bet + minRaise;
		System.out.println("callAmount=" + callAmount + " currentBuyIn=" + currentBuyIn + " bet=" + bet + " minRaise="+minRaise);
		return callAmount;
	}
	
	private int raise (int raisePlus) {
		int raiseAmount = currentBuyIn - bet + minRaise + raisePlus;
		System.out.println("raiseAmount=" + raiseAmount + " currentBuyIn=" + currentBuyIn + " bet=" + bet + " minRaise="+minRaise + " raisePlus=" + raisePlus);
		return raiseAmount;
	}
}
