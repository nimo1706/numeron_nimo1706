package presentation.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import business.service.NumeronScoreService;
import dto.Score;
import dto.User;
import gamestate.GameState;

// ヌメロンゲームのスコア画面を処理するサーブレット
@WebServlet("/score")
public class NumeronScoreServlet extends HttpServlet {

	// スコア処理を提供するサービス
	private NumeronScoreService service = new NumeronScoreService();

	// GETリクエストを処理するメソッド
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 全スコアデータを取得し、リクエスト属性に設定
		List<Score> list = service.findAll();
		request.setAttribute("scoreList",list );

		// スコア画面にフォワードする
		String view = "WEB-INF/view/score.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(view);
		dispatcher.forward(request, response);
	}

	// POSTリクエストを処理するメソッド
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 日本語の文字コード対応
		request.setCharacterEncoding("UTF-8");

		// セッションを取得
		HttpSession session = request.getSession(false);

		// スコア登録処理を呼び出し
		service.resister((User)session.getAttribute("user"), (GameState)session.getAttribute("playerGameState"));
		
		// GETメソッドを再利用してスコア画面を表示
		doGet(request, response);
	}
}