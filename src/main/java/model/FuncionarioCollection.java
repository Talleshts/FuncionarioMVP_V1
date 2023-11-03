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
    
    public static long proximoId = 1;
    
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
    
    public void removerFuncionario(Long id){
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
            }
        }
    }
    
    public ArrayList<Funcionario> getFuncionarios() {
        return funcionarios;
    }
    
    public static long getProximoId() {
        return proximoId;
    }
}

