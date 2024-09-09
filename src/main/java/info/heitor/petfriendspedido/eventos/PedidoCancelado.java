package info.heitor.petfriendspedido.eventos;


import info.heitor.petfriendspedido.model.PedidoEstado;

public class PedidoCancelado extends BaseEvento<String>{

    public PedidoEstado estado;

    public PedidoCancelado(String id, PedidoEstado estado) {
        super(id);
        this.estado = estado;
    }
}
