package skay.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import skay.model.tbl_group_emoji;

@Repository
public interface GroupEmojiRepository extends CrudRepository<tbl_group_emoji, Integer> {

}
