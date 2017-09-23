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
                            <hr class="usuario-perfil-titulo-hr"/>
                        </div>
                        <div class="card-content white">
                            
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <c:import url="../Shared/rodape.jsp"/>
        <c:import url="../Shared/importJs.jsp"/>
    </body>
</html>
