package gamestate;

// ヌメロンゲームにおける推測とその結果を表すクラス
public class Guess {

	// 推測された値を保持する変数
	private String value;
	// 推測値と正解値の完全一致（"eat"）の数を保持する変数
	private int eat;
	// 推測値の数字が正解値に存在するが位置が異なる（"bite"）の数を保持する変数
	private int bite;

	// デフォルトコンストラクタ（引数なし）
	public Guess() {
	}

	// コンストラクタ（推測値、"eat"の数、"bite"の数を引数として受け取る）
	public Guess(String value, int eat, int bite) {
		this.value = value; // 推測された値を初期化
		this.eat = eat; // "eat"の数を初期化
		this.bite = bite; // "bite"の数を初期化
	}

	// 推測された値を取得するメソッド
	public String getValue() {
		return value;
	}

	// 推測された値を設定するメソッド
	public void setValue(String value) {
		this.value = value;
	}

	// "eat"の数を取得するメソッド
	public int getEat() {
		return eat;
	}

	// "eat"の数を設定するメソッド
	public void setEat(int eat) {
		this.eat = eat;
	}

	// "bite"の数を取得するメソッド
	public int getBite() {
		return bite;
	}

	// "bite"の数を設定するメソッド
	public void setBite(int bite) {
		this.bite = bite;
	}

}
