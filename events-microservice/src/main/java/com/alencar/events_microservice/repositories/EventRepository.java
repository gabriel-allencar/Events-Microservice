package com.alencar.events_microservice.repositories;

import com.alencar.events_microservice.domain.Event;
import lombok.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface EventRepository extends JpaRepository<Event, Long> {

@Query(value = "SELECT * FROM event e WHERE parsedatetime(e.date, 'dd/MM/yyyy') >:currentDate",  nativeQuery = true)
List<Event> findUpComingEvents(@Param("currentDate")LocalDateTime currentDate);

    @NonNull
    Optional<Event> findById(@NonNull String id);

}
