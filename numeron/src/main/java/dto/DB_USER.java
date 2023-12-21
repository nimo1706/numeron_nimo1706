package dto;

// データベース内のユーザー情報を表すDTOクラス
public class DB_USER {

	// ユーザーIDを保持する変数
	private int id;
	// ユーザー名を保持する変数
	private String name;
	// ユーザーパスワードを保持する変数
	private String password;

	// デフォルトコンストラクタ（引数なし）
	public DB_USER() {
	}

	// コンストラクタ（ユーザーID、名前、パスワードを引数として受け取る）
	public DB_USER(int id, String name, String password) {
		this.id = id; // ユーザーIDを初期化
		this.name = name; // ユーザー名を初期化
		this.password = password; // パスワードを初期化
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

	// パスワードを取得するメソッド
	public String getPassword() {
		return password;
	}

	// パスワードを設定するメソッド
	public void setPassword(String password) {
		this.password = password;
	}
}
