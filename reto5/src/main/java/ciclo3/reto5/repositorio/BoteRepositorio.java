package ciclo3.reto5.repositorio;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ciclo3.reto5.interfaz.InterfaceBote;
import ciclo3.reto5.modelo.Bote;

/**
 *
 * @author SHANIA
 */

@Repository
public class BoteRepositorio {
    @Autowired
    private InterfaceBote crud;


    public List<Bote> getAll(){
        return (List<Bote>) crud.findAll();
    }

    public Optional <Bote> getBote(int id){
        return crud.findById(id);
    }

    public Bote save(Bote bote){
        return crud.save(bote);
    }
    public void delete(Bote bote){
        crud.delete(bote);
    }
}