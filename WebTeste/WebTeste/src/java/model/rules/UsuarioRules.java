/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.rules;

import java.util.Date;
import model.Usuario;

/**
 *
 * @author aluno
 */
public class UsuarioRules {
    public Usuario login(String login, String senha){
        if(login.equals("adm") && senha.equals("123")){
            return new Usuario("Administrador", login, senha, true, new Date(117, 7, 31, 21, 30));
        }else if(login.equals("zezin") && senha.equals("321")){
            return new Usuario("Zezin das ", login, senha, true, new Date(117, 7, 31, 18, 30));
        }else{
            return null;
        }
    }
    
    
    public boolean senhaExpirada(Usuario user){
        return new Date().after(user.getSenhaExpirada());
    }
}

