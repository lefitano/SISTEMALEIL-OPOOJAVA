import java.util.ArrayList;
import java.util.Scanner;
public class Menu {
    private  ArrayList<Participante> listaParticipantes = new ArrayList<>(); // CRIAÇÃO DE ARRAYLISTS PARA AS CLASSES.
    private ArrayList<Leilao> listaLeilao = new ArrayList<>();
    private ArrayList<ItemLeilao> listaItens = new ArrayList<>();
    private ArrayList<Lance> listaLances = new ArrayList<>();
    private Scanner sc = new Scanner(System.in);
    
    public Menu(){   //construtor do menu, ja inicializei em cima
        
    }
    public static void main(String[] args) throws Exception {

        Menu menu = new Menu(); // criei o menu
        menu.executarSistema(); //
       
    }

   


    public void mostrarMenuPrincipal(){
        System.out.println(" ====> MENU SISTEMA DE LEILÃO <====");
        System.out.println("");
        System.out.println("DIGITE 1 PARA GERERENCIAR OS PARTICIPANTES");
        System.out.println("DIGITE 2 PARA GERENCIAR LEILÃO ");
        System.out.println("DIGITE 3 PARA GERENCIAR ITENS DO LEILÃO");
        System.out.println("DIGITE 4 PARA GERENCIAR LANCES");
        System.out.println("0 = SAIR");
        System.out.println("_____________________");
    }
    public void executarSistema() throws Exception{
        int opcao = -1; // para iniciar o menu

        while(opcao != 0){
            mostrarMenuPrincipal();
            opcao = sc.nextInt();
            sc.nextLine();

            if(opcao == 1){
                menuParticipantes();
            }
            else if(opcao == 2){
                menuLeiloes();
            }
            else if(opcao == 3){
                menuItens();
            }
            else if(opcao == 4){
                menuLance();
            }else if(opcao == 0){
                System.out.println("Sistema encerrado");
            }else{
                System.out.println("Não temessa opção ");
            }
        
        } sc.close();
    }
// ===== >>> aqui eu comcei o menu dos participantes!
    public void menuParticipantes() throws Exception{
        int opcao = -1;

        while(opcao != 0){
            System.out.println(" ====> MENU DE GERÊNCIA DE PARTICIPANTES <====");
            System.out.println("Digite 1 para registrar participante");
            System.out.println("Digite 2 para fazer o login de participante");
            System.out.println("Digite 3 para listar os participantes");
            System.out.println("Digite 4 para consultar participante (txt");
            System.out.println("0 para voltar ao menu principal!");
            System.out.println("_________");

            opcao = sc.nextInt();
            sc.nextLine();

            if(opcao == 1){
                registrarParticipante();
            }else if( opcao == 2){
                loginParticipante();
            }else if(opcao == 3){
                listarParticipantes();
            }else if(opcao == 4){
                 consultarParticipantetxt();
             }
            else if(opcao == 0){
                System.out.println("Voltando ao menu princiapl");
            }else{
                System.out.println("Não tem essa opção chefe");
            }
        }
    }
        public void registrarParticipante()throws Exception{    
            System.out.println("REGISTRAR PARTICIPANTE");
        
        System.out.println("Digite o ID: ");
        int idParticipante = sc.nextInt();
        sc.nextLine();

        System.out.println("Digite o nome do participante: ");
        String nomeParticipante = sc.nextLine();

        System.out.println("Digite o login : ");
        String loginParticipante = sc.nextLine();

        System.out.println("Senha do participante: ");
        String senhaParticipante = sc.nextLine();

        System.out.print("Email do participante: ");
        String emailParticipante = sc.nextLine();
    
        System.out.print("Endereço: ");
        String enderecoParticipante = sc.nextLine();
    
        System.out.print("Telefone: ");
        String telefoneParticipante = sc.nextLine();
            
        Participante p = new Participante(idParticipante, nomeParticipante, loginParticipante, senhaParticipante, emailParticipante, enderecoParticipante, telefoneParticipante);

        if(p.registrarParticipante()){
            listaParticipantes.add(p); //adiciona na lista
              p.inserir(); //insere no arquivo
            // System.out.println("Participante registrado"); //já fiz na classe
        }else{
            System.out.println("Não deu pra registrar o participante");
        }
      }
      public void loginParticipante(){
        System.out.println("LOGIN DE PARTICIPANTe");

        if(listaParticipantes.isEmpty()){ //SE A LISTA TA VAZIA, NÃO TEM PARTICIPANTE
            System.out.println("Não tem nenhum participante registrad");
            return;
        }
        System.out.println("Login : ");
        String login = sc.nextLine();

        System.out.println("Senha : ");
        String senha = sc.nextLine();

        boolean participanteEncontrado = false;  // BOOLEAN CRIADO PARA VERIFICAR SE TEM O PARTICIPATNE E IMPEDIR REPETIÇÃO DE CONDIÇÃO
        for(Participante p : listaParticipantes){ //PERCORRENDO A LISTA DE PARTICIPANTES
            Participante logando = p.loginParticipante(login, senha); //
            if(logando != null){
                System.out.println("LOGIN REALIZADO DE PARTICIPANTE");
                participanteEncontrado = true;
                logando.mostrar();
                break;
            }
            
        }   if(participanteEncontrado){
                System.out.println("Participante não encontrado");
        }
      }
    //   public void inserir() throws Exception{

