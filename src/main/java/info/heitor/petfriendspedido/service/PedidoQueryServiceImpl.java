package info.heitor.petfriendspedido.service;

import info.heitor.petfriendspedido.model.Pedido;
import info.heitor.petfriendspedido.repository.Pedidorepository;
import lombok.RequiredArgsConstructor;
import org.axonframework.eventsourcing.eventstore.EventStore;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PedidoQueryServiceImpl implements PedidoQueryService {

    private final EventStore eventStore;
    private final Pedidorepository pedidorepository;

    @Override
    public Optional<Pedido> obterPorId(String id) {
        return pedidorepository.findById(id);
    }

    @Override
    public List<Object> listarEventos(String id) {
        List<Object> retorno = eventStore.readEvents(id, 0)
                .asStream()
                .map(record -> record.getPayload()).collect(Collectors.toList());
        return retorno;
    }
}
