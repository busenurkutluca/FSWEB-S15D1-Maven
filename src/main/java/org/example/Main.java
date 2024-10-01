package org.example;

import org.example.models.Grocery;
import org.example.mobile.Contact;
import org.example.mobile.MobilePhone;

public class Main {
    public static void main(String[] args) {
        // Market arabası uygulamasını başlat
        System.out.println("Starting Grocery List Application...");
        Grocery.startGrocery();  // Bu, market arabası uygulamanı başlatır.

        // Mobil telefon uygulaması için bir telefon numarası gir
        System.out.println("\nStarting Mobile Phone Application...");
        MobilePhone mobilePhone = new MobilePhone("5551234567");

        // Yeni kişiler ekleyelim
        Contact bob = Contact.createContact("Bob", "31415926");
        Contact alice = Contact.createContact("Alice", "16180339");

        mobilePhone.addNewContact(bob);
        mobilePhone.addNewContact(alice);

        // Kişi listesini yazdır
        mobilePhone.printContacts();
    }
}
