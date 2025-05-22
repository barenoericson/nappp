package config;

import java.sql.*;

public class connectDB {
    private Connection connect;

    // Constructor to connect to the database
    public connectDB() {
        try {
            connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/fft", "root", "");
            System.out.println("Connected to the database successfully!");
        } catch (SQLException ex) {
            System.err.println("Can't connect to database: " + ex.getMessage());
        }
    }

    public Connection getConnection() {
        return connect;
    }

    // Secure data insertion
    public int insertData(String sql, Object... params) {
        int result = 0;
        try (PreparedStatement pst = connect.prepareStatement(sql)) {
            for (int i = 0; i < params.length; i++) {
                pst.setObject(i + 1, params[i]);
            }
            result = pst.executeUpdate();
            System.out.println("Inserted successfully!");
        } catch (SQLException ex) {
            System.err.println("Insert Error: " + ex.getMessage());
            ex.printStackTrace();
        }
        return result;
    }

    // General data retrieval (no parameters)
    public ResultSet getData(String sql) throws SQLException {
        Statement stmt = connect.createStatement();
        return stmt.executeQuery(sql);
    }

    // Secure data retrieval (with parameters)
    public ResultSet getData(String sql, Object... params) throws SQLException {
        PreparedStatement pstmt = connect.prepareStatement(sql);
        for (int i = 0; i < params.length; i++) {
            pstmt.setObject(i + 1, params[i]);
        }
        return pstmt.executeQuery();
    }

    // Check if a value exists
    public boolean fieldExists(String tableName, String columnName, String value) {
        String sql = "SELECT 1 FROM " + tableName + " WHERE " + columnName + " = ? LIMIT 1";
        try (PreparedStatement pstmt = connect.prepareStatement(sql)) {
            pstmt.setString(1, value);
            try (ResultSet result = pstmt.executeQuery()) {
                return result.next();
            }
        } catch (SQLException e) {
            System.err.println("Database Error: " + e.getMessage());
            e.printStackTrace();
        }
        return false;
    }

    // Login validation (You might want to use hashed passwords here)
    public String validateLogin(String username, String password) {
        String query = "SELECT usertype FROM users WHERE username = ? AND password = ?";
        try (PreparedStatement stmt = connect.prepareStatement(query)) {
            stmt.setString(1, username);
            stmt.setString(2, password);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getString("usertype");
                }
            }
        } catch (SQLException ex) {
            System.err.println("Login validation error: " + ex.getMessage());
            ex.printStackTrace();
        }
        return null;
    }

    // Secure data update
    public int updateData(String sql, Object... params) {
        int rowsUpdated = 0;
        try (PreparedStatement pst = connect.prepareStatement(sql)) {
            for (int i = 0; i < params.length; i++) {
                pst.setObject(i + 1, params[i]);
            }
            rowsUpdated = pst.executeUpdate();
        } catch (SQLException ex) {
            System.err.println("Update Error: " + ex.getMessage());
            ex.printStackTrace();
        }
        return rowsUpdated;
    }

    // Check for duplicates, excluding current row (by ID)
    public boolean duplicateCheckExcludingCurrent(String tableName, String columnName, String value, String idColumn, String currentId) {
        String sql = "SELECT 1 FROM " + tableName + " WHERE " + columnName + " = ? AND " + idColumn + " != ? LIMIT 1";
        try (PreparedStatement pstmt = connect.prepareStatement(sql)) {
            pstmt.setString(1, value);
            pstmt.setString(2, currentId);
            try (ResultSet result = pstmt.executeQuery()) {
                return result.next();
            }
        } catch (SQLException e) {
            System.err.println("Duplicate check error: " + e.getMessage());
            e.printStackTrace();
        }
        return false;
    }

    // Close connection
    public void closeConnection() {
        try {
            if (connect != null && !connect.isClosed()) {
                connect.close();
                System.out.println("Database connection closed.");
            }
        } catch (SQLException ex) {
            System.err.println("Error closing connection: " + ex.getMessage());
        }
    }
}
