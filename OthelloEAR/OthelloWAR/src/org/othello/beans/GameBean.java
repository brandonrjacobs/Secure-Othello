package org.othello.beans;

public class GameBean {

	
	private int user1Id;
	private int user2Id;
	private String gameStatus;
	private String gameName;
	private int gameId;
	
	
	public int getUser1Id() {
		return user1Id;
	}
	public void setUser1Id(int user1Id) {
		this.user1Id = user1Id;
	}
	public int getUser2Id() {
		return user2Id;
	}
	public void setUser2Id(int user2Id) {
		this.user2Id = user2Id;
	}
	public int getGameId() {
		return gameId;
	}
	public void setGameId(int gameId) {
		this.gameId = gameId;
	}
	public String getGameStatus() {
		return gameStatus;
	}
	public void setGameStatus(String gameStatus) {
		this.gameStatus = gameStatus;
	}
	public String getGameName() {
		return gameName;
	}
	public void setGameName(String gameName) {
		this.gameName = gameName;
	}
	
	
	
}
