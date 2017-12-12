<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="ru">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Личный кабинет</title>
        <link rel="stylesheet" type="text/css" href="cabinetStyle.css" />
        <meta name="viewport" content="width=device-width">
        <script type="text/javascript" src="js/jquery.js" ></script>

        <style type="text/css">
            TABLE {
                width: 300px; /* Ширина таблицы */
                margin: 10px 0;
                border: 1px solid black; /* Рамка вокруг таблицы */
            }
            TD, TH {
                text-align: center; /* Выравнивание по центру */
                padding: 3px; /* Поля вокруг текста */
            }
            TH {
                color: white; /* Цвет текста */
                background: #97a7b0;  /* Цвет фона */
            }
            TD {
                border-left: 1px dashed black; /* Линия слева от ячейки */
            }
            .even { /* Стиль для четных колонок */
                background: #dcdcdc;  /* Цвет фона */
            } 
            .lc { /* Стиль для первой колонки */
                text-align: left; /* Выравнивание по левому краю */
                border: none; /* Нет лишних линий */
            }

            LABEL{
                padding: 10px 20px;
                font: 18px Verdana, Helvetica, sans-serif
            }
            .profile{
                margin: 10px;
            }
            select {
                width: 170px;

            }

        </style>
    </head>

    <body style="
          margin: 0 auto;
          width: 70%;">
        <div class="wr">
            <h1>Кабинет пользователя ${user.username}</h1>
            <h2>Заказ абонемента</h2>

            <form class="profile" method="post" action="/TestApplication/OrderCardServlet">
                <label>Выбирите тип абонемента: </label>

                <p><select name="abonementType"  size="4">
                        <option disabled>Выберите из списка</option>
                        <option value="single" selected="selected">Одноразовый</option>
                        <option value="monthly">Месячный</option>
                        <option value="gold">Годовой</option>
                    </select>
                </p> 

                <label>Выбирите список услуг: </label>


                <table>
                    <tr>
                        <th class="lc">&nbsp;</th><th class="lc">Услуга</th><th>Цена за день</th><th>Цена за месяц</th><th>Цена за год</th>
                    </tr>
                    <c:forEach items="${services}" var="service" >
                        <tr>
                            <td class="lc">  <input type="checkbox" id="${service.id}" value="${service.id}" name="services"/> </td>
                            <td class="lc">${service.name}</td>
                            <td class="even">${service.priceSingle}</td>
                            <td class="even">${service.priceMonth}</td>
                            <td class="even">${service.priceGold}</td>
                        </tr>
                    </c:forEach>
                </table>

                <div class="center" style="
                         margin: 20px;
                         "><input class="button" type="submit" value="Заказать" style="
                                           font: 24px Arial;
                                           padding: 10px;
                                           "></div>
            </form>




        </div>
    </body>
</html>
