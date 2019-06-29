<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Interviewer</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/general.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/left-navigation-panel.css">
    <script rel="script" type="text/javascript" src="${pageContext.request.contextPath}/js/Interviewer.js"></script>
    <script rel="script" type="text/javascript" src="${pageContext.request.contextPath}/js/Cookies.js"></script>
</head>
<body onload="Interviewer.updateTableValues('/catalog', 'catalog_table', Cookies.getCookie(this, 'user'))">
<input type="checkbox" id="nav-toggle" hidden>
<nav class="nav">
    <label for="nav-toggle" class="nav-toggle" onclick></label>
    <h2 class="logo">
        <a href="">Interviewer</a>
    </h2>
    <ul>
        <li><a href onclick="Interviewer.navigateTo('/catalog', Cookies.getCookie(this, 'user'))">
            Каталог анкет
        </a>
        <li><a href onclick="Interviewer.navigateTo('/questionnaires', Cookies.getCookie(this, 'user'))">
            Мои анкеты
        </a>
        <li><a href onclick="Interviewer.navigateTo('/groups', Cookies.getCookie(this, 'user'))">
            Мои группы
        </a>
        <li><a href onclick="Interviewer.navigateTo('/reports', Cookies.getCookie(this, 'user'))">
            Мои отчеты
        </a>
    </ul>
</nav>
<div class="mask-content"></div>
<main role="main">
    <article>
        <header>
            <h1>Мои отчеты</h1>
        </header>
        <section>
            <table id="catalog_table"></table>
        </section>
        <hr>
        <footer>
            <p><a href="mailto: pickalov.artyom@yandex.ru">Обратная связь</a>
        </footer>
    </article>
</main>
</body>
</html>