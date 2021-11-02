package ciclo3.reto5.interfaz;

import ciclo3.reto5.modelo.Reservacion;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;
import java.util.List;

/**
 *
 * @author SHANIA
 */

public interface InterfaceReservacion extends CrudRepository<Reservacion,Integer>{

    public List<Reservacion> findAllByStatus (String status);

    public List<Reservacion> findAllByStartDateAfterAndStartDateBefore(Date dateOne, Date dateTwo);

    // SELECT clientid, COUNT(*) AS total FROM reservacion group by clientid order by desc;
    @Query("SELECT c.client, COUNT(c.client) FROM Reservacion AS c group by c.client order by COUNT(c.client)DESC")
    public List<Object[]> countTotalReservationsByClient();

}