package com.controller;

import com.model.Customer;
import com.model.Provinces;
import com.service.customerService.ICustomerService;
import com.service.provinceService.IProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import java.util.Optional;

@Controller
@RequestMapping("/pro")
public class ProvincessController {
    @Autowired
    private IProvinceService provinceService;

    @Autowired
    private ICustomerService customerService;

    @GetMapping("/list")
    public ModelAndView showProvinceList() {
        Iterable<Provinces> provinceList = provinceService.findAll();
        ModelAndView modelAndView = new ModelAndView("/province/list");
        modelAndView.addObject("provincess", provinceList);
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("/province/create");
        modelAndView.addObject("provinc", new Provinces());
        return modelAndView;
    }

    @PostMapping("/create")
    public ModelAndView addNewProvince(@ModelAttribute("provin") Provinces provinces, RedirectAttributes redirectAttributes) {
        provinceService.save(provinces);
        ModelAndView modelAndView = new ModelAndView("redirect:/pro/list");
        redirectAttributes.addFlashAttribute("message", "New province created successfully");
        return modelAndView;
    }

    @GetMapping("/edit/{id}")
    public ModelAndView showEditForm(@PathVariable Long id) {
        Optional<Provinces> province = provinceService.findById(id);
        ModelAndView modelAndView = new ModelAndView("/province/edit");
        modelAndView.addObject("provin", province);
        return modelAndView;
    }

    @PostMapping("/edit")
    public ModelAndView updateProvince(@ModelAttribute("province") Provinces provinces,RedirectAttributes redirectAttributes) {
        provinceService.save(provinces);
        ModelAndView modelAndView = new ModelAndView("redirect:/pro/list");
        redirectAttributes.addFlashAttribute("message", "Province updated successfully");
        return modelAndView;
    }

    @GetMapping("/delete/{id}")
    public ModelAndView deleteProvince(@PathVariable Long id,RedirectAttributes redirectAttributes) {
        provinceService.remove(id);
        ModelAndView modelAndView = new ModelAndView("redirect:/pro/list");
        redirectAttributes.addFlashAttribute("message", "Province remove successfully");
        return modelAndView;
    }

    @GetMapping("/view/{id}")
    public ModelAndView viewProvince(@PathVariable("id") Long id){
        Optional<Provinces> provinceOptional = provinceService.findById(id);
        if(!provinceOptional.isPresent()){
            return new ModelAndView("/error.404");
        }

        Iterable<Customer> customers = customerService.findAllByProvince(provinceOptional.get());

        ModelAndView modelAndView = new ModelAndView("/province/view");
        modelAndView.addObject("provinces", provinceOptional.get());
        modelAndView.addObject("customers", customers);
        return modelAndView;
    }
}
