package com.java.spring.boot.controller;

import com.java.spring.boot.dto.ModelDTO;
import com.java.spring.boot.dto.PageDTO;
import com.java.spring.boot.mapper.ModelMapper;
import com.java.spring.boot.mapper.PageMapper;
import com.java.spring.boot.model.Model;
import com.java.spring.boot.service.ModelService;
import lombok.RequiredArgsConstructor;

import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("api/v1/model")
@RequiredArgsConstructor
public class ModelController {
    private final ModelService modelService;

    private final ModelMapper modelMapper;

    @PostMapping("/save")
    public ResponseEntity<?> create(@RequestBody ModelDTO dto){
        Model model = modelMapper.toModelEntity(dto);
        modelService.save(model);

        ModelDTO modelDTO = modelMapper.INSTANCE.toModelDTO(model);
        return ResponseEntity.ok(modelDTO);

    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable("id") int id){
        Model model = modelService.getById(id);
        return ResponseEntity.ok(ModelMapper.INSTANCE.toModelDTO(model));
    }
    @GetMapping("/all")
    public ResponseEntity<?> getAll(@RequestParam Map<String,String> params){
        Page<Model> data = modelService.getModels(params);

        PageDTO dto = PageMapper.INSTANCE.toDTO(data);
        dto.setData(data.get()
                .map(ModelMapper.INSTANCE::toModelDTO).toList());
        return ResponseEntity.ok(dto);
    }
}
