## Programação Orientada a Objetos Avançada - T4
<p align="justify"> Nome: Linneu Augusto Mendo Zanco - 769155 </br>
 </p>
 
## Introdução
<p align="justify"> Os 5 princípios SOLID são princípios bem estabelecidos utilizados na programação orientada a objetos com o intuito de garantir uma boa coesão do código desenvolvido, garantindo uma facilidade de manutenção e extensão do código conforme o desenvolvimento do projeto.</p>
<p align="justify"> Esse trabalho visa o desenvolvimento de um programa simples que implementa todos os 5 princípios SOLID. Dessa forma, foi desenvolvido um programa bastante simples que simula o funcionamento de um aplicativo de controle virtual dos sistemas de uma casa. O programa faz, por exemplo, a abertura e fechamento de portas, acender e apagar luzes, entre outros
</p>

## Desenvolvimeto
<p align="justify"> O programa foi, inicialmente, desenvolvido seguindo uma arquitetura de 3 camadas. Esse tipo de arquitetura separa classes em 3 diferentes camadas, dependendo da função de cada classe, garantindo melhor coesão e abstração dos códigos. As camadas utilizadas foram chamadas de "domain", "service" e "controler". Em "domain" foram mantidas as classes relacionadas a armazenanmento de dados, as classes de objetos base, com os métodos construtores. Na camada "service", foram mantidas as classes relacionadas à operações do sistema. Por fim, a camada mais ao topo, "controller" mantém os métodos de interação do usuário </p>

