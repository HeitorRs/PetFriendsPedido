package info.heitor.petfriendspedido.model;

import info.heitor.petfriendspedido.comandos.CancelarPedidoComando;
import info.heitor.petfriendspedido.comandos.CriarPedidoComando;
import info.heitor.petfriendspedido.eventos.PedidoCancelado;
import info.heitor.petfriendspedido.eventos.PedidoCriado;
import info.heitor.petfriendspedido.eventos.PedidoNovo;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;

@AllArgsConstructor@Data
@Aggregate
@Entity
public class Pedido {

    @AggregateIdentifier
    @Id
    private String id;
    private Long clienteId;
    private double valorTotal;
    private String estado;

    public Pedido() {
    }

    @CommandHandler
    public Pedido(CriarPedidoComando comando){
        AggregateLifecycle.apply(new PedidoCriado(comando.id, comando.clienteId, comando.valorTotal));
    }

    @EventSourcingHandler
    protected void on(PedidoCriado evento) {
        this.id = evento.id;
        this.clienteId = evento.clienteId;
        this.valorTotal = evento.valorTotal;
        this.estado = String.valueOf(PedidoEstado.NOVO);

        AggregateLifecycle.apply(new PedidoNovo(this.id, PedidoEstado.NOVO));
    }

    @EventSourcingHandler
    protected void on(PedidoNovo evento) {
        this.estado = String.valueOf(evento.estado);
    }

    //--------------------------------------------------------------------------------------------------------------
    //--------------------------------------------------------------------------------------------------------------
    //--------------------------------------------------------------------------------------------------------------

    @CommandHandler
    public void on(CancelarPedidoComando comando) {
        if (this.estado.equals(String.valueOf(PedidoEstado.FINALIZADO))) {
            throw new IllegalStateException("Pedido já está fechado e não pode ser cancelado.");
        }
        AggregateLifecycle.apply(new PedidoCancelado(comando.id,PedidoEstado.CANCELADO));
    }
    @EventSourcingHandler
    protected void on(PedidoCancelado evento) {
        this.estado = String.valueOf(PedidoEstado.CANCELADO);
    }
}
