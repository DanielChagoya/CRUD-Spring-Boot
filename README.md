# 🧑‍💻 CRUD de Usuarios con Spring Boot, Thymeleaf y OracleDB

Este proyecto implementa un CRUD de usuarios utilizando Spring Boot, Spring MVC, Thymeleaf, Spring Data JPA y OracleDB.
Incluye interfaz web, validaciones básicas y arquitectura real del ecosistema Spring.

---

## ✨ Características principales

- ✔️ Registrar nuevos usuarios
- ✔️ Listar usuarios en tabla
- ✔️ Editar usuarios
- ✔️ Eliminar usuarios
- ✔️ Arquitectura con Controlador → Servicio → Repositorio
- ✔️ Plantillas Thymeleaf totalmente integradas

---

## 🛠️ Tecnologías utilizadas

- **Java 17**
- **Spring Boot 3.x**
- **Spring MVC**
- **Spring Data JPA**
- **Thymeleaf**
- **OracleDB**
- **Maven**
- **HTML / CSS**

---

## 📂 Estructura del proyecto
```
userapp/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/tuempresa/userapp/
│   │   │       ├── controller/
│   │   │       │     └── UserController.java
│   │   │       ├── model/
│   │   │       │     └── User.java
│   │   │       ├── repository/
│   │   │       │     └── UserRepository.java
│   │   │       ├── service/
│   │   │       │     └── UserService.java
│   │   │       └── UserAppApplication.java
│   │   │
│   │   ├── resources/
│   │   │   ├── templates/
│   │   │   │     ├── index.html
│   │   │   │     ├── form.html
│   │   │   │     └── edit.html
│   │   │   │
│   │   │   ├── static/
│   │   │   │   ├── styles.css
│   │   │   │   └── assets/
│   │   │   │         ├── listado.png
│   │   │   │         ├── formulario.png
│   │   │   │         └── editar.png
│   │   │   │
│   │   │   └── application.properties
│   │   │
│   └── test/
│       └── ...
│
├── pom.xml
├── README.md
└── .gitignore
```
---

## ⚙️ Configuración de la base de datos

Edita tu archivo `application.properties`:

```properties
spring.datasource.url=jdbc:oracle:thin:@localhost:1521:orcl
spring.datasource.username=daniel
spring.datasource.password=12345

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true

```

---

## ▶️ Cómo ejecutar el proyecto

1. Clonar el repositorio: 
```bash 
git clone https://github.com/DanielChagoya/CRUD-Spring-Boot.git
```
2. Importar el proyecto en IntelliJ como Maven Project
3. Crear la base de datos en Oracle
4. Ajustar la configuración en application.properties
5. Ejecutar la app:
```bash
mvn spring-boot:run
```
6. Abrir en el navegador: http://localhost:8080/users

---

## 📸 Capturas del proyecto

![Listado](/src/main/resources/static/assets/Listado.png)
![Formulario](/src/main/resources/static/assets/AgregarUsuario.png)

---

## 👤 Autor

**Daniel Chagoya || Ingeniero en Sistemas Computacionales**  

Proyecto desarrollado como práctica de desarrollo web con Java y Spring Boot.

