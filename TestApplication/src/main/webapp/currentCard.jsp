<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="ru">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Личный кабинет</title>
        <link href="cabinetStyle.css" rel="stylesheet">
        <meta name="viewport" content="width=device-width">
        <script type="text/javascript" src="js/jquery.js" ></script>
    </head>

    <body>
        <div>
            <h1>Кабинет пользователя ${user.username}</h1>
            <h2>Актуальные абонементы</h2>
            <form class="profile" method="post" action="/TestApplication/CurrentCardServlet">
                <div>
                    <span class="title">Тип абонемента</span>
                    <input type="text" name="type" value="${abonement.type}">
                </div>
                <div>
                    <span class="title">Цена</span>
                    <input type="text" name="price" value=${abonement.price}>
                </div>
                <div class="obligatory">
                    <span class="title">Дата начала</span>
                    <input type="text" name="start" value="${abonement.start}">
                </div>
                 <div class="obligatory">
                    <span class="title">Дата окончания</span>
                    <input type="text" name="end" value="${abonement.end}">
                </div>
                
            </form>
        </div>
    </body>
</html>
