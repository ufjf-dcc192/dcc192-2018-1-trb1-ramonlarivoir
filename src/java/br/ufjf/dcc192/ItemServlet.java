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
@WebServlet(name = "ItemServlet", urlPatterns = {"/lista-itens.html"})
public class ItemServlet extends HttpServlet {
    String titulo;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if("/lista-itens.html".equals(request.getServletPath())) {
            Integer id = Integer.parseInt(request.getParameter("id"));
            id++;
            titulo = "Lista de Itens do Pedido " + id;
            request.setAttribute("titulo", titulo);
            
            listaItens(request, response);
        }
    }
    
    protected void listaItens(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer id = Integer.parseInt(request.getParameter("id"));
        List<Item> itens = ListaDePedidos.getInstance().get(id).getItens();
        request.setAttribute("itens", itens);
        
        double total = 0;
        
        for (Item item : itens) {
            total += (item.getPreco()*item.getQuantidade());
        }
        
        request.setAttribute("total", total);
        
        RequestDispatcher despachante = request.getRequestDispatcher("/WEB-INF/lista-itens.jsp");
        despachante.forward(request, response);
    }

    
}
