package skay.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import skay.model.tbl_notification;

@Repository
public interface NotificationRepository extends CrudRepository<tbl_notification, Integer> {

}
