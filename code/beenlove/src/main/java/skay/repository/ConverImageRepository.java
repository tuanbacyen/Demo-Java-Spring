package skay.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import skay.model.tbl_coverimage;

@Repository
public interface ConverImageRepository extends CrudRepository<tbl_coverimage, Integer> {

	// get all
	List<tbl_coverimage> findByCoverimagetype(Integer type);

	// get all with local
	String querry = "select coverimage_id,coverimage_name,CONCAT(:host,coverimage_url) as coverimage_url, coverimage_type from tbl_coverimage"
			+ " where coverimage_type = :type";

	@Query(value = querry, nativeQuery = true)
	List<tbl_coverimage> findByCoverimagetypeEndWith(@Param("host") String host, @Param("type") int type);
}
