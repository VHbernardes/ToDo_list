# Use uma imagem base com o JDK
FROM openjdk:17-jdk-slim

# Adicione informações sobre o autor (opcional)
LABEL authors="Victor"

# Atualize o repositório e instale o Maven
RUN apt-get update && apt-get install -y maven

# Defina o diretório de trabalho dentro do container
WORKDIR /app

# Copie o arquivo pom.xml para baixar dependências primeiro
#COPY pom.xml .
COPY gerenciador_tarefas/pom.xml .

# Baixe as dependências do Maven
RUN mvn dependency:go-offline

# Copie o restante do código da aplicação
COPY src /app/src

# Compile e empacote a aplicação (sem executar os testes)
RUN mvn clean package -DskipTests

# Exponha a porta que o Spring Boot usa (8080 é a porta padrão)
EXPOSE 8080

# Copiar o arquivo .jar para o container
#COPY target/gerenciador_tarefas-0.0.1-SNAPSHOT.jar /app/gerenciador-tarefas.jar
COPY gerenciador_tarefas/target/gerenciador_tarefas-0.0.1-SNAPSHOT.jar /app/gerenciador-tarefas.jar

# Verificar se o .jar foi copiado corretamente
RUN ls -al /app

# Comando para rodar a aplicação
CMD ["java", "-jar", "/app/gerenciador-tarefas.jar"]
