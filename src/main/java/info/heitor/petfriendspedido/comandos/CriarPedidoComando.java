package info.heitor.petfriendspedido.comandos;

public class CriarPedidoComando extends BaseComando<String> {

    public final Long clienteId;
    public final double valorTotal;

    public CriarPedidoComando(String id, Long clienteId, double valorTotal) {
        super(id);
        this.clienteId = clienteId;
        this.valorTotal = valorTotal;
    }

}
