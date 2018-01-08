package daos;


import beans.LoginBean;
import java.io.Serializable;
import java.sql.Connection;
import javax.faces.context.FacesContext;
import java.sql.DriverManager;
import javax.naming.InitialContext;
import javax.sql.DataSource;


public class ConnectionDao implements Serializable {
    private DataSource dataSource;
    private String oracleUrl;
    private String databaseUsername;
    private String databasePassword;
    private final String oracleDriver;    
    private final boolean useConnectionPool = false;

    private final LoginBean loginBean;
    
    public ConnectionDao() {
        oracleDriver = "oracle.jdbc.driver.OracleDriver";

        if (!useConnectionPool) {
            //oracleUrl = "jdbc:oracle:thin:@52.232.34.123:1521:CE471DB";
            oracleUrl = "jdbc:oracle:thin:@localhost:1521:XE";
            databaseUsername = "Housing";
            databasePassword = "sys";
        }

        FacesContext context = FacesContext.getCurrentInstance();
        loginBean = (LoginBean) context.getELContext().getELResolver().getValue(
                                         context.getELContext(), null, "loginBean");
    }

    public Connection getConnection() throws Exception {
        Connection connection = null;

        if (loginBean != null) {
            connection = loginBean.getConnection();

            if (connection == null || connection.isClosed()) {
                connection = openSessionConnection();
                loginBean.setConnection(connection);                
            }
        }
        
        

        return connection;
    }

    public void closeConnection() throws Exception {
        if (loginBean != null) {
            Connection connection = loginBean.getConnection();

            if (connection != null) {
                connection.close();
                loginBean.setConnection(null);
            }
        }
    }

    private Connection openSessionConnection() throws Exception {
        Connection connection = null;

        if (loginBean != null) {
            if (useConnectionPool) {
                dataSource = (DataSource) new InitialContext().lookup("jdbc/Housing");
                connection = dataSource.getConnection();
            } else {
                Class.forName(oracleDriver).newInstance();
                connection = DriverManager.getConnection(oracleUrl,databaseUsername,databasePassword);
            }
        }

        return connection;
    }   
}
