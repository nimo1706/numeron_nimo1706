package business.service;

import business.dao.UserDao;
import dto.DB_USER;
import dto.User;

// ユーザーのログイン処理を担うサービスクラス
public class NumeronLoginService {

	// ユーザーデータにアクセスするためのDAOオブジェクト
	UserDao dao = new UserDao();

	// ユーザー名とパスワードを受け取り、ログイン処理を行うメソッド
	public User login(String name, String password) {
		// ログイン処理の結果を保持するUserオブジェクトを初期化
		User user = null;

		// データベースからログイン情報をチェック
		DB_USER db_user = dao.XXXXXXXXXX(XXXXXXXXXX, XXXXXXXXXX);

		// データベースからの応答がnullでない場合（つまりログイン成功の場合）
		if (db_user != null) {
			// DB_USERオブジェクトからUserオブジェクトを生成
			user = new User(XXXXXXXXXX, XXXXXXXXXX);
		}

		// 最終的なUserオブジェクトを返す（ログイン失敗の場合はnull）
		return user;
	}
}
