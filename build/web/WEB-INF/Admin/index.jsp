<%-- 
    Document   : index
    Created on : 22/09/2017, 13:49:02
    Author     : Automateasy
--%>

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
                <a class="brand-logo center search-prefix" href="">
                    PAINEL ADMINISTRATIVO
                </a>
            </div>
        </nav>
        <div class="card">
            <div class="card-content">
                <div class="row">
                    <div class="col s6">
                        <div class="card">
                            <div class="card-content">
                                <span class="card-title center">Produtos</span>
                                <div class="row">
                                    <div class="col s6 center">
                                        <h5>Alterar produto</h5>
                                        <div class="input-field col s12">
                                            <select name="produto-codigo">
                                                <c:forEach var="produto" items="${produtos}">
                                                    <option value="${produto.codigo}">${produto.titulo}</option>
                                                </c:forEach>
                                            </select>
                                            <label>Selecione o produto</label>
                                        </div>
                                        <a href="#"><i class="small yellow-text text-darken-2 material-icons left">edit</i></a>
                                        <a href="#"><i class="small red-text text-darken-4 material-icons right">clear</i></a>
                                    </div>
                                    <div class="col s6 center">
                                        <h5>Adicionar produto</h5>
                                        <form action="${pageContext.request.contextPath}/FrontController?action=RegistrarProduto" method="post">
                                            <div class="row form-margin-0">
                                                <div class="input-field col s8">
                                                  <input name="titulo" type="text" class="form-input form-margin-0">
                                                  <label for="titulo" class="form-input-label">Titulo</label>
                                                </div>
                                                <div class="input-field col s4">
                                                  <input name="qtd" type="number" class="form-input form-margin-0">
                                                  <label for="qtd" class="form-input-label">Quantidade</label>
                                                </div>
                                            </div>
                                            <div class="row form-margin-0">
                                                <div class="input-field col s12">
                                                    <textarea name="descricao" class="materialize-textarea form-input form-margin-0"></textarea>
                                                    <label for="descricao" class="form-input-label">Descricao</label>
                                                </div>
                                            </div>
                                            <div class="row form-margin-0">
                                                <div class="input-field col s6">
                                                  <input name="marca" type="text" class="form-input form-margin-0">
                                                  <label for="marca" class="form-input-label">Marca</label>
                                                </div>
                                                <div class="input-field col s6">
                                                  <input name="preco" type="number" class="form-input form-margin-0">
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
                    <div class="col s6">
                        <div class="card">
                            <div class="card-content">
                                <span class="card-title center">Pedidos</span>
                                <div class="row">
                                    <div class="col s12 center">
                                        <h5>Alterar estado do Pedido</h5>
                                        <form action="" method="">
                                            <div class="input-field col s12">
                                                <select name="pedido-codigo">
                                                    <c:forEach var="pedido" items="${pedidos}">
                                                        <option value="${pedido.codigo}">Codigo:${pedido.codigo} | Produto: ${pedido.produto.titulo} | Preço: ${pedido.preco} | Quantidade: ${pedido.quantidade} | Estado: ${pedido.estado.estado()}</option>
                                                    </c:forEach>
                                                </select>
                                                <label>Selecione o produto</label>
                                            </div>
                                            <div class="input-field col s6">
                                                <select name="estado">
                                                    <option value="analise">Em Atraso</option>
                                                    <option value="separacao">Em Separação</option>
                                                    <option value="cancelado">Cancelado</option>
                                                    <option value="enviado">Enviado</option>
                                                </select>
                                                <label>Selecione o produto</label>
                                            </div>
                                            <div class="col s12">
                                                <input type="submit" class="btn btn-login-form black-color" value="Alterar">
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
        </script>
    </body>
</html>
