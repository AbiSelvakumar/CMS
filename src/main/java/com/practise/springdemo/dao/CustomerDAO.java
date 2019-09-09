package com.practise.springdemo.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.practise.springdemo.model.SpringModel;

@Repository
public interface CustomerDAO extends CrudRepository<SpringModel, Integer>{

@Override
List<SpringModel> findAll();

}
