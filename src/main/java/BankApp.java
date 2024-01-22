import dao.BankDAO;
import db.DBConnection;
import model.Account;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class BankApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //정렬 설정하기

        //라우터

        //URL 설계(http 프로토콜)
        //http://bank.com/account GET(select, 계좌 전체 조회)  //http에서 get은 정보를 달라고 요청하는거다.
        //http://bank.com/account/10 GET(select, 계좌 부분조회)
        //http://bank.com/account POST(insert, 계좌 생성) // 자원 정보를 줄때 쓴다.
        //http://bank.com/account/1 DELETE (계좌 삭제)//
        //http://bank.com/account/1 PUT(update, 계좌 수정)

        // /account
        // /account/1
        // /account
        // /account/1
        // /account/1

        System.out.println("메서드를 입력하세요");
        String method = sc.nextLine();

        System.out.println("식별자를 입력하세요");
        String action = sc.nextLine();

        String body = "";

        BankDAO bankDAO = new BankDAO();
        if (method.equals("GET")){
            if (action.equals("/account")){
              List<Account> accountList = bankDAO.selectAll();
                System.out.println(accountList);
            } else if (action.equals("/account/1")) {
                Account account = bankDAO.selectByNumber(1);
                System.out.println(account);
            }

        } else if (method.equals("POST")) {
            System.out.println("body 데이터를 입력하세요");
            body = sc.nextLine();

            //password=1234&balance=1000 // 마임타입:x-www-from-urlencoded
            String[] st1 = body.split("&");
            String password = st1[0].split("=")[1];
            int balance = Integer.parseInt(st1[1].split("=")[1]);


            if (action.equals("/account")){
                bankDAO.insert(password,balance);
            }

        } else if (method.equals("PUT")) {

            System.out.println("바디 데이터를 입력하세요");
            body = sc.nextLine();

            //(4)password=1234&balance=1000 //before
            String[]st1 = body.split("&");
            String password = st1[0].split()
            //(4)password=1234&balance=5000 //after


            if(action.equals("/account4")){
                bankDAO.updateByNumber(5000,4);
            }

        } else if (method.equals("DELTE")) {

        }
    }
    }

