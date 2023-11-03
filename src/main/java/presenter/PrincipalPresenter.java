/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package presenter;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import model.FuncionarioCollection;
import view.PrincipalView;

/**
 *
 * @author talle
 */
public class PrincipalPresenter {
    
    private FuncionarioCollection colecaoFuncionarios;
    private PrincipalView viewPrincipal;

    public PrincipalPresenter() {
        colecaoFuncionarios = FuncionarioCollection.getInstancia();
        viewPrincipal = new PrincipalView();
        
        viewPrincipal.getBtnConsultarPrincipal().addActionListener(new ActionListener(){
            
            @Override
            // Ao clicar no botão de consulta, instanciamos a ConsultaPresenter
            public void actionPerformed(ActionEvent e){
                ConsultaPresenter presenterConsulta = new ConsultaPresenter();
            }
        });
        
        viewPrincipal.getBtnIncluirPrincipal().addActionListener(new ActionListener(){
            
            @Override
            // Ao clicar no botão de consulta, instanciamos a InclusaoPresenter
            public void actionPerformed(ActionEvent e){
                InclusaoPresenter presenterInclusao = new InclusaoPresenter();
            }
        });
        
        viewPrincipal.setLocationRelativeTo(null);
        viewPrincipal.setVisible(true);
    }
}
