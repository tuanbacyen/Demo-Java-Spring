package skay.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import skay.model.tbl_garelly;

@Repository
public interface GarellyRepository extends CrudRepository<tbl_garelly, Integer> {

	void deleteByAniversarryid(Integer aniversarryid);

	List<tbl_garelly> findByAniversarryid(int aniversarryid);

	@Query(value = "select garellyid,coupleid,aniversarryid, CONCAT(:host,urlimage) as urlimage"
			+ " from tbl_garelly" + " WHERE aniversarryid = :id", nativeQuery = true)
	List<tbl_garelly> findByAniversarryidEndWith(@Param("host") String host, @Param("id") int id);
}
