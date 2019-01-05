package core;
import java.util.regex.*;

public class Position {
	public int x=0;
	public int y=0;
	private static final String ERR_MOVE_POS_FORMAT = "ERROR: Position";
	private static final String REGEX_BOARD_FORMAT = "[0-9]{2}";
	private static Pattern p = Pattern.compile(REGEX_BOARD_FORMAT);

	public static void main(String[] args){
		Position p = new Position(5,5);
		Position p2 = new Position(0,8);
	}
	public Position(Position p){
		
		if(!this.validateInput(p.x, p.y)){
			System.out.println("ERROR bad input");
		}else{
			System.out.println("Good Input");
			this.x = p.x;
			this.y = p.y;
		}

	}
	
	public Position(int x, int y){
		if(!this.validateInput(x, y)){
			System.out.println("ERROR bad input");
		}else{
			System.out.println("Good Input");
			this.x = x;
			this.y = y;
		}
	}

	private boolean validateInput(Integer x, Integer y)
	{
		String tmp = new String(x.toString() + y.toString());
		Matcher m = p.matcher(tmp);
		boolean output = m.matches();
		return output;
	}

}
