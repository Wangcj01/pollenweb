package com.pollen.pollenweb.controller;

import com.pollen.pollenweb.entity.TestEntity;
import com.pollen.pollenweb.repository.TestEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/testt")
public class TestHandler {

    @Autowired
    private TestEntityRepository testEntityRepository;

    @GetMapping("/showtestall")
    public Collection<TestEntity> showAll(){
        return testEntityRepository.showAll();
    }

    @GetMapping("/findId/{id}")
    public TestEntity findById(@PathVariable("id") Integer id){
        return testEntityRepository.findById(id);
    }

    @PostMapping("/save")
    public void SavenUpdate(@RequestBody TestEntity t){
        testEntityRepository.SavenUpdate(t);
    }

    @PostMapping("/update")
    public void update(@RequestBody TestEntity t){
        testEntityRepository.SavenUpdate(t);
    }

    @DeleteMapping("delete/{id}")
    public void delete(@PathVariable("id") Integer id){
        testEntityRepository.deleteById(id);
    }
}
