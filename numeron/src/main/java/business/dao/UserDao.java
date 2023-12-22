package business.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dto.DB_USER;

// ユーザー情報に関連するデータベース操作を行うクラス
public class UserDao extends DAOTemplate {

	// ユーザー情報をデータベースに挿入するメソッド
	public DB_USER insert(DB_USER db_user) {
		// 挿入用のSQL文を定義
		String insertSql = "INSERT INTO USER (ID, NAME, PASSWORD) VALUES (?, ?, ?)";


		// リソースを自動的に解放するためのtry-with-resources文
		try (Connection con = createConnection();
				PreparedStatement pstmt = con.prepareStatement(insertSql);) {
			// ユーザーIDを設定
			pstmt.setInt(1, db_user.getId());
			// ユーザー名を設定
			pstmt.setString(2, db_user.getName());
			// パスワードを設定
			pstmt.setString(3, db_user.getPassword());

			// SQLを実行し、ユーザー情報を挿入
			pstmt.executeUpdate();

			// 挿入したユーザー情報を返す
			return db_user;
			
		} catch (SQLException e) {
			// SQL例外が発生した場合、実行時例外に変換してスロー
			throw new RuntimeException(e);
		}
	}

	// 指定された名前を持つユーザーの数を取得するメソッド
	public int findName(String name) {
		// 名前検索用のSQL文を定義
		String sql = "SELECT COUNT(*) AS CNT FROM USER WHERE NAME = ?;";

		// リソースを自動的に解放するためのtry-with-resources文
		try (Connection con = createConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);) {
			// 検索する名前を設定
			pstmt.setString(1, name);

			// SQL実行し、結果を取得
			ResultSet rs = pstmt.executeQuery();

			int result = 0;
			if (rs.next()) {
				// 結果セットからユーザー数を取得
				result = rs.getInt("CNT");
			}

			// ユーザー数を返す
			return result;

		} catch (SQLException e) {
			// SQL例外が発生した場合、実行時例外に変換してスロー
			throw new RuntimeException(e);
		}
	}

	// ログイン情報をチェックするメソッド
	public DB_USER checkLogin(String name, String password) {
		// ログインチェック用のSQL文を定義
		String sql = "SELECT * FROM USER WHERE NAME = ? AND PASSWORD = ?;";

		// リソースを自動的に解放するためのtry-with-resources文
		try (Connection con = createConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);) {
			// ユーザー名を設定
			pstmt.setString(1, name);
			// パスワードを設定
			pstmt.setString(2, password);

			// SQL実行し、結果を取得
			ResultSet rs = pstmt.executeQuery();

			DB_USER result = null;
			if (rs.next()) {
				int resultId = rs.getInt("XXXXXXXXXX");
				String resultName = rs.getString("XXXXXXXXXX");
				String resultPassword = rs.getString("XXXXXXXXXX");
				// 結果セットからユーザー情報を取得し、DB_USERオブジェクトを生成
				result = new DB_USER(rs.getInt("ID"), rs.getString("NAME"), rs.getString("PASSWORD"));
			}

			// 取得したユーザー情報を返す
			return result;
		} catch (SQLException e) {
			// SQL例外が発生した場合、実行時例外に変換してスロー
			throw new RuntimeException(e);
		}
	}

	// 次に使用するIDを取得するメソッド
	public int getNextId() {
		// 最大ID取得用のSQL文を定義
		String sql = "SELECT MAX(ID) AS MAX FROM USER";

		// リソースを自動的に解放するためのtry-with-resources文
		try (Connection con = createConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);) {
			// SQL実行し、結果を取得
			ResultSet rs = pstmt.executeQuery();

			int maxId = 0;
			if (rs.next()) {
				// 結果セットから最大IDを取得
				maxId = rs.getInt("MAX");
			}

			// 最大IDに1を加えた値を返す（次のIDとして使用）
			return maxId + 1;
		} catch (SQLException e) {
			// SQL例外が発生した場合、実行時例外に変換してスロー
			throw new RuntimeException(e);
		}
	}
}
