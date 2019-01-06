package org.othello.entities;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table
public class BoardStates {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer StateId;
	private Integer FK_GAMEID;
	private String BoardMap;
	private int MoveNumber;
	private Integer FK_USERID;
	private Integer FK_BOARDID;
	
	public BoardStates() {
		super();
	}

	public BoardStates(Integer stateId, Integer fK_GAMEID, String boardMap, int moveNumber, Integer fK_USERID,
			Integer fK_BOARDID) {
		super();
		StateId = stateId;
		FK_GAMEID = fK_GAMEID;
		BoardMap = boardMap;
		MoveNumber = moveNumber;
		FK_USERID = fK_USERID;
		FK_BOARDID = fK_BOARDID;
	}

	public Integer getStateId() {
		return StateId;
	}

	public void setStateId(Integer stateId) {
		StateId = stateId;
	}

	public Integer getFK_GAMEID() {
		return FK_GAMEID;
	}

	public void setFK_GAMEID(Integer fK_GAMEID) {
		FK_GAMEID = fK_GAMEID;
	}

	public String getBoardMap() {
		return BoardMap;
	}

	public void setBoardMap(String boardMap) {
		BoardMap = boardMap;
	}

	public int getMoveNumber() {
		return MoveNumber;
	}

	public void setMoveNumber(int moveNumber) {
		MoveNumber = moveNumber;
	}

	public Integer getFK_USERID() {
		return FK_USERID;
	}

	public void setFK_USERID(Integer fK_USERID) {
		FK_USERID = fK_USERID;
	}

	public Integer getFK_BOARDID() {
		return FK_BOARDID;
	}

	public void setFK_BOARDID(Integer fK_BOARDID) {
		FK_BOARDID = fK_BOARDID;
	}
	
	
	
	
	
	
	
		
	
}
