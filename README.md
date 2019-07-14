# Teste Técnico JL
## Sistema proposto para avaliar o conhcimento técnico.
---
### Pré Requisitos

- README bem descrito para implantação e utilização do sistema.
- Java 8
- Maven
- Tomcat
- PostgreSQL
- Github
- Swing (aplicação Desktop)
- JSF (aplicação Web)
- JPA (Hibernate ou Eclipselink)

---
### Sistema Proposto
 Uma empresa necessita de uma ferramenta para controlar manualmente o estoque de produtos diversos.  
 Sabendo disto, desenvolver duas aplicações.
 
1. Aplicação Desktop
  1. Tela para cadastrar e editar produtos
  2. Tela para controlar a entrada e saída de estoque
2. Fourth item
  1. Uma página inicial que exibe uma lista de produtos com estoque baixo
  2. Uma página para realizar uma busca de um produto pela sua descrição e exibir seu detalhes cadastrais e informação atualizada do estoque.
  
---
## Sistema Desenvolvido

### Aplicação Desktop

 A aplicação Desktop foi desenvolvida respeitando os requisitos básicos.  
 
 1. Conta com um JFrame principal que contém um JMenuBar para navegação do sistema.
 2. JMenuBar com dois JMenu um para produtos e outro para a movimentação dos estoque.
  1. Os dois JMenu contém dois JMenuItem, para cadastro e listagem dos registros.
 3. As telas tanto de Cadastro como a de Listagem são JInternalFrame.
 4. Para fazer Edição de algum registro, basta selecionar o mesmo na tabela de registro e escolher a opção editar.
 
 ### Aplicação Web
 
 Ainda em desenvolvimento.
  
