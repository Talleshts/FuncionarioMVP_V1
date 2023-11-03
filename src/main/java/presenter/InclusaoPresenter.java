/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package presenter;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.table.DefaultTableModel;
import model.Funcionario;
import model.FuncionarioCollection;
import view.ConsultaView;
import view.InclusaoView;

/**
 *
 * @author talle
 */
public class InclusaoPresenter {
    
    private FuncionarioCollection colecaoFuncionarios;
    private InclusaoView viewInclusao;
    private ConsultaPresenter consultaPresenter;
    private ConsultaView consultaView;
    
    public InclusaoPresenter(){
        colecaoFuncionarios = FuncionarioCollection.getInstancia();
        viewInclusao = new InclusaoView();
        
        /* Adicionar os ActionListeners */
        viewInclusao.getBtnIncluirInclusao().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Recupere os valores dos campos de entrada
                String nome = viewInclusao.getTxtNomeInclusao().getText();
                String cargo = viewInclusao.getTxtCargoInclusao().getText();
                String dataAdmissao = viewInclusao.getTxtDataAdmissaoInclusao().getText();
                Double salario = Double.parseDouble(viewInclusao.getTxtSalarioInclusao().getText());
                Long novoId = FuncionarioCollection.getProximoId();

                // Crie um novo funcionário
                Funcionario novoFuncionario = new Funcionario(novoId, nome, cargo, dataAdmissao, salario);
                FuncionarioCollection.proximoId++;

                // Adicione o novo funcionário à coleção de funcionários
                colecaoFuncionarios.adicionarFuncionario(novoFuncionario);

                /*
                    InclusaoPresenter não pode mexer na ConsultaView, somente a
                    ConsultaPresenter pode.
                */
                // DefaultTableModel model = (DefaultTableModel) consultaView.getTableConsulta().getModel();
                // model.addRow(new Object[] {novoFuncionario.getNome()}); // Adicione mais informações se necessário

                // Limpe os campos de entrada após a inclusão
                viewInclusao.getTxtNomeInclusao().setText("");
                viewInclusao.getTxtCargoInclusao().setText("");
                viewInclusao.getTxtDataAdmissaoInclusao().setText("");
                viewInclusao.getTxtSalarioInclusao().setText("");
                // Atualize a interface do usuário, se necessário
            }
        });
        
        viewInclusao.getBtnCancelarInclusao().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Feche a view de inclusão quando o botão de cancelar for pressionado
                viewInclusao.dispose();
            }
        });
        
        viewInclusao.setLocationRelativeTo(null);
        viewInclusao.setVisible(true);
    }
}
