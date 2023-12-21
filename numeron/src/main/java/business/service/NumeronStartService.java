package business.service;

import java.util.Random;

// ヌメロンゲームの開始時に使用するサービスクラス
public class NumeronStartService {

	// ランダムな3桁の数値を生成するメソッド
	public String generateRandomNumber() {
		// Random オブジェクトのインスタンス化
		Random rand = new Random();
		String number;
		// 重複する桁がない3桁の数値が生成されるまで繰り返す
		do {
			// 3つのランダムな数字を結合して数値を生成
			number = String.valueOf(rand.nextInt(10)) +
					String.valueOf(rand.nextInt(10)) +
					String.valueOf(rand.nextInt(10));
		} while (hasDuplicateDigits(number)); // 生成された数値に重複する桁がないかチェック
		return number; // 生成された数値を返す
	}

	// 数値内に重複する桁があるかどうかを判定するプライベートメソッド
	private boolean hasDuplicateDigits(String number) {
		// すべての桁の組み合わせをチェック
		for (int i = 0; i < number.length(); i++) {
			for (int j = i + 1; j < number.length(); j++) {
				// 桁が重複しているかチェック
				if (number.charAt(i) == number.charAt(j)) {
					return true; // 重複が見つかった場合はtrueを返す
				}
			}
		}
		return false; // 重複がない場合はfalseを返す
	}
}
