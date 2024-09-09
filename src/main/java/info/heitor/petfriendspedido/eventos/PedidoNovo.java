package info.heitor.petfriendspedido.eventos;

import info.heitor.petfriendspedido.model.PedidoEstado;

public class PedidoNovo extends BaseEvento<String>{

    public final PedidoEstado estado;

    public PedidoNovo(String id, PedidoEstado estado) {
        super(id);
        this.estado = estado;
    }
}
