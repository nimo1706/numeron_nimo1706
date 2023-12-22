package business.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dto.DB_SCORE;

// ユーザー情報に関連するデータベース操作を行うクラス
public class ScoreDao extends DAOTemplate {

	// ユーザー情報をデータベースに挿入するメソッド
	public DB_SCORE insert(DB_SCORE db_score) {
		// 挿入用のSQL文を定義
		String insertSql = "INSERT INTO SCORE (ID, RESULT, TURN,USER_ID) VALUES (?, ?, ?, ?)";

		// リソースを自動的に解放するためのtry-with-resources文
		try (Connection con = createConnection();
				PreparedStatement pstmt = con.prepareStatement(insertSql);) {

			// スコアIDを設定
			pstmt.setInt(1, db_score.getId());

			// リザルトを登録
			pstmt.setString(2, db_score.getResult());

			// ターン数を登録
			pstmt.setInt(3, db_score.getTurn());

			// ユーザーIDを登録
			pstmt.setInt(4, db_score.getUser_id());

			// SQLを実行し、ユーザー情報を挿入
			pstmt.executeUpdate();

			// 挿入したユーザー情報を返す
			return db_score;

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
