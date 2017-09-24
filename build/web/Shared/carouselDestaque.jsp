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
                            </div>
                            <div class="card-content padding-0">
                                <span class="black-text ">${destaque.titulo}</span>
                            </div>
                        </div>
                    </div>
                </a>
            </c:forEach>
        </div>
    </div>
</div>