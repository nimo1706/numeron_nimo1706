<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>

<%@ page import="gamestate.*"%>
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

	<%
		User user = (User) session.getAttribute("user");
		GameState playerGameState = (GameState) session.getAttribute("playerGameState");
		GameState cpuGameState = (GameState) session.getAttribute("cpuGameState");
	%>
	
    <div class="game-container">
        <!-- 左のプレイヤーパネル -->
        <div class="player-panel">
            <div class="number"><%=playerGameState.getCorrectNumber() %></div>
            <table class="guesses">
                <tr>
                    <th><%=user.getName() %>の推理</th>
                    <th>EAT</th>
                    <th>BITE</th>
                </tr>
                <%if(!playerGameState.getGuessList().isEmpty()){
                 		for (Guess guess : playerGameState.getGuessList()) { %>
	                    <tr> 
	                        <td><%= guess.getValue() %></td>
	                        <td><%= guess.getEat() %></td>
	                         <td><%= guess.getBite() %></td>
	                    </tr>
                	<%}
                 	}%>
            </table>
        </div>

        <!-- 右のプレイヤーパネル -->
        <div class="player-panel">
            <div class="number">???</div>
            <table class="guesses">
                <tr>
                    <th>CPUの推理</th>
                    <th>EAT</th>
                    <th>BITE</th>
                </tr>
                <%if(!cpuGameState.getGuessList().isEmpty()){
                 		for (Guess guess : cpuGameState.getGuessList()) { %>
	                    <tr> 
	                        <td><%= guess.getValue() %></td>
	                        <td><%= guess.getEat() %></td>
	                         <td><%= guess.getBite() %></td>
	                    </tr>
                	<%}
                 	}%>
            </table>
        </div>
    </div>


	<%if((playerGameState.getGuessList().isEmpty() || cpuGameState.getGuessList().isEmpty()) 
			|| (playerGameState.getGuessList().get(playerGameState.getGuessList().size()-1).getEat() != 3 
			&& cpuGameState.getGuessList().get(cpuGameState.getGuessList().size()-1).getEat() != 3)) {%>

	    <!-- 推測入力フォーム -->
	    <form action="game" method="post">
	        <input type="text" name="guessNumber" required pattern="^(?!.*(.).*\1)[0-9]{3}$" title="3桁の被らない半角数字">
	        <input type="submit" value="Guess" class="button">
	    </form>
    
    <%} else { %>
		<%if(!playerGameState.getGuessList().isEmpty() && playerGameState.getGuessList().get(playerGameState.getGuessList().size()-1).getEat() == 3) {%>
			<%=user.getName()%>さんの勝利！！！おめでとう！
		<%} else {%>
			CPUの勝利！またチャレンジしてね。
		<%} %>
		    <form action="start" method="get">
		        <input type="submit" value="再ゲーム" class="button">
		    </form>
   		    <form action="logout" method="get">
		        <input type="submit" value="ログアウト" class="button">
		    </form>
	<%} %>
</body>

</html>