package com.cog.crm.tagservice;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cog.crm.entity.TagEntity;
import com.cog.crm.tagrepository.TagRepository;

//@Service
public class TagService {

	@Autowired
	private TagRepository tagRepository;

	TagEntity tagData = new TagEntity();

	public List<TagEntity> CreateTag(int id, String tag) {
		System.out.println("service entry");
		Optional<TagEntity> optionalTagData = tagRepository.findById(id);
		System.out.println(optionalTagData.toString());
		if (optionalTagData.isPresent()) {
			System.out.println("Tag is available");

		} else {
			System.out.println("tag is empty");
			TagEntity tagData = new TagEntity();

			tagData.setId(id);
			tagData.setTag(tag);
			System.out.println(id);
			System.out.println(tag);
			tagRepository.save(tagData);
			System.out.println("after saving");
		}
		System.out.println("In service, create Tag method");
		return tagRepository.findAll();
	}

	public List<TagEntity> getTags() {
		return tagRepository.findAll();
	}

	public TagEntity getTagById(int id) {

		return tagRepository.findById(id).orElse(null);
	}

	public List<TagEntity> saveOrUpdate(int id, String tag) {
		tagData.setId(id);
		tagData.setTag(tag);
		tagRepository.save(tagData);
		System.out.println("in service, update tag method");
		return tagRepository.findAll();
	}

	public void deleteById(int id) {
		System.out.println("service method delete");
		tagRepository.deleteById(id);
	}

}
