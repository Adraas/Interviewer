﻿<html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="css/general.css" type="text/css">
    <link rel="stylesheet" href="css/entrance.css" type="text/css"/>
    <script rel="script" type="text/javascript" src="js/Entrance.js"></script>
    <script rel="script" type="text/javascript" src="js/Cookies.js"></script>
    <title>Авторизация</title>
</head>
<body>
<div class="form-wrap">
    <div class="profile"><img src="fonts/minimal-poster-design-avatar.png" alt="Minimal poster design avatar">
        <h1>Авторизация</h1>
    </div>
    <form>
        <p>
        <div>
            <label for="login">Логин</label>
            <input id="login" type="text" required>
        </div>
        <p>
        <div>
            <label for="password">Пароль</label>
            <input id="password" type="password" required>
        </div>
        <button onclick="Entrance.signIn('login', 'password')">Вход</button>
        <p align="center"><a href="sign_up.jsp">Регистрация</a>
        </p>
    </form>
</div>
</body>
</html>