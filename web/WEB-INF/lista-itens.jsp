<%@page import="br.ufjf.dcc192.Item"%>
<%@page import="java.util.List"%>
<%@include file="jspf/header.jspf" %>
<table class="table table-striped table-bordered">
    <thead>
        <tr>
            <th scope="col">#</th>
            <th scope="col">Produto</th>
            <th scope="col">Preço</th>
            <th scope="col">Quantidade</th>
            <!--<th scope="col" colspan="2">Ação</th>-->
        </tr>
    </thead>
    <tbody>
        <%
            int i = 1;
            for (Item item : (List<Item>) request.getAttribute("itens")) {%>
        <tr>
            <th scope="row"><%=i%></th>
            <td><%=item.getProduto()%></td>
            <td><%=item.getPreco()%></td>
            <td><%=item.getQuantidade()%></td>
        <!--    <td><a href="editar-item.html?id=<%=i%>">Editar</a></td>
            <td><a href="">Excluir</a></td> -->
        </tr>
        <% i++;
            }%>
    </tbody>
    <tfoot>
        <tr>
            <th scope="row">Total:</th>
            <td colspan="5"><%=request.getAttribute("total")%></td>
        </tr>
    </tfoot>
</table>
<a href="lista-pedidos.html"><input type="button" class="btn btn-primary" value="Voltar"></a>
<a href="adiciona-item.html?id=<%=request.getAttribute("id")%>"><input type="button" class="btn btn-success" value="Adicionar Item"></a>
<%@include file="jspf/footer.jspf" %>