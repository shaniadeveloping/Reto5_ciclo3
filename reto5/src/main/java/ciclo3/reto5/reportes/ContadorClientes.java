package ciclo3.reto5.reportes;

import ciclo3.reto5.modelo.Cliente;


/**
 *
 * @author SHANIA
 */
public class ContadorClientes {

    private Long total;
    private Cliente client;

    public ContadorClientes(Long total, Cliente client) {
        this.total = total;
        this.client = client;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public Cliente getClient() {
        return client;
    }

    public void setClient(Cliente client) {
        this.client = client;
    }



}