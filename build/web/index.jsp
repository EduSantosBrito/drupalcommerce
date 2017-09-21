<%-- 
    Document   : index
    Created on : 17/09/2017, 20:38:48
    Author     : sandr
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <c:import url="Shared/importCss.jsp"/>
    </head>
    <body>
        <c:import url="Shared/cabecalho.jsp"/>
        <c:import url="Shared/barraLateral.jsp"/>
        <c:import url="Shared/carouselDestaque.jsp"/>
        <div id="novos-produtos">
            <div class="row">
                <div class="col s12">
                    <div class="card z-depth-0">
                        <div class="card-content center card-content-padding-0">
                            <a class="btn-flat grey-text darken-text-2">Produtos em destaque!</a>
                        </div>
                        <div class="card-tabs">
                            <ul class="tabs tabs-fixed-width black-color z-depth-1">
                                <li class="tab"><a href="#divHard">Hardware</a></li>
                                <li class="tab"><a href="#divSoft">Software</a></li>
                                <li class="tab"><a href="#divPeri">Periféricos</a></li>
                            </ul>
                        </div>
                        <div class="card-content z-depth-1">
                            <div id="divHard">
                                <div class="row">
                                    <c:forEach var="hardware" items="${listaHardware}">
                                        <div class="col s2">
                                            <div class="card">
                                                <div class="card-image waves-effect waves-block waves-light">
                                                    <img class="activator" src="${pageContext.request.contextPath}/Shared/pic.jpg">
                                                </div>
                                                <div class="card-content padding-0">
                                                    <span class="card-title activator grey-text text-darken-4">${hardware.nome}<i class="material-icons right">more_vert</i></span>
                                                    <p><a class="btn-flat btn-produto" href="${pageContext.request.contextPath}/FrontController?action=VisualizarProduto&AMP;id=${hardware.codigo}">Página do produto</a></p>
                                                </div>
                                                <div class="card-reveal padding-5">
                                                    <span class="card-title grey-text text-darken-4">${hardware.nome}<i class="material-icons right">close</i></span>
                                                    <p>${hardware.descricao} <br> ${hardware.preco}</p>
                                                </div>
                                            </div>
                                        </div>
                                    </c:forEach>
                                </div>
                            </div>
                            <div id="divSoft">
                                <div class="row">
                                    <c:forEach var="software" items="${listaSoftware}">
                                        <div class="col s2">
                                            <div class="card">
                                                <div class="card-image waves-effect waves-block waves-light">
                                                    <img class="activator" src="${pageContext.request.contextPath}/Shared/pic.jpg">
                                                </div>
                                                <div class="card-content padding-0">
                                                    <span class="card-title activator grey-text text-darken-4">${software.nome}<i class="material-icons right">more_vert</i></span>
                                                    <p><a class="btn-flat btn-produto" href="${pageContext.request.contextPath}/FrontController?action=VisualizarProduto&AMP;id=${software.codigo}">Página do produto</a></p>
                                                </div>
                                                <div class="card-reveal padding-5">
                                                    <span class="card-title grey-text text-darken-4">${software.nome}<i class="material-icons right">close</i></span>
                                                    <p>${software.descricao} <br> ${software.preco}</p>
                                                </div>
                                            </div>
                                        </div>
                                    </c:forEach>
                                </div>
                            </div>
                            <div id="divPeri">
                                <div class="row">
                                    <c:forEach var="periferico" items="${listaPeriferico}">
                                        <div class="col s2">
                                            <div class="card">
                                                <div class="card-image waves-effect waves-block waves-light">
                                                    <img class="activator" src="${pageContext.request.contextPath}/Shared/pic.jpg">
                                                </div>
                                                <div class="card-content padding-0">
                                                    <span class="card-title activator grey-text text-darken-4">${periferico.nome}<i class="material-icons right">more_vert</i></span>
                                                    <p><a class="btn-flat btn-produto" href="${pageContext.request.contextPath}/FrontController?action=VisualizarProduto&AMP;id=${periferico.codigo}">Página do produto</a></p>
                                                </div>
                                                <div class="card-reveal padding-5">
                                                    <span class="card-title grey-text text-darken-4">${periferico.nome}<i class="material-icons right">close</i></span>
                                                    <p>${periferico.descricao} <br> ${periferico.preco}</p>
                                                </div>
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
        <c:import url="Shared/rodape.jsp"/>
        <c:import url="Shared/importJs.jsp"/>
    </body>
</html>
