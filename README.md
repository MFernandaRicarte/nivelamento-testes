# Testes de Nivelamento

## Conteúdos
- [Teste 1](#teste-1)
- [Teste 2](#teste-2)
- [Teste 3](#teste-3)
- [Teste 4](#teste-4)


## Teste 1
Este teste tem como objetivo avaliar habilidades de Web Scraping utilizando a linguagem Java. A tarefa consiste em:

- Acessar o site da ANS;
- Fazer o download dos anexos I e II disponíveis em formato PDF;
- Compactar ambos os arquivos em um único .zip.

### Como executar?
Primeiro, clone o repositório usando o comando abaixo:
```
git clone https://github.com/MFernandaRicarte/nivelamento-testes.git
```
Na raiz do projeto, execute o comando a seguir:
```
cd teste-1
```
Certifique-se de ter o **Java 17+** e o **Maven** instalados.

### ✅ Execução recomendada (via IntelliJ IDEA)

Caso esteja utilizando a IDE IntelliJ IDEA, recomenda-se executar o projeto diretamente pela interface da IDE, utilizando o ícone de execução exibido ao lado do método main na classe WebScraper.java.

### 💡 Alternativa (execução via terminal)
1. Baixe a biblioteca Jsoup:
```
mkdir -p libs
curl -L -o libs/jsoup-1.16.1.jar https://repo1.maven.org/maven2/org/jsoup/jsoup/1.16.1/jsoup-1.16.1.jar
```
2. Compile o projeto:
```
mkdir -p out
javac -cp "libs/jsoup-1.16.1.jar" -d out src/main/java/br/com/nivelamento/WebScraper.java
```
3. Execute o programa:

-  No Linux:
```
java -cp "out:libs/jsoup-1.16.1.jar" br.com.nivelamento.WebScraper
```
-  No Windows:
```
java -cp "out;libs/jsoup-1.16.1.jar" br.com.nivelamento.WebScraper
```
### 🛠️ Tecnologias utilizadas

- Java
- Jsoup 1.16.1 – biblioteca utilizada para realizar o web scraping e extrair os links dos arquivos PDF
- API padrão do Java (java.util.zip) – utilizada para compactação dos arquivos em .zip

## Teste 2


