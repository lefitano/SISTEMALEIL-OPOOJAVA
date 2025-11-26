import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class Leilao {
    private int idLeilao;
    private String dataInicioLeilao;
    private String horaInicioLeilao;
    private String dataFimLeilao;
    private String horaFimLeilao;
    private boolean statusLeilao;
// --- >> CONSTRUTOR FEITO 
    public Leilao(int idLeilao, String dataInicioLeilao, String horaInicioLeilao, String dataFimLeilao, String horaFimLeilao, boolean statusLeilao){
        this.idLeilao = idLeilao;
        this.dataInicioLeilao = dataInicioLeilao;
        this.horaInicioLeilao = horaInicioLeilao;
        this.dataFimLeilao = dataFimLeilao;
        this.horaFimLeilao = horaFimLeilao;
        this.statusLeilao = statusLeilao;
    }
// ------ >>>> GETS DE TODOS OS ATRIBUTOS FEITOS
    public int getIdLeilao(){
        return this.idLeilao;
    }
    public String getDataInicioLeilao(){
        return this.dataInicioLeilao;
    }
    public String getHoraInicioLeilao(){
        return this.horaInicioLeilao;
    }
    public String getDataFimLeilao(){
        return this.dataFimLeilao;
    }
    public String getHoraFimLeilao(){
        return this.horaFimLeilao;
    }
    public boolean isStatusLeilao(){
        return this.statusLeilao;
    }
// FIM DOS GETS FEITOS


// INICIO DOS SETS FEITOS
    public void setIdLeilao(int idLeilao){
        this.idLeilao = idLeilao;
    }
    public void setDataInicioLeilao(String dataInicioLeilao){
        this.dataInicioLeilao = dataInicioLeilao;
    }
    public void setHoraInicioLeilao(String horaInicioLeilao){
        this.horaInicioLeilao = horaInicioLeilao;
    }
    public void setDataFimLeilao(String dataFimLeilao){
        this.dataFimLeilao = dataFimLeilao;
    }
    public void setHoraFimLeilao(String horaFimLeilao){
        this.horaFimLeilao = horaFimLeilao;
    }
    public void setStatusLeilao(boolean statusLeilao){
        this.statusLeilao = statusLeilao;
    }
    //FIM DOS SETS FEITOS

    // ---------------------------------------------------------------------------
//   => MÉTODOS ABAIXO <=
// CRIEI O MÉTODO MOSTRAR, EXIBINDO AS INFORMAÇÕES DO LEILÃO
    public void mostrar(){
        System.out.println("ID leilao : " + getIdLeilao());
        System.out.println("Data de início do Leilão: " + getDataInicioLeilao());
        System.out.println("Hora de início do Leilão : " + getHoraInicioLeilao());
        System.out.println("Data do fim do Leilão : " + getDataFimLeilao());
        System.out.println("Hora do fim do Leilão : " + getHoraFimLeilao());
        System.out.println("Status Leilão : " + isStatusLeilao());
    }

    public boolean registrarLeilao(){                   //PERGUNTAR O PROFESSOR SE A MANIPULAÇÃO DO ATRIBUTO STATUS ESTÁ CERTA, POIS NO AVA TEM SOBRE ATRIBUIR STRINGS E NÃO APENAS O BOOLEAN DE ACORDO COM O UML.
         if(getIdLeilao() <= 0){
            System.out.println("Leilão não registrado");
            setStatusLeilao(false);
            return false;
         }else{
            System.out.println("Registrado");
            System.out.println("ID do leilão : " + getIdLeilao());
            setStatusLeilao(false);
            return true;
         }
    }
    public boolean iniciarLeilao(){
        if(getIdLeilao() <= 0 ||getDataInicioLeilao() == null ||getHoraInicioLeilao() == null ||getDataInicioLeilao().isEmpty() || getHoraInicioLeilao().isEmpty() || !isStatusLeilao()){ //CONDIÇÃO PARA VERIFICAR SE FORAM INSERIDOS A HORA E DATA DO INICIO DO LEILAO, COLOQUEI TAMBEM PARA VERIFICAR O STATUS DO LEILAO, NO CASO DO REGISTRO DO MÉTODO ACIMA.
            System.out.println("O Leilão precisa estar registrado para ser iniciado");
            System.out.println("A data de inicio e hora de inicio precisam ser informadas");
            System.out.println("Leilão não iniciado.");
            setStatusLeilao(false);
            return false;
        }else{
            System.out.println("Agendado");
            System.out.println("Hora Início do Leilão : " + getHoraInicioLeilao());
            System.out.println("Data Início do Leilão : " + getDataInicioLeilao());
            setStatusLeilao(true);
            return true;
        }
    }
    public boolean finalizarLeilao(){
        if(!isStatusLeilao()){
            System.out.println("Leilão precisa estar ativo para ser finalizado!");
            return false;
        }
        if(getDataFimLeilao() == null || getHoraFimLeilao() == null || getDataFimLeilao().isEmpty() || getHoraFimLeilao().isEmpty()){
            System.out.println("Data e Hora do fim do leilão precisam ser informadas");
            return false;
        }else{
            System.out.println("Data do fim do leilão : " + getDataFimLeilao());
            System.out.println("Hora do fim do leilão : " + getHoraFimLeilao());
            System.out.println("Finalizado");
            setStatusLeilao(false);
            return true;
        }
    }

    public ArrayList<Leilao> listarLeiloes(ArrayList<Leilao> listaLeilao){
        if(listaLeilao.isEmpty()){
            System.out.println("Lista de leilões está vazia");
        }else{
            for(Leilao l : listaLeilao){
                l.mostrar();
                System.out.println("-----");
            }
        }
        return listaLeilao;
    }

    public Leilao consultarLeilao(ArrayList<Leilao> listaLeilao, int idBusca){ // RECEBE OS PARÂMETROS DO ARRAYLIST E UM INT IDBUSCA PARA BUSCAR UM LEILÃO DESJEADO
      if(listaLeilao.isEmpty()){ // LISTA VAZIA NÃO TEM LEILÃO
        System.out.println("A lista de leilões está vazia.");
        return null;
      }else{
        for(Leilao l : listaLeilao){ // FOR EACH PARA BUSCAR NA LISTA DE LEILÃO
            if(l.getIdLeilao() == idBusca){ // COMPARANDO SE O IDBUSCA PASSADO COMO PARAMETRO É IGUAL A ALGUM ID DE LEILÃO NA LSITA
                System.out.println("Leilão encontrado");
                l.mostrar();
                return l;
            }

            }
            System.out.println("Leilão não encontrado");   //PERCOREU TODO O FOR MAS NÃO ENCONTROU
            return null;
        }

      }
      public void inserir() throws Exception{
        FileWriter fw = new FileWriter("leilao.txt", true);
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write(this.idLeilao + ";" + this.dataInicioLeilao + ";" + this.horaInicioLeilao + ";" + this.dataFimLeilao + ";" + this.horaFimLeilao + ";" + this.statusLeilao);
        bw.newLine();
        bw.close();
        System.out.println("Leilão salvo no arquiv");
      }

      public Leilao consultar(int idBusca)throws Exception{
        FileReader fr = new FileReader("leilao.txt");
        BufferedReader br = new BufferedReader(fr);

        String linha = "";

        while((linha = br.readLine()) != null){
            String [] dados = linha.split(";");
            
            if(Integer.parseInt(dados[0].trim()) == idBusca){
                Leilao l = new Leilao(Integer.parseInt(dados[0].trim()), dados[1].trim(), dados[2].trim(), dados[3].trim(), dados[4].trim(), Boolean.parseBoolean(dados[5].trim()) );
                br.close();
                System.out.println("Leilão encontrado");
                return l;
            }
        }
        br.close();
        System.out.println("Leilão não encontrado");
        return null;
      }


      
      
    }



