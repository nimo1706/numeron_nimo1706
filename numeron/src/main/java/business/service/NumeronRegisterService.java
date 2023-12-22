package business.service;

import business.dao.UserDao;
import dto.DB_USER;
import dto.User;

// ユーザー登録を担うサービスクラス
public class NumeronRegisterService {

	// ユーザーデータにアクセスするためのDAOオブジェクト
	UserDao dao = new UserDao();

	// ユーザー名とパスワードを受け取り、ユーザー登録処理を行うメソッド
	public User resister(String name, String password) {
		// 指定されたユーザー名が既に存在するかどうかを確認
		int checkCnt = dao.findName(name);

		// 登録結果を保持するUserオブジェクトを初期化
		User user = null;

		// 指定されたユーザー名がまだ存在しない場合
		if (checkCnt == 0) {
			// 新しいユーザーIDを取得
			int id = dao.getNextId();

			// 新しいユーザー情報を持つDB_USERオブジェクトを生成
			DB_USER db_user = new DB_USER(0, name, password);

			// DB_USERオブジェクトをデータベースに挿入
			db_user = dao.insert(db_user);

			// 挿入されたユーザー情報を元にUserオブジェクトを生成
			user = new User(db_user.getId(), db_user.getName());
		}

		// 登録されたUserオブジェクトを返す（登録失敗の場合はnull）
		return user;
	}
}
