package dto;

public class DB_SCORE {

	private int id;
	private String result;
	private int turn;
	private int user_id;

	public DB_SCORE(int id, String result, int turn, int user_id) {
		this.id = id;
		this.result = result;
		this.turn = turn;
		this.user_id = user_id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

}
