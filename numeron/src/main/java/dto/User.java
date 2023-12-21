package dto;

// ユーザー情報を表すDTOクラス
public class User {

	// ユーザーIDを保持する変数
	private int id;
	// ユーザー名を保持する変数
	private String name;

	// デフォルトコンストラクタ（引数なし）
	public User() {
	}

	// コンストラクタ（ユーザーIDと名前を引数として受け取る）
	public User(int id, String name) {
		this.id = id; // ユーザーIDを初期化
		this.name = name; // ユーザー名を初期化
	}

	// ユーザーIDを取得するメソッド
	public int getId() {
		return id;
	}

	// ユーザーIDを設定するメソッド
	public void setId(int id) {
		this.id = id;
	}

	// ユーザー名を取得するメソッド
	public String getName() {
		return name;
	}

	// ユーザー名を設定するメソッド
	public void setName(String name) {
		this.name = name;
	}

}
