package presentation.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import business.service.NumeronRegisterService;
import dto.User;

// ヌメロンゲームのユーザー登録を処理するサーブレット
@WebServlet("/register")
public class NumeronRegisterServlet extends HttpServlet {

	// ユーザー登録を提供するサービス
	private NumeronRegisterService service = new NumeronRegisterService();

	// GETリクエストを処理するメソッド
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// ユーザー登録画面にフォワードする
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

		// リクエストからユーザー名とパスワードを取得
		String name = request.getParameter("XXXXXXXXXX");
		String password = request.getParameter("XXXXXXXXXX");

		// サービスクラスのユーザー登録処理を呼び出し
		User user = service.XXXXXXXXXX(XXXXXXXXXX, XXXXXXXXXX);

		// ユーザー登録に成功した場合
		if (user != null) {
			// セッションを新規作成し、ユーザー情報をセッションに設定
			HttpSession session = request.getSession();
			session.setAttribute("XXXXXXXXXX", XXXXXXXXXX);

			// ゲームのスタート画面にリダイレクト
			response.sendRedirect(request.getContextPath() + "/start");

		} else {
			// ユーザー登録に失敗した場合のエラーメッセージを設定
			request.setAttribute("loginFailure", "登録できませんでした。名前が既に登録されているかも。");

			// ユーザー登録画面にフォワード
			String view = "XXXXXXXXXX";
			RequestDispatcher dispatcher = request.getRequestDispatcher(view);
			dispatcher.forward(request, response);
		}
	}
}
