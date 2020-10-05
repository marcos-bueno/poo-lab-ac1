package com.example.poolabac1.repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import com.example.poolabac1.model.Pedido;
import org.springframework.stereotype.Component;

@Component
public class PedidoRepository {
    private List<Pedido> pedidos;
    private int nextCodigo;
    
    @PostConstruct
    public void init(){
        nextCodigo++;

        Pedido p1 = new Pedido();
        p1.setCodigo(nextCodigo);
        p1.setValor(79.90);
        p1.setDescricao("Primeira descrição");
        p1.setCliente("Marcos B.");
        p1.setData(LocalDate.now());
        nextCodigo++;
        
        Pedido p2 = new Pedido();
        p2.setCodigo(nextCodigo);
        p2.setValor(105.90);
        p2.setDescricao("Outra descrição");
        p2.setCliente("Juliana");
        p2.setData(LocalDate.now());
        nextCodigo++;

        pedidos = new ArrayList<Pedido>();
        pedidos.add(p1);
        pedidos.add(p2);
    }

    public Pedido salvar(Pedido pedido){
        pedido.setCodigo(nextCodigo);
        pedidos.add(pedido);
        nextCodigo++;
        return pedido;
    }

    public Pedido atualizar(Pedido pedido){
        Pedido aux = getPedidoByCodigo(pedido.getCodigo());

        if(aux != null){
            aux.setValor(pedido.getValor());
            aux.setDescricao(pedido.getDescricao());
            aux.setCliente(pedido.getCliente());
            aux.setData(pedido.getData());
        }
        return aux;
    }

    public Pedido excluir(Pedido pedido){
        pedidos.remove(pedido);
        return pedido;
    }

    public Pedido salvando(Pedido pedido){
        Pedido aux = getPedidoByCodigo(pedido.getCodigo());

        if(aux != null){
            aux.setValor(pedido.getValor());
            aux.setDescricao(pedido.getDescricao());
            aux.setCliente(pedido.getCliente());
            aux.setData(pedido.getData());
        }
        return aux;
	}

    public Pedido getPedidoByCodigo(int codigo){
        for (Pedido aux : pedidos){
            if (aux.getCodigo() == codigo){
                return aux;
            }
        }
        return null;
    }

    public List<Pedido> getPedidos(){
        return pedidos;
    }

    public void setPedidos(List<Pedido> pedidos){
        this.pedidos = pedidos;
    }

    public int getNextCodigo(){
        return nextCodigo;
    }

    public void setNextCodigo(int nextCodigo){
        this.nextCodigo = nextCodigo;
    } 
}
