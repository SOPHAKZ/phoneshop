package phone.shop.service;

import lombok.extern.java.Log;
import phone.shop.model.Color;

public interface ColorService {
    Color saveColor(Color color);
    Color getColorById(Long id);
}
