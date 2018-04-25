package com.example.moodsense.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.moodsense.model.Event;

/**
 * @author victor olvera
 *
 */
@Repository
public interface EventRepository extends JpaRepository<Event, Long>{
	
	@Query(value="SELECT * FROM event e WHERE e.id_event = :id_event",nativeQuery=true)
    public Event getEventById(@Param("id_event") int id_event);
	
	@Query(value="SELECT * FROM event e WHERE e.id_user = :id_user",nativeQuery=true)
    public List<Event> getEventsByUserId(@Param("id_user") int id_user);
	
	@Query(value="SELECT * FROM event ev WHERE ev.date = :date", nativeQuery=true)
    public List<Event> getEventsByDate(@Param("date") String date);

}
