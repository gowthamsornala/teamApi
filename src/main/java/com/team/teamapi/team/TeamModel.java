package com.team.teamapi.team;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeamModel {

    @Autowired
    private TeamRepository teamRepository;

    public List<Team> getAllTeams(){
        List<Team> teamList = new ArrayList<>();
        teamRepository.findAll().forEach(teamList::add);
        return teamList;
    }

    public Team getTeam(int id){
        return teamRepository.findById(id).get();
    }

    public void addNewTeam(Team team){
        teamRepository.save(team);
    }

    public void deleteTeam(int id){
        teamRepository.deleteById(id);
    }
}
