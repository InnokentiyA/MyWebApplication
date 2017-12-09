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
        <div class="wr">
            <h1>Кабинет пользователя ${user.username}</h1>
            <h2>Профиль</h2>

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
                <div class="center"><input class="button" type="submit" value="Сохранить"></div>
            </form>
        </div>

    </body>
</html>
