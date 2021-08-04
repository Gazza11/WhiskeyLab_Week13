package com.codeclan.example.WhiskyTracker;

import com.codeclan.example.WhiskyTracker.models.Distillery;
import com.codeclan.example.WhiskyTracker.models.Whisky;
import com.codeclan.example.WhiskyTracker.repositories.DistilleryRepository;
import com.codeclan.example.WhiskyTracker.repositories.WhiskyRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WhiskyTrackerApplicationTests {

	@Autowired
	WhiskyRepository whiskyRepository;

	@Autowired
	DistilleryRepository distilleryRepository;

	@Test
	public void contextLoads() {
	}

	@Test // 1
	public void canGetWhiskiesFromYear(){
		List<Whisky> foundWhiskies = whiskyRepository.findWhiskiesByYear(2018);
		assertEquals(6, foundWhiskies.size());
	}

	@Test // 2
	public void canGetDistilleriesByRegion(){
		List<Distillery> foundDist = distilleryRepository.findDistilleriesByRegion("Highland");
		assertEquals(3, foundDist.size());
	}

	@Test
	public void canFindWhiskeyByDistilleryNameAndAge(){
		List<Whisky> foundWhisk = whiskyRepository.findByDistilleryNameAndAge("Glendronach", 12);
		assertEquals(1, foundWhisk.size());
		assertEquals("The Glendronach Original", foundWhisk.get(0).getName());
	}

	@Test // 4
	public void canGetAllWhiskiesFromRegion(){
		List<Whisky> foundWhisk = whiskyRepository.findWhiskiesByDistilleryRegion("Highland");
		assertEquals(7, foundWhisk.size());
	}

	@Test //5
	public void canGetDistilleriesWithWhiskeyAge(){
		List<Distillery> foundDist = distilleryRepository.findDistilleriesByWhiskiesAge(12);
		assertEquals(6, foundDist.size());
	}

}
