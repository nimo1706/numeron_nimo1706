package presentation.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import business.service.NumeronGameService;
import gamestate.GameState;

// ヌメロンゲームに関するサーブレットクラス
@WebServlet("/game")
public class NumeronGameServlet extends HttpServlet {

	// ヌメロンゲームのロジックを提供するサービス
	private NumeronGameService service = new NumeronGameService();

	// GETリクエストを処理するメソッド
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// セッションを取得（存在しない場合はnull）
		HttpSession session = request.getSession(false);

		// セッションがnull、またはセッション内にユーザー情報がない場合
		if (session == null || session.getAttribute("user") == null) {
			// ログイン画面にリダイレクト
			response.sendRedirect(request.getContextPath() + "/login");

		} else {
			// ゲーム画面にフォワードする
			String view = "/WEB-INF/view/game.jsp";
			RequestDispatcher dispatcher = request.getRequestDispatcher(view);
			dispatcher.forward(request, response);
		}
	}

	// POSTリクエストを処理するメソッド
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 日本語の文字コード対応
		request.setCharacterEncoding("UTF-8");

		// セッションを取得
		HttpSession session = request.getSession(false);
		// コンテキストパスを取得
		String view = request.getContextPath();

		// セッションがnull、またはセッション内にユーザー情報がない場合
		if (session == null || session.getAttribute("user") == null) {
			// ログイン画面のパスを設定
			view += "/login";

		} else {
			// ゲームのプレイヤーとCPUの状態をセッションから取得
			GameState playerGameState = (GameState) session.getAttribute("playerGameState");
			GameState cpuGameState = (GameState) session.getAttribute("cpuGameState");

			// リクエストから推測された数値を取得
			String guessNumber = request.getParameter("guessNumber");

			// 推測処理を実行
			service.processGuess(playerGameState, cpuGameState, guessNumber);

			// ゲーム画面のパスを設定
			view += "/game";

		}

		// 設定した画面にリダイレクト
		response.sendRedirect(view);
	}
}
