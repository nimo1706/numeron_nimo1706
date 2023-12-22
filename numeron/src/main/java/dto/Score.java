package dto;

public class Score {

	private String name;
	private String result;
	private int turn;

	public Score(String name, String result, int turn) {
		this.name = name;
		this.result = result;
		this.turn = turn;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public int getTurn() {
		return turn;
	}

	public void setTurn(int turn) {
		this.turn = turn;
	}

}
