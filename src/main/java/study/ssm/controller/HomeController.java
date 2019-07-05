package study.ssm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import study.ssm.service.BookService;
import study.ssm.service.impl.BookServiceImpl;

@Controller
public class HomeController {

    private final BookServiceImpl bookService;

    public HomeController(BookServiceImpl bookService) {
        this.bookService = bookService;
    }

    @RequestMapping(value = {"/", "/index"})
    public String index(Model model){
        model.addAttribute("books", bookService.getBookList());
        return "index.jsp";
    }

}
