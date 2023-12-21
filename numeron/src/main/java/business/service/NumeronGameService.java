package business.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import gamestate.GameState;
import gamestate.Guess;

// 数値推測ゲームのロジックを扱うサービスクラス
public class NumeronGameService {

	// プレイヤーとCPUの推測を処理するメソッド
	public void processGuess(GameState playerGameState, GameState cpuGameState, String guessNumber) {
		// プレイヤーの推測結果をチェックし、結果をリストに追加
		Guess playerGuessResult = checkNumber(cpuGameState.getCorrectNumber(), guessNumber);
		playerGameState.getGuessList().add(playerGuessResult);

		// CPUの推測結果をチェックし、結果をリストに追加
		Guess cpuGuessResult = cpuCheckNumber(playerGameState, cpuGameState);
		cpuGameState.getGuessList().add(cpuGuessResult);
	}

	// 指定された数字が正解と一致するかどうかをチェックするプライベートメソッド
	private Guess checkNumber(String correctNumber, String GuessNumber) {
		// 正解数（"eat"）と部分一致数（"bite"）を初期化
		int eat = 0;
		int bite = 0;

		// 各桁を検証して、正解数と部分一致数を計算
		for (int i = 0; i < 3; i++) {
			char c = GuessNumber.charAt(i);
			if (correctNumber.charAt(i) == c) {
				eat++;
			} else if (correctNumber.contains(String.valueOf(c))) {
				bite++;
			}
		}

		// 推測とその結果を含むGuessオブジェクトを返す
		return new Guess(GuessNumber, eat, bite);
	}

	// CPUがプレイヤーの数値を推測するメソッド
	private Guess cpuCheckNumber(GameState playerGameState, GameState cpuGameState) {
		// すべての可能な数値組み合わせを生成
		List<String> possibleCombinations = generateAllCombinations();

		// これまでのCPUの推測を用いて可能な組み合わせを絞り込む
		for (Guess guess : cpuGameState.getGuessList()) {
			filterCombinations(possibleCombinations, guess.getValue(), guess.getEat(), guess.getBite());
		}

		// CPUが次に行う推測を行い、その結果を返す
		return checkNumber(playerGameState.getCorrectNumber(), cpuCall(possibleCombinations));
	}

	// CPUの推測を決定するメソッド
	private String cpuCall(List<String> possibleCombinations) {
		// ランダムなインデックスで組み合わせを選択
		Random rand = new Random();
		return possibleCombinations.get(rand.nextInt(possibleCombinations.size()));
	}

	// 有効な組み合わせを絞り込むメソッド
	private void filterCombinations(List<String> possibleCombinations, String guess, int eat, int bite) {
		// 条件に一致しない組み合わせをリストから削除
		possibleCombinations.removeIf(combination -> !isValidCombination(combination, guess, eat, bite));
	}

	// 指定された組み合わせが有効かどうかを判断するメソッド
	private boolean isValidCombination(String combination, String guess, int eat, int bite) {
		// 正解数と部分一致数を計算
		int countEat = 0;
		int countBite = 0;

		for (int i = 0; i < 3; i++) {
			char c = guess.charAt(i);
			if (combination.charAt(i) == c) {
				countEat++;
			} else if (combination.contains(String.valueOf(c))) {
				countBite++;
			}
		}

		// 計算した結果が指定された条件と一致すればtrueを返す
		return countEat == eat && countBite == bite;
	}

	// 数字に重複があるかどうかをチェックするメソッド
	private boolean hasDuplicateDigits(String number) {
		// すべての桁の組み合わせをチェック
		for (int i = 0; i < number.length(); i++) {
			for (int j = i + 1; j < number.length(); j++) {
				if (number.charAt(i) == number.charAt(j)) {
					return true;
				}
			}
		}
		return false;
	}

	// すべての可能な3桁の組み合わせを生成するメソッド
	private List<String> generateAllCombinations() {
		// 組み合わせを保存するリストを初期化
		List<String> combinations = new ArrayList<>();
		for (int i = 0; i < 1000; i++) {
			// 3桁の数値を文字列としてフォーマット
			String combination = String.format("%03d", i);
			// 重複する数字がなければリストに追加
			if (!hasDuplicateDigits(combination)) {
				combinations.add(combination);
			}
		}
		return combinations;
	}

}
