<%-- 
    Document   : carrinho
    Created on : 19/09/2017, 15:07:37
    Author     : Automateasy
--%>

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
        <div id="carrinho">
            <div class="row">
                <div class="col s12">
                    <div class="card z-depth-1 content-margin-left">
                        <div class="card-content center card-content-padding-0 black-color">
                            <a class="btn-flat white-text">CARRINHO</a>
                        </div>
                        <div class="card-content white">
                            <div class="row">
                                <div class="col s12">
                                    <ul class="collection with-header">
                                        <li class="collection-header"><h5>Produtos</h5></li>
                                        <li class="collection-item">
                                            <!--ITEMS-->
                                            <div>
                                                <table>
                                                    <tbody>
                                                        <tr>
                                                            <td class="padding-0">Produto 1</td>
                                                            <td class="td-qtd-size padding-0">Quantidade: 0</td>
                                                            <td class="td-remove-size padding-0">
                                                                <a href="">
                                                                    <i class="material-icons red-text">remove_shopping_cart</i>
                                                                </a>
                                                            </td>
                                                        </tr>
                                                    </tbody>
                                                </table>
                                            </div>
                                        </li>
                                      </ul>
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