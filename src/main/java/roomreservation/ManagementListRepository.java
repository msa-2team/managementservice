package roomreservation;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ManagementListRepository extends CrudRepository<ManagementList, Long> {


}