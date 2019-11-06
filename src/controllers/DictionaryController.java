package controllers;

import model.Dictionary;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

@Controller
public class DictionaryController {
    private Connection getConnection(){
        Connection conn = null;
        try{
            conn = DBConnection.initializeDatabase();
        }catch (Exception e){
            e.printStackTrace();
        }
        return conn;
    }
    @GetMapping("")
    public String getIndex(){
        return "index";
    }

    @PostMapping("/translate")
    public String translate(@RequestParam String searchWord, Model model){
        Connection conn = getConnection();
        String result="That word isn't in the current dictonary!!!";
        ArrayList<Dictionary> dictionary = new ArrayList<>();
        try{
            PreparedStatement ps = conn.prepareStatement("select * from tbl_englishToVn");
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                Dictionary newDictionary = new Dictionary();
                newDictionary.setId(rs.getInt(1));
                newDictionary.setEnglishWord(rs.getString(2));
                newDictionary.setVnMeaning(rs.getString(3));
                dictionary.add(newDictionary);
            }
            rs.close();
            ps.close();
            conn.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        for( Dictionary d : dictionary ){
            if(d.getEnglishWord().equalsIgnoreCase(searchWord.trim())){
                result=d.getVnMeaning();
                break;
            }
        }
        model.addAttribute("result",result);
        model.addAttribute("searchWord",searchWord);
        return "index";
    }
}
