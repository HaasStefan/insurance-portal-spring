# insurance-portal-spring

This is my first Spring application that serves as the backend for my frontend: [Angular Frontend](https://github.com/HaasStefan/ng-journal-insurance-portal/)

I tried to implement a solid flow with a good structure for this simple CRUD use case:

1. Controller (DTO)
2. Service Implementation (DTO -> Domain Model)
3. Repository (Domain Model)

# Todos
1. Tests (maybe with a cancellation service --> which is not just basic crud)
2. Missing domain logic (complaint, claim)
3. Fix CORS
4. DB Migrations using Flyway
5. Dockerize
