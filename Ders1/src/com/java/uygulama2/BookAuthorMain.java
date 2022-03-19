/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.java.uygulama2;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author m07er
 */
public class BookAuthorMain {

    public static void main(String[] args) {

        Author author1 = new Author(1, "Ahmet Hamdi", "Tanpınar", 57, true);
        Author author2 = new Author(2, "Halide Edip", "Adıvar", 49, false);
        Books book1 = new Books(1, "Huzur", 15.99, "1948");
        Books book2 = new Books(2, "Beş Şehir", 16.99, "1946");
        Books book3 = new Books(1, "Ateşten Gömlek", 14.99, "1922");
        Books book4 = new Books(2, "Mor Salkımlı Ev", 19.99, "1926");
        List<Books> listBooks = new ArrayList<Books>();
        author1.setListBook(listBooks);
        author2.setListBook(listBooks);
        book1.setAuthor(author1);
        book2.setAuthor(author1);
        book3.setAuthor(author2);
        book4.setAuthor(author2);
        author1.getListBook().add(book1);
        author1.getListBook().add(book2);
        author2.getListBook().add(book3);
        author2.getListBook().add(book4);

        for (Books book : listBooks) {
            System.out.print("Yazar TC : " + book.getAuthor().getAuthorIdentifier() + " --- ");
            System.out.print("Yazar Adı : " + book.getAuthor().FullName() + " --- ");
            System.out.print("Yazar Yaşı : " + book.getAuthor().getAuthorAge() + " --- ");
            System.out.print("Yazar Cinsiyeti : " + book.getAuthor().Gender() + " --- ");
            System.out.print("Kitap ID : " + book.getBookId() + " --- ");
            System.out.print("Kitap Adı : " + book.getBookName() + " --- ");
            System.out.print("Kitap Fiyatı : " + book.getSalesPrices() + " --- ");
            System.out.println("Kitap Tarihi : " + book.getCreatedDate());
        }
    }
}
