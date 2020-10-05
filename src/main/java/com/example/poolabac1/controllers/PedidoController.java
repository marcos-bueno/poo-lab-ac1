package com.example.poolabac1.controllers;

import java.util.List;
import com.example.poolabac1.model.Pedido;
import com.example.poolabac1.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {
    
    @Autowired
    PedidoRepository repository;

    @GetMapping()
    public List<Pedido> getPedidos() {
        return repository.getPedidos();
    }

    @GetMapping("/{codigo}")
    public Pedido getPedido(@PathVariable int codigo) {
        return repository.getPedidoByCodigo(codigo);
    }

    @PostMapping()
    public Pedido salvar(@RequestBody Pedido pedido) {
        return repository.salvar(pedido);
    }

    @PutMapping("/{codigo}")
    public Pedido atualizar(@RequestBody Pedido pedido, @PathVariable int codigo) {
        Pedido aux = repository.getPedidoByCodigo(codigo);

        if (aux != null) {
            pedido.setCodigo(codigo);
            pedido = repository.salvando(pedido);
            return aux;
        } else {
            return null;
        }
    }

    @DeleteMapping("/{codigo}")
    public Pedido excluir(@PathVariable int codigo) {
        Pedido pedido = repository.getPedidoByCodigo(codigo);
        
        if(pedido == null) {
            return null;
        } else {
            repository.excluir(pedido);
            return pedido;
        }
    }
}
