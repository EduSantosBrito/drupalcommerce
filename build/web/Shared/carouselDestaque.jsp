<<<<<<< HEAD
<%-- 
    Document   : carouselDestaque
    Created on : 17/09/2017, 20:51:04
    Author     : sandr
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!--Produtos em destaque-->
<div class="row">
    <div class="col s12">
        <div class="center carousel-margin-top">
            <div class="carousel-fixed-item center">
                <a class="btn-flat grey-text darken-text-2">Acabaram de chegar!</a>
            </div>
            <c:forEach var="destaque" items="${destaque}">
                <a href="${pageContext.request.contextPath}/FrontController?action=VisualizarProduto&AMP;id=${destaque.codigo}">
                    <div class="col s2 carousel-item">
                        <div class="card">
                            <div class="card-image waves-effect waves-block waves-light">
                                <img class="activator" src="${pageContext.request.contextPath}/Shared/pic.jpg">
                                <span class="card-title white-text">${destaque.titulo}</span>
                            </div>
                        </div>
                    </div>
                </a>
            </c:forEach>
        </div>
    </div>
=======
<%-- 
    Document   : carouselDestaque
    Created on : 17/09/2017, 20:51:04
    Author     : sandr
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!--Produtos em destaque-->
<div class="row">
    <div class="col s12">
        <div class="carousel center carousel-margin-top" data-indicators="true">
            <div class="carousel-fixed-item center">
                <a class="btn-flat grey-text darken-text-2">Acabaram de chegar!</a>
            </div>
            <div class="carousel-fixed-item center middle-indicator">
                <div class="left">
                    <a href="Previo" class="movePrevCarousel middle-indicator-text waves-effect waves-light content-indicator"><i class="material-icons left  middle-indicator-text">chevron_left</i></a>
                </div>
                <div class="right">
                    <a href="Siguiente" class="moveNextCarousel middle-indicator-text waves-effect waves-light content-indicator indicator-right"><i class="material-icons right middle-indicator-text">chevron_right</i></a>
                </div>
            </div>
            <c:forEach var="destaque" items="${destaques}">
                <a class="carousel-item" href="#">
                    <div class="card">
                        <div class="card-image">
                            <img src="Shared/pic.jpg">
                            <span class="card-title card-content-padding-0">${destaque.nome}</span>
                        </div>
                    </div>
                </a>
            </c:forEach>
        </div>
    </div>
>>>>>>> c9c8b6bf5d3fb2e451aa96ef91c0a61196a02b4a
</div>