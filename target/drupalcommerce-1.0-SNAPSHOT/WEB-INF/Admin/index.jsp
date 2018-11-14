<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <c:import url="../../Shared/importCss.jsp"/>
    </head>
    <body class="gray-color">
        <nav id="nav-bar-logo" class="navbar-fixed black-color z-depth-0">
            <div class="nav-wrapper">
                <a class="brand-logo center search-prefix" href="${pageContext.request.contextPath}/FrontController?action=VerificarAutenticacao&AMP;pagina=admin" >
                    AREA ADMINISTRATIVA
                </a>
                <a href="${pageContext.request.contextPath}/index" class="tooltipped" data-position="bottom" data-delay="50" data-tooltip="Voltar">
                    <i class="material-icons prefix right search-prefix">exit_to_app</i>
                </a>
            </div>
        </nav>
        <div class="card">
            <div class="card-content padding-5">
                <div class="row">
                    <div class="col m2">
                        <ul class="tabs tabs-vertical black-color">
                            <li class="tab tab-vertical"><a href="#divProduto">Produto</a></li>
                            <li class="tab tab-vertical"><a href="#divPedido">Pedido</a></li>
                            <li class="tab tab-vertical"><a href="#divPromocao">Promoção</a></li>
                        </ul>
                    </div>
                    <div class="col m10 padding-0">
                        <div id="divProduto" class="col tab-content tab-content-vertical padding-0">
                            <div class="row">
                                <div class="col s12">
                                    <div class="card">
                                        <div class="card-content">
                                            <span class="card-title center">Produtos</span>
                                            <div class="row">
                                                <div class="col s4 center">
                                                    <c:if test="${produto == null}">
                                                        <div class="row">
                                                            <div class="col s12">
                                                                <h5>Alterar produto</h5>
                                                                <form action="${pageContext.request.contextPath}/FrontController?action=SelecionarProduto" method="post">
                                                                    <div class="row">
                                                                        <div class="input-field col s12">
                                                                            <select name="produto-codigo">
                                                                                <c:forEach var="produto" items="${produtos}">
                                                                                    <option value="${produto.codigo}">${produto.titulo}</option>
                                                                                </c:forEach>
                                                                            </select>
                                                                            <label>Selecione o produto</label>
                                                                        </div>
                                                                    </div>
                                                                    <div class="row">
                                                                        <div class="col s6">
                                                                            <input type="submit" class="btn btn-login-form black-color" value="Editar">
                                                                        </div>
                                                                    </div>
                                                                    <div class="col s12">
                                                                        <label class="red-text">${erroSelecaoProduto}</label>
                                                                    </div>
                                                                </form>
                                                            </div>
                                                        </div>
                                                    </c:if>
                                                    <div class="row">
                                                        <c:if test="${produto != null}">
                                                            <h5>Alterar produto</h5>
                                                            <form action="${pageContext.request.contextPath}/FrontController?action=AlterarProduto" method="post">
                                                                <input type="hidden" value="${produto.codigo}" name="codigo-produto">
                                                                <div class="row form-margin-0">
                                                                    <div class="input-field col s8">
                                                                        <input name="titulo" type="text" class="form-input form-margin-0" value="${produto.titulo}" required="true">
                                                                        <label for="titulo" class="form-input-label">Titulo</label>
                                                                    </div>
                                                                    <div class="input-field col s4">
                                                                        <input name="qtd" type="number" class="form-input form-margin-0" value="${produto.quantidade}" onblur="validarQuantidade(this)" required="true">
                                                                        <label for="qtd" class="form-input-label">Quantidade</label>
                                                                    </div>
                                                                </div>
                                                                <div class="row form-margin-0">
                                                                    <div class="input-field col s12">
                                                                        <textarea name="descricao" class="materialize-textarea form-input form-margin-0" required="true">${produto.descricao}</textarea>
                                                                        <label for="descricao" class="form-input-label">Descricao</label>
                                                                    </div>
                                                                </div>
                                                                <div class="row form-margin-0">
                                                                    <div class="input-field col s6">
                                                                        <input name="marca" type="text" class="form-input form-margin-0" value="${produto.marca}" required="true">
                                                                        <label for="marca" class="form-input-label">Marca</label>
                                                                    </div>
                                                                    <div class="input-field col s6">
                                                                        <input name="preco" type="number" class="form-input form-margin-0" value="${produto.preco}" required="true" onblur="validarPreco(this)">
                                                                        <label for="preco" class="form-input-label">Preço</label>
                                                                    </div>
                                                                </div>
                                                                <div class="row form-margin-0">
                                                                    <div class="input-field col s6">
                                                                        <select name="produto-categoria">
                                                                            <option value="comida">Comida</option>
                                                                        </select>
                                                                        <label>Categoria</label>
                                                                    </div>
                                                                    <div class="input-field col s6">
                                                                        <select name="produto-sub-categoria">
                                                                            <option value="HAMBURGER">Hamburguer</option>
                                                                        </select>
                                                                        <label>Sub-Categoria</label>
                                                                    </div>
                                                                </div>
                                                                <div class="row">
                                                                    <div class="col s6">
                                                                        <input type="submit" class="btn btn-login-form black-color" value="Alterar">
                                                                    </div>
                                                                </div>
                                                            </form>
                                                        </c:if>
                                                    </div>
                                                </div>
                                                <div class="col s4 center">
                                                    <h5>Adicionar produto</h5>
                                                    <form action="${pageContext.request.contextPath}/FrontController?action=RegistrarProduto" method="post">
                                                        <div class="row form-margin-0">
                                                            <div class="input-field col s8">
                                                                <input name="titulo" type="text" class="form-input form-margin-0" required="true">
                                                                <label for="titulo" class="form-input-label">Titulo</label>
                                                            </div>
                                                            <div class="input-field col s4">
                                                                <input id="qtd" name="qtd" type="number" class="form-input form-margin-0" onblur="validarQuantidade(this)" required="true">
                                                                <label for="qtd" class="form-input-label">Quantidade</label>
                                                            </div>
                                                        </div>
                                                        <div class="row form-margin-0">
                                                            <div class="input-field col s12">
                                                                <textarea name="descricao" class="materialize-textarea form-input form-margin-0" required="true"></textarea>
                                                                <label for="descricao" class="form-input-label">Descricao</label>
                                                            </div>
                                                        </div>
                                                        <div class="row form-margin-0">
                                                            <div class="input-field col s6">
                                                                <input name="marca" type="text" class="form-input form-margin-0" required="true">
                                                                <label for="marca" class="form-input-label">Marca</label>
                                                            </div>
                                                            <div class="input-field col s6">
                                                                <input name="preco" type="number" class="form-input form-margin-0" required="true" onblur="validarPreco(this)">
                                                                <label for="preco" class="form-input-label">Preço</label>
                                                            </div>
                                                        </div>
                                                        <div class="row form-margin-0">
                                                            <div class="input-field col s6">
                                                                <select name="produto-categoria">
                                                                    <option value="comida">Comida</option>
                                                                </select>
                                                                <label>Categoria</label>
                                                            </div>
                                                            <div class="input-field col s6">
                                                                <select name="produto-sub-categoria">
                                                                    <option value="HAMBURGER">Hamburguer</option>
                                                                </select>
                                                                <label>Sub-Categoria</label>
                                                            </div>
                                                        </div>
                                                        <div class="row">
                                                            <div class="col s6">
                                                                <input type="submit" class="btn btn-login-form black-color" value="Cadastrar">
                                                            </div>
                                                        </div>
                                                    </form>
                                                </div>
                                                <div class="col s4 center">
                                                    <h5>Remover produto</h5>
                                                    <form action="${pageContext.request.contextPath}/FrontController?action=RemoverProduto" method="post">
                                                        <div class="row">
                                                            <div class="input-field col s12">
                                                                <select name="produto-codigo">
                                                                    <c:forEach var="produto" items="${produtos}">
                                                                        <option value="${produto.codigo}">${produto.titulo}</option>
                                                                    </c:forEach>
                                                                </select>
                                                                <label>Selecione o produto</label>
                                                            </div>
                                                        </div>
                                                        <div class="row">
                                                            <div class="col s6">
                                                                <input type="submit" class="btn btn-login-form black-color" value="Remover">
                                                            </div>
                                                        </div>
                                                        <div class="col s12">
                                                            <label class="red-text">${erroRemocaoProduto}</label>
                                                        </div>
                                                    </form>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div id="divPedido" class="col tab-content tab-content-vertical padding-0">
                            <div class="row">
                                <div class="col s12">
                                    <div class="card">
                                        <div class="card-content">
                                            <span class="card-title center">Pedidos</span>
                                            <div class="row">
                                                <div class="col s7 center">
                                                    <h5>Alterar estado do Pedido</h5>
                                                    <form action="${pageContext.request.contextPath}/FrontController?action=AlterarEstadoPedido" method="post">
                                                        <div class="row">
                                                            <div class="input-field col s8">
                                                                <select name="pedido-codigo">
                                                                    <c:forEach var="pedido" items="${pedidos}">
                                                                        <option value="${pedido.codigo}">Codigo:${pedido.codigo} | Preço: ${pedido.preco} | Estado: ${pedido.estado.estado()}</option>
                                                                    </c:forEach>
                                                                </select>
                                                                <label>Selecione o pedido</label>
                                                            </div>
                                                            <div class="col s4" style="padding: 0;">
                                                                <i class="medium material-icons tooltipped" style="cursor: pointer;" onclick="retornarMemento()" data-position="left" data-delay="50" data-tooltip="Recuperar">navigate_before</i>
                                                                <i class="medium material-icons tooltipped" style="cursor: pointer;" onclick="avancarMemento()" data-position="right" data-delay="50" data-tooltip="Avançar">navigate_next</i>
                                                            </div>
                                                        </div>
                                                        <div class="row">
                                                            <div class="input-field col s6">
                                                                <select name="estado">
                                                                    <option value="Analise">Em Análise</option>
                                                                    <option value="Atraso">Em Atraso</option>
                                                                    <option value="Separacao">Em Separação</option>
                                                                    <option value="Cancelado">Cancelado</option>
                                                                    <option value="Enviado">Enviado</option>
                                                                </select>
                                                                <label>Selecione o estado</label>
                                                            </div>
                                                        </div>
                                                        <div class="row">
                                                            <div class="col s6">
                                                                <input type="submit" class="btn btn-login-form black-color" value="Alterar">
                                                            </div>
                                                        </div>
                                                        <div class="col s12">
                                                            <label class="red-text">${alteracaoEstado}</label>
                                                        </div>
                                                    </form>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div id="divPromocao" class="col tab-content tab-content-vertical padding-0">
                            <div class="row">
                                <div class="col s12">
                                    <div class="card">
                                        <div class="card-content">
                                            <span class="card-title center">Promoções</span>
                                            <div class="row">
                                                <div class="col s4 center">
                                                    <h5>Criar promoção</h5>
                                                    <form action="${pageContext.request.contextPath}/FrontController?action=AdicionarPromocao" method="post">
                                                        <div class="row form-margin-0">
                                                            <div class="input-field col s8">
                                                                <input name="titulo" type="text" class="form-input form-margin-0" required="true">
                                                                <label for="titulo" class="form-input-label">Titulo</label>
                                                            </div>
                                                            <div class="input-field col s4">
                                                                <input id="qtd-num" name="desconto" type="number" class="form-input form-margin-0" onblur="validarQuantidade(this)" required="true">
                                                                <label for="desconto" class="form-input-label">Desconto</label>
                                                            </div>
                                                        </div>
                                                        <div class="row">
                                                            <div class="col s6">
                                                                <input type="submit" class="btn btn-login-form black-color" style="margin-top: 20px;" value="Criar">
                                                            </div>  
                                                        </div>
                                                        <div class="col s12">
                                                            <label class="red-text">${erroInsercaoPromocao}</label>
                                                        </div>
                                                    </form>
                                                </div>
                                                <div class="col s4 center">
                                                    <h5>Adicionar promoção</h5>
                                                    <form action="${pageContext.request.contextPath}/FrontController?action=AdicionarPromocaoProduto" method="post">
                                                        <div class="row form-margin-0">
                                                            <div class="input-field col s6">
                                                                <select name="produto-codigo">
                                                                    <c:forEach var="produto" items="${produtos}">
                                                                        <option value="${produto.codigo}">${produto.titulo}</option>
                                                                    </c:forEach>
                                                                </select>
                                                                <label>Selecione o produto</label>
                                                            </div>
                                                            <div class="input-field col s6">
                                                                <select name="promocao-codigo">
                                                                    <c:forEach var="promocao" items="${promocoes}">
                                                                        <option value="${promocao.codigo}">${promocao.titulo}</option>
                                                                    </c:forEach>
                                                                </select>
                                                                <label>Selecione a promoção</label>
                                                            </div>
                                                        </div>
                                                        <div class="row">
                                                            <div class="col s6">
                                                                <input type="submit" class="btn btn-login-form black-color" value="Adicionar">
                                                            </div>  
                                                        </div>
                                                        <div class="col s12">
                                                            <label class="red-text">${erroAdicionarPromocao}</label>
                                                        </div>
                                                    </form>
                                                </div>
                                                <div class="col s4 center">
                                                    <h5>Remover promoção</h5>
                                                    <form action="${pageContext.request.contextPath}/FrontController?action=RemoverPromocaoProduto" method="post">
                                                        <div class="row form-margin-0">
                                                            <div class="input-field col s6">
                                                                <select name="produto-codigo">
                                                                    <c:forEach var="produto" items="${produtos}">
                                                                        <c:if test="${produto.promocao != null}">
                                                                            <option value="${produto.codigo}">${produto.titulo}</option>
                                                                        </c:if>
                                                                    </c:forEach>
                                                                </select>
                                                                <label>Selecione o produto</label>
                                                            </div>
                                                        </div>
                                                        <div class="row">
                                                            <div class="col s6">
                                                                <input type="submit" class="btn btn-login-form black-color" value="Remover">

                                                            </div>  
                                                        </div>
                                                        <div class="col s12">
                                                            <label class="red-text">${erroRemocaoPromocao}</label>
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
            </div>
        </div>
        <form style="display: hidden" action="${pageContext.request.contextPath}/FrontController?action=RetornarEstadoPedido" method="POST" id="formRetorno">
            <input type="hidden" id="idRetorno" name="idRetorno"/>
        </form>
        <form style="display: hidden" action="${pageContext.request.contextPath}/FrontController?action=AvancarEstadoPedido" method="POST" id="formAvanco">
            <input type="hidden" id="idAvanco" name="idAvanco"/>
        </form>
        <c:import url="../../Shared/importJs.jsp"/>
        <script>
            $(document).ready(function () {
                $('select').material_select();
            });
            const pedidoCodigo = $('select[name=pedido-codigo]').val();
            function retornarMemento(){
                
                $("#idRetorno").val(pedidoCodigo);
                $('#formRetorno').submit();
            }
            function avancarMemento(){
                var teste = $('select[name=pedido-codigo]').val();
                $("#idAvanco").val(pedidoCodigo);
                $('#formAvanco').submit();
            }
            function validarPreco(self) {
                if (self.value == "")
                    return;
                if (!isNormalInteger(self.value)) {
                    Materialize.toast('Preço inválido!', 2000);
                    self.value = "";
                }
            }
            function validarQuantidade(self) {
                if (self.value == "")
                    return;
                if (!isNormalInteger(self.value)) {
                    Materialize.toast('Quantidade inválida!', 2000);
                    self.value = "";
                }
            }
            function isNormalInteger(str) {
                return /^\+?(0|[1-9]\d*)$/.test(str);
            }
        </script>
    </body>
</html>
