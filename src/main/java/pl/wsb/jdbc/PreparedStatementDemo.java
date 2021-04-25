package pl.wsb.jdbc;

import java.lang.reflect.InvocationTargetException;
import java.net.ConnectException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class PreparedStatementDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Wpisz imię gracza:");
        String playerName = scanner.nextLine();
        try(Connection con = JdbcConnectionDemo.connection();
            PreparedStatement statement = con.prepareStatement("Select * from players where name like ?")
        ){
            statement.setString(1, playerName);
            final ResultSet set = statement.executeQuery();
            while (set.next()){
                System.out.println(set.getString("name") +" " + set.getInt("points"));
            }
            set.close();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
