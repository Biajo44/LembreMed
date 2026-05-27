package view;

import javax.swing.*;   //importa componentes graficos
import model.Medicamento;   //importa a classe medicamento
import java.util.*; //importa utilitarios

public class ListaMedicamentoFrame extends JFrame{
    private List<Medicamento> lista = new ArrayList<>();    //lista cadastrada
    private DefaultListModel<String> model = new DefaultListModel<>();  //modelo para exibir o item
    private JList<String> jList;    //componente grafico
    
    public ListaMedicamentoFrame(){
        setTitle("LISTA DE MEDICAMENTOS");    //titulo
        setSize(600,400);   //tamanho
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //fecha apenas essa janela (nao encerra o programa)
        setLayout(null);    //layout absoluto posicionamento
        
        jList = new JList<>(model);
        JScrollPane scroll = new JScrollPane(jList);
        scroll.setBounds(20,20,200,200);
        add(scroll);
        
        JButton btnAdd = new JButton("ADICIONAR");
        btnAdd.setBounds(240,20,120,25);
        add(btnAdd);
        
        JButton btnDetalhes = new JButton("DETALHES");
        btnDetalhes.setBounds(240,60,120,25);
        add(btnDetalhes);
        
        //acao do botao adicionar
        btnAdd.addActionListener(e -> {
            CadastroMedicamentoFrame cadastro = new CadastroMedicamentoFrame(lista, this);
            cadastro.setVisible(true);
            
        });
        
        //acao do detalhe
        btnDetalhes.addActionListener(e -> {
            int index = jList.getSelectedIndex();   //pega o item selecionado
            if(index >=0){
                Medicamento m = lista.get(index);   //recupera o medicamento da lista e mostra detalhe
                JOptionPane.showMessageDialog(this, m.detalhes());
            }else{  //caso nao selecionado nenhum item
                JOptionPane.showMessageDialog(this, "SELECIONE UM MEDICAMENTO!");
            }
        });
    }
    
    // metodo para atualizar a lista grafica
    public void atualizarLista(){
        model.clear();  //limpa
        for(Medicamento m : lista){
            model.addElement(m.id + " - " + m.nome);
        }
    }
    
}
