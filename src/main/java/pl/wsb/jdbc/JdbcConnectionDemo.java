package pl.wsb.jdbc;

import java.lang.reflect.InvocationTargetException;
import java.sql.*;

public class JdbcConnectionDemo {

    public static Connection connection() throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, SQLException {
        Class.forName("org.hsqldb.jdbc.JDBCDriver").getConstructor().newInstance();
        return DriverManager.getConnection("jdbc:hsqldb:file:/c:/data/base");
    }

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, SQLException {
        final Connection con = connection();
        final Statement statement = con.createStatement();
        statement.execute("drop table if exists players");
        boolean isResultSet = statement.execute("create table if not exists players  (id int primary key, name varchar(20), points int)");
        System.out.println("Cy jest result set? " + isResultSet);
        int insertedRow = statement.executeUpdate("insert into players values(1, 'alan', 123)");
        insertedRow += statement.executeUpdate("insert into players values(2, 'ewa', 156)");
        insertedRow += statement.executeUpdate("insert into players values(3, 'karol', 56), (4, 'adam', 12)");
        int deletedRows = statement.executeUpdate("delete from players where id = 4");
        int updatedRows = statement.executeUpdate("update players set points = 100 where id = 2");
        System.out.println("Wstawionych wierszy: "+ insertedRow);
        System.out.println("Usuniętych wierszy: " + deletedRows);
        System.out.println("Zmodyfikowanych wierszy: " + updatedRows);
        final ResultSet set = statement.executeQuery("select * from players");
        while(set.next()){
            final int id = set.getInt("id");
            String name = set.getString("name");
            int points = set.getInt("points");
            System.out.println(id + " " + name +" " + points);
        }
        //set.beforeFirst();
        con.close();
        statement.close();
        set.close();
    }
}
