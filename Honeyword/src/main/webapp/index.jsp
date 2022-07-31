<%@include file="head.jsp" %>
<%@include file="header.jsp" %>
<style>
.hello{
background-image:url("images/vm3.jpg");
}
</style>
        <!--body-->
            <body>
                <!--head-starts-->
                <div class="header" id="home">
                    <div class="header-top">
                        <nav class="navbar navbar-default nav-dflt-setin">
                          <div class="container">
                            <!-- Brand and toggle get grouped for better mobile display -->
                            <div class="navbar-header nav-min-wid">
                                <button type="button" class="navbar-toggle collapsed"  data-toggle="collapse"  data-target="#bs-example-navbar-collapse-1" aria-expanded="false" >
                                <span class="sr-only">Toggle navigation</span>
                                <span class="icon-bar"></span>
                                <span class="icon-bar"></span>
                                <span class="icon-bar"></span>
                              </button>
                              <h1><a class="navbar-brand" href="index.jsp">Honeyword</a></h1>
                            </div>
                            <!-- Collect the nav links, forms, and other content for toggling -->
                            <div class="collapse navbar-collapse " id="bs-example-navbar-collapse-1">

                                <ul class="nav navbar-nav nav-max-wid cl-effect-5" id="cl-effect-5">
                            <li><a href="index.jsp"><span data-hover="Home" class="active">Home</span></a></li>
                            <li><a href="about.jsp"><span data-hover="About">About</span></a></li>
                                <li><a href="login.jsp"><span data-hover="Login">Login</span></a></li>
<!--                            <li><a href="services.html"><span data-hover="Services">Services</span></a></li>-->
<!--                            <li><a href="gallery.html"><span data-hover="Gallery">Gallery</span></a></li>
                            <li><a href="typography.html"><span data-hover="Short Codes">Short Codes</span></a></li>-->
                            <li><a href="contact.jsp"><span data-hover="Contact">Contact</span></a></li>
                                </ul>

<!--                                <ul class="nav navbar-nav nav-min-wid social">
                                    <li><a href="#" class="fb"></a></li>
                                    <li><a href="#" class="twit"></a></li>
                                    <li><a href="#" class="gplus"></a></li>
                                    <li><a href="#" class="inst"></a></li>
                                </ul>-->

                            </div><!-- /.navbar-collapse -->
                        <div class="clearfix"></div>
                          </div><!-- /.container-fluid -->
                        </nav>
                    </div>
                    <div class="header-bottom">
                        <div id="mycarousel" class="carousel slide" data-ride="carousel">
                              <!-- Indicators -->
                              <ol class="carousel-indicators">
                                <li data-target="#mycarousel" data-slide-to="0" class="active"></li>
                                <li data-target="#mycarousel" data-slide-to="1"></li>
                                <li data-target="#mycarousel" data-slide-to="2"></li>
                              </ol>

                              <!-- Wrapper for slides -->
                      <div class="carousel-inner" role="listbox">
                                <div class="item active hello">
                                  <img src="images/mypro.png" alt="banner" class="banner-wid" style="height:200px;width:190px;border:1px solid white;margin-left:20px;padding:20px;">
                                    <div class="carousel-caption">
                                        <h3>Honeyword</h3>
                                    </div>
                                </div>
                                <div class="item">
                                  <img src="img/honey.jpg" alt="banner" class="banner-wid">
                                    <div class="carousel-caption">
                                        <h3>Honeyword</h3>
                                    </div>
                                </div>
                                <div class="item">
                                  <img src="images/hw3.jpg" alt="banner" class="banner-wid">
                                    <div class="carousel-caption">
                                        <h3>Honeyword</h3>
                                    </div>
                                </div>
                              </div>
                            <!-- Controls -->

                        </div>
                    </div>
                </div>
                <!--head-ends-->

