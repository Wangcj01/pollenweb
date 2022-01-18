package com.pollen.pollenweb.repository.impl;
import com.pollen.pollenweb.entity.TestEntity;
import com.pollen.pollenweb.repository.TestEntityRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class TestEntityRepositoryImpl implements TestEntityRepository {
    private static Map<Integer,TestEntity> testEntityMap;

    static {
        testEntityMap = new HashMap<>();
        testEntityMap.put(1,new TestEntity(1,"firsttry","pollon1"));
        testEntityMap.put(2,new TestEntity(2,"sencondtry","pollon2"));
        testEntityMap.put(3,new TestEntity(3,"3rdtry","pollon3"));
        testEntityMap.put(4,new TestEntity(4,"4thtry","pollon4"));
        testEntityMap.put(5,new TestEntity(5,"5thtry","pollon5"));
    }

    @Override
    public Collection<TestEntity> showAll() {
        return testEntityMap.values();
    }

    @Override
    public TestEntity findById(int id) {
        return testEntityMap.get(id);
    }

    @Override
    public void SavenUpdate(TestEntity t) {
        testEntityMap.put(t.getId(),t);
    }

    @Override
    public void deleteById(int id) {
        testEntityMap.remove(id);
    }
}
