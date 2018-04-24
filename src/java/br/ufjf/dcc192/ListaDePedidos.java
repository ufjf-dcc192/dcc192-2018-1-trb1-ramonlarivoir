package br.ufjf.dcc192;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Ramon Larivoir
 */
public class ListaDePedidos {
    private static List<Pedido> pedidos;
    
    public static List<Pedido> getInstance() {
            Item i1 = new Item("Coca Colca 600ml", 6, 3);
            Item i2 = new Item("Batata Frita", 14.50, 2);
            Item i3 = new Item("Hamburguer", 11.90, 1);
        if(pedidos == null) {
            pedidos = new ArrayList<>();
            Pedido p1 = new Pedido(1);
            p1.adicionaItem(i1);
            p1.fecharPedido();
            
            Pedido p2 = new Pedido(2);
            p2.adicionaItem(i3);
            p2.adicionaItem(i2);
            pedidos.add(p1);
            pedidos.add(p2);
        }
        return pedidos;
    }
}
