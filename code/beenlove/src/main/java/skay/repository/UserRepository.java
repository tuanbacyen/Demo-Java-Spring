package skay.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import skay.model.tbl_user;

@Repository
public interface UserRepository extends CrudRepository<tbl_user, Integer> {
	// search by username
	@Query(value = "select u.userid, u.username, u.nickname, u.avatar, (select l.state from tbl_request_love l where l.senderid = u.userid or l.receiveid = u.userid) as state, u.emoticon"
			+ " from tbl_user u" + " where u.username LIKE CONCAT('%',:username,'%@%') and u.coupleid is null"
			+ " limit :from,:to", nativeQuery = true)
	List<Object> findByUsernameEndWith(@Param("username") String username, @Param("from") int from,
			@Param("to") int to);

	// check loggin
	List<tbl_user> findByUsernameAndPass(String username, String pass);

	// get 1 user by user name
	tbl_user findByUsername(String user);

	// get userid send
	@Query(value = "select a.userid from tbl_user a where a.coupleid = (select b.coupleid from tbl_user b where b.userid = :userid) and a.userid != :userid", nativeQuery = true)
	String findByUseridEndWith(@Param("userid") int userid);

	// get userid send
	@Query(value = "select a.userid from tbl_user a where a.coupleid = :coupleid and a.userid != :userid", nativeQuery = true)
	String findByUseridEndWith(@Param("userid") int userid, @Param("coupleid") String coupleid);

}
