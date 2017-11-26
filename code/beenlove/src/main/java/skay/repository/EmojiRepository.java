package skay.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import skay.model.tbl_emoji;

@Repository
public interface EmojiRepository extends CrudRepository<tbl_emoji, Integer> {

	// get all
	@Query(value = "select emoji_id, emoji_name, CONCAT(:host,emoji_url) emoji_url, group_emoji_id from tbl_emoji where group_emoji_id = :groupid", nativeQuery = true)
	List<tbl_emoji> findByGroupemojiidEndWith(@Param("host") String host, @Param("groupid") int groupid);
}
