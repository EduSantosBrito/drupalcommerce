<%-- 
    Document   : pedidos
    Created on : 19/09/2017, 15:07:44
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
        <div id="pedidos">
            <div class="row content-margin-left content-margin-top">
                <div class="col s12">
                    <div class="card z-depth-1">
                        <div class="card-content center card-content-padding-0 black-color">
                            <a class="btn-flat white-text">Pedidos</a>
                        </div>
                        <div class="card-content white padding-5">
                            <div class="row">
                                <div class="col s12">
                                    <ul class="collapsible" data-collapsible="accordion">
                                        <li>
                                            <div class="padding-5">
                                              <table>
                                                  <tbody>
                                                      <tr>
                                                          <td class="padding-0">Código do pedido:</td>
                                                          <td class="padding-0">Produto:</td>
                                                          <td class="padding-0 td-qtd-size">Data do pedido: 10/10/1000</td>
                                                          <td class="padding-0 td-qtd-size">Quantidade: 0</td>
                                                          <td class="padding-0 td-qtd-size">Valor Total: 0</td>
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
        <script src="../Shared/js/jquery-3.2.1.min.js"></script>
        <script src="../Shared/js/materialize.js"></script>
        <script src="../Shared/js/index.js"></script>
    </body>
</html>
