package info.heitor.petfriendspedido.eventos;

public class BaseEvento<T>{

    public final T id;

    public BaseEvento(T id) {
        this.id = id;
    }
}
