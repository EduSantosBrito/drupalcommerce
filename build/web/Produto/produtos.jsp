<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <c:import url="../Shared/importCss.jsp" />
    </head>
    <body>
        <c:import url="../Shared/cabecalho.jsp"/>
        <c:import url="../Shared/barraLateral.jsp"/>
        <div id="produtos">
            <div class="row">
                <div class="col s12">
                    <div class="card z-depth-1 content-margin-left">
                        <div class="card-content center card-content-padding-0 black-color">
                            <a class="btn-flat white-text">${produtos[0].categoria}</a>
                        </div>
                        <div class="card-content white">
                            <div class="row">
                                <div class="col s2">
                                    <c:forEach var="produto" items="${produtos}">
                                        <div class="card">
                                            <div class="card-image waves-effect waves-block waves-light">
                                                <img class="activator" src="${pageContext.request.contextPath}/Shared/pic.jpg">
                                            </div>
                                            <div class="card-content padding-0">
                                                <span class="card-title activator grey-text text-darken-4">${produto.titulo}<i class="material-icons right">more_vert</i></span>
                                                <p><a class="btn-flat btn-produto" href="${pageContext.request.contextPath}/FrontController?action=VisualizarProduto&AMP;id=${produto.codigo}">Página do produto</a></p>
                                            </div>
                                            <div class="card-reveal padding-5">
                                                <span class="card-title grey-text text-darken-4">${produto.titulo}<i class="material-icons right">close</i></span>
                                                <p><b>Descrição do produto:</b> ${produto.descricao} <br> <b>Preço:</b> ${produto.preco}</p>
                                            </div>
                                        </div>
                                    </c:forEach>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <c:import url="../Shared/rodape.jsp"/>
        <c:import url="../Shared/importJs.jsp"/>
    </body>
</html>
