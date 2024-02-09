package business.service;

import java.util.List;

import business.dao.ScoreDao;
import dto.DB_SCORE;
import dto.Score;
import dto.User;
import gamestate.GameState;

// ヌメロンゲームのスコアに関連するサービスを提供するクラス
public class NumeronScoreService {

	// スコアデータにアクセスするためのDAOオブジェクト
	private ScoreDao dao = new ScoreDao();

	// 全スコアデータを取得するメソッド
	public List<Score> findAll() {
		// DAOを使用して全スコアデータを取得し返す
		return dao.findAll();
	}

	// スコアを登録するメソッド
	public int resister(User user, GameState playerGameState) {
		// 次に使用するIDを取得
		int id = dao.getNextId();

		// ゲームの結果を判定（最後の推測で"Eat"が3なら勝ち、そうでなければ負け）
		String result = "";
		if (playerGameState.getGuessList().get(playerGameState.getGuessList().size() - 1).getEat() == 3) {
			result = "勝ち";
		} else {
			result = "負け";
		}

		// スコアデータを作成
		DB_SCORE db_score = new DB_SCORE(id, result, playerGameState.getGuessList().size(), user.getId());

		// DAOを使用してスコアデータを挿入し、結果を返す
		return dao.insert(db_score);
	}
}