package org.othello.entities;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table

public class Game {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	@GeneratedValue
	private Integer GameID;
	private Integer FK_USERID1;
	private Integer FK_USERID2;
	private String GameStatus;
	private String GameName;
	
	
	
	public Game() {
		super();
	}
	
	
	public Game(Integer gameID, Integer fK_USERID1, Integer fK_USERID2, String gameStatus, String gameName) {
		super();
		GameID = gameID;
		FK_USERID1 = fK_USERID1;
		FK_USERID2 = fK_USERID2;
		GameStatus = gameStatus;
		GameName = gameName;
	}
	public Integer getGameID() {
		return GameID;
	}
	public void setGameID(Integer gameID) {
		GameID = gameID;
	}
	public Integer getFK_USERID1() {
		return FK_USERID1;
	}
	public void setFK_USERID1(Integer fK_USERID1) {
		FK_USERID1 = fK_USERID1;
	}
	public Integer getFK_USERID2() {
		return FK_USERID2;
	}
	public void setFK_USERID2(Integer fK_USERID2) {
		FK_USERID2 = fK_USERID2;
	}
	public String getGameStatus() {
		return GameStatus;
	}
	public void setGameStatus(String gameStatus) {
		GameStatus = gameStatus;
	}
	public String getGameName() {
		return GameName;
	}
	public void setGameName(String gameName) {
		GameName = gameName;
	}
	
	
	
}
