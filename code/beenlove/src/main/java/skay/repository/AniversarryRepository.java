package skay.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import skay.model.tbl_aniversarry;

@Repository
public interface AniversarryRepository extends CrudRepository<tbl_aniversarry, Integer> {

	@Query(value = "select aniversarryid,coupleid,name,detail,date, CONCAT(:host,urlimage) as urlimage"
			+ " from tbl_aniversarry a" + " where a.coupleid = :coupleid" + " limit :from,:to", nativeQuery = true)
	List<tbl_aniversarry> findByCoupleidEndWith(@Param("host") String host, @Param("coupleid") String coupleid,
			@Param("from") int from, @Param("to") int to);
}
