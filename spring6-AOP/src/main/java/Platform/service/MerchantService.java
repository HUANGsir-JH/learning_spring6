package Platform.service;

import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.List;

@Data
@Service
public class MerchantService {
    public void updateMenu(String merchantID, List<String> items) {
        System.out.println("Merchant: " + merchantID + " update menu: " + items.toString());
    }
}
