package com.tsapliya.customerbase.controllers;

import com.tsapliya.customerbase.model.Customer;
import com.tsapliya.customerbase.dao.CustomerDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@Controller
public class CustomerController {
    private final CustomerDao dao;

    @Autowired
    public CustomerController(final CustomerDao dao) {
        this.dao = dao;
    }

    /*It displays a form to input data, here "command" is a reserved request attribute
     *which is used to display object data into form
     */
    @RequestMapping("/customerForm")
    public String showform(Model m) {
        m.addAttribute("command", new Customer());
        return "customerForm";
    }

    /*It saves object into database. The @ModelAttribute puts request data
     *  into model object. You need to mention RequestMethod.POST method
     *  because default request is GET*/
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(@ModelAttribute("emp") Customer customer) {
        dao.create(customer);
        return "redirect:/viewCustomer";//will redirect to viewemp request mapping
    }

    /* It provides list of employees in model object */
    @RequestMapping("/viewCustomer")
    public RedirectView viewemp(Model m) {
        List<Customer> list = dao.getEmployees();
        m.addAttribute("list", list);
        return new RedirectView("viewCustomer");
    }

    /* It displays object data into form for the given id.
     * The @PathVariable puts URL data into variable.*/
    @RequestMapping(value = "/editCustomer/{id}")
    public String edit(@PathVariable int id, Model m) {
        Customer customer = dao.getEmpById(id);
        m.addAttribute("command", customer);
        return "customerEditForm";
    }

    /* It updates model object. */
    @RequestMapping(value = "/editsave", method = RequestMethod.POST)
    public String editSave(@ModelAttribute("emp") Customer customer) {
        dao.update(customer);
        return "redirect:/viewCustomer";
    }

    /* It deletes record for the given id in URL and redirects to /viewemp */
    @RequestMapping(value = "/deleteCustomer/{id}", method = RequestMethod.GET)
    public String delete(@PathVariable int id) {
        dao.delete(id);
        return "redirect:/viewCustomer";
    }
}  