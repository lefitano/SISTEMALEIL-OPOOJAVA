import java.util.ArrayList;

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
    if(getLoginParticipante() == null || getNomeParticipante() == null  || getEmailParticipante() == null){
        System.out.println("Não foi possível fazer o registro de participante");
        return false;
    }else{
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
}