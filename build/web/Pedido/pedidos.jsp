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
                                                      <c:forEach var="pedido" items="${pedidos}">
                                                        <tr>
                                                            <td class="padding-0">Código do pedido: ${pedido.codigo}</td>
                                                            <td class="padding-0">Produto: ${pedido.produto.titulo}</td>
                                                            <td class="padding-0">Data do pedido: ${pedido.dataPedido}</td>
                                                            <td class="padding-0">Quantidade: ${pedido.quantidade}</td>
                                                            <td class="padding-0">Desconto: ${pedido.desconto}%</td>
                                                            <td class="padding-0">Valor Total: ${pedido.preco}</td>
                                                            <td class="padding-0">Descontado: ${pedido.preco - (pedido.preco * (pedido.desconto / 100))}</td>
                                                            <td class="padding-0">Estado: ${pedido.estado.estado()}</td>
                                                        </tr>
                                                      </c:forEach>
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
