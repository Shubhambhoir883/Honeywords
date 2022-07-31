<%-- 
    Document   : register
    Created on : 6 Aug, 2015, 12:27:41 PM
    Author     : user
--%>
<%@include file="header.jsp" %>
<section class="login">
    <div class="titulo">User Registration</div>
    <form class="form-signin" action="Register" method="post" enctype="application/x-www-form-urlencoded">
        <input autocomplete="off" class="input-block-level validate[required]" type="text" required title="Username required" name="username" placeholder="Username" data-icon="U">
        <input autocomplete="off" class="input-block-level validate[required]" type="password" required title="Password required" name="password" placeholder="Password" data-icon="x">
        
        <input autocomplete="off" class="input-block-level validate[required], custom[email]]" type="text" required title="Email required" name="email" placeholder="Email Address" data-icon="x">
        <input autocomplete="off" class="input-block-level validate[required], custom[phone]] minSize[10] maxSize[10]" type="text" required title="Phone required" name="phone" placeholder="Phone Number" data-icon="x">
        <br>
        
        <center>
           
        <div class="titulo">
        </br>
        Male <input type="radio" name="myradio" value="Male"/>
         
         Female<input type="radio" name="myradio" value="Female"/>
        </div>
        </center>
        
        <div class="olvido">
            <div class="col"><a href="register.jsp" title="Ver Carásteres">Reset</a></div>
            <div class="col"><a href="login.jsp" title="Ver Carásteres">Login</a></div>
        </div>
        <input type="submit" class="enviar" value="Submit">
    </form>
