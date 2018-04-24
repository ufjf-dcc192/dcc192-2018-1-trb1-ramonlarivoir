package br.ufjf.dcc192;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Ramon Larivoir
 */
public class Pedido {
    private static boolean ABERTO = true;
    private static boolean FECHADO = false;
    
    int idMesa;
    List<Item> itens;
    Date horaInicio;
    Date horaFim = null;
    boolean aberto;

    public Pedido(int id_mesa) {
        this.idMesa = id_mesa;
        this.horaInicio = new Date();
        this.aberto = Pedido.ABERTO;
    }

    public int getIdMesa() {
        return idMesa;
    }

    public void setIdMesa(int id_mesa) {
        this.idMesa = id_mesa;
    }

    public List<Item> getItens() {
        return itens;
    }

    public void setItens(Item item) {
        this.itens.add(item);
    }

    public boolean isAberto() {
        return aberto;
    }

    public void setAberto(boolean aberto) {
        this.aberto = aberto;
    }

    public Date getHoraInicio() {
        return horaInicio;
    }

    public Date getHoraFim() {
        return horaFim;
    }
    
    public void fecharPedido() {
        this.horaFim = new Date();
        this.aberto = Pedido.FECHADO;
    }
    
    public void adicionaItem(Item item) {
        if(this.itens == null) {
            this.itens = new ArrayList<>();
            this.itens.add(item);
        } else {
            this.itens.add(item);
        }
    }
    
}
