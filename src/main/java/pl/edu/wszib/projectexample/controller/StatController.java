package pl.edu.wszib.projectexample.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.edu.wszib.projectexample.dao.SelectedColorDao;
import pl.edu.wszib.projectexample.domain.SelectedColor;
import pl.edu.wszib.projectexample.helper.ColorHelper;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
public class StatController {

    @Value("${app.header.stat}")
    private String title;


    @Autowired
    SelectedColorDao selectedColorDao;

    @GetMapping("/stat")
    public String statColorPage(Model model){

        Iterable<SelectedColor> selectedColors = selectedColorDao.findAll();
        Collection<SelectedColor> selectedColorCollection = (Collection<SelectedColor>) selectedColors;

        Map<String, Long> dataMap = selectedColorCollection.stream()
        .collect(Collectors.groupingBy(SelectedColor::getColor, Collectors.counting()));

        List<String> labels = ColorHelper.converColors(dataMap.keySet());


        model.addAttribute("title", title);
        model.addAttribute("dataMap",dataMap );
        model.addAttribute("labels",labels );



        return "stat";


    }
}
