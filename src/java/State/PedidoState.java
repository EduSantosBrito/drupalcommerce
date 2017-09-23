package State;

public interface PedidoState {
    
    public String estado();
    public String analise();
    public String atraso();
    public String separacao();
    public String cancelado();
    public String enviado();
    
}