package br.ufjf.dcc192;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Ramon Larivoir
 */
@WebServlet(name = "PedidoServlet", urlPatterns = {"/index.html", "/novo-pedido.html", "/lista-pedidos.html", "/finalizar-pedido.html"})
public class PedidoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String titulo;
        if("/index.html".equals(request.getServletPath())) {
            titulo = "Gerência de Pedidos";
            request.setAttribute("titulo", titulo);
            
            indexHtml(request, response);
        } else if("/novo-pedido.html".equals(request.getServletPath())) {
            titulo = "Novo Pedido";
            request.setAttribute("titulo", titulo);
            
            novoPedido(request, response);
        } else if("/lista-pedidos.html".equals(request.getServletPath())) {
            titulo = "Lista de Pedidos";
            request.setAttribute("titulo", titulo);
            
            listaPedidos(request, response);
        } else if("/finalizar-pedido.html".equals(request.getServletPath())) {
            finalizarPedido(request, response);            
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       if("/novo-pedido.html".equals(request.getServletPath())) {
           String produto = request.getParameter("produto");
           Integer quantidade = Integer.parseInt(request.getParameter("quantidade"));
           Double preco = Double.parseDouble(request.getParameter("preco"));
           Integer idMesa = Integer.parseInt(request.getParameter("mesa"));
           
           Pedido novoPedido = new Pedido(idMesa);
           
           Item addItem = new Item(produto, preco, quantidade);
           
           novoPedido.adicionaItem(addItem);
           
           ListaDePedidos.getInstance().add(novoPedido);
           
           response.sendRedirect("lista-pedidos.html");
       }
    }
    
    protected void novoPedido(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Mesa> mesas = ListaDeMesas.getInstance();
        request.setAttribute("mesas", mesas);
        
        RequestDispatcher despachante = request.getRequestDispatcher("/WEB-INF/novo-pedido.jsp");
        despachante.forward(request, response);
    }
    
    protected void indexHtml(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher despachante = request.getRequestDispatcher("/WEB-INF/pedido.jsp");
        despachante.forward(request, response);
    }

    protected void listaPedidos(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Pedido> pedidos = ListaDePedidos.getInstance();
        request.setAttribute("pedidos", pedidos);
        
        RequestDispatcher despachante = request.getRequestDispatcher("/WEB-INF/lista-pedidos.jsp");
        despachante.forward(request, response);
    }
    
    private void finalizarPedido(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer id = Integer.parseInt(request.getParameter("i"));
        if(ListaDePedidos.getInstance().get(id).isAberto() == true) {
            ListaDePedidos.getInstance().get(id).fecharPedido();
            response.sendRedirect("lista-pedidos.html");
        } else {
            String titulo = "Este pedido já foi finalizado!";
            request.setAttribute("titulo", titulo);
            RequestDispatcher despachante = request.getRequestDispatcher("/WEB-INF/pedido-finalizado.jsp");
            despachante.forward(request, response);
        }
    }
}
