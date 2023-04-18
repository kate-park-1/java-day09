package mysqlex;

import java.sql.*;

// book 의 price 이 null 인 레코드의 가격을 12000 으로 수정하기
public class DB4demo {
  public static void main(String[] args) {
    Connection conn = makeConnection();
    //Statement stmt = null;
    PreparedStatement ps = null;

    try {
      ps = conn.prepareStatement("update book set price = ? where price is null ");
      ps.setInt(1,12000);
      int i = ps.executeUpdate();
      if (i > 0){
        System.out.println(i +"건이 수정되었습니다.");
      } else {
        System.out.println("데이터 수정 실패 !");
      }
    } catch (SQLException e) {
      System.out.println(e.getMessage());
    }
  }

  public static Connection makeConnection() {
    String url = "jdbc:mysql://localhost:3306/madang?serverTimezone=Asia/Seoul&useSSL=false&allowPublicKeyRetrieval=true";
    Connection conn = null;

    try {
      System.out.println("데이터베이스 연결중...");
      conn = DriverManager.getConnection(url,"root", "1111");
      System.out.println("데이터베이스 연결 성공!");
    } catch (SQLException e) {
      System.out.println("데이터베이스 연결 실패!");
      System.out.println(e.getMessage());
    }
    return conn;
  }
}
