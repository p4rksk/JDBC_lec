package db;

import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnectionTest {


    // 리턴타입을 적을 수 없다.
    // 매개변수를 적을 수 없다.
    // @Test 붙이면 메서드 별로 실행가능
    @Test
    public void getInstance_Test(){
        String username = "root";
        String password = "1234";
        String url = "jdbc:mariadb://localhost:3306/cosdb"; //프로토콜//ip주소:포트번호/테이블 명

        // 프로토콜이 적용된 소켓
        try {
            Connection conn = DriverManager.getConnection(url, username, password);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
