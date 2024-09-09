package info.heitor.petfriendspedido.controller;


import info.heitor.petfriendspedido.model.Pedido;
import info.heitor.petfriendspedido.service.PedidoQueryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/pedidos")
@RequiredArgsConstructor
public class PedidoQueryController {

    private final PedidoQueryService pedidoQueryService;

    @GetMapping("/{id}/eventos")
    public List<Object> listarEventos(@PathVariable String id) {
        return pedidoQueryService.listarEventos(id);
    }

    @GetMapping("/{id}")
    public Optional<Pedido> obetrPedido(@PathVariable String id) {
        return pedidoQueryService.obterPorId(id);
    }
}
