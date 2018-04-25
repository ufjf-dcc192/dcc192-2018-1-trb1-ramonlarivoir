<%@include file="jspf/header.jspf" %>
<form method="POST">
    <input type="hidden" name="idPedido" value="<%=request.getAttribute("idPedido")%>">
    <div class="form-group">
        <label for="produto">Produto</label>
        <input type="text" class="form-control" id="produdo" name="produto">
    </div>
    <div class="form-group">
        <label for="quantidade">Quantidade</label>
        <input type="text" class="form-control" id="quantidade" name="quantidade">
    </div>
    <div class="form-group">
        <label for="preco">Preço</label>
        <input type="text" class="form-control" id="preco" name="preco">
    </div>
    <button type="submit" class="btn btn-success">Cadastrar</button>
    <button type="reset" class="btn btn-primary">Resetar</button>
    <a href="lista-pedidos.html"><input type="button" value="Voltar" class="btn btn-danger"></a>
</form>
<%@include file="jspf/footer.jspf" %>