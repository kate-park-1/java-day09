package mysqlex;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

// usertbl의 birthyear가 1990 인 자료 삭제
public class DB5demo {
  public static void main(String[] args) {
    Connection conn = makeConnection();
    //Statement stmt = null;
    PreparedStatement ps = null;

    try {
      ps = conn.prepareStatement("delete from usertbl where birthyear = ? ");
      ps.setInt(1,1990);
      int i = ps.executeUpdate();
      if (i > 0){
        System.out.println(i +"건이 삭제되었습니다.");
      } else {
        System.out.println("데이터 삭제 실패 !");
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
