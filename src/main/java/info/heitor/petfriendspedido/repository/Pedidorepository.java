package info.heitor.petfriendspedido.repository;

import info.heitor.petfriendspedido.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Pedidorepository extends JpaRepository<Pedido, String> {
}
