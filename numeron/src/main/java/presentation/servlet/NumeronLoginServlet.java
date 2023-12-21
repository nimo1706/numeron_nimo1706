package presentation.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import business.service.NumeronLoginService;
import dto.User;

// ヌメロンゲームのログイン処理を行うサーブレット
@WebServlet("/login")
public class NumeronLoginServlet extends HttpServlet {

	// ログイン処理を提供するサービス
	private NumeronLoginService service = new NumeronLoginService();

	// GETリクエストを処理するメソッド
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// ログイン画面にフォワードする
		String view = "XXXXXXXXXX";
		RequestDispatcher dispatcher = request.getRequestDispatcher(view);
		dispatcher.forward(request, response);
	}

	// POSTリクエストを処理するメソッド
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 日本語パラメータの文字コード対応
		request.setCharacterEncoding("UTF-8");

		// セッションを取得（存在しなければ新規作成しない）
		HttpSession session = request.getSession(false);

		// 既存のセッションがあれば破棄する
		if (session != null) {
			session.invalidate();
		}

		// リクエストからユーザー名とパスワードを取得
		String name = request.getParameter("XXXXXXXXXX");
		String password = request.getParameter("XXXXXXXXXX");

		// サービスクラスのログイン処理を呼び出し、ユーザー情報を取得
		User user = service.XXXXXXXXXX(XXXXXXXXXX, XXXXXXXXXX);

		// ログインに成功した場合
		if (user != null) {
			// 新しいセッションを作成し、ユーザー情報をセッションに設定
			session = request.getSession(true);
			session.setAttribute("XXXXXXXXXX", XXXXXXXXXX);

			// スタート画面にリダイレクト
			response.sendRedirect(request.getContextPath() + "/start");
		} else {
			// ログイン失敗時のエラーメッセージをリクエストスコープに設定
			request.setAttribute("loginFailure", "ログインできませんでした。");

			// ログイン画面にフォワード
			String view = "XXXXXXXXXX";
			RequestDispatcher dispatcher = request.getRequestDispatcher(view);
			dispatcher.forward(request, response);
		}
	}
}
