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
        <link rel="stylesheet" href="Shared/css/materialize.css">
        <link rel="stylesheet" href="Shared/css/index.css">
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
                                <li class="tab"><a href="#divElet">Eletrônicos</a></li>
                                <li class="tab"><a href="#divHard">Hardware</a></li>
                                <li class="tab"><a href="#divSoft">Software</a></li>
                                <li class="tab"><a href="#divPeri">Periféricos</a></li>
                                <li class="tab"><a href="#divCompu">Computadores</a></li>
                            </ul>
                        </div>
                        <div class="card-content z-depth-1">
                            <div id="divElet">
                                <div class="row">
                                    <div class="col s2">
                                        <div class="card">
                                            <div class="card-image waves-effect waves-block waves-light">
                                                <img class="activator" src="Shared/pic.jpg">
                                            </div>
                                            <div class="card-content padding-0">
                                                <span class="card-title activator grey-text text-darken-4">Produto 1<i class="material-icons right">more_vert</i></span>
                                                <p><a class="btn-flat btn-produto" href="#">Página do produto</a></p>
                                            </div>
                                            <div class="card-reveal padding-5">
                                                <span class="card-title grey-text text-darken-4">Produto 1<i class="material-icons right">close</i></span>
                                                <p>Aqui vao informacoes relacionadas ao produto</p>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div id="divHard">HARDWARE</div>
                            <div id="divSoft">SOFTWARE</div>
                            <div id="divPeri">SOFTWARE</div>
                            <div id="divCompu">COMPUTADORES</div>
                          </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="page-footer gray-color">
            <div class="container">
                <div class="row">
                  <div class="col l6 s12">
                      <h5 class="white-text">Virtual Shop</h5>
                      <p class="grey-text text-lighten-4">A sua loja online de produtos eletrônicos</p>
                  </div>
                  <div class="col l4 offset-l2 s12">
                      <h5 class="white-text">Referências</h5>
                      <ul>
                          <li><a class="grey-text text-lighten-3" href="#!">Link 1</a></li>
                          <li><a class="grey-text text-lighten-3" href="#!">Link 2</a></li>
                      </ul>
                  </div>
                </div>
            </div>
        </div>
        <script src="Shared/js/jquery-3.2.1.min.js"></script>
        <script src="Shared/js/materialize.js"></script>
        <script src="Shared/js/index.js"></script>
        <c:import url="Shared/rodape.jsp"/>
    </body>
</html>