</section>
<style>
    body {
        /*    background: -webkit-radial-gradient(rgba(255,255,255,0) 0, rgba(255,255,255,.15) 30%, rgba(255,255,255,.3) 32%, rgba(255,255,255,0) 33%) 0 0, -webkit-radial-gradient(rgba(255,255,255,0) 0, rgba(255,255,255,.1) 11%, rgba(255,255,255,.3) 13%, rgba(255,255,255,0) 14%) 0 0, -webkit-radial-gradient(rgba(255,255,255,0) 0, rgba(255,255,255,.2) 17%, rgba(255,255,255,.43) 19%, rgba(255,255,255,0) 20%) 0 110px, -webkit-radial-gradient(rgba(255,255,255,0) 0, rgba(255,255,255,.2) 11%, rgba(255,255,255,.4) 13%, rgba(255,255,255,0) 14%) -130px -170px, -webkit-radial-gradient(rgba(255,255,255,0) 0, rgba(255,255,255,.2) 11%, rgba(255,255,255,.4) 13%, rgba(255,255,255,0) 14%) 130px 370px, -webkit-radial-gradient(rgba(255,255,255,0) 0, rgba(255,255,255,.1) 11%, rgba(255,255,255,.2) 13%, rgba(255,255,255,0) 14%) 0 0, -webkit-linear-gradient(45deg, #343702 0%, #184500 20%, #187546 30%, #006782 40%, #0b1284 50%, #760ea1 60%, #83096e 70%, #840b2a 80%, #b13e12 90%, #e27412 100%);
            background-color: #840b2a;
            background: -moz-radial-gradient(rgba(255,255,255,0) 0, rgba(255,255,255,.15) 30%, rgba(255,255,255,.3) 32%, rgba(255,255,255,0) 33%) 0 0, -moz-radial-gradient(rgba(255,255,255,0) 0, rgba(255,255,255,.1) 11%, rgba(255,255,255,.3) 13%, rgba(255,255,255,0) 14%) 0 0, -moz-radial-gradient(rgba(255,255,255,0) 0, rgba(255,255,255,.2) 17%, rgba(255,255,255,.43) 19%, rgba(255,255,255,0) 20%) 0 110px, -moz-radial-gradient(rgba(255,255,255,0) 0, rgba(255,255,255,.2) 11%, rgba(255,255,255,.4) 13%, rgba(255,255,255,0) 14%) -130px -170px, -moz-radial-gradient(rgba(255,255,255,0) 0, rgba(255,255,255,.2) 11%, rgba(255,255,255,.4) 13%, rgba(255,255,255,0) 14%) 130px 370px, -moz-radial-gradient(rgba(255,255,255,0) 0, rgba(255,255,255,.1) 11%, rgba(255,255,255,.2) 13%, rgba(255,255,255,0) 14%) 0 0, -moz-linear-gradient(45deg, #343702 0%, #184500 20%, #187546 30%, #006782 40%, #0b1284 50%, #760ea1 60%, #83096e 70%, #840b2a 80%, #b13e12 90%, #e27412 100%);
            background-color: #840b2a;
            background: -o-radial-gradient(rgba(255,255,255,0) 0, rgba(255,255,255,.15) 30%, rgba(255,255,255,.3) 32%, rgba(255,255,255,0) 33%) 0 0, -o-radial-gradient(rgba(255,255,255,0) 0, rgba(255,255,255,.1) 11%, rgba(255,255,255,.3) 13%, rgba(255,255,255,0) 14%) 0 0, -o-radial-gradient(rgba(255,255,255,0) 0, rgba(255,255,255,.2) 17%, rgba(255,255,255,.43) 19%, rgba(255,255,255,0) 20%) 0 110px, -o-radial-gradient(rgba(255,255,255,0) 0, rgba(255,255,255,.2) 11%, rgba(255,255,255,.4) 13%, rgba(255,255,255,0) 14%) -130px -170px, -o-radial-gradient(rgba(255,255,255,0) 0, rgba(255,255,255,.2) 11%, rgba(255,255,255,.4) 13%, rgba(255,255,255,0) 14%) 130px 370px, -o-radial-gradient(rgba(255,255,255,0) 0, rgba(255,255,255,.1) 11%, rgba(255,255,255,.2) 13%, rgba(255,255,255,0) 14%) 0 0, -o-linear-gradient(45deg, #343702 0%, #184500 20%, #187546 30%, #006782 40%, #0b1284 50%, #760ea1 60%, #83096e 70%, #840b2a 80%, #b13e12 90%, #e27412 100%);
            background-size: 1000px 1000px, 410px 410px, 610px 610px, 530px 530px, 730px 730px, 1000px 1000px;*/
        background-color: #840b2a;
    }

    .login {
        width: 300px;
        height: 450px;
        overflow: hidden;
        background: #1e1e1e;
        border-radius: 6px;
        margin: 50px auto;
        box-shadow: 0px 0px 50px rgba(0,0,0,.8);
    }

    .login .titulo {
        width: 298px;
        height: 14px;
        padding-top: 13px;
        padding-bottom: 13px;
        font-size: 14px;
        text-align: center;
        color: #bfbfbf;
        font-weight: bold;
        background: #121212;
        border: #2d2d2d solid 1px;
        margin-bottom: 30px;
        border-top-right-radius: 6px;
        border-top-left-radius: 6px;
        font-family: Arial;
    }

    .login form {
        width: 240px;
        height: auto;
        overflow: hidden;
        margin-left: auto;
        margin-right: auto;
    }

    .login form input[type=text], .login form input[type=password] {
        width: 200px;
        font-size: 12px;
        padding-top: 14px;
        padding-bottom: 14px;
        padding-left: 40px;
        border: none;
        color: #bfbfbf;
        background: #141414;
        outline: none;
        margin: 0;
    }

    .login form input[type=text] {
        border-top-left-radius: 6px;
        border-top-right-radius: 6px;
        border-bottom-left-radius: 6px;
        border-bottom-right-radius: 6px;
        border-top: #0b0b0b solid 1px;
        border-bottom: #353535 1px solid;
        background: #141414 10px center no-repeat;
        /*background: #141414 url(http://dev.dhenriquez.com/test-img/icons/111-user.png) 10px center no-repeat;*/
    }

    .login form input[type=password] {
        border-top-left-radius: 6px;
        border-top-right-radius: 6px;
        border-bottom-left-radius: 6px;
        border-bottom-right-radius: 6px;
        border-top: #0b0b0b 1px solid;
        border-bottom: #353535 1px solid;
        background: #141414 10px center no-repeat;
        /*background: #141414 url(http://dev.dhenriquez.com/test-img/icons/54-lock.png) 10px center no-repeat;*/
    }

    .login form .enviar {
        width: 240px;
        height: 12px;
        display: block;
        padding-top: 10px;
        padding-bottom: 24px;
        border-radius: 6px;
        border: none;
        border-top: #4eb2a8 1px solid;
        border-bottom: #161616 1px solid;
        background: #349e92;
        text-align: center;
        text-decoration: none;
        font-size: 12px;
        font-weight: bold;
        color: #FFF;
        text-shadow: 0 -1px #1d7464, 0 1px #7bb8b3;
        font-family: Arial;
    }

    .login .olvido {
        width: 240px;
        height: auto;
        overflow: hidden;
        padding-top: 25px;
        padding-bottom: 25px;
        font-size: 10px;
        text-align: center;
    }

    .login .olvido .col {
        width: 50%;
        height: auto;
        float: left;
    }

    .login .olvido .col a {
        color: #fff;
        text-decoration: none;
        font: 12px Arial;
    }

    /* http://meyerweb.com/eric/tools/css/reset/ 
       v2.0 | 20110126
       License: none (public domain)
    */

    html, body, div, span, applet, object, iframe, h1, h2, h3, h4, h5, h6, p, blockquote, pre, a, abbr, acronym, address, big, cite, code, del, dfn, em, img, ins, kbd, q, s, samp, small, strike, strong, sub, sup, tt, var, b, u, i, center, dl, dt, dd, ol, ul, li, fieldset, form, label, legend, table, caption, tbody, tfoot, thead, tr, th, td, article, aside, canvas, details, embed, figure, figcaption, footer, header, hgroup, menu, nav, output, ruby, section, summary, time, mark, audio, video {
        margin: 0;
        padding: 0;
        border: 0;
        font-size: 100%;
        font: inherit;
        vertical-align: baseline;
    }

    /* HTML5 display-role reset for older browsers */

    article, aside, details, figcaption, figure, footer, header, hgroup, menu, nav, section { display: block }

    body { line-height: 1 }

    ol, ul { list-style: none }

    blockquote, q { quotes: none }

    blockquote:before, blockquote:after, q:before, q:after {
        content: '';
        content: none;
    }

    table {
        border-collapse: collapse;
        border-spacing: 0;
    }
</style>
