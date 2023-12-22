package business.service;

import java.util.List;

import business.dao.ScoreDao;
import dto.DB_SCORE;
import dto.Score;
import dto.User;
import gamestate.GameState;

public class NumeronScoreService {

	private ScoreDao dao = new ScoreDao();

	public List<Score> findAll() {

		return XXXXXXX;
	}

	public int resister(User user, GameState playerGameState) {

		int id = dao.getNextId();

		String result = "";

		if (playerGameState.getGuessList().get(playerGameState.getGuessList().size() - 1).getEat() == 3) {
			result = "勝ち";
		} else {
			result = "負け";
		}

		DB_SCORE db_score = new DB_SCORE(id, result, playerGameState.getGuessList().size(), user.getId());

		return dao.insert(db_score);
	}

}
