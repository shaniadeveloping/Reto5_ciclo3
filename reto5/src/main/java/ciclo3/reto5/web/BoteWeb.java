package ciclo3.reto5.web;

import ciclo3.reto5.modelo.Bote;
import ciclo3.reto5.servicio.ServiciosBote;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author SHANIA
 */


@RestController
@RequestMapping("/api/Boat")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class BoteWeb {

    @Autowired
    private ServiciosBote servicio;
    @GetMapping("all")
    public List <Bote> getBote(){
        return servicio.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Bote> getBote(@PathVariable("id") int idBoat) {
        return servicio.getBote(idBoat);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Bote save(@RequestBody Bote boat) {
        return servicio.save(boat);
    }
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Bote update(@RequestBody Bote bote) {
        return servicio.update(bote);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int boteId) {
        return servicio.deleteBote(boteId);
    }}
