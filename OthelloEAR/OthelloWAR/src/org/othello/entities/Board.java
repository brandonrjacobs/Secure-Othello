package org.othello.entities;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table
public class Board {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private Integer boardID;
	private Integer FK_GAMEID;
	private Integer FK_USERID;
	
	public Board() {
		super();
	}

	public Board(Integer boardID, Integer fK_GAMEID, Integer fK_USERID) {
		super();
		this.boardID = boardID;
		FK_GAMEID = fK_GAMEID;
		FK_USERID = fK_USERID;
	}

	public Integer getBoardID() {
		return boardID;
	}

	public void setBoardID(Integer boardID) {
		this.boardID = boardID;
	}

	public Integer getFK_GAMEID() {
		return FK_GAMEID;
	}

	public void setFK_GAMEID(Integer fK_GAMEID) {
		FK_GAMEID = fK_GAMEID;
	}

	public Integer getFK_USERID() {
		return FK_USERID;
	}

	public void setFK_USERID(Integer fK_USERID) {
		FK_USERID = fK_USERID;
	}
	
	
	
	
	


}
