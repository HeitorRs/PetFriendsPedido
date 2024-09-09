package info.heitor.petfriendspedido.service;

import info.heitor.petfriendspedido.comandos.CancelarPedidoComando;
import info.heitor.petfriendspedido.comandos.CriarPedidoComando;
import info.heitor.petfriendspedido.model.Pedido;
import info.heitor.petfriendspedido.model.PedidoEstado;
import lombok.RequiredArgsConstructor;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.UUID;
import java.util.concurrent.CompletableFuture;

@Service
@RequiredArgsConstructor
public class PedidoComandoServiceImpl implements PedidoComandoService {

    private final CommandGateway commandGateway;

    @Override
    public CompletableFuture<String> criarPedido(Pedido pedido) {
        return commandGateway.send(new CriarPedidoComando(
                UUID.randomUUID().toString(),
                pedido.getClienteId(),
                pedido.getValorTotal()));
    }

    @Override
    public CompletableFuture<String> cancelarPedido(String id) {
        return commandGateway.send(new CancelarPedidoComando(id, PedidoEstado.CANCELADO));
    }
}
