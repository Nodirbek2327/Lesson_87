package com.example.Controller;

import com.example.dto.BookDto;
import com.example.dto.StudentDTO;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

@RestController
public class BookController {
    public static List<BookDto> bookDtoList = new LinkedList<>();

    @RequestMapping(value = "/book/create", method = RequestMethod.POST)
    public BookDto create(@RequestBody BookDto bookDto){
        bookDto.setId(UUID.randomUUID().toString());
        bookDtoList.add(bookDto);
        return bookDto;
    }

    @RequestMapping(value = "/book/all", method = RequestMethod.GET)
    public List<BookDto> all() {
        return bookDtoList;
    }

    @RequestMapping(value = "/book/{id}", method = RequestMethod.GET)
    public BookDto getById(@PathVariable("id") String id) {
        BookDto bookDto =  bookDtoList.stream().filter(bookDto1 -> bookDto1.getId().equals(id))
                .findAny().orElse(null);
        return bookDto;
    }

    @RequestMapping(value = "/book/{id}", method = RequestMethod.DELETE)
    public Boolean delete(@PathVariable("id") String id) {
        boolean result = bookDtoList.removeIf(s -> s.getId().equals(id));
        return result;
    }

    @RequestMapping(value = "/book/{id}", method = RequestMethod.PUT)
    public Boolean put(@RequestBody BookDto bookDto,
                       @PathVariable("id") String id) {
        for (BookDto b : bookDtoList) {
            if (b.getId().equals(id)) {
                b.setId(bookDto.getId());
                b.setAuthor(bookDto.getAuthor());
                b.setTitle(bookDto.getTitle());
                b.setPublishYear(bookDto.getPublishYear());
                return true;
            }
        }
        return false;
    }
}
