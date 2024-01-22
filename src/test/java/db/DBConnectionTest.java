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
        //given = 파라미터
        //테스트 코드에서는 매개변수를 직접 못적음

        //when = 본 코드 실행
        Connection conn = DBConnection.getInstance();

        //then = 눈 검증
        if (conn == null){
            System.out.println("실패");
        }else{
            System.out.println("성공");
        }

    }
}
