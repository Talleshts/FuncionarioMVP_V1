/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package presenter;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
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
    private Map<String, Funcionario> mapaFuncionarios;
    
    public ConsultaPresenter(){
        colecaoFuncionarios = FuncionarioCollection.getInstancia();
        viewConsulta = new ConsultaView();
         mapaFuncionarios = new HashMap<>();
        /* Adicionar os ActionListeners */
    
        viewConsulta.getBtnCancelarConsulta().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Feche a view de consulta quando o botão de cancelar for pressionado
                viewConsulta.dispose();
            }
        });
        
        /*        viewConsulta.getBtnConsultarConsulta().addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
        // Obtém a linha selecionada na tabela
        int selectedRow = viewConsulta.getTableConsulta().getSelectedRow();
        
        if (selectedRow != -1) {
        // Obtém o modelo da tabela
        DefaultTableModel model = (DefaultTableModel) viewConsulta.getTableConsulta().getModel();
        
        // Obtém os dados do funcionário da linha selecionada
        String nome = (String) model.getValueAt(selectedRow, 0); // Supondo que o nome está na coluna 0
        
        // Aqui você pode passar os dados do funcionário para VisualizacaoPresenter
        VisualizacaoPresenter presenterVisualizacao = new VisualizacaoPresenter(nome, nome, nome, Double.NaN);
        }
        }
        });*/
        
        viewConsulta.getBtnConsultarConsulta().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Obtém a linha selecionada na tabela
                int selectedRow = viewConsulta.getTableConsulta().getSelectedRow();

                if (selectedRow != -1) {
                    // Obtém o modelo da tabela
                    DefaultTableModel model = (DefaultTableModel) viewConsulta.getTableConsulta().getModel();

                    // Obtém os dados do funcionário da linha selecionada
                    String nome = (String) model.getValueAt(selectedRow, 0); // Supondo que o nome está na coluna 0
                    
                    // Obtém as informações adicionais do mapa
                    Funcionario funcionario = mapaFuncionarios.get(nome);
                    
                    if (funcionario != null) {
                        // Aqui você pode passar os dados do funcionário para VisualizacaoPresenter
                        VisualizacaoPresenter presenterVisualizacao = new VisualizacaoPresenter(
                            funcionario.getNome(),
                            funcionario.getCargo(),
                            funcionario.getDataAdmissao(),
                            funcionario.getSalario()
                        );
                    }
                }
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
            // Adicione uma nova linha à tabela com os dados do funcionário
            Object[] rowData = {
                funcionario.getNome()
            };
            model.addRow(rowData);
            
            // Associe as informações do funcionário ao nome no mapa
            mapaFuncionarios.put(funcionario.getNome(), funcionario);
        }
    }
}
