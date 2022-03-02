package com.team.teamapi.team;


import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.team.teamapi.player.Player;

@Entity
public class Team {

     @OneToMany(mappedBy = "team", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
     @JsonIgnore
     private List<Player> playerList;

	@Id
    @GeneratedValue
    private int id;
    private String teamName;
    private int teamRank;

    public Team(){}

    public Team(int id, String name, int rank, List<Player> playerList){
        this.id = id;
        this.teamName = name;
        this.teamRank = rank;
        this.playerList= playerList;
    }
    
    public List<Player> getPlayerList() {
		return playerList;
	}

	public void setPlayerList(List<Player> playerList) {
		this.playerList = playerList;
	}
	
    public int getTeamId(){
        return this.id;
    }

    public String getTeamName(){
        return this.teamName;
    }

    public void setTeamName(String name){
        this.teamName = name;
    }

    public int getTeamRank(){
        return this.teamRank;
    }

    public void setTeamRank(int rank){
        this.teamRank = rank;
    }

}
