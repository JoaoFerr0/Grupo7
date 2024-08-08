# Projeto de Simulação de Circuitos Elétricos
**Grupo: 7**  
**Integrantes/papéis:**  
João Victor Ferro / Líder, coordenador de desenvolvimento back-end, dev back-end, tester/validação  
Theodoro Costa Modesto / Dev back-end, dev front-end  
Viviano Acosta / Dev back-end, dev front-end

## Introudução

A análise de circuitos elétricos é uma das disciplinas mais subestimadas dos cursos de Engenharia Elétrica por parecer simples a primeira vista. 
No entanto, com o passar dos dias e ao passo que o professor avança com o conteúdo, as coisas podem se tornar difíceis, principalemente quando o 
tema avança para análise de circuitos no regime de corrente alternada. Esta simples mudança leva os alunos a terem que aprender conceitos matemáticos 
novos, de domínio da frequência, fasores, além de exigir um bom trato com o tema de números complexos e álgebra linear para resolver os complicados
sistemas lineares aos quais levam a resolução de algumas questões comuns, das quais nem sempre é possível ter acesso à solução para conferência de 
resultados.  
É pensando nesta dificuldade que o nosso grupo idealizou uma aplicação que seja capaz de ajudar os alunos a conferir os resultados dos cansativos 
cálculos desenvolvidos.  
Devendo usar a linguagem de programação Java, escopo da disciplina de Programação Orientada a Objetos do curso de Engenharia Elétrica da UFG, nos
propusemos a desenvolver uma aplicação que seja capaz de simular circuitos elétricos lineares (que só contém componentes lineares, como resistores
capacitores e indutores), apresentando os resultados com precisão e rapidez.  
Com o escopo geral do problema definido, por simplicidade, nos focamos em desenvolver um código capaz de modelar satisfatoriamente circuitos
lineares com uma fonte de tensão independente via análise nodal no domínio da frequência.

## Plano
  **Objetivo geral:** desenvolver uma aplicação em arquitetura MVC que seja capaz de receber a topologia de circuito desejada, assim como os parâmetros
                      dos componentes e devolver ao usuário, de maneira simples, os resultados da simulação.  
  **Objetivos específicos:**   
                               1. Desenvolver o modelo de classes básicas dos componentes a serem aplicados à simulação  
                               2. Desenvolver a metodologia adequada de tratamento dos componentes no domínio da frequência  
                               3. Desenvolver elementos de conexão e interação entre os componentes básicos  
                               4. Desenvolver o modelo adequado para definição da topologia do circuito  
                               5. Desenvolver a metodologia de resolução do circuito via análise nodal  
                               6. Desenvolver a interface gráfica adequada para seleção e impressão dos resultados  
                               7. Desenvolver a integração entre a interface gráfica e o modelo com arquitetura MVC  

## Tarefas 
- João Victor: desenvolver adequadamente algumas classes básicas do projeto e coordenar o desenvolvimento de outras por parte dos outros integrantes; 
produzir a documentação adequada para as classes básicas desenvolvidas; coordenar o desenvolvimento da metodologia de tratamento dos componentes no 
domínio dafrequência; desenvolver os elementos de conexão e interação dos componentes; desenvolver o modelo de definição de topologia e resolução do 
sistema.  

- Theodoro: desenvolver adequadamente algumas classes básicas do projeto; produzir documentação adequada para as classes desenvolvidas; cooperar no
desenvolvimento da interface gráfica; cooperar no desenvolvimento da integração GUI/model com arquitetura MVC.

- Viviano: desevolver adequadamente algumas classe básicas do projeto, produzir documentação adequada para as classes desenvolvidas, cooperar no
desenvolvimento da interface gráfica; cooperar no desenvolvimento da integração GUI/model com arquitetura MVC.
  
## Modelagem inicial





