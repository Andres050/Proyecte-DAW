package cat.iesmanacor.backend_private.controller;

import cat.iesmanacor.backend_private.entities.Localidad;
import cat.iesmanacor.backend_private.entities.Restaurant;
import cat.iesmanacor.backend_private.entities.Useracount;
import cat.iesmanacor.backend_private.services.*;
import org.apache.catalina.User;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class HomeController {

    @Autowired
    RestaurantService restaurantService;

    @Autowired
    UseracountService useracountService;

    @Autowired
    LocalidadService localidadService;

    @Autowired
    ImgService imgService;

    @GetMapping("/home")
    public String getHome(ModelMap model){
        model.addAttribute("restaurantes",restaurantService.findAllRestaurants());
        return "principalPage";
    }

    // ADMIN SECTION DATATABLE RESTAURANTES
    @GetMapping("/restaurante/admin")
    public String adminRestaurantes(ModelMap model){
        return "formularios/restaurante";
    }

    @GetMapping("/configuration/cards")
    public String getCards(){
        return "cards";
    }
}
