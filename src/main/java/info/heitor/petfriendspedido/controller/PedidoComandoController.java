package info.heitor.petfriendspedido.controller;

import info.heitor.petfriendspedido.model.Pedido;
import info.heitor.petfriendspedido.service.PedidoComandoServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/pedidos")
@RequiredArgsConstructor
public class PedidoComandoController {

    private final PedidoComandoServiceImpl pedidoComandoService;

    @PostMapping
    public CompletableFuture<String> CriarPedido(@RequestBody Pedido pedido) {
        return pedidoComandoService.criarPedido(pedido);
    }

    @DeleteMapping("/{id}")
    public CompletableFuture<String> cancelarPedido(@PathVariable String id) {
        return pedidoComandoService.cancelarPedido(id);
    }

}
