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

    <body style="
          margin: 0 auto;
          width: 80%;">
        <div class="wr">
            <h1>Кабинет пользователя ${user.username}</h1>
            <div id="menu" style="
                 height: 45px;
                 background-color: #97a7b0;
                 width: 100%;

                 ">
                <ul>
                    <li style="
                        float: left;
                        list-style-type: none;
                        position: relative;
                        margin-left: 10px;
                        margin-right: 10px; 
                        height: 100%;
                        "><a href="/TestApplication/CabinetServlet" style="
                         display: block;
                         line-height: 45px;
                         padding: 0 10px;
                         color: white;
                         text-decoration: none;
                         text-align: center;
                         font-size: 1.5em;
                         background: #97a7b0;
                         font-family: 'Arial' ;
                         font-weight: bold;
                         ">Профиль</a></li>
                    <li style="
                        float: left;

                        list-style-type: none;
                        position: relative;
                        margin-left: 10px;
                        margin-right: 10px; 
                        height: 100%;
                        "><a style="
                         display: block;
                         line-height: 45px;
                         padding: 0 10px;

                         color: whitesmoke;
                         text-decoration: none;
                         text-align: center;
                         font-size: 1.5em;
                         background: #97a7b0;
                         /*2.5em*/
                         font-family: 'Arial' ;
                         font-weight: bold;
                         ">Актуальные абонементы</a></li>
                    <li style="
                        list-style-type: none;
                        float: left;
                        position: relative;
                        margin-left: 10px;
                        margin-right: 10px; 
                        height: 100%;
                        "><a href="/TestApplication/OrderCardServlet" style="
                         display: block;
                         line-height: 45px;
                         padding: 0 10px;
                         color: white;
                         text-decoration: none;
                         text-align: center;
                         font-size: 1.5em;
                         background: #97a7b0;
                         /*2.5em*/
                         font-family: 'Arial' ;
                         font-weight: bold;
                         ">Заказать абонемент</a></li>
                    <li style="
                        float: left;
                        list-style-type: none;
                        position: relative;
                        margin-left: 10px;
                        margin-right: 10px; 
                        height: 100%;
                        "><a href="/TestApplication/CurrentCardServlet" style="
                         display: block;
                         line-height: 45px;
                         padding: 0 10px;
                         color: white;

                         text-decoration: none;
                         text-align: center;
                         font-size: 1.5em;
                         background: #97a7b0;
                         /*2.5em*/
                         font-family: 'Arial' ;
                         font-weight: bold;
                         ">История заказов</a></li>
                </ul>
            </div>

            <form class="profile" method="post" action="/TestApplication/CurrentCardServlet">
                <div>
                    <span class="title">Тип абонемента</span>
                    <input type="text" name="type" value="${abonement.type}" readonly>
                </div>
                <div>
                    <span class="title">Цена</span>
                    <input type="text" name="price" value=${abonement.price} readonly>
                </div>
                <div class="obligatory">
                    <span class="title">Дата начала</span>
                    <input type="text" name="start" value="${abonement.start}" readonly>
                </div>
                <div class="obligatory">
                    <span class="title">Дата окончания</span>
                    <input type="text" name="end" value="${abonement.end}" readonly>
                </div>
                <div class="obligatory">
                    <span class="title">Доступные услуги</span>
                    <input type="text" name="end" value="Массаж, басейн" readonly>
                </div>

            </form>
        </div>
    </body>
</html>
