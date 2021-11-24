# Introduction to Spring Framework

Napisz aplikację, która:

- [ ] wyświetli listę wszystkich dostępnych produktów na magazynie
- [ ] zmniejszy ilość produktów na magazynie
- [ ] jeśli ilość produktów na magazynie spadnie do 10 - aplikacja opublikuje zdarzenie, tak aby inne aplikacje, które
  użyją tego kodu, mogły to zdarzenie przechwycić i zalogować ten fakt
- [ ] jeśli ilość produktów na magazynie spadnie do 0 - aplikacja wyśle maila z ostrzeżeniem
    - do testow, mozesz sprobowac uzyc ponizsze skrzynki tymczasowe
        - [Mailtrap](https://mailtrap.io/)
            * Przykladowa konfiguracja w Spring Boocie:

```properties
spring.mail.host=smtp.mailtrap.io
spring.mail.port=2525
spring.mail.username=[user]
spring.mail.password=[password]
spring.mail.properties.mail.smtp.auth=true
spring.mail.properties.mail.smtp.starttls.enable=true
```

        - [Mailinator](https://www.mailinator.com/)

- [ ] policzy czas wykonywania się operacji zmniejszania ilości produktów na magazynie. Zaloguj informacje:
    - jak dlugo wykonywala sie operacja
    - z jakimi parametrami zostala wywołana metoda

# Articles

* [Spring Framework](https://spring.io/)
    * [Core Technologies](https://docs.spring.io/spring-framework/docs/current/reference/html/core.html)
    * [API](https://docs.spring.io/spring-framework/docs/current/javadoc-api/)
* [Baeldung](https://www.baeldung.com/)

