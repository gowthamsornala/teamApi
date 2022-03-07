package com.team.teamapi.player;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;
import javax.persistence.criteria.*;

import com.team.teamapi.team.TeamRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlayerModel{
	
    @Autowired
    private PlayerRepository playerRepository;

    @Autowired
    private TeamRepository teamRepository;
    
    @PersistenceContext
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("Player_unit");
    EntityManager em = emf.createEntityManager();
    
    CriteriaBuilder cb = em.getCriteriaBuilder();
    CriteriaQuery<Player> cq = cb.createQuery(Player.class);
    Root<Player> root = cq.from(Player.class);
    
    public List<Player> getPlayers(){
        List<Player> playerList = new ArrayList<>();
        playerRepository.findAll().forEach(playerList::add);
        return playerList;
    }
    
    public List<Player> getPlayersByTeam(int teamId){
    	TypedQuery<Player> query = em.createQuery(cq.select(root).where(cb.equal(root.get("teamId"), teamId)));
    	List<Player> players = query.getResultList();
    	return players;
    }

    public Player getPlayer(int teamId, int playerId){
        return playerRepository.findByIdAndTeamId(teamId, playerId);
    }

    public void addPlayer(int teamId, Player player){
        teamRepository.findById(teamId).map(team -> {
        	player.setTeam(team);
        	return playerRepository.save(player);
        });
    }

    public void deletePlayer(int id){
        playerRepository.deleteById(id);
    }
}
