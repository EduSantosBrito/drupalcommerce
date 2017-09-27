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
        <div id="usuario-perfil" class="content-margin-left">
            <div class="row">
                <div class="col s12">
                    <div class="card black-color">
                        <div class="card-content padding-0">
                            <label class="usuario-perfil-titulo white-text">${usuario.nome}</label>
                            <c:if test="${usuario.alertas.size() > 0}">
                                <i class="material-icons prefix white-text dropdown-button drpd-att tooltipped" href='#' data-activates='dropdown-att' data-position="bottom" data-delay="50" data-tooltip="Alertas">feedback</i>
                            </c:if>
                            <hr class="usuario-perfil-titulo-hr"/>
                        </div>
                        <div class="card-content white">
                            
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <ul id='dropdown-att' class='dropdown-content center'>
            <li>
                <a href="${pageContext.request.contextPath}/FrontController?action=RemoveAlerta" class="black-text">
                    Remover todos
                    <i class="material-icons prefix right icon-margin-0">close</i>
                </a>
            </li>
            <c:forEach var="alerta" items="${usuario.alertas}">
                <li>
                    <a class="black-text">${alerta}</a>
                </li>
            </c:forEach>
        </ul>
        <c:import url="../Shared/rodape.jsp"/>
        <c:import url="../Shared/importJs.jsp"/>
    </body>
</html>
