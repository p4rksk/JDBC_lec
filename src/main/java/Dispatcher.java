import controller.BankController;
import controller.RequstMapping;

import java.lang.reflect.Method;

/**
 * 책임 : 라우팅
 */
public class Dispatcher {

    private BankController con;

    public Dispatcher(BankController con) {
        this.con = con;
    }

    public void route(String path){
        Method[] methods = con.getClass().getDeclaredMethods(); //get 가져오다. //리플랙션 장착
        //System.out.println(methods.length);

        for (Method method : methods){
            //System.out.println(method.getName());
            RequstMapping rm = method.getDeclaredAnnotation(RequstMapping.class); // getDeclared Annotation은 method에 어노테이션이 몇개 있는지 분석

            if (rm == null) {
                continue;
            }


            if (rm.uri().equals(path)){
                //System.out.println("걸림?");
                try {
                    method.invoke(con); //con.login();
                    break;
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

    }
}

