<%-- 
    Document   : barraLateral
    Created on : 17/09/2017, 20:48:32
    Author     : sandr
--%>

<!--Barra lateral pequena-->
<div id="small-navbar" class="side-menu-small black-color hide-on-med-and-down">
    <ul class="center">
        <li>
            <a id="small-bar" href="#" class="tooltipped" data-position="right" data-delay="50" data-tooltip="Expandir menu">
                <i class="small white-text material-icons side-menu-small-li-hover">keyboard_arrow_right</i>
            </a>
        </li>
        <li>
            <a href="#" class="tooltipped" data-position="right" data-delay="50" data-tooltip="Inicio">
                <i class="white-text material-icons side-menu-small-li-hover">home</i>
            </a>
        </li>
        <li>
            <a href="#" class="tooltipped" data-position="right" data-delay="50" data-tooltip="Conta">
                <i class="white-text material-icons side-menu-small-li-hover">account_circle</i>
            </a>
        </li>
        <li>
            <a class="dropdown-button tooltipped" href="#" data-activates="dropdown-produtos-small" data-position="right" data-delay="50" data-tooltip="Expandir categorias">
                <i class="white-text material-icons side-menu-small-li-hover">shop</i>
            </a>
        </li>
        <li>
            <a href="#" class="tooltipped" data-position="right" data-delay="50" data-tooltip="Carrinho">
                <i class="white-text material-icons side-menu-small-li-hover">shopping_cart</i>
            </a>
        </li>
    </ul>
</div>

<!--Barra lateral grande-->
<div id="large-navbar" class="side-menu-large black-color hide-on-med-and-down">
    <ul class="">
        <!--ARROW-->
        <li>
            <a id="large-bar" href="#" class="white-text large-arrow-left tooltipped" data-position="right" data-delay="50" data-tooltip="Diminuir menu">
                <i class="small material-icons side-menu-small-li-hover">keyboard_arrow_left</i>
            </a>
        </li>
        <!--INICIO-->
        <li>
            <a class="white-text black-color collapsible-header side-menu-large-li-hover side-menu-small-li-hover" href="#">
                <i class="material-icons">home</i> INICIO
            </a>
        </li>
        <!--CATEGORIAS-->
        <li>
            <ul class="collapsible collapsible-accordion collapsible-drop-categorias">
                <li>
                    <a class="collapsible-header white-text black-color side-menu-large-li-hover side-menu-small-li-hover">
                        <i class="material-icons">account_circle</i>CONTA
                        <i class="material-icons">arrow_drop_down</i>
                    </a>
                    <div class="collapsible-body green-color collapsible-drop-categorias">
                        <ul class="">
                            <!--Hardware Dropdown-->
                            <li class="collapsible-drop-categorias-label">
                                <a class="collapsible-header white-text black-color side-menu-large-li-hover side-menu-small-li-hover">
                                    Perfil
                                </a>
                            </li>
                            <!--Perifericos Dropdown-->
                            <li class="collapsible-drop-categorias-label">
                                <a class="collapsible-header white-text black-color side-menu-large-li-hover side-menu-small-li-hover">
                                    Pedidos
                                </a>
                            </li>
                        </ul>
                    </div>
                </li>
            </ul>
        </li>
        <!--CATEGORIAS-->
        <li>
            <ul class="collapsible collapsible-accordion collapsible-drop-categorias">
                <li>
                    <a class="collapsible-header white-text black-color side-menu-large-li-hover side-menu-small-li-hover">
                        <i class="material-icons">shop</i>CATEGORIAS
                        <i class="material-icons">arrow_drop_down</i>
                    </a>
                    <div class="collapsible-body green-color collapsible-drop-categorias">
                        <ul class="">
                            <!--Hardware Dropdown-->
                            <li class="collapsible-drop-categorias-label">
                                <ul class="collapsible collapsible-drop-categorias">
                                    <li>
                                        <a class="collapsible-header white-text black-color side-menu-large-li-hover side-menu-small-li-hover">
                                            Hardware<i class="material-icons">arrow_drop_down</i>
                                        </a>
                                        <div class="collapsible-body gray-color collapsible-drop-categorias">
                                            <ul>
                                                <a class="white-text" href="#!">
                                                    <li class="dropdown-menu-hover-right collapsible-drop-categorias-label">
                                                        Placa mae
                                                    </li>
                                                </a>
                                                <a class="white-text" href="#!">
                                                    <li class="dropdown-menu-hover-right collapsible-drop-categorias-label">
                                                        Memoria RAM
                                                    </li>
                                                </a>
                                                <a class="white-text" href="#!">
                                                    <li class="dropdown-menu-hover-right collapsible-drop-categorias-label">
                                                        Processadores
                                                    </li>
                                                </a>
                                                <a class="white-text" href="#!">
                                                    <li class="dropdown-menu-hover-right collapsible-drop-categorias-label">
                                                        Disco Rigido
                                                    </li>
                                                </a>
                                                <a class="white-text" href="#!">
                                                    <li class="dropdown-menu-hover-right collapsible-drop-categorias-label">
                                                        SSD
                                                    </li>
                                                </a>
                                            </ul>
                                        </div>
                                    </li>
                                </ul>
                            </li>
                            <!--Perifericos Dropdown-->
                            <li class="collapsible-drop-categorias-label">
                                <ul class="collapsible collapsible-accordion collapsible-drop-categorias">
                                    <li>
                                        <a class="collapsible-header white-text black-color side-menu-large-li-hover side-menu-small-li-hover">
                                            Perifericos<i class="material-icons">arrow_drop_down</i>
                                        </a>
                                        <div class="collapsible-body gray-color collapsible-drop-categorias">
                                            <ul>
                                                <a class="white-text" href="#!">
                                                    <li class="dropdown-menu-hover-right collapsible-drop-categorias-label">
                                                        Gabinetes
                                                    </li>
                                                </a>
                                                <a class="white-text" href="#!">
                                                    <li class="dropdown-menu-hover-right collapsible-drop-categorias-label">
                                                        Teclado & Mouse
                                                    </li>
                                                </a>
                                                <a class="white-text" href="#!">
                                                    <li class="dropdown-menu-hover-right collapsible-drop-categorias-label">
                                                        Adaptadores
                                                    </li>
                                                </a>
                                                <a class="white-text" href="#!">
                                                    <li class="dropdown-menu-hover-right collapsible-drop-categorias-label">
                                                        Acessorios
                                                    </li>
                                                </a>
                                                <a class="white-text" href="#!">
                                                    <li class="dropdown-menu-hover-right collapsible-drop-categorias-label">
                                                        Fones
                                                    </li>
                                                </a>
                                            </ul>
                                        </div>
                                    </li>
                                </ul>
                            </li>
                        </ul>
                    </div>
                </li>
            </ul>
        </li>
        <!--CARRINHO-->
        <li>
            <ul class="collapsible collapsible-accordion collapsible-drop-categorias">
                <!--TITULO CARRINHO-->
                <li>
                    <a class="collapsible-header white-text black-color side-menu-large-li-hover side-menu-small-li-hover">
                        <i class="material-icons">shopping_cart</i>CARRINHO
                        <i class="material-icons">arrow_drop_down</i>
                    </a>
                    <div class="collapsible-body green-color collapsible-drop-categorias">
                        <!--LISTA DE PRODUTOS NO CARRINHO-->
                        <ul>
                            <!--Produto 1-->
                            <li class="drop-carrinho-produto">
                                <ul class="z-depth-2">
                                    <li>
                                        <!--TITULO PRODUTO-->
                                        <a class="collapsible-header white-text black-color side-menu-large-li-hover side-menu-small-li-hover">
                                            Produto 1
                                        </a>
                                    </li>
                                </ul>
                            </li>
                            <!--Produto 2-->
                            <li class="drop-carrinho-produto">
                                <ul class="z-depth-2">
                                    <li>
                                        <!--TITULO PRODUTO-->
                                        <a class="collapsible-header white-text black-color side-menu-large-li-hover side-menu-small-li-hover">
                                            Produto 2
                                        </a>
                                    </li>
                                </ul>
                            </li>
                            <!--Produto 3-->
                            <li class="drop-carrinho-produto">
                                <ul class="z-depth-2">
                                    <li>
                                        <!--TITULO PRODUTO-->
                                        <a class="collapsible-header white-text black-color side-menu-large-li-hover side-menu-small-li-hover">
                                            Produto 3
                                        </a>
                                    </li>
                                </ul>
                            </li>
                            <!--Finalizar compra-->
                            <li class="drop-carrinho-produto">
                                <a href="" class="btn black-color btn-finalizar side-menu-small-li-hover">Finalizar compras!</a>
                            </li>
                        </ul>
                    </div>
                </li>
            </ul>
        </li>
    </ul>
