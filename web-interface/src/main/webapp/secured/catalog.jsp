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
<body onload="Interviewer.updateDataSectionValues('/catalog', Cookies.getCookie(this, 'user'))">
<input type="checkbox" id="nav-toggle" hidden>
<nav class="nav">
    <label for="nav-toggle" class="nav-toggle" onclick></label>
    <h2 class="logo">
        <a href="">Interviewer</a>
    </h2>
    <ul>
        <li><a href="${pageContext.request.contextPath}/secured/catalog.jsp">
            Каталог анкет
        </a>
        <li><a href="${pageContext.request.contextPath}/secured/my_questionnaires.jsp">
            Мои анкеты
        </a>
        <li><a href="${pageContext.request.contextPath}/secured/my_groups.jsp">
            Мои группы
        </a>
        <li><a href="${pageContext.request.contextPath}/secured/my_reports.jsp">
            Мои отчеты
        </a>
    </ul>
</nav>
<div class="mask-content"></div>
<main role="main">
    <article>
        <header>
            <h1>Каталог анкет</h1>
        </header>
        <section id="data_section">
            <p>Здесь пока ничего нет</p>
        </section>
        <hr>
        <footer>
            <p><a href="mailto: pickalov.artyom@yandex.ru">Обратная связь</a>
        </footer>
    </article>
</main>
</body>
</html>