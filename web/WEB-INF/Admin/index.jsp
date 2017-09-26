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
                    PAINEL ADMINISTRATIVO
                </a>
                <a href="${pageContext.request.contextPath}/index" class="tooltipped"data-position="bottom" data-delay="50" data-tooltip="Voltar">
                    <i class="material-icons prefix right search-prefix">exit_to_app</i>
                </a>
            </div>
        </nav>
        <div class="card">
            <div class="card-content">
                <div class="row">
                    <div class="col s7">
                        <div class="card">
                            <div class="card-content">
                                <span class="card-title center">Produtos</span>
                                <div class="row">
                                    <div class="col s6 center">
                                        <c:if test="${produto == null}">
                                            <div class="row">
                                                <div class="col s12">
                                                    <h5>Alterar produto</h5>
                                                    <form action="${pageContext.request.contextPath}/FrontController?action=SelecionarProduto" method="post">
                                                        <div class="input-field col s10">
                                                            <select name="produto-codigo">
                                                                <c:forEach var="produto" items="${produtos}">
                                                                    <option value="${produto.codigo}">${produto.titulo}</option>
                                                                </c:forEach>
                                                            </select>
                                                            <label>Selecione o produto</label>
                                                        </div>
                                                        <input type="submit" class="btn btn-login-form black-color" value="Editar">
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
                                                                <option value="hardware">Hardware</option>
                                                                <option value="software">Software</option>
                                                                <option value="periferico">Periférico</option>
                                                            </select>
                                                            <label>Categoria</label>
                                                        </div>
                                                        <div class="input-field col s6">
                                                            <select name="produto-sub-categoria">
                                                                <option value="placa_mae">Placa Mae</option>
                                                                <option value="memoria_ram">Memoria RAM</option>
                                                                <option value="processador">Processadores</option>
                                                                <option value="vga">Placa de Video</option>
                                                                <option value="hd">Disco Ridigo (HD)</option>
                                                                <option value="ssd">SSD</option>
                                                            </select>
                                                            <label>Sub-Categoria</label>
                                                        </div>
                                                    </div>
                                                    <div class="row">
                                                        <input type="submit" class="btn btn-login-form black-color" value="Alterar">
                                                    </div>
                                                </form>
                                            </c:if>
                                        </div>
                                    </div>
                                    <div class="col s6 center">
                                        <h5>Adicionar produto</h5>
                                        <form action="${pageContext.request.contextPath}/FrontController?action=RegistrarProduto" method="post">
                                            <div class="row form-margin-0">
                                                <div class="input-field col s8">
                                                    <input name="titulo" type="text" class="form-input form-margin-0" required="true">
                                                    <label for="titulo" class="form-input-label">Titulo</label>
                                                </div>
                                                <div class="input-field col s4">
                                                    <input id="qtd-num" name="qtd" type="number" class="form-input form-margin-0" onblur="validarQuantidade(this)" required="true">
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
                                                        <option value="hardware">Hardware</option>
                                                        <option value="software">Software</option>
                                                        <option value="periferico">Periférico</option>
                                                    </select>
                                                    <label>Categoria</label>
                                                </div>
                                                <div class="input-field col s6">
                                                    <select name="produto-sub-categoria">
                                                        <option value="placa_mae">Placa Mae</option>
                                                        <option value="memoria_ram">Memoria RAM</option>
                                                        <option value="processador">Processadores</option>
                                                        <option value="vga">Placa de Video</option>
                                                        <option value="hd">Disco Ridigo (HD)</option>
                                                        <option value="ssd">SSD</option>
                                                    </select>
                                                    <label>Sub-Categoria</label>
                                                </div>
                                            </div>
                                            <div class="row">
                                                <input type="submit" class="btn btn-login-form black-color" value="Cadastrar">
                                            </div>
                                        </form>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col s5">
                        <div class="card">
                            <div class="card-content">
                                <span class="card-title center">Pedidos</span>
                                <div class="row">
                                    <div class="col s12 center">
                                        <h5>Alterar estado do Pedido</h5>
                                        <form action="${pageContext.request.contextPath}/FrontController?action=AlterarEstadoPedido" method="post">
                                            <div class="input-field col s12">
                                                <select name="pedido-codigo">
                                                    <c:forEach var="pedido" items="${pedidos}">
                                                        <option value="${pedido.codigo}">Codigo:${pedido.codigo} | Preço: ${pedido.preco} | Estado: ${pedido.estado.estado()}</option>
                                                    </c:forEach>
                                                </select>
                                                <label>Selecione o pedido</label>
                                            </div>
                                            <div class="input-field col s6">
                                                <select name="estado">
                                                    <option value="analise">Em Análise</option>
                                                    <option value="atraso">Em Atraso</option>
                                                    <option value="separacao">Em Separação</option>
                                                    <option value="cancelado">Cancelado</option>
                                                    <option value="enviado">Enviado</option>
                                                </select>
                                                <label>Selecione o estado</label>
                                            </div>
                                            <div class="col s12">
                                                <input type="submit" class="btn btn-login-form black-color" value="Alterar">
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
        </div>
        <div class="card">
            <div class="card-content">
                <div class="row">
                    <div class="col s7">
                        <div class="card">
                            <div class="card-content">
                                <span class="card-title center">Promoções</span>
                                <div class="row">
                                    <div class="col s6 center">
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
                                        </form>
                                    </div>
                                    <div class="col s6 center">
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
                                                    <input type="submit" class="btn btn-login-form black-color" style="margin-top: 20px;" value="Adicionar">
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
        <c:import url="../../Shared/importJs.jsp"/>
        <script>
            $(document).ready(function() {
                $('select').material_select();
            });
            function validarPreco(self){
                if(self.value == "")
                    return;
                if(!isNormalInteger(self.value)){
                    Materialize.toast('Preço inválido!', 2000) ;
                    self.value = "";
                }
            }
            function validarQuantidade(self){
                if(self.value == "")
                    return;
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
