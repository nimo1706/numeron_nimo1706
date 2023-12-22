<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>

<%@ page import="dto.*"%>
<%@ page import="java.util.List"%>

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
			<h1>Numeron</h1>

			<p>SCORE</p>
			<%
				List<Score> scoreList = (List<Score>) request.getAttribute("scoreList");
			%>

			<table class="guesses">
				<tr>
					<th>ユーザー名</th>
					<th>勝敗</th>
					<th>ターン数</th>
				</tr>
				<%if(scoreList != null){
                 		for (Score score : scoreList) { %>
				<tr>
					<td><%= score.getName() %></td>
					<td><%= score.getResult() %></td>
					<td><%= score.getTurn() %></td>
				</tr>
				<%}
                 	}%>
			</table>
			
		    <form action="start" method="get">
		        <input type="submit" value="再ゲーム" class="button">
		    </form>
   		    <form action="logout" method="get">
		        <input type="submit" value="ログアウト" class="button">
		    </form>
		    
		</div>
	</div>

</body>

</html>