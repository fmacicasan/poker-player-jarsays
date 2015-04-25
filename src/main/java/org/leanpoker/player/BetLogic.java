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
		
		logCards(cards, player.getName());
		logCards(gameState.getCommunityCards(), "Community cards: ");
	}

	private void logCards(List<Card> cards, String string) {
		StringBuilder sb = new StringBuilder(string + " cards:");
		for (Card card : cards) {
			sb.append("  " + card);
		}
		System.out.println(sb.toString());
	}

	public int calculate() {
		int noPlayers = gameState.getPlayers().size();
		int noCommunityCards = gameState.getCommunityCards().size();
		int callAmount = call();
		
		if (noCommunityCards < 3) {
			Card card1 = cards.get(0);
			Card card2 = cards.get(1);
			if (hasChanceToWin(card1, card2)) {
				if (callAmount >= chipsAvailable) return 0;
				
				return callAmount;
			} else {
				System.out.println("No chanche to win " + card1.getRank() + "  " + card2.getRank());
				return 0;
			}
		}
		
		int rankId = getRankId();
		
		if (noCommunityCards == 3 && rankId >= 1) {
			if (callAmount >= chipsAvailable) return 0;
			
			return call();
		}
		
		
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
		
		if (rankId < 3 && chipsAvailable < call()) {
			System.out.println("rankId<2 chipsAvailable < minRaise currentBuyIn=" + currentBuyIn + " bet=" + bet + " minRaise="+minRaise + "chipsAvailable=" + chipsAvailable);
			return 0;
		}
		
		
		
		if (callAmount >= chipsAvailable && rankId <= 4) return 0;
		
		if (rankId > 6) return chipsAvailable;
		if (rankId > 5) return raise((int)(chipsAvailable * 0.1));
		if (rankId > 4) return raise(0);
		
		return callAmount;
	}

	private int getRankId() {
		List<Card> allCards = new ArrayList<Card>();
		allCards.addAll(cards);
		allCards.addAll(gameState.getCommunityCards());
		
		int rankId = 0;
		try {
			return Ranking.getBestHand(allCards).getRank();
		} catch (IOException e) {
			e.printStackTrace();
			rankId = 0;
		}
		return rankId;
	}
	
	private boolean hasChanceToWin(Card card1, Card card2) {
		String rank1 = card1.getRank();
		String rank2 = card2.getRank();
		int pot = gameState.getPot();
	
		if (rank1.equals(rank2)) return true;
		if (isGreatRank(rank1) || isGreatRank(rank2) && pot < 50) return true;
		
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
		int callAmount = currentBuyIn - bet;
		System.out.println("callAmount=" + callAmount + " currentBuyIn=" + currentBuyIn + " bet=" + bet);
		
		return callAmount;
	}
	
	private int raise (int raisePlus) {
		int raiseAmount = currentBuyIn - bet + minRaise + raisePlus;
		System.out.println("raiseAmount=" + raiseAmount + " currentBuyIn=" + currentBuyIn + " bet=" + bet + " minRaise="+minRaise + " raisePlus=" + raisePlus);
		return raiseAmount;
	}
}
