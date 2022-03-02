package com.team.teamapi.player;

import java.util.ArrayList;
import java.util.List;

import com.team.teamapi.team.TeamRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlayerModel {
	
    @Autowired
    private PlayerRepository playerRepository;

    @Autowired
    private TeamRepository teamRepository;
    
    public List<Player> getPlayers(){
        List<Player> playerList = new ArrayList<>();
        playerRepository.findAll().forEach(playerList::add);
        return playerList;
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
