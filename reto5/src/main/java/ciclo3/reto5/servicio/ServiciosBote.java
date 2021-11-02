package ciclo3.reto5.servicio;

import ciclo3.reto5.modelo.Bote;
import ciclo3.reto5.repositorio.BoteRepositorio;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author SHANIA
 */

@Service
public class ServiciosBote {
    @Autowired
    private BoteRepositorio metodosCrud;

    public ServiciosBote() {
    }

    public List<Bote> getAll(){
        return metodosCrud.getAll();
    }

    public Optional<Bote> getBote(int idBote){
        return metodosCrud.getBote(idBote);
    }

    public Bote save(Bote bote){
        if(bote.getId()==null){
            return metodosCrud.save(bote);
        }else{
            Optional<Bote> evt=metodosCrud.getBote(bote.getId());
            if(evt.isEmpty()){
                return metodosCrud.save(bote);
            }else{
                return bote;
            }
        }
    }
    public Bote update(Bote bote){
        if(bote.getId()!=null){
            Optional<Bote> e=metodosCrud.getBote(bote.getId());
            if(!e.isEmpty()){
                if(bote.getName()!=null){
                    e.get().setName(bote.getName());
                }
                if(bote.getBrand()!=null){
                    e.get().setBrand(bote.getBrand());
                }
                if(bote.getYear()!=null){
                    e.get().setYear(bote.getYear());
                }
                if(bote.getDescription()!=null){
                    e.get().setDescription(bote.getDescription());
                }
                if(bote.getCategory()!=null){
                    e.get().setCategory(bote.getCategory());
                }
                metodosCrud.save(e.get());
                return e.get();
            }else{
                return bote;
            }
        }else{
            return bote;
        }
    }


    public boolean deleteBote(int boteId) {
        Boolean aBoolean = getBote(boteId).map(bote -> {
            metodosCrud.delete(bote);
            return true;
        }).orElse(false);
        return aBoolean;
    }

}