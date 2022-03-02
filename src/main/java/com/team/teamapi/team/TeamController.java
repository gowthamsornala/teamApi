package com.team.teamapi.team;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class TeamController {

    
    @Autowired
    private TeamModel teamModel;

    @GetMapping("/teams")
    public List<Team> getTeams(){
        return teamModel.getAllTeams();
    }

    @GetMapping("/teams/{id}")
    public Team getTeam(@PathVariable int id){
        return teamModel.getTeam(id);
    }

    @PostMapping(value="/team/add")
    public void postTeam(@RequestBody Team team) {
        teamModel.addNewTeam(team);
    }

    @DeleteMapping("team/{id}")
    public void deleteTeam(@PathVariable int id){
        teamModel.deleteTeam(id);
    }
    
}
