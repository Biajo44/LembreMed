package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;   //importa componentes graficos
import model.Usuario;   //importa a classe usuario

public class CadastroUsuarioFrame extends JFrame{
    public Usuario usuario;
    
    public CadastroUsuarioFrame(){
        setTitle("CADASTRO DE USUARIO");    //titulo
        setSize(500,600);   //tamanho
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); //fecha apenas essa janela (nao encerra o programa)
        setLayout(null);    //layout absoluto posicionamento
        
        JTextField txtNome = new JTextField();
        JPasswordField txtSenha = new JPasswordField();
        JPasswordField txtConfirmar = new JPasswordField();
        JTextField txtTelefone = new JTextField();
        JTextField txtEndereco = new JTextField();
        JTextField txtEmail = new JTextField();
        JComboBox<String> cbSexo = new JComboBox<>(new String[]{"Masculino","Feminino"});   //combobox
        JTextField txtIdade= new JTextField();
        JButton btnSalvar = new JButton("Salvar");
        
        JLabel[] labels = {
            new JLabel("Nome: "), new JLabel("Senha: "), new JLabel("Confirmar senha: "), 
            new JLabel("Telefone (DDD): "), new JLabel("Endereco: "), new JLabel("Email: "),
            new JLabel("Sexo: "), new JLabel("Idade: ")
        };
        
        // posiciona os labels na tela
        int y = 20;
        for (int i=0; i<labels.length; i++){
            labels[i].setBounds(20,y,120,25);
            add(labels[i]);
            y+=40;
        }
        
        //posiciona os campos de texto
        txtNome.setBounds(150,20,200,25); add(txtNome);
        txtSenha.setBounds(150,60,200,25); add(txtSenha);
        txtConfirmar.setBounds(150,100,200,25); add(txtConfirmar);
        txtTelefone.setBounds(150,140,200,25); add(txtTelefone);
        txtEndereco.setBounds(150,180,200,25); add(txtEndereco);
        txtEmail.setBounds(150,220,200,25); add(txtEmail);
        cbSexo.setBounds(150,260,200,25); add(cbSexo);
        txtIdade.setBounds(150,300,200,25); add(txtIdade);
        
        btnSalvar.setBounds(150,340,100,25);
            add(btnSalvar);
            
            //acao de salvar
            btnSalvar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!new String(txtSenha.getPassword()).equals(new String(txtConfirmar.getPassword()))) {
                    JOptionPane.showMessageDialog(CadastroUsuarioFrame.this, "SENHAS NAO CONFEREM!");
                    return;
                }
                usuario = new Usuario(txtNome.getText(), new String(txtSenha.getPassword()),
                        txtTelefone.getText(), txtEndereco.getText(), txtEmail.getText(), cbSexo.getSelectedItem().toString(),
                        Integer.parseInt(txtIdade.getText())
                );
                JOptionPane.showMessageDialog(CadastroUsuarioFrame.this, "USUARIO CADASTRADO COM SUCESSO!");
                dispose();
                new LoginFrame(usuario).setVisible(true);
            }
        });
        
    }
    
}
