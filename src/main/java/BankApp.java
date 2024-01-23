import controller.BankController;
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
        String url = "/insert";

        BankDAO dao = new BankDAO();
        //누구도 만들 책임이 없는 것은 메인에서 만든다.
        BankController con = new BankController(dao);

        Dispatcher dis = new Dispatcher(con);
        dis.route(url);
    }
}

