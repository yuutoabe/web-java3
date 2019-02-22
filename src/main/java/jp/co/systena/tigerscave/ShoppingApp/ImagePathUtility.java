package jp.co.systena.tigerscave.ShoppingApp;

import lombok.extern.slf4j.Slf4j;
import lombok.val;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class ImagePathUtility {
    public static String getCardImagePath(Card card){
        val builder = new StringBuilder();
        builder.append("card_")
                .append(card.getSuit().toString().toLowerCase())
                .append("_")
                .append(String.format("%02d",card.getNumber()))
                .append(".png");
        log.info(builder.toString());
        return builder.toString();
    }

    public static List<String> getCardImagePathList(List<Card> list){
        val result = new ArrayList<String >();
        for (val card : list){
            result.add(getCardImagePath(card));
        }
        return result;
    }
}
