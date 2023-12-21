<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>

<!doctype html>
<html lang="ja">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width,initial-scale=1">
<title>Numeron</title>
<link rel="stylesheet" href="<c:url value="/assets/styles.css" />">
</head>
<body>

<div class="game-container">
    <div class="player-panel">
        <h1>ログイン</h1>
        
			<!-- エラーメッセージが存在するときだけ表示する -->
			<%String failureMessage = (String)request.getAttribute("loginFailure"); %>
			<% if (failureMessage != null) {%>
			<%=failureMessage %>
			<%} %>

        <form action="login" method="post">
            <p><label for="username">ユーザー名:</label>
           	<input type="text" id="username" name="username" required></p>
            <p><label for="password">パスワード:</label>
           	<input type="password" id="password" name="password" required></p>
           	<input type="submit" value="ログイン" class="button">
        </form>
        <form action="register" method="get">
            <input type="submit" value="新規登録" class="button">
        </form>
    </div>
</div>

</body>

</html>