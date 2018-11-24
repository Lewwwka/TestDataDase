import java.sql.*;

public class DBTest {
    //Для примера данные конфигурации вынесены здесь. В рабочих проектах данные конфигурации выносятся в отдельный файл.
    private final String url = "jdbc:sqlserver://";
    private final String serverName= "localhost";
    private final String portNumber = "1433";
    private final String databaseName= "FirstBD";
//    private final String userName = "";
//    private final String password = "";
    //Пример заполнения конфигурации подключения. Можно заполнять страндартными методами Java JDBC
    private String connectionUrl = url + serverName + ":" + portNumber + ";databaseName=" + databaseName + ";integratedSecurity=true" ;

//    Пример работы Select
   public void select() {
       Connection con = null;
        try {
            //Указываем название драйвера, если требуется
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            //Выполняем подключение
            con = DriverManager.getConnection(connectionUrl); //,userName,password

            //Выполняем наш SQL запрос
            String sqlSelect = "SELECT * FROM [FirstBD].[dbo].[TestTable]";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sqlSelect);

            //Обрабатываем полученные данные от БД
            while (rs.next()) {
                System.out.println(rs.getString("Name"));
            }

            rs.close();
            stmt.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
   }

    //Пример работы Insert
//    public void insert() {
//        Connection conn = null;
//        try {
//            //Указываем название драйвера, если требуется
//            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
//            //Выполняем подключение
//            conn = DriverManager.getConnection(connectionUrl);
//
//
////            Server[@Name='ALEX-PC']/Database[@Name='БазаLewka']/Table[@Name='Users' and @Schema='dbo']
//
////            INSERT INTO <table_name> (<col_name1>, <col_name2>, <col_name3>, …) VALUES (<value1>, <value2>, <value3>, …)
//
//            //Выполняем наш SQL запрос на вставку
//            String sql = "INSERT INTO [БазаLewka].[dbo].[Users](name) VALUES (?)";
//            PreparedStatement stat = conn.prepareStatement(sql);
//            stat.setString(1, "java");
//            stat.executeUpdate();
//
//            conn.close();
//            stat.close();
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            try {
//                conn.close();
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//        }
//    }
}