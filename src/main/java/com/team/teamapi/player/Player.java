package com.team.teamapi.player;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.team.teamapi.team.Team;

@Entity
public class Player {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String playerName;
    private String playerRole;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonIgnore
    private Team team;
    
    public Player(){}

	public Player(String name, String role, Team team){
        this.playerName = name;
        this.playerRole = role;
        this.team = team;
    }

    public Team getTeam() {
		return team;
	}

	public void setTeam(Team team) {
		this.team = team;
	}
	
    public int getPlayerId(){
        return id;
    }

    public String getPlayerName(){
        return this.playerName;
    }

    public void setPlayerName(String name){
        this.playerName = name;
    }

    public String getPlayerRole(){
        return this.playerRole;
    }

    public void setPlayerRole(String role){
        this.playerRole = role;
    }

}
