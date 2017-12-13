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
                        "><a style="
                         display: block;
                         line-height: 45px;
                         padding: 0 10px;
                         color: whitesmoke;
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


            <form class="profile" method="post" action="/TestApplication/CabinetServlet">
                <div>
                    <span class="title">Фамилия</span>
                    <input type="text" name="surname" value="${user.surname}">
                </div>
                <div>
                    <span class="title">Имя</span>
                    <input type="text" name="name" value=${user.name}>
                </div>
                <div class="obligatory">
                    <span class="title">E-mail</span>
                    <input type="text" name="email" value="${user.email}">
                </div>
                <div>
                    <span class="title"> Контактный телефон</span>
                    <div class="phone-masterpass">Укажите телефон, если планируете использовать <a href="https://masterpass.com/#ru-ru" target="_blank">Masterpass</a> при оплате <span class="tooltip" data-tooltip="Masterpass - электронный кошелек от Mastercard">
                            <img src="images/question.png">
                        </span>
                    </div>
                    <input type="text" name="phone" value=${user.phone}>
                    <div class="prompt">Формат: +код страны код оператора телефон<br>Пример: +380 44 591 19 88</div></div><div class="passwd">
                    <span class="title">Новый пароль</span><input type="password" name="passwd_new" value="">
                    <label class="passwd-check"><input type="checkbox">Посмотреть пароль</label>
                </div>
                <div class="passwd">
                    <span class="title">Текущий пароль</span>
                    <input type="password" name="passwd" value="">
                    <label class="passwd-check"><input type="checkbox">Посмотреть пароль</label>
                    <div class="prompt">Введите текущий пароль для подтверждения изменения пароля
                    </div>

                </div> 
                <div class="center" style="
                     margin: 20px;
                     "><input class="button" type="submit" value="Сохранить" style="
                         font: 24px Arial;
                         padding: 10px;
                         "></div>
            </form>
        </div>

    </body>
</html>
