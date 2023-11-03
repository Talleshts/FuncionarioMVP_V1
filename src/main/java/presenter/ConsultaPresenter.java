/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package presenter;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.Funcionario;
import model.FuncionarioCollection;
import view.ConsultaView;

/**
 *
 * @author talle
 */
public class ConsultaPresenter {
    
    private FuncionarioCollection colecaoFuncionarios;
    private ConsultaView viewConsulta;
    
    public ConsultaPresenter(){
        colecaoFuncionarios = FuncionarioCollection.getInstancia();
        viewConsulta = new ConsultaView();
        
        /* Adicionar os ActionListeners */
    
        viewConsulta.getBtnCancelarConsulta().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Feche a view de consulta quando o botão de cancelar for pressionado
                viewConsulta.dispose();
            }
        });
        
        viewConsulta.setLocationRelativeTo(null);
        viewConsulta.setVisible(true);
    
    }
   
    // Método para atualizar a tabela com os dados dos funcionários
    public void atualizarTabela() {
        
        JTable tableConsulta = viewConsulta.getTableConsulta();
        DefaultTableModel model = (DefaultTableModel) tableConsulta.getModel();
        model.addColumn("Nome do Funcionário");
        model.setRowCount(0); // Limpa todas as linhas da tabela

        for (Funcionario funcionario : colecaoFuncionarios.getFuncionarios()) {
            System.out.println(funcionario.getNome());
            // Adicione uma nova linha à tabela com os dados do funcionário
            Object[] rowData = {
                funcionario.getNome()
            };
            model.addRow(rowData);
        }
    }

    /*
        Não deveria ser papel da ConsultaPresenter chamar o método "adicionarFuncionario"
        da FuncionarioCollection.

        Quem deve fazer isso é a própria InclusaoPresenter.
    */
    // void adicionarNovoFuncionario(Funcionario novoFuncionario) {
    //     
    //     colecaoFuncionarios.adicionarFuncionario(novoFuncionario);
    //     viewConsulta.atualizarTabela();
    // }
}
