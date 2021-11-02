package ciclo3.reto5.repositorio;

import ciclo3.reto5.interfaz.InterfaceMensaje;
import ciclo3.reto5.modelo.Mensaje;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


/**
 *
 * @author SHANIA
 */

@Repository
public class MensajeRepositorio {
    @Autowired
    private InterfaceMensaje crud3;
    public List<Mensaje> getAll(){
        return (List<Mensaje>) crud3.findAll();
    }
    public Optional<Mensaje> getMessage(int id){
        return crud3.findById(id);
    }

    public Mensaje save(Mensaje message){
        return crud3.save(message);
    }
    public void delete(Mensaje mensaje){
        crud3.delete(mensaje);
    }

}
