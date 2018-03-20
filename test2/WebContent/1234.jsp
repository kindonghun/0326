<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width", initial-scale="1">
		<title>BootStrap</title>
		<link rel="stylesheet" href="css/bootstrap.css">
		<link rel="stylesheet" href="css/codingBooster.css">
	</head>
	<body>
	<% //현재 세션이 존재할경우 아이디값을 받아서 넣어준다.
	String userID = null;
	if(session.getAttribute("userID")!=null){
		userID =(String)session.getAttribute("userID");
	}
	System.out.println("main userid:"+userID);
%>
		<style type="text/css">
		.jumbotron{
			background-image: url('images/2.jpg');
			background-size: cover;
			text-shadow: black 0.2em 0.2em 0.2em;
			color: white;
		}
			</style>
			<nav class="navbar navbar-default">
				<div class="container-fluid">
					<div class="navbar-header">
						<button type="button" class="navbar-toggle collapsed" data-toggle="collapse"
						data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
						<span class="sr-only"></span>
						<span class="icon-bar"></span>
						<span class="icon-bar"></span>
						<span class="icon-bar"></span>
					</button>
					<a class="navbar-brand" href="#">Black Hole</a>
				</div>
				<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
					<ul class="nav navbar-nav">
						<li class="active"><a href="#">소개<span class="sr-only"></span></a></li>
						<li><a href="#">공지사항</a></li>
						<li class="dropdown">
							<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button"
								aria-haspopup="true" aria-expanded="false">제품분류<span class="caret"></span></a>
							<ul class="dropdown-menu">
								<li><a href="#">식물</a></li>
								<li><a href="#">마스크</a></li>
								<li><a href="#">공기청정기</a></li>
							</ul>
						</li>
					</ul>
					<form class="navbar-form navbar-left">
						<div class="form-group">
							<input type="text" class="from-control" placeholder="내용을입력하세요.">
						</div>
						<button type="submit" class="btn btn-default">검색</button>
					</form>
					<%
				if(userID==null){
			
				%>
					<ul class="nav navbar-nav navbar-right">
						<li class="dropdown">
							<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button"
								aria-haspopup="true" aria-expanded="false">접속하기<span class="caret"></span></a>
							<ul class="dropdown-menu">
								<li><a href="#">로그인</a></li>
								<li><a href="#">회원가입</a></li>
							</ul>
						</li>
					</ul>
					<%
				}else{
					%>
					<ul class="nav navbar-nav navbar-right">
				<li class="dropdown">
				<a href="#" class="dropdown-toggle"
					data-toggle="dropdown" role="button" aria-haspopup="true"
					aria-expanded="faise">회원관리<span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href="logoutAction.jsp">로그아웃</a></li>
					</ul>
				<li>
			</ul>
			<%
				}
			%>
			
				</div>
			</div>
		</nav>
		<div class="container">
			<div class="jumbotron">
				<h1 class="text-center">BootStrap 사이트를 소개합니다.</h1>
				<p class="text-center"> BootStrap는 it 교육 사이트입니다. 다양한 it 관련 무료 및 유료 강의가 존재합니다</p>
				<p class="text-center"><a class="btn btn-primary btn-lg" href="#" role="button">제품알아보기</a></p>
			</div>
			<div class="row"> <!-- 하나의줄에는 12만큼의 줄이있는데 col-md-4 는 3분의1만큼 차지함 -->
				<div class="col-md-4">
					<h4>특징</h4>
					<p>다른사이트와 차원이다른 깔끔한 구성을 보여줍니다. 모든페이지가 사용자가 접근하고 읽기쉽도록 정교하게 구성되어있습니다.</p>
					<p><a class="btn btn-default" data-target="#modal">자세히알아보기</a></p>
			</div>
			<div class="row"> <!-- 하나의줄에는 12만큼의 줄이있는데 col-md-4 는 3분의1만큼 차지함 -->
				<div class="col-md-4">
					<h4>제품</h4>
					<p>다른사이트와 차원이다른 깔끔한 구성을 보여줍니다. 모든페이지가 사용자가 접근하고 읽기쉽도록 정교하게 구성되어있습니다.</p>
					<p><a class="btn btn-default" data-target="#modal">제품보러가기</a></p>
			</div>
			<div class="row"> <!-- 하나의줄에는 12만큼의 줄이있는데 col-md-4 는 3분의1만큼 차지함 -->
				<div class="col-md-4" >
					<h4 style="text-align: center">이벤트</h4>
					<p>다른사이트와 차원이다른 깔끔한 구성을 보여줍니다. 모든페이지가 사용자가 접근하고 읽기쉽도록 정교하게 구성되어있습니다.</p>
					<p><a class="btn btn-default" data-target="#modal">이벤트보러가기</a></p>
			</div>
		</div>
		<footer style="background-color:#000000; color: #ffffff">
			<div class="container">
				<br>
				<div class="row">
					<div class="col-sm-2" style="text-align: center;"><h5>Copyright &copy; 2018</h5><h5>김동훈(DongHun Kim)</h5></div>
					<div class="col-sm-4"><h4">대표자 소개</h4><p>저는 BootStrap 대표 A입니다 부트스트랩 으로 만든 홈페이지입니다.</p></div>
					<div class="col-sm-2"><h4 style="text-align: center;">네비게이션</h4>
						<div class="list-group">
							<a href="#" class="list-group-item">소개</a>
							<a href="#" class="list-group-item">공지사항</a>
							<a href="#" class="list-group-item">제품분류</a>
						</div>
					</div>
					<div class="col-sm-2"><h4 style="text-align: center;">SNS </h4>
						<div class="list-group">
							<a href="#" class="list-group-item">페이스북</a>
							<a href="#" class="list-group-item">유튜브</a>
							<a href="#" class="list-group-item">네이버TV</a>
						</div>
					</div>
					<div class="col-sm-2"><h4 style="text-align: center;"><span class="glyphicon glyphicon-ok"></span>&nbsp; by 김동훈</h4></div>
				</div>
			</div>
		</footer>
		<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
		<script src="js/bootstrap.js"></script>
	</body>
</html>