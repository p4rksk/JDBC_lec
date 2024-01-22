package dao;

import db.DBConnection;
import model.Account;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * DAO -Data Access Object
 * SRP - 단일 책임의 원칙
 */

public class BankDAO {
    public int deleteByNumber(int number) {
        Connection conn = DBConnection.getInstance();
        try {
            String sql = "delete from account_tb where number = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);//라이브러리 버퍼 사용 즉 버퍼 달기

            // parameterIndex는 쿼리마다에 물음표 순서
            // 응답 결과 요쳥 받은 행 이 결과로 온다.
            pstmt.setInt(1, number);

            int num = pstmt.executeUpdate();//플러쉬 역할을 가지고 있음
            return num;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }

    public int insert(String password, int balnace) {
        Connection conn = DBConnection.getInstance();
        try {
            String sql = "insert into account_tb(password, balance, created_at) values(?,?,now())";
            PreparedStatement pstmt = conn.prepareStatement(sql);//라이브러리 버퍼 사용 즉 버퍼 달기

            // parameterIndex는 쿼리마다에 물음표 순서
            // 응답 결과 요쳥 받은 행 이 결과로 온다.
            pstmt.setString(1, password);
            pstmt.setInt(2, balnace);

            int num = pstmt.executeUpdate();//플러쉬 역할을 가지고 있음
            return num;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }


    public int updateByNumber(int balance, int number) {
        Connection conn = DBConnection.getInstance();
        try {
            String sql = "update account_tb set balance = ? where number = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);//라이브러리 버퍼 사용 즉 버퍼 달기

            // parameterIndex는 쿼리마다에 물음표 순서
            // 응답 결과 요쳥 받은 행 이 결과로 온다.
            pstmt.setInt(1, balance);
            pstmt.setInt(2, number);

            int num = pstmt.executeUpdate();//플러쉬 역할을 가지고 있음
            return num;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }

    public Account selectByNumber(int number) {
        Connection conn = DBConnection.getInstance();
        try {
            String sql = "select * from account_tb where number = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, number);

            //select 결과는 테이블로 받게 설정
            ResultSet rs = pstmt.executeQuery(); //rs = 테이블형테에 데이터

            boolean isRow = rs.next(); //커서 한칸 내리기


            //출력하고 싶은 칼럼만 골라 출력하기
            //박스 만들기
            if (rs.next()){
                Account account = new Account(
                        rs.getInt("number"),
                        rs.getString("password"),
                        rs.getInt("balance"),
                        rs.getTimestamp("created_at")
                );
                return account;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    //전체 조회 할 때  내림차순으로 조회
    public List<Account> selectAll(){
        Connection conn = DBConnection.getInstance();
        try {
            String sql = "select * from account_tb order by number desc";//order by number desc 내림차순으로 변경
            PreparedStatement pstmt = conn.prepareStatement(sql);


            //select 결과는 테이블로 받게 설정
            ResultSet rs = pstmt.executeQuery(); //rs = 테이블형테에 데이터



            //출력하고 싶은 칼럼만 골라 출력하기
            //박스 만들기
            List<Account> accountList = new ArrayList<>();
            while (rs.next()){
                Account account = new Account(
                        rs.getInt("number"),
                        rs.getString("password"),
                        rs.getInt("balance"),
                        rs.getTimestamp("created_at")

                );
                accountList.add(account);
            }
            return accountList;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    }