    //   }

      public void listarParticipantes(){
        System.out.println("LISTAD DOS PARTICIPANTES: ");
        Participante temp = new Participante(0, null, null, null, null, null, null); //OBJETO TEMPORARIO CRIEI PAR CHAMAR O METODO
        temp.listarParticipantes(listaParticipantes);  
    
       }
      //=====>>>> //TENHO QUE CHAMAR O CONSULTAR O FEITO PARA LEITURA DE ARQUIVO TXT NA CLASSE PARTICIPANTE  <<<<<======
       public void consultarParticipantetxt() throws Exception{
        System.out.println("Consultado participante no arquivo de texto");

        System.out.println("Digite o ID do participante");
        int idBuscaParticipante = sc.nextInt(); // variavel para receber o inteiro digitar pelo usuario no scanner
        sc.nextLine(); // vai limpar o buffer

        Participante pTemporario = new Participante(0, null, null, null, null, null, null); //criei um objeto apenas para chamar o metodo e salvar no objeto novo com as informações
        Participante pEncontrado = pTemporario.consultar(idBuscaParticipante);
        if(pEncontrado != null){
            pEncontrado.mostrar();
        }
       }

      // AQUI COMECEI A CRIAR O MENU DE LEILOES
      public void menuLeiloes() throws Exception{
        int opcao = -1;
        while(opcao != 0){
            System.out.println("===== > MENU DE LEILÃO < =====");
            System.out.println("1 para registrar leilão");
            System.out.println("2 para iniciar leilão");
            System.out.println("3 para finalizar leilão");
            System.out.println("4 para consultar leilão");
            System.out.println("5 para listar leilão");
            System.out.println("6 para consultar leilão no txt");
            System.out.println("0 para voltar");
            opcao = sc.nextInt();
            sc.nextLine();

            if(opcao == 1){
                registrarLeilao();
            }else if( opcao == 2){
                iniciarLeilao();
            }else if( opcao == 3){
                finalizarLeilao();
            }else if(opcao == 4){
                consultarLeilao();
            }else if (opcao == 5){
                listarLeiloes();
            }else if(opcao == 6){
                consultarLeilaotxt();
            }
            else if(opcao == 0){
                System.out.println("Voltando ao menu anterior");
            }else{
            System.out.println("Opção inválida");
            }
        }
        //iniciando os metodos de leilao que criei
      }
      public void registrarLeilao() throws Exception{
        System.out.println("REGISTRO DE LEILÃO");
        
        System.out.println("Digite o ID do leilão: ");
        int idLeilao = sc.nextInt();
        sc.nextLine();

        System.out.println("Digite a Data de inicio do Leilão : ");
        String dataInicioLeilao = sc.nextLine();

        System.out.println("Digite a Hora de inicio do Leilão :");
        String horaInicioLeilao = sc.nextLine();

        System.out.println("Digite a Data Final do Leilão :");
        String dataFimLeilao = sc.nextLine();

        System.out.println("Digite a Hora final do Leilão : ");
        String horaFimLeilao = sc.nextLine();

        Leilao novoLeilao = new Leilao(idLeilao, dataInicioLeilao, horaInicioLeilao, dataFimLeilao, horaFimLeilao, false); //objeto criado com o construtor, lembrando que o status so é alterado quando iniciar o leilao com o metodo
        if(novoLeilao.registrarLeilao()){
            listaLeilao.add(novoLeilao);
            novoLeilao.inserir(); // chamei o método inserir para escrever no txt igual o do registrar participante.
        }
      }

