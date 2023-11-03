/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package presenter;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
        
        viewConsulta.setLocationRelativeTo(null);
        viewConsulta.setVisible(true);
    
        viewConsulta.getBtnCancelarConsulta().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Feche a view de consulta quando o botão de cancelar for pressionado
                viewConsulta.dispose();
            }
        });
    
    }
   
    

    void adicionarNovoFuncionario(Funcionario novoFuncionario) {
        
        colecaoFuncionarios.adicionarFuncionario(novoFuncionario);
        viewConsulta.atualizarTabela();
    }
}
