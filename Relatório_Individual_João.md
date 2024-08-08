# Relatório de atividades individuais
**Grupo:** 7  
**Aluno:** João Victor Ferro  

O projeto foi desenvolvido usando em grande parte a IDE BlueJ, com suporte para linguegem Java. Outros porgramas utilizados foram:
VSCode, para desenvolvimento de código e visualização de códigos em formato fxml; SceneBuilder, utilizado para montar de modo visual a 
interface a ser pretensamente utilizada na aplicação; GitBash e WindowsPowerShell, usados para realizar

No decorrer do projeto, busquei a melhor maneira de realizar os cálculo de modo mais simples e geral possível. No início tive a ideia de 
trabalhar com interfaces, classes e métodos que permitissem realizar a simulação por meio da redução do cirucito a uma impedância equivalente, 
simplificando o cálculo e depois expandir o sistema usando divisores de tensão e corrente, por pensar que esta seria a abordagem mais fácil de 
desenvolver, isso me levou a desenvolver inicialmente uma interface chamada Imped, que serviria como base para a implementação dos métodos 
necessários para tratar os componentes passivos no domínio da frequência. A ideia não levou a um caminho conveniente e acabei por utilizar
o mesmo nome, Imped, mas para codificar uma classe que serviria para que seus objetos servissem como atribuito impedância dos componentes 
passivos.  
Com o passar do tempo a ideia de redução/expansão de circuitos se mostrou uma abordagem mais complexa e principalmente limitadaque o esperado 
e resolvemos em conjunto desenvolver outra ideia. Partimos para a análise de circuitos pelo método de análise nodal. Esta abordagem exigiria
um modelo capaz de gerar e resolver sistemas lineares com o uso de matrizes e vetores utilizando números complexos. Neste ponto, houve a 
tentativa de aproveitar a classe Imped para modelar números complexos, visto que sua estrutura já estava voltada para isto. Porém isso também 
se mostrou inviável, pois teríamos que trabalhar e construir complexas operações de álgebra linear com matrizes e vetores que usassem este tipo
de objeto.  
Por fim resolvi descartar a classe Imped, que a esta altura já tinha sido renomeada como NComplexo, e trocar toda esta implementação pelo import 
de uma biblioteca com suporte para álgebra linear e número complexos (org.apache.commons.math3), e ainda assim levou um tempo até eu entender 
como utilizar as duas coisas juntas. A maior dificuldade enfrentada na construção do modelo de resolução foi o processo de construção da matriz 
de admitâncias com base nas condições de contorno impostas pela fonte de tensão de alimentação do sistema. Por fim o modelo ficou pronto e foram 
executados alguns testes com o intuito de validar os resultados, usando como base de comparação um simulador comercial desenvolvido para plataforma 
mobile (app: Proto, disponível em Play Store em 07/08/2024).  
No desenvolvimento 
