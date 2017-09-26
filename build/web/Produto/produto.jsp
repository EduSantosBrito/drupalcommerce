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
        <div id="produto" class="">
            <div class="row">
                <div class="col s12">
                    <div class="card black-color content-margin-left">
                        <div class="card-content padding-0">
                            <label class="usuario-perfil-titulo white-text">${produto.titulo}</label>
                            <hr class="usuario-perfil-titulo-hr"/>
                        </div>
                        <div class="card-content white">
                            <div class="row">
                                <div class="col s4">
                                    <div class="card">
                                        <div class="card-image">
                                            <img src="${pageContext.request.contextPath}/Shared/pic.jpg" style="width: 100%; height: 400px;" class="z-depth-1">
                                        </div>
                                        <div class="card-content padding-5 card-produto-h">
                                            <div class="row form-margin-0">
                                                <div class="col s6">
                                                    <b>Preço:</b> ${produto.preco}
                                                </div>
                                                <div class="col s6">
                                                    <b>Em estoque:</b> ${produto.quantidade}
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="col s8">
                                    <div class="card">
                                        <div class="card-content z-depth-1" style="min-height: 400px;">
                                            <div class="row">
                                                <b>Marca:</b> ${produto.marca}
                                            </div>
                                            <div class="row">
                                                <b>Desrição:</b> ${produto.descricao}
                                            </div>
                                            <c:if test="${produto.promocao != null}">
                                                <div class="row">
                                                    <b>Promoção:</b> ${produto.promocao.getDescricaoPromocao()}
                                                </div>
                                            </c:if>
                                        </div>
                                        <div class="card-content padding-5 card-produto-h">
                                            <c:if test="${usuario != null}">
                                                <form action="${pageContext.request.contextPath}/FrontController?action=AdicionarCarrinho" method="post">
                                                    <div class="row form-margin-0">
                                                        <div class="col s6">
                                                            <label class="produto-quantidade">Quantidade: </label>
                                                            <input name="qtd-prod" type="number" class="produto-qtd-compra" onblur="validarQuantidade(this)" required="true">
                                                        </div>
                                                        <div class="col s6">
                                                            <c:if test="${produto.quantidade > 0}">
                                                                <input type="hidden" name="cod-produto" value="${produto.codigo}">
                                                                <input type="submit" class="btn btn-produto-compra black-color right" value="Adicionar Carrinho!">
                                                            </c:if>
                                                            <c:if test="${produto.quantidade == 0}">
                                                                    <a type="submit" class="btn btn-produto-compra black-color right" href="${pageContext.request.contextPath}/FrontController?action=InteresseProduto&AMP;id=${produto.codigo}">Produto indisponível, Avise-me</a>
                                                            </c:if>
                                                        </div>
                                                    </div>
                                                </form>
                                            </c:if>
                                            <c:if test="${usuario == null}">
                                                <div class="row form-margin-0">
                                                    <div class="col s6">
                                                        <label class="produto-quantidade">Entre para comprar!</label>
                                                    </div>
                                                </div>
                                            </c:if>
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
        <c:import url="../Shared/importJs.jsp"/>
        <script>
            function validarQuantidade(self){
                if(!isNormalInteger(self.value)){
                    Materialize.toast('Quantidade inválida!', 2000) ;
                    self.value = "";
                }
            }
            function isNormalInteger(str) {
                return /^\+?(0|[1-9]\d*)$/.test(str);
            }
        </script>
    </body>
</html>
