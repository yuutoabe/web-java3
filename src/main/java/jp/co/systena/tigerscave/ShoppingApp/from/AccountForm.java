package jp.co.systena.tigerscave.ShoppingApp.from;

import lombok.Data;

import java.io.Serializable;

@Data
public class AccountForm implements Serializable {
    private String userName;
    private  String password;
}
