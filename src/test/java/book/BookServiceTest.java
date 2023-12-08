package book;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class BookServiceTest {
    @Test
    void findBookByIdTestWithMock() {
        BookRepository bookRepository = mock(BookRepository.class);   // Создаем имитацию (мок) для интерфейса BookRepository
        BookService bookService = new BookService(bookRepository); // Создаем экземпляр BookService с имитацией BookRepository
        /* Задаем поведение заглушки: id = 1; title = SomeTitle; author = SomeAuthor; */
        when(bookRepository.findById("1")).thenReturn(new Book("1", "SomeTitle", "SomeAuthor"));
        String id = "1";  // Создаем ожидаемый id
        String actualId = bookService.findBookById("1").getId(); // получаем id книги при вызове метода findBookById() класса BookService.

        assertEquals(id, actualId);
    }
    @Test
    void findAllBooksTestWithMock() {
        BookRepository bookRepository = mock(BookRepository.class);   // Создаем имитацию (мок) для интерфейса BookRepository
        BookService bookService = new BookService(bookRepository); // Создаем экземпляр BookService с имитацией BookRepository
        /* Задаем поведение заглушки:  */
        when(bookRepository.findAll()).thenReturn(new ArrayList<>(Arrays.asList(new Book("1"), new Book("2"), new Book("3"), new Book("4"))));
        int size = 4;  //  длина списка
        int actualSize = bookService.findAllBooks().size(); // получаем длину списка книг при вызове метода findAllBooks() класса BookService.

        assertEquals(size, actualSize);
         }
}