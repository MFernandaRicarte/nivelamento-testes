# Testes de Nivelamento

## Conteúdos
- [Teste 1](#teste-1)
- [Teste 2](#teste-2)
- [Teste 3](#teste-3)
- [Teste 4](#teste-4)

### ⚠️ Observação importante:
Os Testes 1 e 2 utilizam bibliotecas externas e arquivos de entrada. Por isso, recomenda-se fortemente executá-los pela IDE IntelliJ IDEA, que gerencia automaticamente as dependências e o ambiente de execução, evitando erros comuns no terminal.

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
Este teste tem como objetivo avaliar habilidades de transformação e manipulação de dados estruturados a partir de um documento em PDF. A tarefa consiste em:
- Extrair os dados da tabela Rol de Procedimentos e Eventos em Saúde presente no Anexo I do Teste 1 (todas as páginas);
- Salvar os dados extraídos em um arquivo .csv;
- Compactar esse arquivo em um .zip com o nome Teste_Fernanda.zip;
- Substituir as abreviações das colunas OD e AMB pelas descrições completas, conforme a legenda do rodapé do documento.

### Como executar?
Após clonar o projeto, na raiz, execute o comando a seguir:
```
cd teste-2
```
### ✅ Execução recomendada (via IntelliJ IDEA)
Caso esteja utilizando a IDE IntelliJ IDEA, execute a classe Main.java utilizando o ícone de execução ao lado do método main.

### 🛠️ Tecnologias utilizadas
- Java 17 – linguagem utilizada para desenvolvimento da aplicação
- Apache PDFBox – biblioteca utilizada para leitura e extração de texto do PDF
- OpenCSV – biblioteca utilizada para gerar o arquivo CSV
- API padrão do Java (java.util.zip) – utilizada para compactar o CSV em .zip

## Teste 3
Este teste tem como objetivo avaliar conhecimentos em banco de dados, modelagem, importação de dados e criação de consultas analíticas utilizando SQL. As tarefas consistem em:
- Estruturar tabelas compatíveis com os arquivos CSV fornecidos pela ANS;
- Importar dados corretamente, respeitando o encoding dos arquivos;
- Desenvolver queries analíticas para responder a perguntas sobre despesas das operadoras de planos de saúde.

### 🖼️ Resultados das consultas
Resultado Top 10 despesas médico-hospitalares – Trimestre

![image (1)](https://github.com/user-attachments/assets/56a1bafb-5e61-46be-8ecb-460e4db6961f)

Resultado Top 10 despesas médico-hospitalares – Ano

![image](https://github.com/user-attachments/assets/7c7b6064-85c2-495d-8810-bce81b3c8459)


### 🛠️ Tecnologias utilizadas
- SQL (PostgreSQL 13) – linguagem utilizada nos scripts e consultas
- DBeaver – ferramenta utilizada para testar, visualizar e validar os scripts SQL
- IntelliJ IDEA – utilizado apenas para organização e versionamento dos arquivos no GitHub

### Observação
Os scripts foram testados e validados no ambiente DBeaver com PostgreSQL.
Após a execução, os arquivos foram organizados no projeto via IntelliJ IDEA para fins de versionamento e publicação no GitHub.
