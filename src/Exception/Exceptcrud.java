package Exception;

import javax.swing.JOptionPane;

import controller.Controller;

public class Exceptcrud implements Intercafeexc {
    private Controller ctrl = new Controller();

    @Override
    public boolean VerifyDell(String Nome, String senha, String UserD) {
        Controller ctrl = new Controller();
        try {
            if (ctrl.auth(Nome, senha)) {
                if (ctrl.isAdm(Nome)) {
                    if (ctrl.deleteElement(UserD)) {
                        JOptionPane.showMessageDialog(null, "Usuario '" + UserD + "'deletado");
                        return true;
                    } else {
                        JOptionPane.showMessageDialog(null, "Usuario não encontrado");
                        return false;
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Usuario não autorizado");
                    return false;
                }
            } else {
                JOptionPane.showMessageDialog(null, "senha invalida para deletar o usuario");
                return false;
            }
        } catch (Exception err) {
            System.out.println(err.getMessage());
            return false;
        }
    }

    @Override
    public boolean VerifyAdd(String New_user, String Senha, String Senha_rep) {
        Controller auth = new Controller();
        try {
            if (auth.VerifySenha(Senha, Senha_rep)) {
                if (auth.insertDB(New_user, Senha, "n")) {
                    JOptionPane.showMessageDialog(null, "cadastrado");
                    return true;
                } else {
                    JOptionPane.showMessageDialog(null, "Usuario já cadastrado");
                    return false;
                }
            } else {
                JOptionPane.showMessageDialog(null, "Senhas diferentes");
                return false;
            }
        } catch (Exception err) {
            System.out.println(err.getMessage());
            return false;
        }

    }

    @Override
    public boolean VerifyUpdate(String Nome, String user, String senha, String adm, String auth, String pass) {
        Controller ctrl = new Controller();
        try {
            if (ctrl.auth(auth, pass)) {
                if (ctrl.isAdm(auth)) {
                    if (ctrl.UpdateUser(user, Nome, senha, adm)) {
                        return true;
                    } else {
                        JOptionPane.showMessageDialog(null, "usuario nao encontrado");
                        return false;
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Usuario não autorizado");
                    return false;
                }
            } else {
                JOptionPane.showMessageDialog(null, "senha invalida para atualizar o usuario");
                return false;
            }
        } catch (Exception err) {
            System.out.println(err.getMessage());
            return false;
        }
    }

    @Override
    public boolean VerifyUpdateEvent(String evento, String tell, String local, String bairro, int[] data) {
        try {
            if (ctrl.AddEvent(evento, tell, local, bairro, data)) {
                return true;
            } else {
                JOptionPane.showMessageDialog(null, "Não foi possivel cadastrar seu evento");
                return false;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

}
