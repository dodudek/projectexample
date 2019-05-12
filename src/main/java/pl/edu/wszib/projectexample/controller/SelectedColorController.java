package pl.edu.wszib.projectexample.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.thymeleaf.util.StringUtils;
import pl.edu.wszib.projectexample.dao.SelectedColorDao;
import pl.edu.wszib.projectexample.domain.SelectedColor;

import java.util.Date;

@Controller
public class SelectedColorController {

    @Value("${app.header.select_color}")
    private String title;


    @Autowired
    SelectedColorDao selectedColorDao;

    @GetMapping({"/select","/select/{color}"})
    public String seletColorPage(@PathVariable(required = false) String color, Model model){

        if(!StringUtils.isEmpty(color)){
            selectedColorDao.save(new SelectedColor(color, new Date()));

        }

        String [][] colors = {{"red", "blue","green", "silver"},
                {"black", "yellow","white", "purple"},
                {"aquamarine", "pink","orange", "cyan"},
                {"magenta", "violet","navy", "mint"}};

        model.addAttribute("title", title);
        model.addAttribute("colors", colors);
        return "select";
    }




}
