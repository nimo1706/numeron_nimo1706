package presentation.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

// ヌメロンゲームのログアウトを処理するサーブレット
@WebServlet("/logout")
public class NumeronLogoutServlet extends HttpServlet {

	// GETリクエストを処理するメソッド
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// セッションを取得（存在しなければ新規作成しない）
		HttpSession session = request.getSession(false);
		// セッションが存在すれば破棄する
		if (session != null) {
			session.invalidate();
		}

		// ログイン画面にリダイレクト
		response.sendRedirect(request.getContextPath() + "/login");
	}
}
