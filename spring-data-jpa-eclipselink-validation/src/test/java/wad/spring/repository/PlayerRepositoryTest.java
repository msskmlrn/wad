/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package wad.spring.repository;

import junit.framework.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import wad.spring.domain.Player;
import wad.spring.domain.Team;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-context-test.xml",
    "classpath:spring-database-test.xml"})

public class PlayerRepositoryTest {

    @Autowired
    PlayerRepository playerRepository;
    
    @Autowired
    TeamRepository teamRepository;

    @Test
    public void createIncrementsElementCountByOne() {
        long countAtStart = playerRepository.count();

        Player p = new Player();
        p.setName("Matti");
        playerRepository.save(p);

        long countAtEnd = playerRepository.count();
        Assert.assertTrue("Player count should be increased by one when adding an element.",
                countAtStart + 1 == countAtEnd);
    }
    
    @Test
    public void savePlayerToDatabase() {
        Team team = new Team();
        team.setName("LeTeam");
        team = teamRepository.save(team);
        
        Player player = new Player();
        player.setName("Matti");
        team.addPlayer(player);
        
        String name = playerRepository.findAll().get(0).getName();
        
        Assert.assertTrue("Player names should match.",
                name.equals("Matti"));
    }
    
    @Test
    public void saveTwoPlayersToTeam() {
        long countAtStart = playerRepository.count();
        
        Team team = new Team();
        team.setName("LeTeam");
        team = teamRepository.save(team);
        
        Player player = new Player();
        player.setName("Matti");
        team.addPlayer(player);

        player = new Player();
        player.setName("Pekka");
        team.addPlayer(player);
        teamRepository.save(team);
        
        long countAtEnd = playerRepository.count();
        
        Assert.assertTrue("Player count should be increase by two when adding two elements", 
                countAtStart +2 == countAtEnd);
        
    }
    
    @Test
    public void saveTwoPlayersToTeamTakeTwo() {
        long countAtStart = playerRepository.count();
        
        Team team = new Team();
        team.setName("LeTeam");
        team = teamRepository.save(team);
        
        Player player = new Player();
        player.setName("Matti");
        team.addPlayer(player);

        player = new Player();
        player.setName("Pekka");
        team.addPlayer(player);
        teamRepository.save(team);
        
        teamRepository.delete(team);
        
        long countAtEnd = playerRepository.count();
        
        Assert.assertTrue("Player count should be the same as in the beginning", 
                countAtStart == countAtEnd);
        
    }
}