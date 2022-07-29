<%-- 
    Document   : accueil
    Created on : 29 juil. 2022, 21:09:07
    Author     : BABA SAIDOU DIEME
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

    <%@include file="begin.jsp" %>
    
        <%@include file="header.jsp" %>
        <div data-vide-bg="video/video">
            <div class="container">
                <div class="banner-info">
                    <h1>teste acceuil</h1>
                    <h3>C'est un fait établi depuis longtemps qu'un lecteur sera distrait par la lisibilité </h3>	
                    <div class="search-form">
                        <form action="#" method="post">
                            <input type="text" placeholder="Search..." name="Search...">
                            <input type="submit" value=" " >
                        </form>
                    </div>		
                </div>	
            </div>
        </div>

        <script>window.jQuery || document.write('<script src="js/vendor/jquery-1.11.1.min.js"><\/script>')</script>
        <script src="js/jquery.vide.min.js"></script>

        <!--content-->
        <div class="content-mid ">
            <div class="container ">
                <div class="spec ">
                    <h3>Nos Produits</h3>
                    <div class="ser-t">
                        <b></b>
                        <span><i></i></span>
                        <b class="line"></b>
                    </div>
                </div>
                <div class="tab-head ">
                    <nav class="nav-sidebar">
                        <ul class="nav tabs ">
                            <li class="active"><a href="#tab1" data-toggle="tab">Alimentation</a></li>
                            <li class=""><a href="#tab2" data-toggle="tab">Santé & Beauté</a></li> 
                            <li class=""><a href="#tab3" data-toggle="tab">Maison</a></li>
                        </ul>
                    </nav>
                    <div class=" tab-content tab-content-t ">
                        <div class="tab-pane active text-style" id="tab1">
                            <div class=" con-w3l">
                                <c:forEach var="voiture" items="${listVoiture}"> 
                                    <div class="col-md-3 pro-1">
                                        <div class="col-m">
                                            <a href="#" data-toggle="modal" data-target="#myModal<c:out value="${voiture.matricule}"/>" class="offer-img">
                                                <img src=viewImage?id=<c:out value="${voiture.matricule}"/> alt="" class="img-responsive">
                                            </a>
                                            <div class="mid-1">
                                                <div class="women">
                                                    <h6><c:out value="${voiture.designation}"/></h6>							
                                                </div>
                                                <div class="mid-2">
                                                    <p ><em class="item_price">XOF<c:out value="${voiture.prix}"/></em></p>
                                                    <div class="block">
                                                        <div class="starbox small ghosting"> </div>
                                                    </div>
                                                    <div class="clearfix"></div>
                                                </div>
                                                <div class="add">
                                                    <button class="btn btn-danger my-cart-btn my-cart-b" data-id="4" data-name="<c:out value="${voiture.designation}"/>" data-summary="summary 4" data-price="<c:out value="${voiture.prix}"/>" data-quantity="<c:out value="${voiture.stock}"/>" data-image="viewImage?id=<c:out value="${voiture.matricule}"/>">Add to Cart</button>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </c:forEach>
                                <div class="clearfix"></div>
                            </div>
                        </div>
                        <div class="tab-pane  text-style" id="tab2">
                            <div class=" con-w3l">
                                <c:forEach var="voiture" items="${listVoiture}"> 
                                    <div class="col-md-3 pro-1">
                                        <div class="col-m">
                                            <a href="#" data-toggle="modal" data-target="#myModal<c:out value="${voiture.matricule}"/>" class="offer-img">
                                                <img src=viewImage?id=<c:out value="${voiture.matricule}"/> alt="" class="img-responsive">
                                            </a>
                                            <div class="mid-1">
                                                <div class="women">
                                                    <h6><c:out value="${voiture.designation}"/></h6>							
                                                </div>
                                                <div class="mid-2">
                                                    <p ><em class="item_price">XOF<c:out value="${voiture.prix}"/></em></p>
                                                    <div class="block">
                                                        <div class="starbox small ghosting"> </div>
                                                    </div>
                                                    <div class="clearfix"></div>
                                                </div>
                                                <div class="add">
                                                    <button class="btn btn-danger my-cart-btn my-cart-b" data-id="4" data-name="<c:out value="${voiture.designation}"/>" data-summary="summary 4" data-price="<c:out value="${voiture.prix}"/>" data-quantity="1" data-image="viewImage?id=<c:out value="${voiture.matricule}"/>">Add to Cart</button>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </c:forEach>
                                <div class="clearfix"></div>
                            </div>		  
                        </div>
                        <div class="tab-pane  text-style" id="tab3">
                            <div class=" con-w3l">
                                <c:forEach var="voiture" items="${listVoiture}"> 
                                    <div class="col-md-3 pro-1">
                                        <div class="col-m">
                                            <a href="#" data-toggle="modal" data-target="#myModal<c:out value="${product.idArticle}"/>" class="offer-img">
                                                <img src=viewImage?id=<c:out value="${voiture.idArticle}"/> alt="" class="img-responsive">
                                            </a>
                                            <div class="mid-1">
                                                <div class="women">
                                                    <h6><c:out value="${voiture.designation}"/></h6>							
                                                </div>
                                                <div class="mid-2">
                                                    <p ><em class="item_price">XOF<c:out value="${voiture.prix}"/></em></p>
                                                    <div class="block">
                                                        <div class="starbox small ghosting"> </div>
                                                    </div>
                                                    <div class="clearfix"></div>
                                                </div>
                                                <div class="add">
                                                    <button class="btn btn-danger my-cart-btn my-cart-b" data-id="4" data-name="<c:out value="${voiture.designation}"/>" data-summary="summary 4" data-price="<c:out value="${voiture.prix}"/>" data-quantity="<c:out value="${voiture.stock}"/>" data-image="viewImage?id=<c:out value="${voiture.matricule}"/>">Add to Cart</button>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </c:forEach>
                                <div class="clearfix"></div>
                            </div>		  
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- smooth scrolling -->
        <script type="text/javascript">
            $(document).ready(function () {
                /*
                 var defaults = {
                 containerID: 'toTop', // fading element id
                 containerHoverID: 'toTopHover', // fading element hover id
                 scrollSpeed: 1200,
                 easingType: 'linear' 
                 };
                 */
                $().UItoTop({easingType: 'easeOutQuart'});
            });
        </script>
        <a href="#" id="toTop" style="display: block;"> <span id="toTopHover" style="opacity: 1;"> </span></a>
        <!-- //smooth scrolling -->
        <!-- for bootstrap working -->
        <script src="js/bootstrap.js"></script>
        <!-- //for bootstrap working -->
        <script type='text/javascript' src="js/jquery.mycart.js"></script>
        <script type="text/javascript">
            $(function () {

                var goToCartIcon = function ($addTocartBtn) {
                    var $cartIcon = $(".my-cart-icon");
                    var $image = $('<img width="30px" height="30px" src="' + $addTocartBtn.data("image") + '"/>').css({"position": "fixed", "z-index": "999"});
                    $addTocartBtn.prepend($image);
                    var position = $cartIcon.position();
                    $image.animate({
                        top: position.top,
                        left: position.left
                    }, 500, "linear", function () {
                        $image.remove();
                    });
                }

                $('.my-cart-btn').myCart({
                    classCartIcon: 'my-cart-icon',
                    classCartBadge: 'my-cart-badge',
                    affixCartIcon: true,
                    checkoutCart: function (products) {
                        $.each(products, function () {
                            console.log(this);
                        });
                    },
                    clickOnAddToCart: function ($addTocart) {
                        goToCartIcon($addTocart);
                    },
                    getDiscountPrice: function (products) {
                        var total = 0;
                        $.each(products, function () {
                            total += this.quantity * this.price;
                        });
                        return total * 1;
                    }
                });
            });
        </script>
        <!-- product -->
        <c:forEach var="product" items="${listArticle}"> 
            <div class="modal fade" id="myModal<c:out value="${product.idArticle}"/>" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
                <div class="modal-dialog" role="document">
                    <div class="modal-content modal-info">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>						
                        </div>
                        <div class="modal-body modal-spa">
                            <div class="col-md-5 span-2">
                                <div class="item">
                                    <img src=viewImage?id=<c:out value="${product.idArticle}"/> alt="" class="img-responsive">
                                </div>
                            </div>
                            <div class="col-md-7 span-1 ">
                                <h3><c:out value="${product.designation}"/>(1 kg)</h3>
                                <p class="in-para"> <c:out value="${product.description}"/></p>
                                <div class="price_single">
                                    <span class="reducedfrom "><c:out value="${product.prix}"/></span>

                                    <div class="clearfix"></div>
                                </div>
                                <h4 class="quick">Quick Overview:</h4>
                                <p class="quick_desc"> <c:out value="${product.description}"/></p>
                                <div class="add-to">
                                    <button class="btn btn-danger my-cart-btn my-cart-btn1 " data-id="<c:out value="${product.idArticle}"/>" data-name="<c:out value="${product.designation}"/>" data-summary="summary 1" data-price="<c:out value="${product.prix}"/>" data-quantity="1" data-image=viewImage?id=<c:out value="${product.idArticle}"/>>Add to Cart</button>
                                </div>
                            </div>
                            <div class="clearfix"> </div>
                        </div>
                    </div>
                </div>
            </div>
        </c:forEach>
        <!--content-->
        <%@include file="footer.jsp" %>
    



