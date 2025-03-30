## Use uma imagem base com o JDK
#FROM openjdk:17-jdk-slim
#
## Adicione informações sobre o autor (opcional)
#LABEL authors="Victor"
#
## Atualize o repositório e instale o Maven
#RUN apt-get update && apt-get install -y maven
#
## Defina o diretório de trabalho dentro do container
#WORKDIR /app
#
## Copie o arquivo pom.xml para baixar dependências primeiro
#COPY pom.xml .
#
## Baixe as dependências do Maven
#RUN mvn dependency:go-offline
#
## Copie o restante do código da aplicação
#COPY src /app/src
#
## Compile e empacote a aplicação (sem executar os testes)
#RUN mvn clean package -DskipTests
#
## Exponha a porta que o Spring Boot usa (8080 é a porta padrão)
#EXPOSE 8080
#
## Copiar o arquivo .jar para o container
#COPY target/gerenciador_tarefas-0.0.1-SNAPSHOT.jar /app/gerenciador-tarefas.jar
#
## Verificar se o .jar foi copiado corretamente
#RUN ls -al /app
#
## Comando para rodar a aplicação
#CMD ["java", "-jar", "/app/gerenciador-tarefas.jar"]

# Etapa 1: Construir o projeto com Maven
FROM maven:3.8.5-openjdk-17 AS builder

# Definir o diretório de trabalho
WORKDIR /app

# Copiar o arquivo pom.xml e baixar as dependências primeiro
COPY pom.xml .

# Baixar dependências para cache
RUN mvn dependency:go-offline

# Copiar todo o código da aplicação
COPY src ./src

# Compilar e empacotar a aplicação (sem executar os testes)
RUN mvn clean package -DskipTests

# Etapa 2: Criar a imagem final com apenas o .jar gerado
FROM openjdk:17-jdk-slim

WORKDIR /app

# Copiar o JAR gerado na fase anterior
COPY --from=builder /app/target/gerenciador_tarefas-0.0.1-SNAPSHOT.jar /app/gerenciador-tarefas.jar

# Expor a porta 8080 (opcional, mas recomendado)
EXPOSE 8080

# Comando para rodar a aplicação
CMD ["java", "-jar", "/app/gerenciador-tarefas.jar"]