import java.util.ArrayList;
public class ItemLeilao {
    private int idItem;
    private Leilao leilao;
    private String descricaoItem;
    private Double lanceMinimoItem;
    private boolean itemArrematado;
    private Lance lanceArrematante;

    public ItemLeilao(int idItem, Leilao leilao, String descricaoItem, Double lanceMinimoItem, boolean itemArrematado, Lance lanceArrematante){
        this.idItem = idItem;
        this.leilao = leilao;
        this.descricaoItem = descricaoItem;
        this.lanceMinimoItem = lanceMinimoItem;
        this.itemArrematado = itemArrematado;
        this.lanceArrematante = lanceArrematante;
    }
// ---- >> INICIO DOS GETS PRONTOS
    public int getIdItem(){
        return this.idItem;
    }
    public Leilao getLeilao(){
        return this.leilao;
    }
    public String getDescricaoItem(){
        return this.descricaoItem;
    }
    public Double getLanceMinimoItem(){
        return this.lanceMinimoItem;
    }
    public boolean isItemArrematado(){
        return this.itemArrematado;
    }
    public Lance getLanceArrematante(){
        return this.lanceArrematante;
    }

  //  -- > FIM DOS GETS PRONTOS

  public void setIdItem(int idItem){
        this.idItem = idItem;
  }
  public void setLeilao(Leilao leilao){
        this.leilao = leilao;
  }
  public void setDescricaoItem(String descricaoItem){
        this.descricaoItem = descricaoItem;
  }
  public void setLanceMinimoItem(Double lanceMinimoItem){
        this.lanceMinimoItem = lanceMinimoItem;
  }
  public void setItemArrematado(boolean itemArrematado){
        this.itemArrematado = itemArrematado;
  }
  public void setLanceArrematante(Lance lanceArrematante){
        this.lanceArrematante = lanceArrematante;
  }

   //FIM DOS SETS FEITOS

    // ---------------------------------------------------------------------------
//   => MÉTODOS ABAIXO <=
// CRIEI O MÉTODO MOSTRAR, EXIBINDO AS INFORMAÇÕES DOS ITENS DO  LEILÃO

public void mostrar(){
    System.out.println("ID do Item : " + getIdItem());
    System.out.println("Descrição do item : " + getDescricaoItem());
    System.out.println("Lance Minímo : " + getLanceMinimoItem());
    System.out.println("Leilão do item: " + getLeilao().getIdLeilao());
}

public boolean registrarItem(){
    if(getIdItem() <= 0 || getDescricaoItem() == null || getDescricaoItem().isEmpty() || getLanceMinimoItem() <= 0 || getLeilao() == null){
        System.out.println("Não foi possível registrar o item");
        System.out.println("Verifique as condições necessárias");
        return false;
    }else{
        setItemArrematado(false);
        setLanceArrematante(null);
        System.out.println("ITEM REGISTRADO");
        System.out.println("Item ID : " + getIdItem());
        System.out.println("Descrição : " + getDescricaoItem());
        System.out.println("Lance minimo necessário: " + getLanceMinimoItem());
        return true;
    }
}
public void arrematarItem(Lance lance){  //USA O LANCE COMO PARAMETRO
    if(lance == null){  // SE NÃO TIVER NADA INFORMADO NO LANCE, INVALIDA
        System.out.println("Lance inválido");
        return;
    }if(isItemArrematado()){ // VERIRICA O STATUS DO ITEM, SE JA ESTIVER ARREMATADO, OU SEJA TRUE, INVALIDA
        System.out.println("Item já arrematado!");
        return;
    }else if(lance.getValorLance() < getLanceMinimoItem()){ // SE O VALOR DO LANCE FOR MENOR QUE O MINIMO EXIGIDO DO ITEM, INVALIDA
        System.out.println("Valor do lance : " + lance.getValorLance());
        System.out.println("Valor do lance tem que ser maior que o valor minímo de : " + getLanceMinimoItem());
        return;
    }else { // SE PASSAR POR TODAS AS CONDIÇÕES ANTERIORES, VALIDA O LANCE E ARREMATA O ITEM
    System.out.println("ITEM ARREMATADO!");
    setItemArrematado(true);
    setLanceArrematante(lance);
    System.out.println("ID item arrematado : " + getIdItem() + "|" + "Descrição : " + getDescricaoItem());
    System.out.println("Dono do lance : " + lance.getParticipante().getNomeParticipante());
    System.out.println("Valor do lance : " + lance.getValorLance());
    }
}

public ItemLeilao consultarItem(ArrayList<ItemLeilao> listaItens, int idItemBusca){  // PARA CONSULTAR, PRECISO TER O ARRAYLIST E PROCURAR O ITEM DE ACORDO COM SEU ID
    if(listaItens.isEmpty()){ //SE A LISTA ESTA VAZIA, INVALIDA
        System.out.println("Lista de itens vazia!");
        return null;
    }
    for(ItemLeilao i : listaItens){ // FOR EACH PARA PERCORRER ENTRE A LISTA DE ITENS
        if(idItemBusca == i.getIdItem()){ // VALIDANDO SE O ID MANDADO COM PARAMETRO EXISTE NA LISTA
            System.out.println("Item encontrado!");
            i.mostrar();
            return i;
        }
    } System.out.println("Item de ID " + idItemBusca + " não encontrado"); // INVALIDA SE N O ID DO ITEM PASSADO COMO BUSCA NÃO EXISTIR NA LISTA
      return null;
    
}

public ArrayList<ItemLeilao> listarItens(ArrayList<ItemLeilao> listaItens){
    if(listaItens.isEmpty()){
        System.out.println("A lista de itens está vazia!");
        return null;
    }else{
        for(ItemLeilao i : listaItens){
            i.mostrar();
            System.out.println("----");
            
        }
        return listaItens;
    }
}


}
