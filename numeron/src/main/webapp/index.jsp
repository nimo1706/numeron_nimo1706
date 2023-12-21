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
	<div class="game-container">
		<div class="player-panel">
			<h1>Numeron</h1>
			
			<p>Numeronを始めよう！</p>
			<p>ルール</p>
			<p>それぞれのプレイヤーが、0-9までの数字が書かれた10枚のカードのうち3枚を使って、3桁の番号を作成する。カードに重複は無いので「550」「377」「999」といった同じ数字を2つ以上使用した番号は作れない。<br>
				先攻のプレイヤーは相手の番号を推理してコールする。相手はコールされた番号と自分の番号を見比べ、コールされた番号がどの程度合っているかを発表する。<br>
				数字と桁が合っていた場合は「EAT」（イート）、数字は合っているが桁は合っていない場合は「BITE」（バイト）となる。<br>
				例として相手の番号が「765」・コールされた番号が「746」であった場合は、3桁のうち「7」は桁の位置が合致しているためEAT、「6」は数字自体は合っているが桁の位置が違うためBITE。EATが1つ・BITEが1つなので、「1EAT-1BITE」となる。<br>
				これを先攻・後攻が繰り返して行い、先に相手の番号を完全に当てきった（3桁なら3EATを相手に発表させた）プレイヤーの勝利となる。</p>

			<form action="login" method="get">
				<input type="submit" value="ログインしてゲーム開始" class="button">
			</form>
		</div>
	</div>

</body>

</html>