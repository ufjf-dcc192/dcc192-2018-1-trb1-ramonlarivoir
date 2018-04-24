package br.ufjf.dcc192;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Ramon Larivoir
 */
public class ListaDeMesas {
    private static List<Mesa> mesas;
    
    public static List<Mesa> getInstance() {
        if(mesas == null) {
            mesas = new ArrayList<>();
            mesas.add(new Mesa(1));
            mesas.add(new Mesa(2));
            mesas.add(new Mesa(3));
            mesas.add(new Mesa(4));
        }
        return mesas;
    }
}
