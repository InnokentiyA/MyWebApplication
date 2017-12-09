<div class="container">
    <!-- Codrops top bar -->
    <div class="codrops-top">  
        <div class="clr"></div>
    </div><!--/ Codrops top bar -->

    <section>				
        <div id="container_demo" >

            <a class="hiddenanchor" id="toregister"></a>
            <a class="hiddenanchor" id="tologin"></a>
            <div id="wrapper">
                <div id="login" class="animate form">
                    <form  action="mysuperscript.php" autocomplete="on"> 
                        <h1>Log in</h1> 
                        <p> 
                            <label for="username" class="uname" data-icon="u" > Your email or username </label>
                            <input id="username" name="username" required="required" type="text" placeholder="myusername or mymail@mail.com"/>
                        </p>
                        <p> 
                            <label for="password" class="youpasswd" data-icon="p"> Your password </label>
                            <input id="password" name="password" required="required" type="password" placeholder="eg. X8df!90EO" /> 
                        </p>
                        <p class="keeplogin"> 
                            <input type="checkbox" name="loginkeeping" id="loginkeeping" value="loginkeeping" /> 
                            <label for="loginkeeping">Keep me logged in</label>
                        </p>
                        <div id="messageDiv" style="display:none;
                             color: red;
                             font-size: small;
                             "></div> 
                        <p class="login button"> 
                            <input type="button" id="secondLogin" value="Log in" />

                        </p>
                        <p class="change_link">
                            Not a member yet ?
                            <a href="#toregister" class="to_register">Join us</a>
                        </p>
                    </form>
                </div>

                <div id="register" class="animate form">
                    <form  action="mysuperscript.php" autocomplete="on"> 
                        <h1> Sign up </h1> 
                        <p> 
                            <label for="usernamesignup" class="uname" data-icon="u">Your username</label>
                            <input id="usernamesignup" name="usernamesignup" required="required" type="text" placeholder="mysuperusername690" />
                        </p>
                        <p> 
                            <label for="emailsignup" class="youmail" data-icon="e" > Your email</label>
                            <input id="emailsignup" name="emailsignup" required="required" type="email" placeholder="mysupermail@mail.com"/> 
                        </p>
                        <p> 
                            <label for="passwordsignup" class="youpasswd" data-icon="p">Your password </label>
                            <input id="passwordsignup" name="passwordsignup" required="required" type="password" placeholder="eg. X8df!90EO"/>
                        </p>
                        <p> 
                            <label for="passwordsignup_confirm" class="youpasswd" data-icon="p">Please confirm your password </label>
                            <input id="passwordsignup_confirm" name="passwordsignup_confirm" required="required" type="password" placeholder="eg. X8df!90EO"/>
                        </p>
                        <p class="signin button"> 
                            <input type="submit" id="secondSignin" value="Sign up"/> 
                        </p>
                        <p class="change_link">  
                            Already a member ?
                            <a href="#tologin" class="to_register"> Go and log in </a>
                        </p>
                    </form>
                </div>

            </div>
        </div>  
    </section>
</div>
