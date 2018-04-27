<%@page import="br.ufjf.dcc192.Mesa"%>
<%@page import="java.util.List"%>
<%@include file="jspf/header.jspf" %>
<form method="POST">
    <div class="form-group">
        <label for="produto">Produto</label>
        <input type="text" class="form-control" id="produdo" name="produto" required>
    </div>
    <div class="form-group">
        <label for="quantidade">Quantidade</label>
        <input type="number" class="form-control" id="quantidade" name="quantidade" required>
    </div>
    <div class="form-group">
        <label for="preco">Preço</label>
        <input type="number" class="form-control" id="preco" name="preco" required>
    </div>
    <div class="form-group">
    <label for="mesa">Mesa</label>
    <select class="form-control" id="mesa" name="mesa">
    <%
        for (Mesa mesa : (List<Mesa>)request.getAttribute("mesas")) {
    %>
        <option><%=mesa.getId()%></option>
    <%
        }
    %>
    </select>
  </div>
    <button type="submit" class="btn btn-success">Cadastrar</button>
    <button type="reset" class="btn btn-primary">Resetar</button>
    <a href="index.html"><input type="button" value="Voltar" class="btn btn-danger"></a>
</form>
<%@include file="jspf/footer.jspf" %>
