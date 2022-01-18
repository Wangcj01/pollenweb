package com.pollen.pollenweb.repository;

import com.pollen.pollenweb.entity.TestEntity;

import java.util.Collection;

public interface TestEntityRepository {
    public Collection<TestEntity> showAll();
    public TestEntity findById(int id);
    public void SavenUpdate(TestEntity t);
    public void deleteById(int id);
}
