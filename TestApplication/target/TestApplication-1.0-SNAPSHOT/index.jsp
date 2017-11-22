<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="ru">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Спортивный клуб SportGO</title>
        <link href="style.css" rel="stylesheet">
        <link rel="stylesheet" href="style1.css">
        <link rel="stylesheet" type="text/css" href="css/demo.css" />
        <link rel="stylesheet" type="text/css" href="css/loginStyle.css" />
        <link rel="stylesheet" type="text/css" href="css/animate-custom.css" />
        <meta name="viewport" content="width=device-width">
        <link href="responsive.css" rel="stylesheet">
        <script type="text/javascript" src="js/jquery.js" ></script>
    </head>

    <body>
    <header>
        <center>
            <div id="divId" 
                 style="position: absolute;
                 width: 500px; height: 400px; top: 300px;" >
                <%@include file="loginForm.jsp" %>

            </div>
            
        </center>   

        <nav class="menu">
            <div class="logo">
                <img src="Photo/logo.png" alt="logo">
            </div>
            <div class="hamb">
                <span></span>
                <span></span>
                <span></span>
            </div>
            <ul id="navbar">

                <li><a href="#">главная</a></li>
                <li><a href="#">о клубе</a>
                    <ul class="club">
                        <li><a href="#">История компании</a></li>
                        <li><a href="#">Наш персонал</a></li>
                        <li><a href="#">Наши партнеры</a></li>
                    </ul>
                </li>
                <li><a href="#">услуги</a></li>
                <li><a href="#">контакты</a></li>
            </ul>
            <div id="enter" style="  
                 width: 150px; 
                 height: 50px;  
                 position: fixed; 
                 top:10px; 
                 right:10px;"> <button id="loginButton" type="button">Войти</button> </div>
            <div id="out" style=" 
                 display: none;
                 width: 150px; 
                 height: 50px;  
                 position: fixed; 
                 top:10px; 
                 right:10px;"> <button id="unloginButton" type="button">Выйти</button>
                <span id="userName"></span>
            </div>
        </nav>
    </header>


    <div class="content-wrapper">
        <div class="main-information">
            <div class="info">
                <h1>Спортивный клуб SportGO </h1>
                <p>- территория, где совершенствуется тело, восстанавливаюся силы и создается настроение. Вы приходите в любой фитнес-клуб «SportGO», и на рецепции показываете флаер, который получите на свой электронный ящик. </p>

            </div>
            <div class="our-gym">
                <img src="Photo/ourGym1.jpg" alt="ourgym">
            </div>
        </div>


        <h2>Спортивные услуги</h2>
        <div class="sports-Services">
            <div class="firstRow">
                <div class="fr1">
                    <figure>
                        <div><img src="Photo/sportGym1.jpg" alt="gym"></div>
                        <figcaption>Тренажерный зал</figcaption>
                    </figure>
                </div>
                <div class="fr2">
                    <figure>
                        <div><img src="Photo/swimmingPool1.jpg" alt="pool"></div>
                        <figcaption>Бассейн</figcaption>
                    </figure>
                </div >
                <div class="fr3">
                    <figure>
                        <div><img src="Photo/fitball1.jpg" alt="fitball"></div>
                        <figcaption>Фитбол</figcaption>
                    </figure>
                </div >
            </div>
            <div class="secondRow">
                <div class="sr1">
                    <figure >
                        <div><img src="Photo/tennisCourt1.jpg" alt="tennis"></div>
                        <figcaption>Теннисный корт</figcaption>
                    </figure>
                </div>
                <div class="sr2">
                    <figure>
                        <div><img src="Photo/SPA1.jpg" alt="SPA"></div>
                        <figcaption>SPA</figcaption>
                    </figure>
                </div>
                <div class="sr3">
                    <figure>
                        <div><img src="Photo/childrensFitness1.jpg" alt="childfitness"></div>
                        <figcaption>Детский фитнес</figcaption>
                    </figure>
                </div>
            </div>
        </div>

        <h2>Тренажерный зал "SportGO" это: </h2>
        <div class="main-Features">

            <div class="feature1">
                <h4>Большие площади</h4>
                <img src="Photo/home.jpg" alt="sign1">
                <p>Чем больше пространства для занятий - тем лучше. Мы стараемся предоставить нашим клиентам как можно больше свободного места для тренировок.</p>
            </div>
            <div class="feature2">
                <h4>Новые тренажеры</h4>
                <img src="Photo/star.jpg" alt="sign2">
                <p>Мы постепенно обновляем парк наших машин на самую современную линию силовых тренажеров от американской компании "Sport Arts".</p>
            </div>
            <div class="feature3">
                <h4>Здоровая атмосфера</h4>
                <img src="Photo/home.jpg" alt="sign3">
                <p>Хорошее освещение, мягкое покрытие, большие зеркала, постоянное кондиционирование - вот к чему мы стремимся в обустройстве залов</p>
            </div>
        </div>

    </div>

    <footer>
        <div class="contacts-map">
            <div class="map">
                <h3>SportGO на карте: </h3>
                <iframe src="https://www.google.com/maps/embed?pb=!1m16!1m12!1m3!1d5087.912571402193!2d30.455789720733847!3d50.386013443774885!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!2m1!1z0LLRg9C7INCc0LDRgNGI0LDQu9CwINCa0L7QvdC10LLQsCA4!5e0!3m2!1sru!2sua!4v1478560339813" width="350" height="200" frameborder="0" style="border:0" allowfullscreen></iframe>
            </div>
            <div class="contact">
                <h3>Контакты:</h3>

                <p>ЦЕНТРАЛЬНЫЙ ОФИС ГРУППЫ <br>
                    КОМПАНИЙ SportGO</p>
                <p>03191, г. Киев, ул. Маршала Конева, 8. </p>
                <p>тел.: (044) 585-24-00</p>
                <p>e-mail: office@gosportclub.com</p>

            </div>
        </div>

        <div class="copyright">
            <div>
                <p>© 2016 gosportclub.com.ua. Все права защищены.</p>
            </div>
            <div class="sotialNetwork">
                <a href="http://www.facebook.com"><img src="Photo/facebook.png" alt="bacebook"></a>
                <a href="http://vk.com/"><img src="Photo/vk.png" alt="vk"></a>
                <a href="http://twitter.com/"><img src="Photo/twitter.png" alt="twitter"></a>
            </div>
        </div>
    </footer>




    <script>
        $(document).on("click", "#secondLogin", function () { // When HTML DOM "click" event is invoked on element with ID "somebutton", execute the following function...
            var username = $("#username").val();
            var password = $("#password").val();
            if(username == ""){
                    $('#messageDiv').text("display","none");
                    alert("Username is required");
                    return;
                }
                if(password == ""){
                    $('#messageDiv').css("display","none");
                    alert("Password is required");
                    return;
                }
            $.get("LoginServlet?username=" + username + "&password=" + password, function (responseText) {   // Execute Ajax GET request on URL of "someservlet" and execute the following function with Ajax response text...
                alert(responseText);
                if ($.trim(responseText) === "Wrong") {
                    $("#messageDiv").text("Неправильный логин или пароль!");
                } else {

                    $("#divId").hide("fast");
                    $("#userName").text(responseText);
                    $("#enter").hide(1000);
                    $("#out").show(1000);

                }// Locate HTML DOM element with ID "somediv" and set its text content with the response text.
            });
        });

        $(this).ready(function () {

            $('#loginButton').click(function (event) {

                $('#divId').css('display', 'block');
            });
            $('#unloginButton').click(function (event) {
                $.get("UnLoginServlet", function (responseText) {   // Execute Ajax GET request on URL of "someservlet" and execute the following function with Ajax response text...
                    alert(responseText);
                    if ($.trim(responseText) === "OK") {
                        $("#out").hide(1000);
                        $("#enter").show(1000);
                    }
                });
            });
        });




        $(document).on("click", "#secondSignin", function () { // When HTML DOM "click" event is invoked on element with ID "somebutton", execute the following function...

            var username = $("#usernamesignup").val();
            var email = $("#emailsignup").val();
            var password = $("#password").val();
            $.get("RegistrationServlet?firstName=" + username + "&email=" + email + "&password=" + password, function (responseText) {   // Execute Ajax GET request on URL of "someservlet" and execute the following function with Ajax response text...
                alert(responseText);

                if ($.trim(responseText) === "Wrong") {
                    $("#regMessageDiv").text("Неправильные данные!");
                } else {
                    alert("Successfully registered!!!!!!!!!!!!!!!!!");
                    $("#divId").hide("fast");



                }// Locate HTML DOM element with ID "somediv" and set its text content with the response text.
            });
        });

    </script>
</body>
</html>
