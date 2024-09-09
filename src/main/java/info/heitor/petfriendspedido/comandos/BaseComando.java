package info.heitor.petfriendspedido.comandos;

import org.axonframework.modelling.command.TargetAggregateIdentifier;

public class BaseComando<T> {

    @TargetAggregateIdentifier
    public final T id;

    public BaseComando(T id) {
        this.id = id;
    }
}
