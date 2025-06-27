# Plantio Backend

Projeto backend para o sistema de plantio MHQA.

## Tecnologias
- Java
- Spring Boot
- Maven

## Pré-requisitos
- Java 17+
- Maven 3.8+

## Configuração
1. Clone o repositório
2. Execute `mvn clean install`
3. Execute `mvn spring-boot:run` para iniciar a aplicação

## Docker
O projeto inclui um Dockerfile para construção de imagens e um arquivo Compose.yml para orquestração.

```bash
docker-compose up --build
```

## Estrutura do Projeto
- `Backend/`: Contém o código fonte principal
  - `src/main/`: Código da aplicação
  - `src/test/`: Testes
- `.github/workflows/`: CI/CD

## Licença
MIT