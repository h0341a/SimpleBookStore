package study.ssm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import study.ssm.entity.Book;
import study.ssm.service.BookService;
import study.ssm.service.impl.BookServiceImpl;

import javax.jws.WebParam;
import javax.management.MalformedObjectNameException;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/book")
public class BookController {

    private final BookServiceImpl bookService;

    public BookController(BookServiceImpl bookService) {
        this.bookService = bookService;
    }

    @RequestMapping("/delete")
    public String delete(int bid, Model model, HttpSession session){
        if(session.getAttribute("username") != null && bookService.deleteBook(bid)){
            model.addAttribute("actionState", "删除成功!");
        }else{
            model.addAttribute( "actionState","删除失败!");
        }
        return "index";
    }

    @RequestMapping("/insert")
    public String insert(Book book, Model model, HttpSession session){
        if(session.getAttribute("username") != null && bookService.insertBook(book)){
            model.addAttribute("actionState", "添加成功!");
        }else{
            model.addAttribute( "actionState","添加失败!");
        }
        return "index";
    }


}
