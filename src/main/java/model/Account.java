package model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.sql.Timestamp;

//모든 생성자를 만든다.

/*
*DB에 Slect 한 데이터를 담기 위한 오브젝트
 */
@ToString
@AllArgsConstructor //모든 파라미터가 있는 친구들을 자동으로 생성자로 만들어 주는 lobok 라이브버리중 하나
@Getter
public class Account {
    private int number;
    private String passworld;
    private int balance;

    //java.sql의 TimeSTAMP
    //카멜표기법 사용하기
    private Timestamp createdAt;
}
