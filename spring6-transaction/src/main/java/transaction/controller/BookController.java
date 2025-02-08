package transaction.controller;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import transaction.service.ServiceImp;

@Data
@Controller
public class BookController {
    @Autowired
    private final ServiceImp service;
    
    // 买书
    @Transactional
    public void buyBook(Integer bookId, Integer userId) {
        service.buyBook(bookId, userId);
    }
}
