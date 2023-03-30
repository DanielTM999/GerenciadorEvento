package Model;

import java.sql.*;
import java.util.ArrayList;

public class Actsql {
    private PreparedStatement pste = null;
    private ResultSet ress = null;
    private Conexao database = new Conexao.ConexaoBuilder()
            .host("localhost")
            .user("root")
            .senha("")
            .database("poo")
            .builder();

    private Connection Conexao = database.conexao();

    public int insert(String Table, String[] colluns, String[] values) {
        String sql = Sqlquery.SqlInsertComand(Table, colluns);

        try {
            pste = Conexao.prepareStatement(sql);
            for (int i = 0; i < values.length; i++) {
                pste.setString(i + 1, values[i]);
            }
            return pste.executeUpdate();
        } catch (Exception err) {
            System.out.println(err.getMessage());
            return -1;
        }

    }

    public ArrayList<String> SearchingItens(String Table, String collun, String condition, int numColl) {
        String sql = Sqlquery.SqlSearchingItensComand(Table, collun);

        try {
            ArrayList<String> dados = new ArrayList<>();

            pste = Conexao.prepareStatement(sql);

            pste.setString(1, condition);

            ress = pste.executeQuery();

            if (ress.next()) {
                for (int i = 1; i <= numColl; i++) {
                    dados.add(ress.getString(i));
                }
            }

            return dados;
        } catch (Exception err) {
            System.out.println(err.getMessage());
            return null;
        }
    }

    public int DeleteItens(String Table, String colluns, String Nome) {
        String sql = Sqlquery.SqlDeleteComand(Table, colluns);

        try {
            pste = Conexao.prepareStatement(sql);
            pste.setString(1, Nome);
            return pste.executeUpdate();
        } catch (Exception err) {
            System.out.println(err.getMessage());
            return -1;
        }
    }

    public int UpdateElemnt(String Table, String[] collun, String[] values, String condition, String user) {
        String sql = Sqlquery.SqlUpdateComand(Table, collun, condition);

        try {
            pste = Conexao.prepareStatement(sql);
            for (int i = 0; i < values.length; i++) {
                System.out.println(values[i]);
                pste.setString(i + 1, values[i]);
            }

            pste.setString(values.length + 1, user);

            return pste.executeUpdate();

        } catch (Exception err) {
            System.out.println(err.getMessage());
            return -1;
        }
    }

    public void SearchingAll() {
        String sql = Sqlquery.SqlSearchingAll("eventos");
        try {
            ArrayList<String> dados = new ArrayList<>();
            pste = Conexao.prepareStatement(sql);
            ress = pste.executeQuery();

            while (ress.next()) {
                dados.add(ress.getString("evento"));
            }

            System.out.println(dados);

        } catch (Exception e) {
            System.out.println(e.getMessage());
            // return null;
        }

    }
}