<!--                content-starts
                <div class="content">
                    <section class="best-quality">
                        <div class="container">
                       <p>Lorem Ipsum is simply dummy text of the printing and typesetting industry.<a class="btn btn-default btn-quality" href="#" role="button">Find out more</a></p>
                        </div>
                    </section>
                    <div class="work-section">
                        <div class="container">
                            <div class="col-md-6 work-grids">
                                <div class="work-grid-text">
                                    <ul>
                                        <li>
                                        <span class="glyphicon glyphicon-glass work-grid-icn" aria-hidden="true"></span>Care
                                        </li>
                                        <li>
                                        <span class="glyphicon glyphicon-wrench work-grid-icn" aria-hidden="true"></span>Installation
                                        </li>
                                        <li>
                                        <span class="glyphicon glyphicon-pushpin work-grid-icn" aria-hidden="true"></span>Preference
                                        </li>
                                        
                                    </ul>
                                    <div class="clearfix"></div>
                                    <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Maecenas tempus neque at imperdiet faucibus. Praesent eget orci quis orci pharetra eleifend a eu diam. Morbi facilisis vitae quam consectetur malesuada. Nullam a felis ut magna tincidunt luctus eu sit amet tortor.</p>
                                    <a class="btn btn-default work-btn" href="#" role="button">find out more</a>
                                </div>
                            </div>
                            <div class="col-md-6 work-grids">
                                <div class="work-img">
                                    <img src="images/wrk.jpg" alt="/" class="work-img-wid">
                                </div>
                            </div>
                            <div class="col-md-6 work-grids">
                                <div class="work-img">
                                    <img src="images/wrk1.jpg" alt="/" class="work-img-wid">
                                </div>
                            </div>
                            <div class="col-md-6 work-grids">
                                <div class="work-grid-text">
                                    <ul>
                                        <li>
                                        <span class="glyphicon glyphicon-usd work-grid-icn" aria-hidden="true"></span>Affordable
                                        </li>
                                        <li>
                                        <span class="glyphicon glyphicon-ok work-grid-icn" aria-hidden="true"></span>Quality Check
                                        </li>
                                        <li>
                                        <span class="glyphicon glyphicon-user work-grid-icn" aria-hidden="true"></span>Support
                                        </li>
                                        
                                    </ul>
                                    <div class="clearfix"></div>
                                    <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Maecenas tempus neque at imperdiet faucibus. Praesent eget orci quis orci pharetra eleifend a eu diam. Morbi facilisis vitae quam consectetur malesuada. Nullam a felis ut magna tincidunt luctus eu sit amet tortor.</p>
                                    <a class="btn btn-default work-btn" href="#" role="button">find out more</a>
                                </div>
                            </div>
                    <div class="clearfix"></div>
                        </div>
                    </div>
                    <div class="our-latest">
                        <div class="container">
                            <h2>Our Latest Projects</h2>
                            <div class="col-md-6 latest-grid">
                                <div class="latest-bg-pos">
                                    <img src="images/proj2.jpg" alt="/" class="latest-img">
                                    <div class="latest-text">
                                        <div class="border-line">
                                            <h3>Lorem Ipsum Exclusive</h3>
                                            <p>7<small>th</small> July, 2015</p>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="col-md-6 latest-grid">
                                <div class="latest-bg-pos">
                                    <img src="images/proj.jpg" alt="/" class="latest-img">
                                    <div class="latest-text">
                                        <div class="border-line">
                                            <h3>Lorem Ipsum Exclusive</h3>
                                            <p>25<small>th</small> Aug, 2015</p>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="col-md-6 latest-grid">
                                <div class="latest-bg-pos">
                                    <img src="images/proj1.jpg" alt="/" class="latest-img">
                                    <div class="latest-text">
                                        <div class="border-line">
                                            <h3>Lorem Ipsum Exclusive</h3>
                                            <p>18<small>th</small> May, 2015</p>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="col-md-6 latest-grid">
                                <div class="latest-bg-pos">
                                    <img src="images/proj3.jpg" alt="/" class="latest-img">
                                    <div class="latest-text">
                                        <div class="border-line">
                                            <h3>Lorem Ipsum Exclusive</h3>
                                            <p>7<small>th</small> Feb, 2015</p>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="clearfix"></div>
                        </div>
                    </div>
                    <div class="twitter-feeds">
                        script
                        <script src="js/responsiveslides.min.js"></script>
                        <script>
                            $(function () {
                              $("#slider").responsiveSlides({
                                auto: true,
                                speed: 500,
                                namespace: "callbacks",
                                pager: true,
                              });
                            });
                        </script>
                        script
                        <div class="container">
                             <div class="slider">
                                <div class="callbacks_container">
                                  <ul class="rslides" id="slider">
                                    <li>
                                      <div class="caption">
                                        <h3>TWITTER FEEDS</h3>
                                        <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. consectetur adipiscing elit. consectetur adipiscing elit.</p>
                                      </div>
                                    </li>
                                    <li>
                                      <div class="caption">
                                        <h3>TWITTER FEEDS</h3>
                                        <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. consectetur adipiscing elit. consectetur adipiscing . consectetur adipiscing elit</p>
                                          <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. consectetur adipiscing elit consectetur adipiscing  elit.</p>
                                      </div>
                                    </li>
                                    <li>
                                      <div class="caption">
                                        <h3>TWITTER FEEDS</h3>
                                        <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. consectetur adipiscing elit. consectetur adipiscing elit.</p>
                        <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. consectetur adipiscing elit.</p>
                                      </div>
                                    </li>
                                    </ul>
                                 </div>
                            </div>
                        </div>
                    </div>
                </div>
                content-ends-->

                <!--footer-starts-->
                 <%@include file="footer.jsp" %>
                <!--footer-ends-->
            </body>
        <!--body-->
    </html>