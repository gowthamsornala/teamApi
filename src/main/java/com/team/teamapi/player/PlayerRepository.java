package com.team.teamapi.player;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Integer> {

	List<Player> findByTeamId(int id);
	Player findByIdAndTeamId(int teamId, int playerId);
}
