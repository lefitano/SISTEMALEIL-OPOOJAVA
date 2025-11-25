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
    public void executarSistema(){
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
    public void menuParticipantes(){
        int opcao = -1;

        while(opcao != 0){
            System.out.println(" ====> MENU DE GERÊNCIA DE PARTICIPANTES <====");
            System.out.println("Digite 1 para registrar participante");
            System.out.println("Digite 2 para fazer o login de participante");
            System.out.println("Digite 3 para listar os participantes");
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
            }else if(opcao == 0){
                System.out.println("Voltando ao menu princiapl");
            }else{
                System.out.println("Não tem essa opção chefe");
            }
        }
    }
        public void registrarParticipante(){
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
            listaParticipantes.add(p);
            System.out.println("Participante registrado");
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
            
        }   if(!participanteEncontrado){
                System.out.println("Participante não encontrado");
        }
      }

      public void listarParticipantes(){
        System.out.println("LISTAD DOS PARTICIPANTES: ");

        if(listaParticipantes.isEmpty()){
            System.out.println("Lista vazia");
        }else{
            for(Participante p : listaParticipantes){
                System.out.println("____");
                p.mostrar();
            }
        }
      }
      // AQUI COMECEI A CRIAR O MENU DE LEILOES
      public void menuLeiloes(){
        int opcao = -1;
        while(opcao != 0){
            System.out.println("===== > MENU DE LEILÃO < =====");
            System.out.println("1 para registrar leilão");
            System.out.println("2 para iniciar leilão");
            System.out.println("3 para finalizar leilão");
            System.out.println("4 para consultar leilão");
            System.out.println("5 para listar leilão");
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
            }else if(opcao == 0){
                System.out.println("Voltando ao menu anterior");
            }else{
            System.out.println("Opção inválida");
            }
        }
        //iniciando os metodos de leilao que criei
      }
      public void registrarLeilao(){
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
                
             if(l.isStatusLeilao()){   // SE O STATUS JA FOR TRUE, OU SEJA, O LEILAO JA FOI INICIADO
                System.out.println("Esse leilão já foi iniciado!");
            }else{
                l.setStatusLeilao(true); // SE NÃO, MUYDAR O STATUS PARA TRUE E INICIAR O LEILAO
                System.out.println("Leilão iniciado");
            }
           
        } 
        break;
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

    boolean encontrouLeilao = false;   // variavel apenasd de controle q criei
    for(Leilao l : listaLeilao){
        if(l.getIdLeilao() == idLeilao){
            encontrouLeilao = true;
            l.mostrar();
            break;
        }
    }
    if(!encontrouLeilao){
        System.out.println("Leilão não encontrado!");
    }
 }
 public void listarLeiloes(){
    System.out.println("LISTA DE LEILÕES");

    if(listaLeilao.isEmpty()){
        System.out.println("Não tem nenhum leilão na lista");
    }else{
        for(Leilao l : listaLeilao){
            System.out.print("__________");
            l.mostrar();
            System.out.println("____________");
        }
        System.out.println("_________");
    }
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
        if(!l.isStatusLeilao()){
            System.out.println("Leilão não iniciado!");
        }else{
            l.setStatusLeilao(false);
            System.out.println("Leilão finalizado!!!");
        }
        
    }   break;
    }
        if(!encontrou){
            System.out.println("Leilãoi nao encontrado!");
    }
 }


 // COMECEI O MENU DOS ITENS

public void menuItens(){

    int opcao = -1;

    while(opcao != 0){
        System.out.println("=== >> MENU DE ITENS DE LEILÃO <<===");
        System.out.println("_______");
        System.out.println("DIGITE 1 PARA REGISTRAR ITEM");
        System.out.println("DIGITE 2 PARA ARREMATAR");
        System.out.println("DIGITE 3 PARA CONSULTAR ITEM");
        System.out.println("DIGITE 4 para LISTAR ITENS");
        
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
        }else if( opcao == 0){
            System.out.println("Voltando");
        }else{
            System.out.println("Opção inválida");
        }
    }
}

// CRIANDO OS METODOS DO MENU DE ITEMLEILAO

public void registrarItem(){
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

    System.out.println("Digite o lance minimo do item : ");
    Double lanceMinimoItem = sc.nextDouble();
    sc.nextLine();
//ABAIXO O OBJETO DO ITEMLEILAO QUE EU PRECISEI CRIAR
    ItemLeilao novoitem = new ItemLeilao(idItem, leilaoEncontrado, descricaoItem, lanceMinimoItem, false, null);

//adiconei o item na listaItens
     if(novoitem.registrarItem()){
        listaItens.add(novoitem);
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

    boolean encontrouItem = false;
    for(ItemLeilao il : listaItens){
        if(il.getIdItem() == iDItemConsulta){
            encontrouItem = true;
            il.mostrar();
            break;
            

        }
    }
    if(!encontrouItem){
        System.out.println("Item não encontrado");
    }
}

public void listarItens(){
    System.out.println("LISTAR ITENS SELECIOJADO");

    if(listaItens.isEmpty()){
        System.out.println("LISTA VAZIA");
        
        
    }
    else{
        for(ItemLeilao il : listaItens){
            System.out.println("-----");
            il.mostrar();
            System.out.println("_______");
        }
    }

}
public void menuLance(){
    int opcao = -1;

    while(opcao != 0){
        System.out.println("MENU DE LANCES");
        System.out.println("1 para registrar Lance");
        System.out.println("2 para listar lances");
        System.out.println("0 para voltar");

        opcao = sc.nextInt();
        sc.nextLine();

        if(opcao == 1){
            registrarLance();
        }else if(opcao == 2){
            listarLances();
        }else if(opcao == 0){
            System.out.println("voltando ao menu");
        }else{
            System.out.println("Opção inválida");
        }
    }
}

public void registrarLance(){
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
    }


}

public void listarLances(){
    System.out.println("LISTAR OS ITENS");

    if(listaLances.isEmpty()){
        System.out.println("LISTA DE LANCES TA VAZIA");
    }else{
    for(Lance l : listaLances){
        System.out.println("_____");
        l.mostrar();
        System.out.println("_____");

        }

    }
}



}

