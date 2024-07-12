# Bookingspace Application

## Testdaten

Die Testdaten für die Anwendung werden beim Start automatisch geladen. Dies geschieht in der `BookingspaceApplication`-Klasse unter Verwendung der `CommandLineRunner`-Schnittstelle.

### Wo und wie die Testdaten definiert werden

In der Methode `demoUsers` innerhalb der `BookingspaceApplication`-Klasse werden Beispielbenutzer und -buchungen erstellt und in die entsprechenden Repositories gespeichert.

#### Beispielbenutzer

Es werden vier Beispielbenutzer erstellt, jeder mit einer eindeutigen ID, einem Namen, einer E-Mail-Adresse, einem Passwort und einer Rolle. Die Passwörter werden mit dem `BCrypt`-Algorithmus gehasht.

#### Beispielbuchungen

Ebenso werden vier Beispielbuchungen erstellt, jede mit einer eindeutigen ID, einem Datum, einem Buchungstyp, einem Buchungsstatus und einem zugehörigen Benutzer.

### Laden der Testdaten

Die Methode `demoUsers` wird als Bean definiert und automatisch beim Start der Anwendung ausgeführt, was sicherstellt, dass die Testdaten in die Datenbank geladen werden.

```java
@Bean
public CommandLineRunner demoUsers(CustomerRepository customerRepository, BookingRepository bookingRepository) {
    return (args) -> {
        // Beispielbenutzer erstellen und speichern
        Customer c1 = new Customer(1L, "Sujan", "Sa-Van", "sujan.savan@customer.ch","" , BCrypt.hashpw("123", BCrypt.gensalt()), Roles.ADMIN);
        Customer c2 = new Customer(2L, "Äl", "Bane", "ÄlBane@customer.ch","" , BCrypt.hashpw("123", BCrypt.gensalt()), Roles.MEMBER);
        Customer c3 = new Customer(3L, "Ethan", "Luber", "liketurtles@customer.ch","" , BCrypt.hashpw("123", BCrypt.gensalt()), Roles.MEMBER);
        Customer c4 = new Customer(4L, "fiction", "al-persen", "fictionalPerson@customer.ch","" , BCrypt.hashpw("123", BCrypt.gensalt()), Roles.MEMBER);

        customerRepository.save(c1);
        customerRepository.save(c2);
        customerRepository.save(c3);
        customerRepository.save(c4);

        // Beispielbuchungen erstellen und speichern
        Booking b1 = new Booking(1L, Date.valueOf("2023-07-01"), BookingTypes.FULL_DAY, BookingStatus.PENDING, 1L, c1);
        Booking b2 = new Booking(2L, Date.valueOf("2023-07-02"), BookingTypes.HALF_DAY, BookingStatus.PENDING, 2L, c2);
        Booking b3 = new Booking(3L, Date.valueOf("2023-07-03"), BookingTypes.FULL_DAY, BookingStatus.PENDING, 3L, c3);
        Booking b4 = new Booking(4L, Date.valueOf("2023-07-04"), BookingTypes.HALF_DAY, BookingStatus.PENDING, 4L, c4);

        bookingRepository.save(b1);
        bookingRepository.save(b2);
        bookingRepository.save(b3);
        bookingRepository.save(b4);
    };
}