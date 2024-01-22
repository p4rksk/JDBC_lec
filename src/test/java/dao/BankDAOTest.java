package dao;

import model.Account;
import org.junit.jupiter.api.Test;

import java.sql.SQLOutput;
import java.util.List;

/**
 * DAO -Data Access Object
 * SRP - 단일 책임의 원칙
 */

public class BankDAOTest {

    @Test
    public void slecetAll_test(){
       //given

       //when
       BankDAO dao = new BankDAO();
       List<Account> accountList = dao.selectAll();

        System.out.println(accountList.size());
        System.out.println(accountList);

       //then
    }
    @Test
    public void selectByNumber_test(){
    int number = 2;

        BankDAO dao = new BankDAO();
        Account account = dao.selectByNumber(number);

        if (account == null){
            System.out.println(number+"로 조회된 값이 없습니다");
        }else{
            System.out.println(account);
  //          System.out.println(account.getNumber());
  //          System.out.println(account.getPassworld());
  //          System.out.println(account.getBalance());
  //          System.out.println(account.getCreatedAt());
        }
    }

@Test
    public void deleteByNumber_test(){
        //given
        String password = "1111";
        int balance = 1234;

        //when
        BankDAO dao = new BankDAO();
        int result = dao.deleteByNumber(1);

        //then
        if (result == 1){
            System.out.println("삭제 성공");
        } else if (result == 0) {
            System.out.println("번호를 찾을 수 없습니다");
        }else{
            System.out.println("삭제 실패");
        }
}
}
