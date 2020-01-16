package com.example.findchavrusa;
import android.annotation.SuppressLint;
import android.os.Build;
import android.os.StrictMode;
import android.util.Log;

import androidx.annotation.RequiresApi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseConnection {

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)

    // Change below settings as per your database ip and credentials
            String ip = "localhost"; // if you have to add port then it would be like .i.e. 182.50.133.109:1433
    String db = "AndroidProj"; //Name of Database


    // String un = "saadmin"; //Database user
    // String password = "123456789"; //Database Password

    @SuppressLint("NewApi")
    public Connection CONN() {
        // StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder()
        //   .permitAll().build();
        // StrictMode.setThreadPolicy(policy);

        Connection conn = null;
        String ConnURL;
        try {
            Class.forName("net.sourceforge.jtds.jdbc.Driver");
            ConnURL = "jdbc:jtds:sqlserver://" + ip + ";integratedSecurity=true;" + "databaseName=" + db + ";";
            conn = DriverManager.getConnection(ConnURL);
        } catch (SQLException se) {
            System.out.println(se.getMessage());
            Log.e("ERRO", se.getMessage());
        } catch (ClassNotFoundException e) {
            Log.e("ERRO", e.getMessage());
            System.out.println(e.getMessage());
        } catch (Exception e) {
            Log.e("ERRO", e.getMessage());
            System.out.println(e.getMessage());
        }

        return conn;
    }

    public void testConnect() {


        Connection conn = this.CONN(); //Connection Object
        if (conn == null) {
            System.out.println("failed");
        } else {
            // Change below query according to your own database.
            String query = "EXEC dbo.test";
            try {
                Statement stmt = conn.createStatement();
                stmt.executeQuery(query);
            } catch (SQLException e) {
                e.printStackTrace();
            }


        }
    }
}









