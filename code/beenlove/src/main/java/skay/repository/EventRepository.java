package skay.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import skay.model.tbl_event;

@Repository
public interface EventRepository extends CrudRepository<tbl_event, Integer> {

	// find even
	@Query(value = "select eventid, coupleid, name,date,alterday, CONCAT(:host,emoticon) as emoticon from tbl_event"
			+ " where coupleid = :coupleid" + " ORDER BY date DESC" + " limit :from,:to", nativeQuery = true)
	List<tbl_event> findByCoupleidEndWith(@Param("host") String host, @Param("coupleid") String coupleid,
			@Param("from") int from, @Param("to") int to);
}
