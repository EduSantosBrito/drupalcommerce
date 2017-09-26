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
                                                                <td class="padding-0">
                                                                    <c:if test="${item.produto.promocao != null}">
                                                                        Desconto: ${item.produto.promocao.getDesconto()}%
                                                                    </c:if>
                                                                </td>
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
                                        <c:if test="${usuario.carrinho.itens.size() != '0' && usuario != null}">
                                            <a class="btn btn-produto-compra black-color right modal-trigger" href="#modalCompra">Finalizar Compra</a>
                                        </c:if>
                                    </ul>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!--MODAL COMPRA-->
        <div id="modalCompra" class="modal modal-fixed-footer">
            <div class="modal-content">
                <div class="row">
                    <div class="col s12">
                        <h4>Pagamento</h4>
                        <hr />
                    </div>
                </div>
                <div class="row">
                    <div class="col s12">
                        <h5>Boleto Bancário</h5>
                        <h6>15% de desconto R$ ${usuario.carrinho.total - (usuario.carrinho.total * 0.15)}</h6>
                        <a class="btn btn-produto-compra black-color" href="${pageContext.request.contextPath}/FrontController?action=FinalizarPedido&AMP;pagamento=Boleto">Pagar no boleto</a>
                        <hr/>
                    </div>
                    
                    <div class="col s12">
                        <div class="row">
                            <div class="col s5">
                                <h5>Cartão de Crédito</h5>
                                <h6>À vista com até 10% de desconto, 2x ou 3x com até 5% de desconto</h6>
                            </div>
                            <form action="${pageContext.request.contextPath}/FrontController?action=FinalizarPedido" method="post" >
                                <div class="col s7">
                                    <div class="row form-margin-0">
                                        <div class="input-field col s12">
                                            <select name="pagamento">
                                              <option value="CartaoUma">À vista - 10% desconto R$ ${usuario.carrinho.total - (usuario.carrinho.total * 0.10)}</option>
                                              <option value="CartaoDuas">2x - 5% desconto R$ ${(usuario.carrinho.total - (usuario.carrinho.total * 0.05)) / 2}</option>
                                              <option value="CartaoTres">3x - 5% desconto R$ ${Math.round((usuario.carrinho.total - (usuario.carrinho.total * 0.05)) / 3)}.0</option>
                                            </select>
                                            <label class="form-input-label">Forma de pagamento*</label>
                                        </div>
                                    </div>
                                    <div class="row form-margin-0">
                                        <div class="input-field col s12">
                                            <input name="nome-cartao" type="text" class="form-input form-margin-0">
                                            <label for="nome-cartao" class="form-input-label">Nome* </label>
                                        </div>
                                    </div>
                                    <div class="row form-margin-0">
                                        <div class="input-field col s12">
                                            <input name="numero-cartao" type="number" class="form-input form-margin-0">
                                            <label for="numero-cartao" class="form-input-label">Número* </label>
                                        </div>
                                    </div>
                                    <div class="row form-margin-0">
                                        <div class="input-field col s4">
                                            <input name="validade-mes-cartao" type="number" class="form-input form-margin-0">
                                            <label for="validade-mes-cartao" class="form-input-label">Validade mês </label>
                                        </div>
                                        <div class="input-field col s4">
                                            <input name="validade-dia-cartao" type="number" class="form-input form-margin-0">
                                            <label for="validade-dia-cartao" class="form-input-label">Validade dia </label>
                                        </div>
                                    </div>
                                    <div class="row form-margin-0">
                                        <div class="input-field col s6">
                                            <input name="codigo-cartao" type="number" class="form-input form-margin-0">
                                            <label for="codigo-cartao" class="form-input-label">Código de segurança </label>
                                        </div>
                                    </div>
                                    <div class="row form-margin-0">
                                        <div class="input-field col s12">
                                            <input name="cpf-cartao" type="number" class="form-input form-margin-0">
                                            <label for="cpf-cartao" class="form-input-label">CPF do proprietário </label>
                                        </div>
                                    </div>
                                    <div class="row form-margin-0">
                                        <div class="input-field col s4">
                                            <input name="dia-cartao" type="number" class="form-input form-margin-0">
                                            <label for="validade-mes-cartao" class="form-input-label">Dia nascimento</label>
                                        </div>
                                        <div class="input-field col s4">
                                            <input name="mes-cartao" type="number" class="form-input form-margin-0">
                                            <label for="mes-cartao" class="form-input-label">Mês nascimento</label>
                                        </div>
                                        <div class="input-field col s4">
                                            <input name="ano-cartao" type="number" class="form-input form-margin-0">
                                            <label for="ano-cartao" class="form-input-label">Ano nascimento</label>
                                        </div>
                                    </div>
                                    <input class="btn btn-produto-compra right black-color"  type="submit" value="Pagar no cartão">
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>         
        <c:import url="../Shared/rodape.jsp"/>
        <c:import url="../Shared/importJs.jsp"/>
        <script>
            $( document ).ready(function() {
                $('.modal').modal();
                $('select').material_select();
            });
        </script>
    </body>
</html>