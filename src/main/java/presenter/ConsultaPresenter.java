/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package presenter;

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
    }
}
