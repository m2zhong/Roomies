package com.rip.roomies.sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * This is a SQLQuery helper class which will handle connecting to and exectuing
 * statements from the database.
 */
public class SQLQuery {
    // Connection to the database
    private static Connection conn = null;

    // The connection string to connect to database
    private static final String CONN_STRING = "jdbc:sqlserver://rationallyimpairedprogrammers.database.windows.net:1433;database=cse110_dev;user=roomies_app@rationallyimpairedprogrammers;password=#room1es4lyfe;encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;";

    /**
     * Helper class that initiates the connection to the database, setting the
     * conn object to a non-null value if successful.
     * @return True if the connection was successful, false otherwise
     * @throws SQLException if the database cannot be connected to
     */
    private synchronized static void connect() throws SQLException {
        conn = DriverManager.getConnection(CONN_STRING);
    }

    /**
     * Queries the server by attempting to execute the string passed into the method.
     * If there is any error in either connecting or executing the query, the exception
     * will be thrown to the caller.
     * @param query The sql string to attempt to execute
     * @return The result set of the query
     * @throws SQLException if the database cannot be connected to or statement fails
     */
    public synchronized static ResultSet execute(String query) throws SQLException {
        if (conn == null) {
            connect();
        }

        Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                ResultSet.CONCUR_UPDATABLE);
        return stmt.executeQuery(query);
    }
}
