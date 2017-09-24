<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<nav id="nav-bar-logo" class="navbar-fixed black-color z-depth-0">
    <div class="nav-wrapper">
        <a class="brand-logo center search-prefix" href="${pageContext.request.contextPath}/index">
            <i class="material-icons left">cloud</i>Virtual Shop<i class="material-icons right">cloud</i>
        </a>
        <ul class="right">
        <li class="btn-cabecalho">
            <a href=""><i class="material-icons prefix search-prefix">search</i></a>
        </li>
        <li>
            <div class="input-field">
                <input placeholder="Pesquisar" class="search-menu-input" id="menu-search" type="text">
            </div>
        </li>
        <li class="btn-cabecalho">
            <c:if test = "${usuario == null}">
                <a href="" class="dropdown-button dropdown-button-login tooltipped" data-activates="dropdown-login" data-position="bottom" data-delay="50" data-tooltip="Login / Cadastro">
                    <i class="material-icons prefix search-prefix">account_circle</i>
                </a>
            </c:if>
            <c:if test = "${usuario != null}">
                <a href="${pageContext.request.contextPath}/FrontController?action=Deslogar" class="tooltipped" data-position="bottom" data-delay="50" data-tooltip="Sair">
                    <i class="material-icons prefix search-prefix">exit_to_app</i>
                </a>
            </c:if>
        </li>
        </ul>
    </div>
</nav>
<!--Dropdown login-->
<c:if test = "${usuario == null}">
    <div id="dropdown-login" class="dropdown-content black-color">
        <form action="${pageContext.request.contextPath}/FrontController?action=Logar" method="post" class="col s12">
            <div class="row login-row-none">
                <div class="input-field col s12">
                    <input name="email_login" type="email" class="login-input-margin" required="true">
                  <label for="email_login" class="login-input-label">Email:</label>
                </div>
                <div class="input-field col s12">
                  <input name="senha_login" type="password" class="login-input-margin" required="true">
                  <label for="senha_login" class="login-input-label">Senha</label>
                </div>
            </div>
            <div class="row login-row-none right">
                <div class="col s8">
                    <label>Ainda nao possui uma conta?<a href="${pageContext.request.contextPath}/Usuario/login.jsp" class="login-cadastro side-menu-small-li-hover" > CADASTRE-SE</a></label>
                </div>
                <div class="col s4">
                    <input type="submit" class="btn white black-text btn-login" value="Entrar">
                </div>
            </div>
        </form>
    </div>
</c:if>