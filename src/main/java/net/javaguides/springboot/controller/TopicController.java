package net.javaguides.springboot.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class TopicController {
	

	public List<Topic> listOfCourses() {
		List<Topic> l = new ArrayList<Topic>();

		l.add(new Topic(1, "spring framework", "spring framework description"));
		l.add(new Topic(2, "core java", "core java description"));
		l.add(new Topic(3, "javascript", "javascript description"));
		return l;
	}

	@GetMapping("/topics")
	public List<Topic> getAllTopics() {
		List<Topic> l=listOfCourses();
		return l;
	}
	
	@GetMapping("/topics/{id}")
	public Topic getById(@PathVariable int id){
		List<Topic> l=listOfCourses();
		for(Topic t:l) {
			if(t.getId()==id) {
				return t;
			}
		}
		return null;
	}
}