      public void iniciarLeilao(){
        System.out.println("Digite o ID do leilão que você quer iniciar: ");
        int idLeilao = sc.nextInt();
        sc.nextLine();

        boolean encontrou = false; //variavel que criei so pra controlar se encontrou ou não
        for(Leilao l : listaLeilao){
            if(l.getIdLeilao() == idLeilao){  // LOGICA : === > SE O ID EXISTIR NA LSITA, ALTERO A VARIAVEL DE CONTROLE DE ENCONTRO
               
                encontrou = true;                               
                
             if(l.iniciarLeilao()){   // SE O STATUS JA FOR TRUE, OU SEJA, O LEILAO JA FOI INICIADO
                System.out.println("Leilão iniciado com sucesso");
                
            } 
            break;
           
        } 
      
      } 
      if(!encontrou){  // SE NENHUMA DAS CONDIÇÕES ACIMA DEREM CERTO!
        System.out.println("Leilão não existe");
    }
}

public void consultarLeilao(){
    System.out.println("CONSULTAR LEILÃO");

    System.out.println("Digite o ID de busca do leilão : ");
    int idLeilao = sc.nextInt();
    sc.nextLine();

    Leilao temp = new Leilao(idLeilao, null, null, null, null, false);
    temp.consultarLeilao(listaLeilao, idLeilao);

    
 }
 public void consultarLeilaotxt() throws Exception{
    System.out.println("Aqui vamos consultar o Leilao no txt");
    System.out.println("Digite o ID do Leilão que você quer pesquisar:");
    int idBuscaLeilaotxt =  sc.nextInt();
    sc.nextLine();

    Leilao leilaoTemporario = new Leilao(0, null, null, null, null, false);
    Leilao leilaoEncontrado = leilaoTemporario.consultar(idBuscaLeilaotxt);
    if(leilaoEncontrado != null){
        leilaoEncontrado.mostrar();
    }
 }
 public void listarLeiloes(){
    System.out.println("LISTA DE LEILÕES");
    Leilao temp = new Leilao(0, null, null, null, null, false);
    temp.listarLeiloes(listaLeilao);
    
 }  
 public void finalizarLeilao(){
    System.out.println("PARA FINALIZAR LEILÃO");
    System.out.println("Diga o ID do leilão para finalizar");

    int idLeilao = sc.nextInt();
    sc.nextLine();

    boolean encontrou = false;

    for(Leilao l : listaLeilao){
        if(idLeilao == l.getIdLeilao()){
            encontrou = true;
        if(l.finalizarLeilao()){
            System.out.println("Leilão finalizado!");
            
        } else{
            System.out.println("Não foi possível finalizar o leilão");
        }break;

        }   
    }
        if(!encontrou){
            System.out.println("Leilãoi nao encontrado!");
    }
 }


