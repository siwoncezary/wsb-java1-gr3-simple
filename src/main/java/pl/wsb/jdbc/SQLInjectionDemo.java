package pl.wsb.jdbc;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class SQLInjectionDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Wpisz imię szukanego gracza: ");
        String playerName = scanner.nextLine();
        try (Connection con = JdbcConnectionDemo.connection();
             Statement statement = con.createStatement();
        ){
            final ResultSet set = statement.executeQuery("select * from players where name = " + playerName);
            while(set.next()){
                System.out.println(set.getString("name") + " " + set.getInt("points"));
            }
            set.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
