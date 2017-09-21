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
                            <a class="btn-flat white-text right">Preço Total: ${usuario.carrinho.total}R$</a>
                        </div>
                        <div class="card-content white padding-0">
                            <div class="row">
                                <div class="col s12">
                                    <ul class="collection with-header">
                                        <li class="collection-item">
                                            <c:forEach var="item" items="${usuario.carrinho.itens}">
                                                <div>
                                                    <table>
                                                        <tbody>
                                                            <tr>
                                                                <td class="padding-0">Produto: ${item.produto.titulo}</td>
                                                                <td class="padding-0">Preço: ${item.produto.preco}R$</td>
                                                                <td class="td-qtd-size padding-0">Quantidade: ${item.quantidade}</td>
                                                                <td class="td-remove-size padding-0">
                                                                    <a href="${pageContext.request.contextPath}/FrontController?action=RemoverProdutoCarrinho&AMP;id=${item.produto.codigo}">
                                                                        <i class="material-icons red-text">remove_shopping_cart</i>
                                                                    </a>
                                                                </td>
                                                            </tr>
                                                        </tbody>
                                                    </table>
                                                </div>
                                            </c:forEach>
                                        </li>
                                        <a type="submit" class="btn btn-produto-compra black-color right" href="${pageContext.request.contextPath}/FrontController?action=FinalizarPedido">Finalizar Pedido</a>
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