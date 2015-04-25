package org.leanpoker.player;

import java.util.List;

import org.leanpoker.player.entities.Card;
import org.leanpoker.player.entities.GameState;
import org.leanpoker.player.entities.PlayerDetails;

public class BetLogic {
	
	private int chipsAvailable = 0;
	private GameState gameState;
	private List<Card> cards;
	
	
	public BetLogic(GameState gameState) {
		this.gameState = gameState;
		
		init(gameState);
	}

	private void init(GameState gameState) {
		for (PlayerDetails player : gameState.getPlayers()) {
			if (player.getName().equalsIgnoreCase("Jarsays")) {
				chipsAvailable = player.getStack();
				cards = player.getHoleCards();
				break;
			}
		}
	}

	public int calculate() {
		int minRaise = gameState.getMinimumRaise();
		int currentBuyIn =gameState.getCurrentBuyIn();
		int noPlayers = gameState.getPlayers().size();
		int noCommunityCards = gameState.getCommunityCards().size();
		
		//call the ranking Api
		int rankId = 3;
		
		if (noCommunityCards < 3) {
			return minRaise;
		}
		
		if (rankId < 1) return 0;
		
		if (noPlayers > 4) {
//			if (rankId < 2) { 
				return 0;
//			}
		}
		
//		if (rankId < 2 && chipsAvailable < minRaise) return 0;
		
//		if (rankId > 2) return raise(minRaise);
		
		return minRaise;
	}

	private int raise(int minRaise) {
		int remainingChips = chipsAvailable - minRaise;
		
		if (remainingChips > 0) return minRaise + (int)(chipsAvailable * 0.1);
		
		return minRaise;
	}
}
