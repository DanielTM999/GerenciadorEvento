package Model;

public class Sqlquery {

    public static String SqlInsertComand(String Table, String[] colluns) {
        String aux = "";
        String pste = "";

        for (int i = 0; i < colluns.length; i++) {
            aux += colluns[i] + ",";
            pste += "?,";
        }
        aux = aux.substring(0, aux.length() - 1);
        pste = pste.substring(0, pste.length() - 1);

        String sql = "INSERT INTO " + Table + "(" + aux + ") VALUES (" + pste + ")";

        return sql;
    }

    public static String SqlSearchingItensComand(String Table, String Collun) {
        String sql = "SELECT * FROM " + Table + " WHERE " + Collun + "= ?";

        return sql;
    }

    public static String SqlDeleteComand(String Table, String Collun) {
        String sql = "DELETE FROM " + Table + " WHERE " + Collun + "= ?";

        return sql;
    }

    public static String SqlUpdateComand(String Table, String[] Collun, String condition) {

        String pste = "";

        for (int i = 0; i < Collun.length; i++) {
            pste += Collun[i] + " = ?,";
        }
        pste = pste.substring(0, pste.length() - 1);

        String sql = "UPDATE " + Table + " SET " + pste + " WHERE " + condition + " = ?";

        return sql;
    }

    public static String SqlSearchingAll(String Table) {
        String sql = "SELECT * FROM " + Table;

        return sql;
    }
}
