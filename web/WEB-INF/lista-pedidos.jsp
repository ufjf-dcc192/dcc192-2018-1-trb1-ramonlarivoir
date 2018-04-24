<%@page import="br.ufjf.dcc192.Pedido"%>
<%@page import="java.util.List"%>
<%@page import="br.ufjf.dcc192.Mesa"%>
<%@include file="jspf/header.jspf" %>
<table class="table table-striped">
    <thead>
        <tr>
            <th scope="col">Pedido</th>
            <th scope="col">Situação</th>
            <th scope="col">Hora Abertura</th>
            <th scope="col">Hora Fechamento</th>
            <th scope="col">Mesa</th>
            <th scope="col">Item</th>
            <th scope="col" colspan="3">Ação</th>
        </tr>
    </thead>
    <tbody>
        <%
        int i = 0; 
        for (Pedido pedido : (List<Pedido>)request.getAttribute("pedidos")) {
        %>
        <tr>
            <th scope="row"><%=i+1%></th>
            <td><%=(pedido.isAberto())?"Aberto":"Fechado"%></td>
            <td><%=pedido.getHoraInicio()%></td>
            <td><%=(pedido.isAberto())?"--":pedido.getHoraFim()%></td>
            <td><%=pedido.getIdMesa()%></td>
            <td><a href="lista-itens.html?id=<%=i%>">Visualizar Itens</a></td>
            <td><a href="finalizar-pedido.html?i=<%=i%>">Fechar Pedido</a></td>
            <td><a href="">Adicionar Item</a></td>
            <td><a href="">Editar Item</a></td>
        </tr>
        <%
          i++;  }
        %>
    </tbody>
</table>
<%@include file="jspf/footer.jspf" %>
