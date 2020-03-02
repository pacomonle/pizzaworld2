package es.once.Pizza.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;

import es.once.Pizza.repository.IngredienteRepository;
import es.once.Pizza.repository.PizzaRepository;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * PizzaController
 */
@Controller
public class PizzaController {

    @Autowired
    PizzaRepository pzRepo;

    @Autowired
    IngredienteRepository inRepo;

    @GetMapping(value = "/pizzas")
    @ResponseBody
    public ModelAndView listaPizzas(){
        ModelAndView modelAndView = new ModelAndView("lista_pizzas");
        modelAndView.addObject("pizzas", pzRepo.findAll());

        return modelAndView;
    }
    
    @GetMapping("/pizzas/{id}/")
    @ResponseBody
    public ModelAndView unaPizza(@RequestParam("id") Long id){
        ModelAndView modelAndView=new ModelAndView("una_pizza");
        modelAndView.addObject("pizza", pzRepo.findById(id));
        
        return modelAndView;
    }

    /***********
     * 
     *Poblamos en la vista una tabla con los ingredientes disponibles para seleccionar
     */
    /*********
     * 
     * TODO: la idea es hacer una primera página que de de alta la nueva pizza con su nombre
     * y la referencia a su imagen. Una vez validada la nueva pizza nos lllevería a otra página donde
     * añadir sus ingredientes y porúltimo calcular su precio.
     * Esto evitaría tener que hacer el cálculo del precio en el objeto
     * 
     * Habrá que hacer la página de añadir ingredientes con sus controladores y también  falta 
     * el @Post para dar de alta la pizza
     */
    @GetMapping("/pizzas/add")
    @ResponseBody
    public ModelAndView creaPizza(){

        ModelAndView modelAndView = new ModelAndView("crear_pizza");
        modelAndView.addObject("ingredientes", inRepo.findAll());

        return modelAndView;
    }




}