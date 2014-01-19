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

public class TeamRepositoryTest {

    @Autowired
    TeamRepository teamRepository;
   
    @Test
    public void saveTeamToDatabase() {
        long countAtStart = teamRepository.count();
        
        Team team = new Team();
        team.setName("LeTeam");
        team = teamRepository.save(team);
        
        long countAtEnd = teamRepository.count();
        Assert.assertTrue("Team count should be increase by one when adding an element", 
                countAtStart +1 == countAtEnd);
        
    }
    
}