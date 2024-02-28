package com.cog.crm.tagcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.cog.crm.entity.TagEntity;
import com.cog.crm.tagservice.TagService;

@RestController

public class TagController {

	@Autowired
	private TagService tagService;
	
	@GetMapping("/home")
	public ModelAndView listOfTags() {
		//System.out.println("index.jsp");
		List<TagEntity> data = tagService.getTags();
		ModelAndView mv = new ModelAndView("index");
		mv.addObject("data", data);
		return mv;
	}
	
	//To get the AddTag form
	@GetMapping("/addTagForm")
	public ModelAndView openForm() {
		System.out.println("new tag add form page");
		return new ModelAndView("addTagForm");
	}
	
	//to add tags in add Tag form
	@PostMapping("/addTag")
	public ModelAndView addTag(@RequestParam int id, @RequestParam String tag) {
		List<TagEntity> entireData = tagService.CreateTag(id,tag);
		System.out.println("post method");
		ModelAndView mv = new ModelAndView("redirect:/home");
		mv.addObject("data", entireData);
		return mv;
		
	}
	
//	@GetMapping("/tags")
//	public List<TagEntity> getAllTags() {
//		return tagService.getTags();
//	}
	@GetMapping("/tag/{id}")
	public TagEntity getTagById1(@PathVariable int id) {
		return tagService.getTagById(id);
	}
	
	@GetMapping("/updateTagForm/{id}")
	public ModelAndView openUpdateForm() {
		System.out.println("update form page");
		return new ModelAndView("updateTagForm");
	}

//	@PutMapping("/updateTag/{id}")
	@RequestMapping(value = "/updateTag/{id}", method = { RequestMethod.GET, RequestMethod.PUT })
	public ModelAndView updateTag(@RequestParam int id, @RequestParam String tag) {
		System.out.println("put method");
		List<TagEntity> entireData = tagService.saveOrUpdate(id, tag);
		ModelAndView mv = new ModelAndView("redirect:/home");
		mv.addObject("data", entireData);
		return mv;
		
	}
	
	@GetMapping("/deleteTag/{id}")
	public ModelAndView deleteTag(@PathVariable int id) {
		System.out.println("controller delete method");
		tagService.deleteById(id);
		List<TagEntity> data = tagService.getTags();
		ModelAndView mv = new ModelAndView("redirect:/home");
		mv.addObject("data", data);
		return mv;
	}

}
