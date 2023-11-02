/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author Arthu
 */
public class FuncionarioCollection {
    
    private static FuncionarioCollection funcionarioCollection;
    
    private ArrayList<Funcionario> funcionarios;
    
    private FuncionarioCollection(){
        funcionarios = new ArrayList<>();
    }
    
    public static FuncionarioCollection getInstancia(){
        
        if(funcionarioCollection == null){
            funcionarioCollection = new FuncionarioCollection();
        }
        
        return funcionarioCollection;
    }
    
    public void adicionarFuncionario(Funcionario funcionario){
        funcionarios.add(funcionario);
    }
    
    public void removerFuncionario(long id){
        
        for(Funcionario funcionario : funcionarios){
            
            if(funcionario.getId() == id){
                funcionarios.remove(funcionario);
                return;
            }
        }
    }
    
    public void listarFuncionario(long id){
        
        for(Funcionario funcionario : funcionarios){
            
            if(funcionario.getId() == id){
                System.out.println(funcionario.getNome());
                return;
                /*
                    Na verdaaaaade, nós vamos tirar esse println daqui e adicionar
                    no JTextField(?) a Stringzona com todos os campos de funcionario
                */
            }
        }
    }
    
    /*
        Tallin, vi que no seu diagrama de classe tinha um método "atualizar",
        mas acho que não precisa, olhando o requisito do trabalho.
    
        Além disso, provavelmente teríamos que criar um novo botão de atualizar,
        uma nova tela de atualizar... etc.
    */
    
}

