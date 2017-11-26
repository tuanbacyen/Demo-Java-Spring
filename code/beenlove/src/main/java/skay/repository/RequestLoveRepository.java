package skay.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import skay.model.tbl_request_love;

@Repository
public interface RequestLoveRepository extends CrudRepository<tbl_request_love, Integer> {

	// find request
	@Query(value = "select * from tbl_request_love"
			+ " where senderid = :senderid and receiveid = :receiveid or senderid = :receiveid and receiveid = :senderid"
			, nativeQuery = true)
	tbl_request_love findBySenderidAndReceiveidEndWith(@Param("senderid") int senderid,
			@Param("receiveid") int receiveid);
}
