/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Java1.Erwinsyah.Arya;

import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Ryo
 */

@Controller
public class Controllerbuah {
    @RequestMapping("/inputan")
    
    public String userInput(HttpServletRequest data, Model Buah){
        String nBuah = data.getParameter("var_namaBuah");
        String hBuah = data.getParameter("var_hargaperkilo");
        Integer chBuah = Integer.valueOf(hBuah);
        String jBuah = data.getParameter("var_jumlahbeli");
        Double cjBuah = Double.valueOf(jBuah);
        Double jumlahbayar = chBuah * cjBuah;
        Double total = null;
        Integer diskon = 0;
        Double hargadiskon = 0.0;
        
        if(jumlahbayar < 16000){
            total = jumlahbayar - (jumlahbayar*diskon/100);
            hargadiskon = jumlahbayar*diskon/100;
        }else if(jumlahbayar < 25000){
            diskon = 10;
            total = jumlahbayar - (jumlahbayar*diskon/100);
            hargadiskon = jumlahbayar*diskon/100; 
        }else{
            diskon = 15;
            total = jumlahbayar - (jumlahbayar*diskon/100);
            hargadiskon = jumlahbayar*diskon/100;
        }
        Buah.addAttribute("nama",nBuah);
        Buah.addAttribute("harga",chBuah);
        Buah.addAttribute("perkilo",cjBuah);
        Buah.addAttribute("totalbayar", total);
        Buah.addAttribute("diskon", hargadiskon);
        Buah.addAttribute("disc", diskon);
        Buah.addAttribute("total", jumlahbayar);
        return "Erwinsyah";
    }
}