![Arquitetura de 3 Camadas](https://imgur.com/w2QtG0r.png)

<p align = "justify"> A camada domain contém todas as classes com métodos construtures, getters e setters para cada dispositivo, ou seja "Porta", "Alarme", "Lampada" e "Ventilador". Essa camada contém também a classe "Usuario", que contém os métodos getters e setters para objetos do tipo usuário. Por fim, temos a classe "Sistema" que contém estruturas do tipo ArrayList para cada dispositivo. Cada classe implementa a interface de seu nome, no entanto, todos os dispositivos implementam a interface "Devices". </p>

![Camada Domain](https://imgur.com/34K4K7S.png)

<p align = "justify"> A camada services contém as classes com métodos relacionados à operações do sistema. Essas operações são mudar os estados dos dispositivos e obter e exibir as informações dos mesmo. As classes dessa camada são "AlarmeService", "PortaService", "VentiladorService" e "LampadaService". Há também a classe "InterruptorService" que serve como classe abstrata para as suas classes derivadas "LampadaService" e "VentiladorService". Novamente, cada classe implementa a interface com seu respectivo nome </p>

![Camada Service](https://imgur.com/gRonuX1.png)

<p align = "justify"> A última camada é a camada controller. Essa camada é a que recebe interação do usuário. Nela temos a classe "UsuarioController" responsável pelo processo de login e troca de senha. Além disso temos as classes "PortaController", "AlarmeController", "LampadaController" e "VentiladorControler". Essas classes recebem as entradas dadas pelo usuário para definir o estado de cada dispositivo. O programa pode ser então executado através do código da classe "SistemaControle", que contém o método "main".</p>
 
 ![Camada Controller](https://imgur.com/37b7Aek.png)

## Princípios SOLID
<p align="justify"> O primeiro princípio SOLID, o Princípio da Responsabilidade Única, diz que cada classe deve ter apenas um motivo para mudança. Isso significa dizer que cada classe deve ter apenas uma responsabilidade. A arquitetura de 3 camadas demonstra bem como esse princípio foi aplicado neste projeto. Cada classe, serve apenas uma única função de acordo com a camada em que ela está inserida. Por exemplo, a classe "Alarme" apenas mantém os dados dos alarmes inseridos no sistema, enquanto a classe "AlarmeService" mantém operações como ligar ou desligar um alarme, e a classe "AlarmeController" dá ao usuário a opção de interagir com esses serviços. </p>

<p align="justify"> O segundo princípio, o Princípio do Aberto-Fechado, diz que classes devem ser abertos para extensão, mas fechados para modificação. Dizer que um código é aberto para extensão significa que conforme o desenvolvimento avança, o código deve estar apto a ser extendido de maneira a receber os novos comportamentos requeridos. No entanto, devemos garantir que o código é fechado para modificação, ou seja, devemos garantir que esses novos comportamentos sendo adicionados não requerem modificação do código previamente escrito, apenas adição de mais código. </p>

```Java
 public abstract class InterruptorService implements IInterruptorService { //Classe pai
	
	private iSistema sistema;

	@Override
	public boolean checarInterruptor(String Nome) {
		Interruptor interruptor = new Interruptor();
		
		for (Interruptor i : this.sistema.getInterruptor()) {
			if (i.getNome().equals(Nome)) {
				interruptor = i;
			}
		}
		
		if (interruptor.getEstado() == true) {
			System.out.printf("O interruptor %s está ligado.\n", interruptor.getNome());
		}
		
		else if (interruptor.getEstado() == false) {
			System.out.printf("O interruptor %s está desligado.\n", interruptor.getNome());
		}
		return interruptor.getEstado();
	}

	@Override
	public void altEstado(String Nome) {
		Interruptor interruptor = new Interruptor();
		
		for (Interruptor i : this.sistema.getInterruptor()) {
			if (i.getNome().equals(Nome)) {
				interruptor = i;
			}
		}
		if (interruptor.getEstado() == true)
			interruptor.setEstado(false);
		else if (interruptor.getEstado() == false) {
			interruptor.setEstado(true);
		}
	}
}

public class LampadaService extends InterruptorService implements ILampadaService  { //Classe Derivada

	private iSistema sistema;
	
	public LampadaService(iSistema sistema) {
		this.sistema = sistema;
	}

	@Override
	public boolean checarInterruptor(String Nome) {
		Lampada lampada = new Lampada();
		
		for (Lampada l : this.sistema.getLampada()) {
			if (l.getNome().equals(Nome)) {
				lampada = l;
			}
		}
		if (lampada.getEstado() == true) {
			System.out.printf("A lampada %s está ligado com uma intensidade de %d.\n", lampada.getNome(), lampada.getIntensidade());
		}
		
		else if (lampada.getEstado() == false) {
			System.out.printf("A lampada %s está desligado.\n", lampada.getNome());
		}
		return lampada.getEstado();
	}

	@Override
	public void altEstado(String Nome) {
		Lampada lampada = new Lampada();
		
		for (Lampada i : this.sistema.getLampada()) {
			if (i.getNome().equals(Nome)) {
				lampada = i;
			}
		}
		if (lampada.getEstado() == true)
			lampada.setEstado(false);
		else if (lampada.getEstado() == false) {
			lampada.setEstado(true);
			lampada.setIntensidade(100); //intensidade padrão
		}
	}


	@Override
	public List<Lampada> buscarTodas(iSistema sistema) {
		return sistema.getLampada();
	}
	
	public boolean altIntensidade(iLampada lampada, int intensidade) {
		lampada.setIntensidade(intensidade);
		return true;
	}

}
```
<p align = "center"> Exemplo do Princípio Aberto-Fechado </p>

<p align = "justify"> No programa desenvolvido, podemos ver esse princípio, por exemplo, na classe abstrata "InterruptorService". Essa classe implementa os métodos de serviço para objetos do tipo "interruptor". No entanto, temos dois tipos de objetos com interruptores, lâmpadas e ventiladores, cada um desses com um comportamento diferente. A classe abstrata "InterruptorService", então implementa os métodos para interruptores e as classes "LampadaService" e "VentiladorService" herdam dessa classe alterando seus métodos para refletir o comportamento diferente de cada objeto. Dessa maneira, demonstramos como novas funcionalidades podem ser adicionadas sem alterar o código previamente escrito. Da mesma forma que fizemos em "LampadaService" e "VentiladorService", podemos incluir em nosso código novos dispositivos dependentes de interruptores por meio da herança da classe "InterruptorService".</p>

<p align = "justify"> O Princípio da Substituição de Liskov dita que devemos ser capazes de utilizar um objeto de uma classe derivada no lugar de um objeto da classe pai e o código deve funcionar de maneira correta. A classe "InterruptorService" é novamente uma boa maneira de exemplificar esse princípio. O método "checarInterruptor" dessa classe, por exemplo, é sobreescrito nas classes derivadas, e ainda assim, podemos substituir um objeto dessas classes por um da classe base sem comprometer o funcionamento do programa.</p>

```Java
public abstract class InterruptorService implements IInterruptorService { //Classe Pai
 public boolean checarInterruptor(String Nome) {
		Interruptor interruptor = new Interruptor();
		
		for (Interruptor i : this.sistema.getInterruptor()) {
			if (i.getNome().equals(Nome)) {
				interruptor = i;
			}
		}
		
		if (interruptor.getEstado() == true) {
			System.out.printf("O interruptor %s está ligado.\n", interruptor.getNome());
		}
		
		else if (interruptor.getEstado() == false) {
			System.out.printf("O interruptor %s está desligado.\n", interruptor.getNome());
		}
		return interruptor.getEstado();
	}
 
 public class VentiladorService implements IVentiladorService { //Classe Derivada
  public boolean checarInterruptor(String Nome) {
		 Ventilador ventilador = new Ventilador();
		
		 for (Ventilador l : this.sistema.getVentilador()) {
			 if (l.getNome().equals(Nome)) {
			 	ventilador = l;
			 }
	 	}
		 if (ventilador.getEstado() == true) {
		 	System.out.printf("A ventilador %s está ligado com uma intensidade de %s.\n", ventilador.getNome(), ventilador.getIntensidade());
		 }
		
		 else if (ventilador.getEstado() == false) {
		 	System.out.printf("A ventilador %s está desligado.\n", ventilador.getNome());
		 }
		 return false;
	 }
```
<p align = "center"> Exemplo do Princípio Substituição de Liskov </p>

<p align = "justify"> O Princípio da Segregação de Interface diz que uma classe não deve ser obrigada a implementar uma interface que ela não utiliza, e que clientes não devem ser obrigados a  se depender de métodos que eles não precisam. Esse princípio garante o desenvolvimeto de interfaces que não são "gordas", ou seja, interfaces que contém muitos métodos, que provavelmente não serão todos utilizados pelas classes que os implementam. Para garantir esse princípio, é necessário atentar-se para desenvolver interfaces apenas com métodos que serão utilizados pelas classes que os implementare. </p>

```Java
public interface Devices {
	public void setEstado(boolean Estado);
	public boolean getEstado();
	public void setNome(String Nome);
	public String getNome();
 //Métodos não utilizados pelas classes que implementam a interface:
	public void setIntensidade(int intensidade); 
	public int getIntensidade();
}
```
<p align = "center"> Exemplo de uso errado da Segregação de Interfaces</p>

```Java
public interface Devices {
	public void setEstado(boolean Estado);
	public boolean getEstado();
	public void setNome(String Nome);
	public String getNome();
}

public interface iLampada extends Devices {
	public void setIntensidade(int intensidade);
	public int getIntensidade();
}
```
<p align = "center"> Exemplo do uso correto da Segregação de Interfaces</p>

<p align - "justify"> O programa desenvolvido está repleto de interfaces, e nenhuma dessas contém métodos desnecessários às classes que as recebem. No entanto, podemos perceber esse princípio especialmente bem nas interfaces "Devices", "iLampada" e "iVentilador". A interface "Devices" contém métodos que serão utilizados por todos os dispositivos. No entanto, as classes "Lampada" e "Ventilador" representam dois dispositivos que apresentam campos que nenhum outro contém e, por isso, possuem métodos que outros dispositivos não necessitam. Os métodos de "iLampada" e "iVentilador" poderiam ter sido desenvolvidos na interface "Devices", e teríamos apenas uma interface. Isso, porém, deixaria ela "gorda", pois outras classes, como "Porta", não precisam dos métodos que "iLampada" e "iVentilador" contém. </p>

<p align - "justify"> O último princípio SOLID, o Princípio da Inversão de Dependência, diz que módulos de alto nível não devem depender de módulos de baixo nível. Ambos 
devem depender de abstrações. Além disso, abstrações não devem depender de detalhes. Os detalhes devem depender das abstrações. Módulos de alto nível incluem funções importantes de um programa. Se estes dependem de módulos de baixo nível, mudanças nesses níveis mais baixos poderão mudar completamente o funcionamento de nosso programa, nos forçando a alterar os níveis mais altos da aplicação para corrigir o funcionamento. Ao invés disso, podemos fazer com que ambos os níveis mais altos, quanto os mais baixos dependam de abstrações, invertendo assim o sentido da cascata de dependências. Assim, podemos ajustar detalhes do código sem precisar nos preocuparmos com os efeitos que isso trará em camadas superiores.</p>

```Java
public class PortaController {
	
	private IPortaService service;
	
	public PortaController(IPortaService service) {
		this.service = service;
	}
	
	public boolean altEstado(Devices porta, iUsuario user, UsuarioController uControl) {
		if (uControl.login(user) == true) {
			service.altEstado(porta);
			return true;
		}
		return false;
	}
	
	public Porta addPorta() {
		Porta porta = new Porta();
		Scanner scan = new Scanner(System.in);
		String portaName;
		System.out.println("Escolha o nome da porta a ser adicionada:\n");
		portaName = scan.nextLine();
		porta.setNome(portaName);
		return porta;
	}
}
```
<p align = "center"> Exemplo do Princípio da Inversão de Dependência.</p>

<p align = "justify"> Na arquitetura de 3 camadas vemos facilmente os módulos do código desenvolvido. A camada "controller" contém os módulos de nível mais alto, já a camada "domain" contém os de nível mais baixo. Neste projeto, o uso de interfaces garante a abstração e, assim, fazemos que os módulos dependam apenas dessas interfaces das camadas mais baixas, ou seja, das abstrações. No módulo "PortaController", vemos que essa classe recebe como atributo um objeto criado a partir da interface "IPortaService". Dessa maneira, garantimos que o código de "PortaController" não fique dependente de códigos da porta de níveis mais baixos, ela é dependende das abstrações dessas.</p>

<p align = "justify"> Similarmente ao Princípio da Inversão de Dependência, a Inversão de Controle altera o fluxo usual de controle de um programa. Na Inversão de Controle, ao invés do fluxo do programa ser definido pelo programador, ele é definido por um framework ou uma interface gráfica. Já na injeção de controle, há também uma inversão na qual tiramos o controle da classe de instanciar os objetos dos quais ela é dependente e damos essa função no método principal. Na injeção de dependência isso é feito passando o objeto ao qual uma classe é dependente, como um parâmetro dessa classe. Pode-se ver um exemplo de injeção de dependência no código usado para exemplificar a Inversão de Dependência. Na classe "PortaController", ao invés de instanciar um objeto do tipo "PortaService" cada vez que chamados o método, nós passamos um objeto dessa classe previamente instanciado para o construtor da classe. </p>

<p align = "justify"> Dessa forma, acabamos por desacoplar ainda mais nosso código, garantimos assim, que não tenhamos que passar pelos  processos de instanciamento toda vez que utilizarmos uma classe que depende de outra, podemos realiza-los apenas uma vez.</p>

## Funcionamento
<p align = "justify"> O programa que foi criado simula o funcionamento de um sistema de controle remoto para casas. Ele pode ser rodado executando o código da classe "SistemaControle". As funções do programa são: Gerenciar o sistema de porta, adicionando novas portas, abrindo ou fechando uma porta e checando se uma porta está aberta ou fechada; Gerenciar o sistemas de alarmes, adicionando novos alarmes, desligando ou ligando um alarme e checando se um alarme está ligado; Gerenciar o sistema de interruptores, este inclui interruptores para lampadas e para ventiladores. Podemos adicionar lampadas e ventiladores, liga-los ou desliga-los, alterar a valocidade do ventilador ou a intensidade da lâmpada (como um dimmer) e checar se estão ligados ou desligados. O programa mantém também dados do usuário, ou seja, o nome de usuário e a senha, necessários para realizar uma ação de segurança. </p> 
<p align = "justify"> Inicialmente o programa pede a inserção de um nome de usuário e uma senha, estes serão utilizados para alterar o estado de um dispositivo. Os sistemas são então iniciados. Cada controller é construido, e também é construído um objeto da classe "Sistema", da camada "domain". Essa classe guarda em listas todos os dispositivos adicionados no sistema. O sistema já inicia com alguns dispositivos inseridos: uma porta, um alarme, uma lampada e um ventilador.</p>

![Inserção do Usuário](https://imgur.com/fEwAuAA.png)

<p align = "justify"> O usuário recebe então um menu, onde ele pode selecionar com qual dispositivo ele quer interagir. Através desse menu, podemos realizar todas as ações. Além dos dispositivos, podemos alterar a senha do usuário através desse menu. É importante notar que o sistema é sensível à letras maiúsculas e minúsculas. Para finalizar a execução devemos utilizar a opção 0.</p>

![Menu inicial](https://imgur.com/aPYwt0y.png)

<p align = "justify"> Ao selecionar o dispositivo que deseja gerenciar, o programa mostra o menu de opções ao usuário, onde ele pode selecionar se deseja checar o estado do dispositivo, alterar o estado ou adicionar um novo dispositivo do tipo escolhido.</p>

![Menu do Dispositivo](https://imgur.com/N7mTQJN.png)

![Operação Completa](https://imgur.com/F9Z6QhP.png)

## Conclusão
<p align="justify">O sistema criado, apesar de simples, encapsula e exemplifica bem cada um dos 5 princípios SOLID. A partir desses, foi possível o desenvolvimento de um programa que será fácil de manter e extender. Além disso, a arquitetura de 3 camadas utilizada, também foi responsável pela fácil implementação desses princípios.
</p>
</br></br>

## Referências
<p align="justify">
Robert Martin, Micah Martin, Princípios, Padrões e Práticas Ágeis em C#,  Bookman Editora, 2009.
</p>
