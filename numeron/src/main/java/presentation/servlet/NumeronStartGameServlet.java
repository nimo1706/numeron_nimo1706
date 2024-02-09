package presentation.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import business.service.NumeronStartService;
import gamestate.GameState;

// ヌメロンゲームの開始を処理するサーブレット
@WebServlet("/start")
public class NumeronStartGameServlet extends HttpServlet {

	// ゲーム開始処理を提供するサービス
	private NumeronStartService service = new NumeronStartService();

	// GETリクエストを処理するメソッド
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// セッションを取得（存在しなければ新規作成しない）
		HttpSession session = request.getSession(false);

		// セッションがnull、またはセッション内にユーザー情報がない場合
		if (session == null || session.getAttribute("user") == null) {
			// ログイン画面にリダイレクト
			response.sendRedirect(request.getContextPath() + "/login");

		} else {
			// ゲーム開始画面にフォワードする
			String view = "/WEB-INF/view/start.jsp";
			RequestDispatcher dispatcher = request.getRequestDispatcher(view);
			dispatcher.forward(request, response);
		}
	}

	// POSTリクエストを処理するメソッド
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 日本語パラメータの文字コード対応
		request.setCharacterEncoding("UTF-8");

		// セッションを取得
		HttpSession session = request.getSession(false);

		// セッションがnull、またはセッション内にユーザー情報がない場合
		if (session == null || session.getAttribute("user") == null) {
			// ログイン画面にリダイレクト
			response.sendRedirect(request.getContextPath() + "/login");

		} else {
			// リクエストからプレイヤーの選択した数値を取得
			String playerNumber = request.getParameter("number");
			// CPUの数値をランダムに生成
			String cpuNumber = service.generateRandomNumber();

			// ゲームの状態をセッションに設定
			session.setAttribute("playerGameState", new GameState(playerNumber, new ArrayList<>()));
			session.setAttribute("cpuGameState", new GameState(cpuNumber, new ArrayList<>()));

			// ゲーム画面にリダイレクト
			response.sendRedirect(request.getContextPath() + "/game");
		}
	}
}
