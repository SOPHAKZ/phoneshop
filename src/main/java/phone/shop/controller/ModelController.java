package phone.shop.controller;

import phone.shop.dto.ModelDTO;
import phone.shop.dto.PageDTO;
import phone.shop.mapper.ModelMapper;
import phone.shop.mapper.PageMapper;
import phone.shop.model.Model;
import phone.shop.service.ModelService;
import lombok.RequiredArgsConstructor;

import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static phone.shop.mapper.ModelMapper.INSTANCE;

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

        ModelDTO modelDTO = INSTANCE.toModelDTO(model);
        return ResponseEntity.ok(modelDTO);

    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable("id") Long id){
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
