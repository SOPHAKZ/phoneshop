package phone.shop.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import phone.shop.exception.ResourceNotFoundResponse;
import phone.shop.model.Color;
import phone.shop.repository.ColorRepository;
import phone.shop.service.ColorService;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ColorServicesImpl implements ColorService {

    private final ColorRepository colorRepository;
    @Override
    public Color saveColor(Color color) {
        return colorRepository.save(color);
    }

    @Override
    public Color getColorById(Long id) {
        return colorRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundResponse("Color",id));
    }
}
