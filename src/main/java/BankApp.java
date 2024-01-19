import db.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BankApp {
    public static void main(String[] args) {
        Connection conn = DBConnection.getInstance();
        try {
            String insert = "insert into account_tb(password, balance, created_at) values(?,?,now())";
            String delete = "delete from account_tb where number = ?";
            String update = "update account_tb set balance = balance + ? where number = ?";
            PreparedStatement pstmt = conn.prepareStatement(delete);//라이브러리 버퍼 사용 즉 버퍼 달기

            // parameterIndex는 쿼리마다에 물음표 순서
            pstmt.setInt(1,3);

            int num = pstmt.executeUpdate();//플러쉬 역할을 가지고 있음
            System.out.println(num);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
