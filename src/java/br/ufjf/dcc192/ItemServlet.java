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
@WebServlet(name = "ItemServlet", urlPatterns = {"/lista-itens.html", "/adiciona-item.html"})
public class ItemServlet extends HttpServlet {

    String titulo;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if ("/lista-itens.html".equals(request.getServletPath())) {
            Integer id = Integer.parseInt(request.getParameter("id"));
            request.setAttribute("id", id);
            id++;
            titulo = "Lista de Itens do Pedido " + id;
            request.setAttribute("titulo", titulo);

            listaItens(request, response);
        } else if ("/adiciona-item.html".equals(request.getServletPath())) {
            Integer id = Integer.parseInt(request.getParameter("id"));
            id++;
            titulo = "Adicionar item ao Pedido " + id;
            request.setAttribute("titulo", titulo);

            adicionaItem(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if ("/adiciona-item.html".equals(request.getServletPath())) {
            Integer idPedido = Integer.parseInt(request.getParameter("idPedido"));
            String produto = request.getParameter("produto");
            Integer quantidade = Integer.parseInt(request.getParameter("quantidade"));
            Double preco = Double.parseDouble(request.getParameter("preco"));
            
            if (ListaDePedidos.getInstance().get(idPedido).isAberto() == false) {
                String titulo = "Este pedido já foi finalizado!";
                request.setAttribute("titulo", titulo);
                RequestDispatcher despachante = request.getRequestDispatcher("/WEB-INF/pedido-finalizado.jsp");
                despachante.forward(request, response);
            } else {
                Item novoItem = new Item(produto, preco, quantidade);
                ListaDePedidos.getInstance().get(idPedido).adicionaItem(novoItem);
                
                response.sendRedirect("lista-itens.html?id="+idPedido);
            }
        }
    }

    protected void listaItens(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer id = Integer.parseInt(request.getParameter("id"));
        List<Item> itens = ListaDePedidos.getInstance().get(id).getItens();
        request.setAttribute("itens", itens);

        double total = 0;

        for (Item item : itens) {
            total += (item.getPreco() * item.getQuantidade());
        }

        request.setAttribute("total", total);

        RequestDispatcher despachante = request.getRequestDispatcher("/WEB-INF/lista-itens.jsp");
        despachante.forward(request, response);
    }

    protected void adicionaItem(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer idPedido = Integer.parseInt(request.getParameter("id"));
        request.setAttribute("idPedido", idPedido);

        RequestDispatcher despachante = request.getRequestDispatcher("/WEB-INF/adiciona-item.jsp");
        despachante.forward(request, response);
    }

}
