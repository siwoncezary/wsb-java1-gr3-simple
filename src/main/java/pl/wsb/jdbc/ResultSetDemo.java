package pl.wsb.jdbc;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ResultSetDemo {
    public static void main(String[] args) {
        try(Connection con = JdbcConnectionDemo.connection();
            Statement statement = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
        ){
            ResultSet set = statement.executeQuery("select * from players");
            int id = 2;
            //modyfikacja liczby punktów gracza o id = 2
            while(set.next()){
                System.out.println("Przed zmianą :" + set.getString("name") +" " + set.getInt("points"));
                if (set.getInt("id") == 2){
                    final int prevPoints = set.getInt("points");
                    set.updateInt("points", prevPoints + 50);
                    set.updateRow();
                }
            }
            set.beforeFirst();
            while(set.next()){
                System.out.println("Pozmianie zmianą :" + set.getString("name") +" " + set.getInt("points"));
            }

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
