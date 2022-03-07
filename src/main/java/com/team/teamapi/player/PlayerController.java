package com.team.teamapi.player;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PlayerController {
    
    @Autowired
    private PlayerModel playerModel;
    
    @GetMapping("/players")
    public List<Player> getPlayers(){
        return playerModel.getPlayers();
    }

//    @GetMapping("/teams/{teamId}/players")
//    public List<Player> getPlayersByTeam(@PathVariable int teamId){
//    	return playerModel.getPlayersByTeam(teamId);
//    	}
    
    @GetMapping("teams/{teamId}/players/{playerId}")
    public Player getPlayer(@PathVariable int teamId, @PathVariable int playerId){
        return playerModel.getPlayer(teamId, playerId);
    }

    @PostMapping("teams/{teamId}/players/add")
    public void addPlayer(@PathVariable int teamId, @RequestBody Player player){
        playerModel.addPlayer(teamId, player);
    }

    @DeleteMapping("/players/{id}")
    public void deletePlayer(@PathVariable int id){
        playerModel.deletePlayer(id);
    }
}
