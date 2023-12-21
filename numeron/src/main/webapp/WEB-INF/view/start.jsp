<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>

<%@ page import="dto.*"%>

<!doctype html>
<html lang="ja">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width,initial-scale=1">
<title>Numeron</title>
<link rel="stylesheet" href="<c:url value="/assets/styles.css" />">
</head>
<body>

	<%
		User user = (User) session.getAttribute("user");
	%>

	<div class="game-container">
		<div class="player-panel">
			<h1>Numeron</h1>
			
			<p><%=user.getName() %>さん　ようこそ！</p>
			<p>ゲームを始めるには自分の数字を3桁入力し、下のボタンをクリックしてください。</p>

			<form action="start" method="post">
				<input type="text" name="number" required pattern="^(?!.*(.).*\1)[0-9]{3}$" title="3桁の被らない半角数字">
				<input type="submit" value="ゲーム開始" class="button">
			</form>
		</div>
	</div>

</body>

</html>