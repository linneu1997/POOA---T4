## Programação Orientada a Objetos Avançada - T4
<p align="justify"> Nome: Linneu Augusto Mendo Zanco - 769155 </br>
 </p>
 
## Introdução
<p align="justify"> Os 5 princípios SOLID são princípios bem estabelecidos utilizados na programação orientada a objetos com o intuito de garantir uma boa coesão do código desenvolvido, garantindo uma facilidade de manutenção e extensão do código conforme o desenvolvimento do projeto.</p>
<p align="justify"> Esse trabalho visa o desenvolvimento de um programa simples que implementa todos os 5 princípios SOLID. Dessa forma, foi desenvolvido um programa bastante simples que simula o funcionamento de um aplicativo de controle virtual dos sistemas de uma casa. O programa faz, por exemplo, a abertura e fechamento de portas, acender e apagar luzes, entre outros
</p>

## Desenvolvimeto
<p align="justify"> O programa foi, inicialmente, desenvolvido seguindo uma arquitetura de 3 camadas. Esse tipo de arquitetura separa classes em 3 diferentes camadas, dependendo da função de cada classe, garantindo melhor coesão e abstração dos códigos. As camadas utilizadas foram chamadas de "domain", "service" e "controler". Em "domain" foram mantidas as classes relacionadas a armazenanmento de dados, as classes de objetos base, com os métodos construtores. Na camada "service", foram mantidas as classes relacionadas à operações do sistema. Por fim, a camada mais ao topo, "controller" mantém os métodos de interação do usuário </p>
<p align="justify"> O primeiro princípio SOLID, o Princípio da Responsabilidade Única, diz que cada classe deve ter apenas um motivo para mudança. Isso significa dizer que cada classe deve ter apenas uma responsabilidade. A arquitetura de 3 camadas demonstra bem como esse princípio foi aplicado neste projeto. Cada classe, serve apenas uma única função de acordo com a camada em que ela está inserida. Por exemplo, a classe "Alarme" apenas mantém os dados dos alarmes inseridos no sistema, enquanto a classe "AlarmeService" mantém operações como ligar ou desligar um alarme, e a classe "AlarmeController" dá ao usuário a opção de interagir com esses serviços. </p>
<p align="justify"> O segundo princípio, o Princípio do Aberto-Fechado, diz que classes devem ser abertos para extensão, mas fechados para modificação. Dizer que um código é aberto para extensão significa que conforme o desenvolvimento avança, o código deve estar apto a ser extendido de maneira a receber os novos comportamentos requeridos. No entanto, devemos garantir que o código é fechado para modificação, ou seja, devemos garantir que esses novos comportamentos sendo adicionados não requerem modificação do código previamente escrito, apenas adição de mais código. </p>
<p align = "justify"> No programa desenvolvido, podemos ver esse princípio, por exemplo, na classe abstrata "InterruptorService". Essa classe implementa os métodos de serviço para objetos do tipo "interruptor". No entanto, temos dois tipos de objetos com interruptores, lâmpadas e ventiladores, cada um desses com um comportamento diferente. A classe abstrata "InterruptorService", então implementa os métodos para interruptores e as classes "LampadaService" e "VentiladorService" herdam dessa classe alterando seus métodos para refletir o comportamento diferente de cada objeto. Dessa maneira, demonstramos como novas funcionalidades podem ser adicionadas sem alterar o código previamente escrito. Da mesma forma que fizemos em "LampadaService" e "VentiladorService", podemos incluir em nosso código novos dispositivos dependentes de interruptores por meio da herança da classe "InterruptorService".</p>
<p align = "justify"> O princípio da Substituição de Liskov dita que devemos ser capazes de utilizar um objeto de uma classe derivada no lugar de um objeto da classe pai e o código deve funcionar de maneira correta. A classe "InterruptorService" é novamente uma boa maneira de exemplificar esse princípio. </p>

## Aplicação
No exemplo 1 podemos ver o código para um sistema de biblioteca:


~~~C++
struct livro {
  emprestimo = 0; </br>
  ...
} Livro;

public class Biblioteca {
    public void emprestar_livro(Livro livro){
          livro.emprestimo = 1; #Livro emprestado
    }
    
    public void devolver_livro(Livro livro){
          livro.emprestimo = 0; #Livro devolvido
    }
    
    public void imprimir_livros(Livro livro){
          printf("%s", livro.dados);
    }
}
~~~

<p align="center">Exemplo 1</p></br>
<p align="justify">No código desse sistema temos uma única classe “Biblioteca” com três métodos. O primeiro método, “emprestar_livro”, realiza um empréstimo, alterando os atributos do livro para indicar que ele foi emprestado. No método “devolver_livro” vemos o comportamento oposto, ele altera o valor do atributo “emprestimo” para indicar que o cliente devolveu um livro que havia sido emprestado. O último método, “imprimir_livros”, imprime os dados de um livro.</p>
<p align="justify">Podemos ver que esse programa não segue o conceito do SRP. Os métodos da classe “Biblioteca” possuem responsabilidades diferentes. Enquanto os dois primeiros métodos são responsáveis pela retirada e manipulação de livros na biblioteca, o último método é responsável por mostrar as informações de um livro.</p>
<p align="justify">Para manter a coesão de nosso código e diminuir o acoplamento, podemos dividir essa classe em duas novas classes diferentes, cada uma assumindo uma das responsabilidades descritas previamente. Podemos ver isso no exemplo 2.
</p></br></br>

~~~C++
struct livro {
  emprestimo = 0;
  ...
} Livro;

public class Imprimir {
    public void imprimir_livros(Livro livro){
          printf("%s", livro.dados);
    }
    
 }
 
 public class Manuseio_livro {
    public void devolver_livro(Livro livro){
          livro.emprestimo = 0; #Livro devolvido
    }
    
    public void emprestar_livro(Livro livro){
          livro.mprestimo = 1; #Livro emprestado
    }
 }
~~~
<p align="center">Exemplo 2</p></br>
<p align="justify">Agora temos duas classes. A classe “Imprimir” manteve o método “imprimir_livros”, ela se torna assim unicamente responsável por exibir os dados do livro cadastrado. Já a classe “Manuseio_livro” adotou os métodos “devolver_livro” e “emprestar_livro”, sendo então responsável por realizar a retirada e manuseio dos livros da biblioteca. Dessa forma o código se tornou mais coeso e de fácil manutenção. Ao realizar alteração nos métodos de empréstimo, por exemplo, já não temos mais que nos preocupar em afetar a função de imprimir.</p>
<p align="justify">É importante notar que os métodos para emprestar e devolver livros são diferentes, porém realizam a mesma função. Assim, ao se aplicar o SRP, ambos os métodos pertencem à mesma classe. Isso deve ser frisado, pois um erro comum é se confundir nas responsabilidades de cada método. Muitas vezes isso leva à implementação errada do conceito, criando códigos com classes que deveriam estar juntas, pois são utilizadas em conjunto, possuem a mesma função ou são altamente coesas. 
</p>

## Conclusão
<p align="justify">O Princípio da Responsabilidade Única é um importante método para manter um programa enxuto e de fácil manutenção. Apesar de ser um conceito simples, é importante se atentar à coesão para não realizar alterações erradas. Devemos pensar de maneira simples para garantir que não estamos fazendo alterações desnecessárias.
</p>
</br></br>

## Referências
<p align="justify">
Robert Martin, Micah Martin, Princípios, Padrões e Práticas Ágeis em C#,  Bookman Editora, 2009.
</p>
