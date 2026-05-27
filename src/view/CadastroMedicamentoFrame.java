package view;

import javax.swing.*;   //importa componentes graficos
import model.Medicamento;   //importa a classe medicamento
import java.util.List;  //importa a interface list para trabalhar com listas

public class CadastroMedicamentoFrame  extends JFrame{
    
    public CadastroMedicamentoFrame(List<Medicamento> lista, ListaMedicamentoFrame listaFrame){
        setTitle("CADASTRO DE MEDICAMENTO");    //titulo
        setSize(500,450);   //tamanho
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); //fecha apenas essa janela (nao encerra o programa)
        setLayout(null);    //layout absoluto posicionamento
        
        JTextField txtNome = new JTextField();
        JTextField txtQtd = new JTextField();
        JTextField txtDias = new JTextField();
        
        // spinner para horario 
        SpinnerDateModel modelHora = new SpinnerDateModel();
        JSpinner spinnerHora = new JSpinner(modelHora);
        JSpinner.DateEditor editor = new JSpinner.DateEditor(spinnerHora, "HH:mm");
        spinnerHora.setEditor(editor);
        
        JButton btnSalvar = new JButton("Salvar");
        
        JLabel[] labels = {
            new JLabel("Nome: "), new JLabel("Horario: "), new JLabel("Quantidade: "), new JLabel("Dias: ")
        };
        
        // posiciona os labels na tela
        int y = 20;
        for (int i=0; i<labels.length; i++){    
            labels[i].setBounds(20,y,120,25);   //define posicao e tamanho
            add(labels[i]);     //adiciona ao frame
            y+=40;  //incrementa a posicao
        }
        
        //posiciona os campos de texto
        txtNome.setBounds(150,20,200,25); add(txtNome);
        spinnerHora.setBounds(180,60,180,25); add(spinnerHora);
        txtQtd.setBounds(150,100,200,25); add(txtQtd);
        txtDias.setBounds(150,140,200,25); add(txtDias);
        
        btnSalvar.setBounds(150,180,100,25);
        add(btnSalvar);
        
        btnSalvar.addActionListener(e -> {
            try{
            int id = lista.size()+1;    //gera id automatico
            String horario = editor.getFormat().format(spinnerHora.getValue());
            
            Medicamento m = new Medicamento(id, txtNome.getText(), horario,
            Integer.parseInt(txtQtd.getText()), Integer.parseInt(txtDias.getText()));
            
            lista.add(m);
            
            JOptionPane.showMessageDialog(this, "MEDICAMENTO CADASTRADO!");
            
            listaFrame.atualizarLista();
            
            dispose();  //fecha apos salvar
            
            } catch (Exception ex){
                JOptionPane.showMessageDialog(this, "ERRO AO CADASTRAR: preenchar todos os  campos. ");
            }
        });
   
}
    
}
