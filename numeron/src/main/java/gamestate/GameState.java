package gamestate;

import java.util.List;

// ヌメロンゲームの現在の状態を表すクラス
public class GameState {

	// 正解の数値を保持する変数
	private String correctNumber;
	// ユーザーまたはCPUによる推測のリストを保持する変数
	private List<Guess> guessList;

	// デフォルトコンストラクタ（引数なし）
	public GameState() {
	}

	// コンストラクタ（正解の数値と推測リストを引数として受け取る）
	public GameState(String correctNumber, List<Guess> guessList) {
		this.correctNumber = correctNumber; // 正解の数値を初期化
		this.guessList = guessList; // 推測リストを初期化
	}

	// 正解の数値を取得するメソッド
	public String getCorrectNumber() {
		return correctNumber;
	}

	// 正解の数値を設定するメソッド
	public void setCorrectNumber(String correctNumber) {
		this.correctNumber = correctNumber;
	}

	// 推測リストを取得するメソッド
	public List<Guess> getGuessList() {
		return guessList;
	}

	// 推測リストを設定するメソッド
	public void setGuessList(List<Guess> guessList) {
		this.guessList = guessList;
	}

}
