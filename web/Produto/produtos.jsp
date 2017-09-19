<%-- 
    Document   : produtos
    Created on : 19/09/2017, 15:08:06
    Author     : Automateasy
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <c:import url="../Shared/importCss.jsp" />
        <link rel="stylesheet" href="../Shared/css/materialize.css">
        <link rel="stylesheet" href="../Shared/css/index.css">
    </head>
    <body>
        <c:import url="../Shared/cabecalho.jsp"/>
        <c:import url="../Shared/barraLateral.jsp"/>
        <div id="produtos">
            <div class="row">
                <div class="col s12">
                    <div class="card z-depth-1 content-margin-left">
                        <div class="card-content center card-content-padding-0 black-color">
                            <a class="btn-flat white-text">CATEGORIA X</a>
                        </div>
                        <div class="card-content white">
                            <div class="row">
                                <div class="col s2">
                                    <div class="card">
                                        <div class="card-image waves-effect waves-block waves-light">
                                            <img class="activator" src="../Shared/pic.jpg">
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
                    </div>
                </div>
            </div>
        </div>
        <c:import url="../Shared/rodape.jsp"/>
        <script src="../Shared/js/jquery-3.2.1.min.js"></script>
        <script src="../Shared/js/materialize.js"></script>
        <script src="../Shared/js/index.js"></script>
    </body>
</html>
