package com.java.spring.boot.service;

import com.java.spring.boot.model.Model;
import org.springframework.boot.Banner;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Map;

public interface ModelService {

    Model save(Model model);
    Model getById(int id);
//    Page<Model> getModels(Map<String,String> params);

    Page<Model> getModels(Map<String,String> params);
}
