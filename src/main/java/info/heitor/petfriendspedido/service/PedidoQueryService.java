package info.heitor.petfriendspedido.service;

import info.heitor.petfriendspedido.model.Pedido;

import java.util.List;
import java.util.Optional;

public interface PedidoQueryService {
    public Optional<Pedido> obterPorId(String id);
    public List<Object> listarEventos(String id);
}
