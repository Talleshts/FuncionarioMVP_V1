/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package presenter;

import java.time.Instant;
import java.time.LocalDateTime;
import view.VisualizacaoView;
import java.time.ZoneId;
import java.util.Date;
/**
 *
 * @author talle
 */
public class VisualizacaoPresenter {
    
    private String nomeFuncionario;
    private String cargoFuncionario;
    private String dataAdmissao;
    private Double salario;
    private VisualizacaoView viewVisualizacao; 
    

    public VisualizacaoPresenter(String nomeFuncionario, String cargoFuncionario, String dataAdmissao, Double salario) {
        this.nomeFuncionario = nomeFuncionario;
        this.cargoFuncionario = cargoFuncionario;
        this.dataAdmissao = dataAdmissao;
        this.salario = salario;

        // Crie uma instância de VisualizacaoView
        viewVisualizacao = new VisualizacaoView();

        // Agora você pode acessar os componentes da view
        viewVisualizacao.getTxtNomeVisualizacao().setText(nomeFuncionario);
        viewVisualizacao.getTxtDataAdmissaoVisualizacao().setText(dataAdmissao);
        viewVisualizacao.getTxtCargoVisualizacao().setText(cargoFuncionario);
        viewVisualizacao.getTxtSalarioVisualizacao().setText(salario.toString());

        viewVisualizacao.setLocationRelativeTo(null);
        viewVisualizacao.setVisible(true);
    }

}
