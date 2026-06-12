# Онлайн-кинотеатр REST API

Лабораторная работа №3 по разработке веб-сервиса на Java.

## Стек технологий
- Java 17
- Spring Boot 3.1.5
- Spring Data JPA (Hibernate)
- H2 Database
- Maven
- Git

## Функциональность
- POST `/api/movies` — создание фильма
- GET `/api/movies` — получение всех фильмов
- GET `/api/movies/{id}` — получение фильма по ID
- PUT `/api/movies/{id}` — обновление фильма
- DELETE `/api/movies/{id}` — удаление фильма



## Запуск проекта

```bash
git clone https://github.com/anastajzia/cinema-lab.git
cd cinema-lab
mvn spring-boot:run
```

После запуска приложение доступно по адресу: http://localhost:8080/api/movies

## H2 Console
- URL: http://localhost:8080/h2-console
- JDBC URL: jdbc:h2:mem:cinema_db
- User: sa
- Password: (пусто)

  <img width="2803" height="2684" alt="схема" src="https://github.com/user-attachments/assets/9ed8453f-4c51-4624-a3d4-662b9e8ff2d7" />