 // COMECEI O MENU DOS ITENS

public void menuItens() throws Exception{

    int opcao = -1;

    while(opcao != 0){
        System.out.println("=== >> MENU DE ITENS DE LEILÃO <<===");
        System.out.println("_______");
        System.out.println("DIGITE 1 PARA REGISTRAR ITEM");
        System.out.println("DIGITE 2 PARA ARREMATAR");
        System.out.println("DIGITE 3 PARA CONSULTAR ITEM");
        System.out.println("DIGITE 4 para LISTAR ITENS");
        System.out.println("DIGITE 5 PARA CONSULTAR ITENS NO TXT");
        System.out.println("DIGITE 0 PARA VOLTAR O MENU");
        
        opcao = sc.nextInt();
        sc.nextLine();

        if(opcao == 1){
            registrarItem();
        }else if( opcao == 2){
            arrematarItem();
        }else if(opcao == 3){
            consultarItem();
        }else if(opcao == 4){
            listarItens();
        }else if(opcao == 5){
            consultarItemtxt();
        }
        else if( opcao == 0){
            System.out.println("Voltando");
        }else{
            System.out.println("Opção inválida");
        }
    }
}

// CRIANDO OS METODOS DO MENU DE ITEMLEILAO

public void registrarItem() throws Exception{
    System.out.println("REGISTRO DE ITEM");

    System.out.println("Digite o ID do item");
    int idItem = sc.nextInt();
    sc.nextLine();

    System.out.println("Digite o id do leilão do item ");
    int idleilao = sc.nextInt();
    sc.nextLine();

      //preciso ver se o leilao tem na list
      Leilao leilaoEncontrado = null;
      for(Leilao l : listaLeilao){
          if(l.getIdLeilao() == idleilao){
              leilaoEncontrado = l;
              break;
          }
      }
      
      // se o leilao nao existir
      if(leilaoEncontrado == null){
          System.out.println("Leilão não encontrado! Item não registrado.");
          return;
      }

    System.out.println("Digite a descrição do item :");
    String descricaoItem = sc.nextLine();
    sc.nextLine();

    System.out.println("Digite o lance minimo do item : ");
    Double lanceMinimoItem = sc.nextDouble();
    sc.nextLine();
//ABAIXO O OBJETO DO ITEMLEILAO QUE EU PRECISEI CRIAR
    ItemLeilao novoitem = new ItemLeilao(idItem, leilaoEncontrado, descricaoItem, lanceMinimoItem, false, null);

//adiconei o item na listaItens
     if(novoitem.registrarItem()){   //REGISTRAR ITEM FINAL 
        listaItens.add(novoitem);
        novoitem.inserir(); // inserindo no txt
     }
}

public void arrematarItem(){
    System.out.println("ARREMATE DE ITEM");

    if(listaItens.isEmpty()){
        System.out.println("Não tem item na list");
        return;
    }

    System.out.println("Digite o ID do item que você quer arrematar:");
    int idItemDesejado = sc.nextInt();
    sc.nextLine();

    ItemLeilao itemEncontrado = null; // variavel de controle igual fiz nos outros métodos

    for(ItemLeilao i : listaItens){
        if(i.getIdItem() == idItemDesejado){
            itemEncontrado = i;
            break;
        }
    }
    if(itemEncontrado == null){
        System.out.println("Item não encontrado");
        return;
    }

    System.out.println("Digite o ID do lance: ");  // pgeando id do lance
    int idLance = sc.nextInt();
    sc.nextLine();

    Lance lanceEncontrado = null; //variavel para controle do lance 

    for(Lance l : listaLances){
        if(l.getIdLance() == idLance){
            lanceEncontrado = l;
            System.out.println("Lance encontrado");
            break;
        }
    }
    if(lanceEncontrado == null){
        System.out.println("Não tem esse lance");
        return;
    }
    itemEncontrado.arrematarItem(lanceEncontrado);
}
public void consultarItem(){
    System.out.println("CONSULTA DE ITEM");

    if(listaItens.isEmpty()){
        System.out.println("A lista de itens está vazia");
        return;
    }
    System.out.println("Digite o ID do item que quer ver: ");
    int iDItemConsulta = sc.nextInt();
    sc.nextLine();
    ItemLeilao temp = new ItemLeilao(iDItemConsulta, null, null, null, false, null);
    temp.consultarItem(listaItens, iDItemConsulta);

}
public void consultarItemtxt() throws Exception{
    System.out.println("VAMO CONSULTAR ITEM NO TXT");
    System.out.println("Digite o ID de busca do Item desejado :");
    int idBuscaItemLeilao = sc.nextInt();
    sc.nextLine();

    ItemLeilao itemprovisorio = new ItemLeilao(0, null, null, null, false, null);
    ItemLeilao itemEncontrado = itemprovisorio.consultar(idBuscaItemLeilao);

    if(itemEncontrado != null){
        itemEncontrado.mostrar();
    }
}

public void listarItens(){
    System.out.println("LISTAR ITENS SELECIOJADO");
    ItemLeilao temp = new ItemLeilao(0, null, null, null, false, null);
    temp.listarItens(listaItens);

    

}
public void menuLance() throws Exception{
    int opcao = -1;

    while(opcao != 0){
        System.out.println("MENU DE LANCES");
        System.out.println("1 para registrar Lance");
        System.out.println("2 para listar lances");
        System.out.println("3 para consultar lance no txt");
        System.out.println("0 para voltar");

        opcao = sc.nextInt();
        sc.nextLine();

        if(opcao == 1){
            registrarLance();
        }else if(opcao == 2){
            listarLances();
        }else if(opcao == 3){
            consultarLancetxt();
        }
        else if(opcao == 0){
            System.out.println("voltando ao menu");
        }else{
            System.out.println("Opção inválida");
        }
    }
}

public void registrarLance() throws Exception{
    System.out.println("REGISTRO DE LANCE");

    System.out.println("Digite o ID do lance");
    int idLance = sc.nextInt();
    sc.nextLine();

    System.out.println("Digite o ID do participante");
    int idParticipante = sc.nextInt();
    sc.nextLine();

    Participante participanteEncontrado = null; // criei variavel de controle do participante para acha-lo no loop
    for(Participante p : listaParticipantes){               // aqui comecei as condições para que o lance seja registrado
        if(p.getIdParticipante() == idParticipante){
            participanteEncontrado = p;
            break;   // para achar o participante dono do lance
        }
    }if(participanteEncontrado == null){
        System.out.println("Não achei o particpante");
        return;
    }

    System.out.println("Digita o ID do item do Leilao");
    int idItem = sc.nextInt();
    sc.nextLine();

    ItemLeilao itemEncontrado = null;
    for(ItemLeilao i : listaItens){  // para achar o item do leilao que vai o lance
        if(i.getIdItem() == idItem){
            itemEncontrado = i;
            break;
        }
    }if(itemEncontrado == null){
        System.out.println("Item não encontrado");
        return;
    }

    if(itemEncontrado.isItemArrematado()){  //verificar se o lance ja nao fio arrematado
        System.out.println("Item ja arrematado");
        return;
        
    }

    System.out.println("Digite o valor do lance:");
    Double valorLance = sc.nextDouble();
    sc.nextLine();

    System.out.println("Digite a data do lance:");
    String dataLance = sc.nextLine();

    System.out.println("Digite a hora do Lance");
    String horaLance = sc.nextLine();

    Lance novoLance = new Lance(idLance, participanteEncontrado, itemEncontrado, valorLance, dataLance, horaLance); //criei o lance depois de verificar as condições

    if(novoLance.registrarLance()){
        listaLances.add(novoLance);
        novoLance.inserir();
    }

}

public void listarLances(){
    System.out.println("LISTAR OS ITENS");

    Lance temp = new Lance(0, null, null, null, null, null);
    temp.listarLances(listaLances);

}

public void consultarLancetxt() throws Exception{
    System.out.println("CONSULTAR LANCE NO TXT");
    System.out.println("Digite o ID para consultar Lance no txt");

    int idBuscaLance = sc.nextInt();
    sc.nextLine();

    Lance lancetemporario = new Lance(0, null, null, 0.0, null, null);
    Lance lanceEncontrado = lancetemporario.consultar(idBuscaLance);

    if(lanceEncontrado != null){
        lanceEncontrado.mostrar();
    }


}



}

