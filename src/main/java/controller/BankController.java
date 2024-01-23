package controller;

import dao.BankDAO;
import lombok.AllArgsConstructor;

/**
 *  책임 : 유효성 검사(바디 데이터), 파싱(바디데이터), 적절한 DAO 찾기
 */

public class BankController {
    private BankDAO dao;

    public BankController(BankDAO dao) {
        this.dao = dao;
    }

    @RequstMapping(uri = "/insert")
    public void insert(){
        //1. 파싱

        //2. 유효성 검사

        //3.dao 찾기
        System.out.println("controller : insert");
        dao.insert("1234",1000);
    }

    @RequstMapping(uri = "/delete")
    public void delete(){
        System.out.println("controller : delte");
        dao.deleteByNumber(2);
    }

    @RequstMapping(uri = "/update")
    public void update(){
        System.out.println("controller : update");
        dao.updateByNumber(1000,1);
    }

    @RequstMapping(uri = "/selectOne")
    public void selectOne(){
        System.out.println("controller : selectOne");
        dao.selectByNumber(1);
    }

    @RequstMapping(uri = "selectAll")
    public void selectAll(){
        System.out.println("controller : selectAll");
        dao.selectAll();
    }
}
