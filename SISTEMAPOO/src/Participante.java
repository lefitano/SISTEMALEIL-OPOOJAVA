import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class Participante{
    private int idParticipante;
    private String nomeParticipante;
    private String loginParticipante;
    private String senhaParticipante;
    private String emailParticipante;
    private String enderecoParticipante;
    private String telefoneParticipante;

/// --- >> CONSTRUTOR PARTICIPANTE PRONTO
    public Participante(int idParticipante, String nomeParticipante, String loginParticipante, String senhaParticipante, String emailParticipante, String enderecoParticipante, String telefoneParticipante){
        this.idParticipante = idParticipante;
        this.nomeParticipante = nomeParticipante;
        this.loginParticipante = loginParticipante;
        this.senhaParticipante = senhaParticipante;
        this.emailParticipante = emailParticipante;
        this.enderecoParticipante = enderecoParticipante;
        this.telefoneParticipante = telefoneParticipante;

    }
// ----- >>> INICIO GETS DE TODOS ATRIBUTOS PRONTOS <<< ---------
    public int getIdParticipante(){
        return this.idParticipante;
    }
    public String getNomeParticipante(){
        return this.nomeParticipante;
    }
    public String getLoginParticipante(){
        return this.loginParticipante;
    }
    public String getSenhaParticipante(){
        return this.senhaParticipante;
    }
    public String getEmailParticipante(){
        return this.emailParticipante;
    }
    public String getEnderecoParticipante(){
        return this.enderecoParticipante;
    }
    public String getTelefoneParticipante(){
        return this.telefoneParticipante;
    }    
// ------ > FIM DOS GETS   <---------

// ------ >>>> INICIO DOS SETS DE TODOS OS ATRIBUTOS PRONTOS <<<< -------
    public void setIdParticipante(int idParticipante){
        this.idParticipante = idParticipante;
    }
    public void setNomeParticipante(String nomeParticipante){
        this.nomeParticipante = nomeParticipante;
    }
    public void setLoginParticipante(String loginParticipante){
        this.loginParticipante = loginParticipante;
    }
    public void setSenhaParticipante(String senhaParticipante){
        this.senhaParticipante = senhaParticipante;
    }
    public void setEmailParticipante(String emailParticipante){
        this.emailParticipante = emailParticipante;
    }
    public void setEnderecoParticipante(String enderecoParticipante){
        this.enderecoParticipante = enderecoParticipante;
    }
    public void setTelefoneParticipante(String telefoneParticipante){
        this.telefoneParticipante = telefoneParticipante;
    }
// -------- >> FIM DOS SETS << ------
// ---------------------------------------------------------------------------
//   => MÉTODOS ABAIXO <=


// CRIEI O MÉTODO MOSTRAR, EXIBINDO AS INFORMAÇÕES QUE PODEM SER SEGURAS PARA COMPARTILHAR
public void mostrar(){
    System.out.println("Nome do participante : " + getNomeParticipante());
    System.out.println("ID participante: " + getIdParticipante());
    System.out.println("Email participante : " + getEmailParticipante());
    System.out.println("Endereço participante : " + getEnderecoParticipante());
    System.out.println("Telefone participante : " + getTelefoneParticipante());
}


// MÉTODO LOGIN FEITO, USEI COMO PARÂMETROS O LOGIN E SENHA QUE SERÃO PEDIDOS PELO CONSTRUTOR
public Participante loginParticipante(String login, String senha){
    if(this.loginParticipante.equals(login) && this.senhaParticipante.equals(senha)){
        System.out.println("Login realizado com sucesso");
        return this ; // RETORNEI O PRÓPRIO OBJETO
    }else{
        System.out.println("Erro ao realizar login, verifique suas credenciais");
        return null;
    }
}

// MÉTODO PARA REGISTRAR PARTICIPANTE (TIRAR DÚVIDA COM PROFESSOR)
public boolean registrarParticipante(){
    if(getIdParticipante() <= 0 ||getLoginParticipante() == null || getNomeParticipante() == null  || getEmailParticipante() == null){
        System.out.println("Não foi possível fazer o registro de participante");
        return false;
    }else{
        //Participante p = new Participante(idParticipante, nomeParticipante, loginParticipante, senhaParticipante, emailParticipante, enderecoParticipante, telefoneParticipante);
        System.out.println("Participante registrado com sucesso");
        return true;
    }
}
//ARRAY DO TIPO PARTICIPANTE, DENOMINEI COMO LISTAPARTICIPANTES, PARA ADICIONAR O PARTICIPANTES REGISTRADOS E LISTÁ-LOS COM OS MÉTODOS.
// public ArrayList<Participante> listaParticipantes = new ArrayList<>();

public ArrayList<Participante> listarParticipantes(ArrayList<Participante> listaParticipantes){  //CRIEI O LISTARPARTICIPANTES DO TIPO ARRAYLIST<PARTICIPANTE> IGUAL TINHA NO UML
    if(listaParticipantes.isEmpty()){ 
        System.out.println("Não tem participantes!");

    }else{
    for(Participante p : listaParticipantes){ // FOR EACH PARA MOSTRAR AS INFORMAÇÕES DOS PARTICIPANTES NA LISTA.
        p.mostrar();
        System.out.println("-------");
        }
    }
    return listaParticipantes;
}

public void inserir() throws Exception{
    FileWriter fw = new FileWriter("participante.txt", true);
    BufferedWriter bw = new BufferedWriter(fw);
    bw.write(this.idParticipante + ";" + this.nomeParticipante + ";" + this.loginParticipante + ";" + this.senhaParticipante + ";" + this.emailParticipante + ";" + this.enderecoParticipante + ";" + this.telefoneParticipante);
    bw.newLine();
    bw.close();
    System.out.println("Participante salvo no arquivo participante.txt");
}

public Participante consultar(int idBusca) throws Exception{
    FileReader fr = new FileReader("participante.txt");
    BufferedReader br = new BufferedReader(fr);

    String linha = "";
    while((linha = br.readLine()) != null){ // loop para ler as linhas do arquivo que forem diferentes de null
        String [] dados = linha.split(";"); // cria o array dados e quebra as linhas em cada ;

        if(Integer.parseInt(dados[0].trim()) == idBusca){ // compara se o o dados[0] que no array é o ID, convertendo ele pra inteiro e compara com idBusca que eu passei como parâmetro, além de quebrar o espaços em branco om trim()
            Participante p = new Participante(Integer.parseInt(dados[0].trim()), dados[1].trim(),dados[2].trim(), dados[3].trim(), dados[4].trim(), dados[5].trim(), dados[6].trim()); // aqui foi p transformar o primeiro parâmetro para inteiro, já que recebe uma string e o resto dos parâmetros continuam String, seguindo a ordem do construtor

                br.close(); // para fechar o reader quando enconttrar
                System.out.println("Participante encontrado");
                return p;

        }
    }
    br.close(); // para fehcar o reader caso não encontrar
    System.out.println("Participante não encontrado");
    return null;
}

public ArrayList<Participante> listarParticipantestxt() throws Exception{
    ArrayList<Participante> listatxtparticipante = new ArrayList<>();
    FileReader fr = new FileReader("participante.txt");
    BufferedReader br = new BufferedReader(fr);
    String linha = "";

    while((linha = br.readLine()) != null){
        String [] dados = linha.split(";");
        Participante p = new Participante(Integer.parseInt(dados[0].trim()), dados[1].trim(), dados[2].trim(), dados[3].trim(), dados[4].trim(), dados[5].trim(), dados[6].trim());
        listatxtparticipante.add(p);
        

        
    }
    br.close();
    return listatxtparticipante;


}
}