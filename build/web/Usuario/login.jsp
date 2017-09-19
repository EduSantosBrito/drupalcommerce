<%-- 
    Document   : registro
    Created on : 19/09/2017, 13:04:21
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
        <div id="login-registro" class="">
            <div class="row center">
                <div class="col s6 offset-s3">
                    <div class="card black-color">
                        <div class="card-content white-text card-login-content">
                            Bem vindo ao Virtual Shop!
                            <hr />
                        </div>
                        <div class="card-tabs">
                            <ul class="tabs tabs-fixed-width black-color z-depth-1">
                                <li class="tab"><a href="#login">Logar</a></li>
                                <li class="tab"><a href="#registro">Registrar</a></li>
                            </ul>
                        </div>
                        <div class="card-content white card-login-tab">
                            <div id="login" class="row">
                                <form id="form-login" action="" method="post" class="col s12">
                                    <div class="row form-margin-0">
                                        <div class="input-field col s8 offset-s2">
                                            <input id="email" type="email" class="form-input" required="true">
                                            <label for="email" class="form-input-label">Email:</label>
                                        </div>
                                    </div>
                                    <div class="row form-margin-0">
                                        <div class="input-field col s8 offset-s2">
                                            <input id="senha" type="password" required="true" class="form-input">
                                            <label for="senha" class="form-input-label">Senha:</label>
                                        </div>
                                    </div>
                                    <div class="row form-margin-0">
                                        <div class="input-field col s4 offset-s2">
                                            <input id="btn-login" type="submit" class="btn btn-login-form black-color" value="Entrar">
                                        </div>
                                    </div>
                                </form>
                            </div>
                            <div id="registro" class="row">
                                <form id="form-registro" action="" method="post" class="col s12">
                                    <div class="row form-margin-0">
                                        <div class="input-field col s6">
                                            <input id="email" type="text" class="form-input" required="true">
                                            <label for="email" class="form-input-label">Nome:</label>
                                        </div>
                                        <div class="input-field col s6">
                                            <input id="senha" type="email" required="true" class="form-input">
                                            <label for="senha" class="form-input-label">Email:</label>
                                        </div>
                                    </div>
                                    <div class="row form-margin-0">
                                        <div class="input-field col s6">
                                            <input id="password" type="password" class="form-input" required="true">
                                            <label for="password" class="form-input-label">Senha:</label>
                                        </div>
                                        <div class="input-field col s6">
                                            <input id="password2" type="password" required="true" class="form-input">
                                            <label for="password2" class="form-input-label">Repita a senha:</label>
                                        </div>
                                    </div>
                                    <div class="row form-margin-0">
                                        <div class="input-field col s12">
                                            <textarea id="endereco" class="materialize-textarea form-input"></textarea>
                                            <label for="endereco" class="form-input-label">Endereço:</label>
                                        </div>
                                    </div>
                                    <div class="row form-margin-0">
                                        <div class="input-field col s6">
                                            <input id="telefone" type="number" class="form-input" >
                                            <label for="telefone" class="form-input-label">Telefone:</label>
                                        </div>
                                        <div class="input-field col s6">
                                            <input id="btn-login" type="submit" class="btn btn-login-form black-color" value="Registrar">
                                        </div>
                                    </div>
                                </form>
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
