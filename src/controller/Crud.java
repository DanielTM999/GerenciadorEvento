package controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.JOptionPane;

import Model.Actsql;

public class Crud implements Auht {
    Actsql db = new Actsql();

    @Override
    public boolean auth(String user, String password) {
        if ((user.isBlank() || user.isEmpty()) && (password.isBlank() || password.isEmpty())) {
            return false;
        } else {
            user = user.toLowerCase();
            try {
                ArrayList<String> data = new ArrayList<>();
                data = db.SearchingItens("usuarios", "usuario", user, 4);

                if (data.size() == 0) {
                    return false;
                } else {
                    if (data.get(2).equals(password)) {
                        return true;
                    } else {
                        return false;
                    }
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
                return false;
            }

        }
    }

    @Override
    public boolean insertDB(String Nome, String Senha, String adm) {
        String colluns[] = { "usuario", "senha", "adm" };
        String values[] = { Nome, Senha, adm };
        List<String> data = new ArrayList<>();

        try {
            data = db.SearchingItens("usuarios", "usuario", Nome, 3);

            System.out.println(data);
            if (data.size() == 0) {
                int sql = db.insert("usuarios", colluns, values);
                if (sql == 1) {
                    return true;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return false;
        }

    }

    @Override
    public boolean deleteElement(String Nome) {
        Nome = Nome.toLowerCase();
        try {
            int res = db.DeleteItens("usuarios", "usuario", Nome);

            if (res == 1) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return false;
        }

    }

    @Override
    public boolean isAdm(String Nome) {
        Nome = Nome.toLowerCase();
        try {
            ArrayList<String> data = new ArrayList<>();
            data = db.SearchingItens("usuarios", "usuario", Nome, 4);
            System.out.println(data.get(3));
            if (data.get(3).equals("s")) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return false;
        }
    }

    @Override
    public boolean UpdateUser(String user, String Nome, String senha, String adm) {
        String colluns[] = { "usuario", "senha", "adm" };
        String values[] = { Nome, senha, adm };

        try {
            int data = db.UpdateElemnt("usuarios", colluns, values, "usuario", user);

            if (data == 1) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return false;
        }

    }

    @Override
    public boolean AddEvent(String evento, String tell, String local, String bairro, int[] data) {
        LocalDateTime now = LocalDateTime.now();

        if ((evento.isBlank() || evento.isEmpty()) || (tell.isEmpty() || tell.isBlank()) || (local.isEmpty()
                || local.isBlank()) || (bairro.isEmpty() || bairro.isBlank())) {
            JOptionPane.showMessageDialog(null, "preencha os campos");
            return false;
        }

        if (data[0] < now.getDayOfMonth()) {
            if (data[1] < now.getMonthValue()) {
                if (data[2] <= now.getYear()) {
                    return false;
                }
            } else {
                if (data[2] < now.getYear()) {
                    return false;
                }
            }
        } else {
            if (data[1] < now.getMonthValue()) {
                if (data[2] <= now.getYear()) {
                    return false;
                }
            } else {
                if (data[2] < now.getYear()) {
                    return false;
                }
            }
        }

        try {
            String dataEv = data[0] + "/" + data[1] + "/" + data[2];
            System.out.println(dataEv);
            String[] colluns = { "evento", "tell", "local", "bairro", "data" };
            String[] values = { evento, tell, local, bairro, dataEv };
            int ress = db.insert("eventos", colluns, values);
            System.out.println(ress);

            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return false;
        }
    }

}
