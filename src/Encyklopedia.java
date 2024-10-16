import javax.swing.*;
import java.io.FileReader;
import java.sql.*;
import java.util.ArrayList;
import java.util.Properties;

public class Encyklopedia {
    Connection con;
    String url = "jdbc:mysql://localhost:3306/";
    String dbname = "Wiki";
    String dbuser = "root";
    String dbpassword = "";
    String sql;
    ArrayList<String[]> values;
    public Encyklopedia() {
        try {
            con = null;
            con = DriverManager.getConnection(url + dbname, dbuser, dbpassword);
            System.out.println("Połączenie udane!");
        } catch (Exception e) {
            System.out.println("Połączenie nieudane!");
            System.out.println("Powód: ");
            System.out.println(e);
        }
    }
    public ArrayList<String[]> wyszukajNotatki() {
        sql = "SELECT * from dane";
        values = new ArrayList<String[]>();
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()) {
                String valhaslo = rs.getString("haslo");
                String valzd1 = rs.getString("zd1");
                String valpd1 = rs.getString("podpis1");
                String valzd2 = rs.getString("zd2");
                String valpd2 = rs.getString("podpis2");
                String valtresc = rs.getString("tresc");
                values.add(new String[]{valhaslo, valzd1, valpd1, valzd2, valpd2, valtresc});
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        for (String[] e:
                values) {
            for (String el:
                    e) {
                System.out.print(el+" | ");
            }
            System.out.println();
        }
        return values;
    }
}
