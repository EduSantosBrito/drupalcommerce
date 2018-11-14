<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div id="small-navbar" class="side-menu-small black-color">
    <ul class="center">
        <li class="btn-cabecalho tooltipped" data-position="right" data-delay="50" data-tooltip="Expandir menu">
            <a id="small-bar" href="#">
                <i class="small white-text material-icons side-menu-small-li-hover icon-margin">keyboard_arrow_right</i>
            </a>
        </li>
        <li class="btn-cabecalho tooltipped" data-position="right" data-delay="50" data-tooltip="Inicio">
            <a href="${pageContext.request.contextPath}/index">
                <i class="white-text material-icons side-menu-small-li-hover icon-margin">home</i>
            </a>
        </li>
        <li class="btn-cabecalho tooltipped" data-position="right" data-delay="50" data-tooltip="Conta">
            <a href="${pageContext.request.contextPath}/FrontController?action=VerificarAutenticacao&AMP;pagina=perfil">
                <i class="white-text material-icons side-menu-small-li-hover icon-margin">account_circle</i>
            </a>
        </li>
        <li class="btn-cabecalho tooltipped" data-position="right" data-delay="50" data-tooltip="Expandir categorias">
            <a class="dropdown-button" href="#" data-activates="dropdown-produtos-small" >
                <i class="white-text material-icons side-menu-small-li-hover icon-margin">shop</i>
            </a>
        </li>
        <li class="btn-cabecalho tooltipped" data-position="right" data-delay="50" data-tooltip="Carrinho">
            <a href="${pageContext.request.contextPath}/Pedido/carrinho.jsp">
                <i class="white-text material-icons side-menu-small-li-hover icon-margin">shopping_cart</i>
            </a>
        </li>
    </ul>
</div>

<div id="large-navbar" class="side-menu-large black-color hide-on-med-and-down z-depth-2">
    <ul class="">
        <li class="side-menu-large-li-hover tooltipped" data-position="right" data-delay="50" data-tooltip="Diminuir menu">
            <a id="large-bar" href="#" class="white-text large-arrow-left ">
                <i class="small material-icons side-menu-small-li-hover icon-margin">keyboard_arrow_left</i>
            </a>
        </li>
        <c:if test="${usuario.email == 'aaa@gmail.com'}">
            <li>
                <a href="${pageContext.request.contextPath}/FrontController?action=VerificarAutenticacao&AMP;pagina=admin" class="white-text black-color collapsible-header side-menu-large-li-hover side-menu-small-li-hover">
                    <i class="material-icons">build</i> PAINEL ADM
                </a>
            </li>
        </c:if>
        <li>
            <a href="${pageContext.request.contextPath}/index" class="white-text black-color collapsible-header side-menu-large-li-hover side-menu-small-li-hover">
                <i class="material-icons">home</i> INICIO
            </a>
        </li>
        <li>
            <ul class="collapsible collapsible-accordion collapsible-drop-categorias">
                <li>
                    <a class="collapsible-header white-text black-color side-menu-large-li-hover side-menu-small-li-hover">
                        <i class="material-icons">account_circle</i>CONTA
                        <i class="material-icons">arrow_drop_down</i>
                    </a>
                    <div class="collapsible-body white collapsible-drop-categorias">
                        <ul class="">
                            <li class="collapsible-drop-categorias-label">
                                <a href="${pageContext.request.contextPath}/FrontController?action=VerificarAutenticacao&AMP;pagina=perfil" class="collapsible-header white-text black-color side-menu-large-li-hover side-menu-small-li-hover">
                                    Perfil
                                </a>
                            </li>
                            <li class="collapsible-drop-categorias-label">
                                <a href="${pageContext.request.contextPath}/FrontController?action=VerificarAutenticacao&AMP;pagina=VisualizarPedido" class="collapsible-header white-text black-color side-menu-large-li-hover side-menu-small-li-hover">
                                    Pedidos
                                </a>
                            </li>
                        </ul>
                    </div>
                </li>
            </ul>
        </li>
        <li>
            <ul class="collapsible collapsible-accordion collapsible-drop-categorias">
                <li>
                    <a class="collapsible-header white-text black-color side-menu-large-li-hover side-menu-small-li-hover">
                        <i class="material-icons">shop</i>CATEGORIAS
                        <i class="material-icons">arrow_drop_down</i>
                    </a>
                    <div class="collapsible-body white collapsible-drop-categorias">
                        <ul class="">
                            <li class="collapsible-drop-categorias-label">
                                <ul class="collapsible collapsible-drop-categorias">
                                    <li>
                                        <a class="collapsible-header white-text black-color side-menu-large-li-hover side-menu-small-li-hover">
                                            Comida<i class="material-icons">arrow_drop_down</i>
                                        </a>
                                        <div class="collapsible-body gray-color collapsible-drop-categorias">
                                            <ul>
                                                <a class="white-text" href="${pageContext.request.contextPath}/FrontController?action=ListaProdutosSubCategoria&AMP;subCategoria=HAMBURGER">
                                                    <li class="dropdown-menu-hover-right collapsible-drop-categorias-label">
                                                        Hamburguer
                                                    </li>
                                                </a>
                                        </div>         
                                    </li>
                                </ul>
                            </li>
                        </ul>
                    </div>
                </li>
            </ul>
        </li>
        <li>
            <ul class="collapsible collapsible-accordion collapsible-drop-categorias">
                <li>
                    <a class="collapsible-header white-text black-color side-menu-large-li-hover side-menu-small-li-hover">
                        <i class="material-icons">shopping_cart</i>CARRINHO
                        <i class="material-icons">arrow_drop_down</i>
                    </a>
                    <div class="collapsible-body white collapsible-drop-categorias">
                        <ul>
                            <c:forEach var="item" items="${usuario.carrinho.itens}">
                                <li class="collapsible-drop-categorias-label">
                                    <ul class="z-depth-2">
                                        <li>
                                            <a class="collapsible-header white-text black-color side-menu-large-li-hover side-menu-small-li-hover padding-5">
                                                <p>${item.produto.titulo}</p>
                                            </a>
                                        </li>
                                    </ul>
                                </li>
                            </c:forEach>
                            <li class="collapsible-drop-categorias-label">
                                <a class="btn black-color btn-finalizar side-menu-small-li-hover">Total: ${usuario.carrinho.total}</a>
                            </li>
                            <li class="collapsible-drop-categorias-label">
                                <a href="${pageContext.request.contextPath}/Pedido/carrinho.jsp" class="btn black-color btn-finalizar side-menu-small-li-hover">Finalizar compras!</a>
                            </li>
                        </ul>
                    </div>
                </li>
            </ul>
        </li>
    </ul>
</div>

<ul id="dropdown-produtos-small" class="collapsible dropdown-content dropdown-menu" data-collapsible="accordion">
    <li class="collapsible-drop-size">
        <div class="collapsible-header black-color white-text collapsible-drop-title side-menu-small-li-hover">
            Comida
            <i class="material-icons">arrow_drop_down</i>
        </div>
        <div class="collapsible-body collapsible-drop-categorias">
            <ul class="gray-color">
                <a href="${pageContext.request.contextPath}/FrontController?action=ListaProdutosSubCategoria&AMP;subCategoria=HAMBURGER">
                    <li class="dropdown-menu-hover white-text collapsible-drop-categorias-label">Hamburguer</li>
                </a>
            </ul>
        </div>
    </li>
</ul>