<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <c:import url="../Shared/importCss.jsp" />
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
                                <form action="${pageContext.request.contextPath}/FrontController?action=Logar" method="post" class="col s12">
                                    <div class="row form-margin-0">
                                        <div class="input-field col s8 offset-s2">
                                            <input name="email_login" type="email" class="form-input" required="true">
                                            <label for="email_login" class="form-input-label">Email:</label>
                                        </div>
                                    </div>
                                    <div class="row form-margin-0">
                                        <div class="input-field col s8 offset-s2">
                                            <input name="senha_login" type="password" required="true" class="form-input">
                                            <label for="senha_login" class="form-input-label">Senha:</label>
                                        </div>
                                    </div>
                                    <div class="row form-margin-0">
                                        <div class="input-field col s4 offset-s2">
                                            <input id="btn-login" type="submit" class="btn btn-login-form black-color" value="Entrar">
                                        </div>
                                    </div>
                                </form>
                                <label class="red-text">${errorLogin}</label>
                            </div>
                            <div id="registro" class="row">
                                <form id="form-registro" action="${pageContext.request.contextPath}/FrontController?action=RegistrarUsuario" method="post" class="col s12">
                                    <div class="row form-margin-0">
                                        <div class="input-field col s6">
                                            <input name="nome_login" type="text" class="form-input" required="true">
                                            <label for="nome_login" class="form-input-label">Nome:</label>
                                        </div>
                                        <div class="input-field col s6">
                                            <input name="email_login" type="email" required="true" class="form-input">
                                            <label for="email_login" class="form-input-label">Email:</label>
                                        </div>
                                    </div>
                                    <div class="row form-margin-0">
                                        <div class="input-field col s6">
                                            <input name="senha_login" type="password" class="form-input" required="true">
                                            <label for="senha_login" class="form-input-label">Senha:</label>
                                        </div>
                                        <div class="input-field col s6">
                                            <input name="senha2" type="password" required="true" class="form-input">
                                            <label for="senha" class="form-input-label">Repita a senha:</label>
                                        </div>
                                    </div>
                                    <div class="row form-margin-0">
                                        <div class="input-field col s12">
                                            <textarea name="endereco_login" class="materialize-textarea form-input"></textarea>
                                            <label for="endereco_login" class="form-input-label">Endereço:</label>
                                        </div>
                                    </div>
                                    <div class="row form-margin-0">
                                        <div class="input-field col s6">
                                            <input name="telefone_login" type="number" class="form-input" >
                                            <label for="telefone_login" class="form-input-label">Telefone:</label>
                                        </div>
                                        <div class="input-field col s6">
                                            <input id="btn-login" type="submit" class="btn btn-login-form black-color" value="Registrar">
                                        </div>
                                    </div>
                                </form>
                                <label class="red-text">${error}</label>
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
