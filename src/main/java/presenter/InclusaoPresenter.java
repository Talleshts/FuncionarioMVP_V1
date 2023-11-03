/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package presenter;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.FuncionarioCollection;
import view.InclusaoView;

/**
 *
 * @author talle
 */
public class InclusaoPresenter {
    
    private FuncionarioCollection colecaoFuncionarios;
    private InclusaoView viewInclusao;
    
    public InclusaoPresenter(){
        colecaoFuncionarios = FuncionarioCollection.getInstancia();
        viewInclusao = new InclusaoView();
        
        /* Adicionar os ActionListeners */
        
        viewInclusao.setLocationRelativeTo(null);
        viewInclusao.setVisible(true);
    }
}
