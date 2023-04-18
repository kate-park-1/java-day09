package mysqlex;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DB1demo {
  public static void main(String[] args) {
    String url = "jdbc:mysql://localhost:3306/madang?serverTimezone=Asia/Seoul&useSSL=false&allowPublicKeyRetrieval=true";
    Connection conn = null;

    try {
      System.out.println("데이터베이스 연결중...");
      conn = DriverManager.getConnection(url,"root", "1111");
      System.out.println("데이터베이스 연결 성공!");
    } catch (SQLException e) {
      System.out.println("데이터베이스 연결 실패!");
      System.out.println(e.getMessage());
    } finally {
      if (conn!= null) {
        try {
          conn.close();
        } catch (SQLException e) {
          e.printStackTrace();
        }
      }
    }
  }
}
