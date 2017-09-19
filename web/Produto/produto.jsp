<%-- 
    Document   : produto
    Created on : 19/09/2017, 15:07:59
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
        <div id="produto" class="">
            <div class="row">
                <div class="col s10 offset-s1">
                    <div class="card black-color content-margin-left">
                        <div class="card-content padding-0">
                            <label class="usuario-perfil-titulo white-text">Produto 1</label>
                            <hr class="usuario-perfil-titulo-hr"/>
                        </div>
                        <div class="card-content white">
                            <div class="row">
                                <div class="col s4">
                                    <div class="card">
                                        <div class="card-image">
                                            <img src="../Shared/pic.jpg" style="width: 100%; height: 400px;" class="z-depth-1">
                                        </div>
                                        <div class="card-content padding-5 card-produto-h">
                                            <div class="row form-margin-0">
                                                <div class="col s6">
                                                    Preco
                                                </div>
                                                <div class="col s6">
                                                    Em estoque: 0
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="col s8">
                                    <div class="card">
                                        <div class="card-content z-depth-1" style="min-height: 400px;">
                                            <div class="row">
                                                Marca
                                            </div>
                                            <div class="row">
                                                Descricao
                                            </div>
                                        </div>
                                        <div class="card-content padding-5 card-produto-h">
                                            <form action="" method="">
                                                <div class="row form-margin-0">
                                                    <div class="col s6">
                                                        <label class="produto-quantidade">Quantidade: </label>
                                                        <input id="qtd-prod" type="number" class="produto-qtd-compra">
                                                    </div>
                                                    <div class="col s6">
                                                        <input type="hidden" name="cod-produto" value="">
                                                        <a type="submit" class="btn btn-produto-compra black-color right">Adicionar Carrinho!</a>
                                                    </div>
                                                </div>
                                            </form>
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
