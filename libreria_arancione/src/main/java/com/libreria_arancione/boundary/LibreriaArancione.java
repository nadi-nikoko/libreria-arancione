package com.libreria_arancione.boundary;

import java.util.List;
import java.util.Optional;

import com.libreria_arancione.control.Store;
import com.libreria_arancione.entity.BookTransaction;
import com.libreria_arancione.entity.BookShop;
import com.libreria_arancione.entity.Student;

public class LibreriaArancione {

    // Student Methods

    public static void addStudent(String name, String surname, String email, String phone, String schoolYear) {

        Student std = new Student(name, surname, email, phone, schoolYear);
        Store.saveStudent(std);
    }

    public static void updateStudent(Student Student) {
        Store.saveStudent(Student);
    }

    public static Student findStudentById(int id) {
        Optional<Student> std = Store.findStudentById(id);
        return std.orElseThrow(() -> new RuntimeException("Student not found"));
    }

    public static List<Student> findStudentsByName(String student) {
        List<Student> studentsByName = Store.findStudentByName(student);
        return studentsByName;
    }

    public static void deleteStudent(int id) {
        Student student = findStudentById(id);
        Store.InvalidateStudent(student);
    }

    // Book Methods

    public static void saveBook(String title, String author, int iSBN, int yearOfPublication,
            String publisher) {
        BookShop book = new BookShop(title, author, yearOfPublication, iSBN, publisher);
        Store.saveBook(book);
    }

    public static void updateBook(BookShop book) {
        Store.AddBook(book);
    }

    public static BookShop findBookById(int id) {
        Optional<BookShop> bookOptional = Store.findBookById(id);
        return bookOptional.orElseThrow(() -> new RuntimeException("Book not found"));
    }

    public static List<BookShop> findBookByTitleOrAuthor(String book) {
        List<BookShop> bookList = Store.findBookByTitleOrAuthor(book);
        return bookList;
    }

    public static void deleteBook(int id) {
        BookShop book = findBookById(id);
        Store.InvalidateBook(book);
    }

    // Other Methods

    public static void Purchase(BookShop bookById, Student studentById, int price) {
        BookTransaction purchase = new BookTransaction(bookById, studentById, price);
        Store.changeAvailabilityBook(bookById, false);
        Store.saveBookTransaction(purchase);
    }

    public static List<BookTransaction> booksTransactionList() {
        return Store.booksTransactionList();
    }

    public static int TotalBooksSold() {
        return Store.TotalBooksSold();
    }

    public static int TotalCash() {
        return Store.TotalCash();
    }

}
