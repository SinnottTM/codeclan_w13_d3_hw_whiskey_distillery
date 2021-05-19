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

	@Test
	public void canFindWhiskysByYear(){
		List<Whisky> foundWhiskies = whiskyRepository.findWhiskyByYear(2018);
		assertEquals(6, foundWhiskies.size());
	}

	@Test
	public void canFindDistillerysByRegion(){
		List<Distillery> foundDistilleries = distilleryRepository.findDistillerysByRegion("Island");
		assertEquals(3, foundDistilleries.size());
	}

	@Test
	public void canfindAllWhiskiesByAge(){
		Distillery testDistillery = distilleryRepository.getOne(1L);
		List<Whisky> foundWhiskies = whiskyRepository.findAllWhiskiesByDistilleryAndAge(testDistillery, 15);
		assertEquals("The Glendronach Revival", foundWhiskies.get(0).getName());
	}

	@Test
	public void canFindWhiskiesByRegion(){
		List<Whisky> foundWhiskys = whiskyRepository.findByDistilleryRegion("Island");
		assertEquals(6, foundWhiskys.size());
	}

	@Test
	public void canFindDistilleriesWithWhiskyOver12YearsOld(){
		List<Distillery> foundDistilleries = distilleryRepository.findDistilleriesByWhiskiesAgeGreaterThan(11);
		assertEquals(16, foundDistilleries.size());
	}


}
