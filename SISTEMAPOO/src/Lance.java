import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class Lance {
    private int idLance;
    private Participante participante;
    private ItemLeilao itemLeilao;
    private Double valorLance;
    private String dataLance;
    private String horaLance;

    public Lance(int idLance, Participante participante, ItemLeilao itemLeilao, Double valorLance, String dataLance, String horaLance){
        this.idLance = idLance;
        this.itemLeilao = itemLeilao;
        this.valorLance = valorLance;
        this.dataLance = dataLance;
        this.horaLance = horaLance;
        this.participante = participante;
    }
// ---> INICIO GETS JA FEITOS
    public int getIdLance(){
        return this.idLance;
    }
    public Participante getParticipante(){
        return this.participante;
    }
    public ItemLeilao getItemLeilao(){
        return this.itemLeilao;
    }
    public Double getValorLance(){
        return this.valorLance;
    }
    public String getDataLance(){
        return this.dataLance;
    }
    public String getHoraLance(){
        return this.horaLance;
    }
    // -- FIM DOS GETS

    //--- INICIO DOS SETTERS
    public void setIdLance(int idLance){
        this.idLance = idLance;
    }
    public void setParticipante(Participante participante){
        this.participante = participante;
    }
    public void setItemLeilao(ItemLeilao itemLeilao){
        this.itemLeilao = itemLeilao;
    }
    public void setValorLance(Double valorLance){
        this.valorLance = valorLance;
    }
    public void setDataLance(String dataLance){
        this.dataLance = dataLance;
    }
    public void setHoraLance(String horaLance){
        this.horaLance = horaLance;
    }

    /// --->>>> FIM DOS SETS
    /// 
    // ---------------------------------------------------------------------------
//   => MÉTODOS ABAIXO <=
// CRIEI O MÉTODO MOSTRAR, EXIBINDO AS INFORMAÇÕES DO LANCE

public void mostrar(){  
    System.out.println("ID Lance : " + getIdLance());
    System.out.println("Item do Leilão : " + getItemLeilao().getDescricaoItem());
    System.out.println("Valor lance : " + getValorLance() + " | " + "Hora Lance : " + getHoraLance() + " | " + "Data Lance : " + getDataLance());
    System.out.println("Participante : " + getParticipante().getNomeParticipante());
}
// MÉTODO REGISTRAR LANCE, MAIS OU MENOS PARECIDO COM REGISTRAR PARTICIPANTE
public boolean registrarLance(){ 
    if(getParticipante() == null || getValorLance() == null || getValorLance() <= 0 ||getItemLeilao() == null){
        System.out.println("Dados inválidos");
        System.out.println("Não foi possível realizar o lance");
        return false;
    }else if(getValorLance() < getItemLeilao().getLanceMinimoItem()){
        System.out.println("O valor do lance tem que ser maior que o minímo de : " + getItemLeilao().getLanceMinimoItem());
        System.out.println("Lance não registrado.");
        return false;
    }else{
        System.out.println("Lance de " + getValorLance() + " registrado com sucesso");
        return true;
    }
}

public ArrayList<Lance> listarLances(ArrayList<Lance> listaLances){
    if(listaLances.isEmpty()){
        System.out.println("A lista de lances está vazia");
    }else{
        for(Lance l : listaLances){
            l.mostrar();
            System.out.println("------");
        }   
    } return listaLances;
}

public void inserir() throws Exception{
    FileWriter fw = new FileWriter("lance.txt", true);
    BufferedWriter bw = new BufferedWriter(fw);
    bw.write(this.idLance + ";" + this.participante.getIdParticipante() + ";" + this.itemLeilao.getIdItem() + ";" + this.valorLance + ";" + this.dataLance + ";" + this.horaLance);
    bw.newLine();
    bw.close();
    System.out.println("Lance inserido no lance.txt");
}

public Lance consultar(int idBusca) throws Exception{
    FileReader fr = new FileReader("lance.txt");
    BufferedReader br = new BufferedReader(fr);

    String linha = "";

    while((linha = br.readLine()) != null){
        String [] dados = linha.split(";");

        if(Integer.parseInt(dados[0].trim()) == idBusca){

            Participante participantetemp = new Participante(0, "", "", "", "", "", "");
            Participante participanterecuperar = participantetemp.consultar(Integer.parseInt(dados[1].trim())); // ou seja, vai pegar o id do participante que o usuário quiser, no caso da ordem do array dados. o id do participante esta a posição 1
            // so pra ajudar na explicaçao, o participante e o item sempra vão existir no lance, diferentemente da construção do itemleilao que o lance poderia não existir
            ItemLeilao itemtemp = new ItemLeilao(0, null, "", 0.0, false, null);
            ItemLeilao itemrecuperar = itemtemp.consultar(Integer.parseInt(dados[2].trim())); // mesma logica de recuprar o participante, no caso, ele vai pegar no array a posição 2 que esta o id do participante desejado

            Lance l  = new Lance(Integer.parseInt(dados[0].trim()), participanterecuperar, itemrecuperar, Double.parseDouble(dados[3].trim()), dados[4].trim(), dados[5].trim());
            br.close();
            System.out.println("Lance encontrado!");
            return l;
            
        }
    } br.close();
        System.out.println("Lance não encontrado!");
        return null;

}




}
