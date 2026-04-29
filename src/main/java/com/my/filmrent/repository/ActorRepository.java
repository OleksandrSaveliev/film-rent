package com.my.filmrent.repository;

import com.my.filmrent.entity.Actor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface ActorRepository extends JpaRepository<Actor, Integer> {

    Set<Actor> findAllByActorIdIn(Set<Integer> actorIds);
}