</div>

<!--Dropdown produtos small-->
<ul id="dropdown-produtos-small" class="collapsible dropdown-content dropdown-menu" data-collapsible="accordion">
    <!--Hardware Dropdown-->
    <li class="collapsible-drop-size">
        <div class="collapsible-header black-color white-text collapsible-drop-title side-menu-small-li-hover">
            Hardware
            <i class="material-icons">arrow_drop_down</i>
        </div>
        <div class="collapsible-body collapsible-drop-categorias">
            <ul class="gray-color">
                <li class="dropdown-menu-hover white-text collapsible-drop-categorias-label">Placa mae</li>
                <li class="dropdown-menu-hover white-text collapsible-drop-categorias-label">Memoria RAM</li>
                <li class="dropdown-menu-hover white-text collapsible-drop-categorias-label">Processadores</li>
                <li class="dropdown-menu-hover white-text collapsible-drop-categorias-label">Placa de Video</li>
                <li class="dropdown-menu-hover white-text collapsible-drop-categorias-label">Disco Rigido</li>
                <li class="dropdown-menu-hover white-text collapsible-drop-categorias-label">SSD</li>
            </ul>
        </div>
    </li>
    <!--Perifericos Dropdown-->
    <li class="collapsible-drop-size">
        <div class="collapsible-header black-color white-text collapsible-drop-title side-menu-small-li-hover">
            Perifericos
            <i class="material-icons">arrow_drop_down</i>
        </div>
        <div class="collapsible-body collapsible-drop-categorias">
            <ul class="gray-color">
                <li class="dropdown-menu-hover white-text collapsible-drop-categorias-label">Gabinetes</li>
                <li class="dropdown-menu-hover white-text collapsible-drop-categorias-label">Teclados & Mouse</li>
                <li class="dropdown-menu-hover white-text collapsible-drop-categorias-label">Adaptadores</li>
                <li class="dropdown-menu-hover white-text collapsible-drop-categorias-label">Acessorios</li>
                <li class="dropdown-menu-hover white-text collapsible-drop-categorias-label">Fones</li>
                <li class="dropdown-menu-hover white-text collapsible-drop-categorias-label">Cabos</li>
            </ul>
        </div>
    </li>
</ul>