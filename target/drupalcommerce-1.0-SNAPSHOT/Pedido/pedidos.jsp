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
                                    <div class="padding-5">
                                        <table class="bordered">
                                            <tbody>
                                                <c:forEach var="pedido" items="${pedidos}">
                                                    <tr>
                                                        <td class="padding-5 td-small-size">Código: ${pedido.codigo}</td>
                                                        <td class="padding-5">Produto: ${pedido.produto.titulo}</td>
                                                        <td class="padding-5">Data: ${pedido.dataPedido}</td>
                                                        <td class="padding-5">Quantidade: ${pedido.quantidade}</td>
                                                        <td class="padding-5">Valor do produto: ${pedido.preco}</td>
                                                        <td class="padding-5">Pago: ${ Math.round( pedido.preco - (pedido.preco * ( ( pedido.desconto / 100) + ( pedido.produto.promocao.getDesconto() /100 ) ) ) )} (${pedido.desconto + pedido.produto.promocao.getDesconto()}%)</td>
                                                        <td class="padding-5">Estado: ${pedido.estado.estado()}</td>
                                                    </tr>
                                                </c:forEach>
                                            </tbody>
                                        </table>
                                    </div>
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