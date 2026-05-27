package view;

import javax.swing.*;   //importa componentes graficos
import model.Usuario;   //importa a classe usuario

public class LoginFrame extends JFrame {
    private JTextField txtNome; //campo digitar nome
    private JPasswordField txtSenha;    //campo digitar senha
    private JButton btnLogin;   
    private Usuario usuario;
    
    //construtor da tela de login, recebe um usuario para autenticacao
    public LoginFrame(Usuario usuario){
        this.usuario = usuario;
        
        setTitle("LOGIN");    //titulo
        setSize(400,250);   //tamanho
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //fecha apenas essa janela (nao encerra o programa)
        setLayout(null);    //layout absoluto posicionamento
        
        //label e campo do nome
        JLabel lblNome = new JLabel("Nome: ");
        lblNome.setBounds(20,20,80,25);
        add(lblNome);
        
        txtNome = new JTextField();
        txtNome.setBounds(100,20,200,25);
        add(txtNome);
        
        //label e campo da senha
        JLabel lblSenha = new JLabel("Senha: ");
        lblSenha.setBounds(20,60,80,25);
        add(lblSenha);
        
        txtSenha = new JPasswordField();
        txtSenha.setBounds(100,60,200,25);
        add(txtSenha);
        
        btnLogin = new JButton("Entrar");
        btnLogin.setBounds(100,100,100,25);
        add(btnLogin);
        
        btnLogin.addActionListener(e -> {
            String nome = txtNome.getText();
            String senha = new String(txtSenha.getPassword());
            
            //verifica se existe e se estao corretos
            if(usuario != null && usuario.nome.equals(nome) && usuario.senha.equals(senha)){
                JOptionPane.showMessageDialog(this, "BEM-VINDO, " + usuario.nome + "!");
                
                dispose();  //fecha
                new ListaMedicamentoFrame().setVisible(true);   //abre a lista de medicamento
            }else{
                JOptionPane.showMessageDialog(this, "LOGIN INVALIDO!");
            }
        });
        
    }
    
}
