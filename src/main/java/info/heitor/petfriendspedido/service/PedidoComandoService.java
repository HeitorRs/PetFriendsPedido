package info.heitor.petfriendspedido.service;

import info.heitor.petfriendspedido.model.Pedido;

import java.util.concurrent.CompletableFuture;

public interface PedidoComandoService {
    public CompletableFuture<String> criarPedido(Pedido pedido);
    public CompletableFuture<String> cancelarPedido(String id);
}
