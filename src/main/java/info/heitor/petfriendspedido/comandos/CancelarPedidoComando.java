package info.heitor.petfriendspedido.comandos;

import info.heitor.petfriendspedido.model.PedidoEstado;

public class CancelarPedidoComando extends BaseComando<String> {

    public PedidoEstado estado;

    public CancelarPedidoComando(String id, PedidoEstado estado) {
        super(id);
        this.estado = estado;
    }
}
