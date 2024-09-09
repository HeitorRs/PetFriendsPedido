package info.heitor.petfriendspedido.eventos;

public class PedidoCriado extends BaseEvento<String>{

    public final Long clienteId;
    public final double valorTotal;

    public PedidoCriado(String id, Long clienteId, double valorTotal) {
        super(id);
        this.clienteId = clienteId;
        this.valorTotal = valorTotal;
    }
}
