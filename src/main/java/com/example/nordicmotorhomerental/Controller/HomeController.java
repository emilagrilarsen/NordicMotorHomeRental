package com.example.nordicmotorhomerental.Controller;

import com.example.nordicmotorhomerental.Model.*;
import com.example.nordicmotorhomerental.Service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    ContractService contractService;
    @Autowired
    CustomerService customerService;
    @Autowired
    EmployeeService employeeService;
    @Autowired
    MotorHomeService motorHomeService;
    @Autowired
    RepairService repairService;



    //-----------------------------------------------Index site---------------------------------------------------------
    @GetMapping("/")
    public String index() {
        return "/Index/Index";
    }
//----------------------------------------------Contract starter her----------------------------------------------------
//-------------------------------------------Show contract list metode--------------------------------------------------
    @GetMapping("/Contract")
    public String contract(Model model) {
        List<Contract> contractList = contractService.showContractList();
        model.addAttribute("Contracts", contractList);
        return"/Contract/Contract";
    }

//----------------------------------------Create contract GET og POST metode--------------------------------------------
    @GetMapping("/AddContract/{id}")
    public String createContract(@PathVariable("id") int id, Model model) {
        model.addAttribute("motorhome", motorHomeService.findMotorHomeById(id));
        return "/Contract/AddContract";
    }

    // Add customer post metode
    @PostMapping("/AddContract/{motorHomeID}")
    public String createContract(@ModelAttribute Contract contract, @PathVariable("motorHomeID") int id) {
        MotorHome motorHome = motorHomeService.findMotorHomeById(id);
        contractService.createContract(contract.getContractID(), contract, motorHome);

        return "redirect:/Contract";
    }

//-------------------------------------------Delete contract GET metode-------------------------------------------------
    @GetMapping("/deleteContract/{id}")
    public String deleteContract(@PathVariable("id") int id) {
        boolean deleted = contractService.deleteContract(id);
        if (deleted) {
            return "redirect:/Contract";
        } else {
            return "redirect:/Contract";
        }
    }

//-----------------------------------------Edit contract GET og POST metode---------------------------------------------
    @GetMapping("/EditContract/{id}")
    public String editContract(@PathVariable("id") int id, Model model) {
        model.addAttribute("contract", contractService.findContractById(id));
        return "/Contract/EditContract";
    }

    @PostMapping("/EditContract/{motorHomeID}")
    public String editContract(@ModelAttribute Contract contract, @PathVariable("motorHomeID") int id) {
        MotorHome motorHome = motorHomeService.findMotorHomeById(id);
        contractService.editContract(contract.getMotorHomeID(), contract, motorHome);
        return "redirect:/Contract";
    }
//---------------------------------------Cancel contract starter her ---------------------------------------------------

    @GetMapping("/cancelContract/{id}")
    public String cancelContract(@PathVariable("id") int id) {
        Contract contract = contractService.findContractById(id);
        contract.setCancel(true);
        contractService.setCancellationPrice(id, contract);

        return "redirect:/Contract";
    }


//--------------------------------------------Contract slutter her------------------------------------------------------



//-------------------------------------------------Customers site-------------------------------------------------------
//----------------------------------------------Customer list metode----------------------------------------------------
    // Metode der henter alle vores Customer objekter ned på en liste,
    // som vi kan bruge til at displaye vores Customers
    @GetMapping("/Customer")
    public String customer(Model model) {
        List<Customer> customerList = customerService.showCustomerList();
        model.addAttribute("Customers", customerList);
        return"/Customer/Customer";
    }

//--------------------------------------Create customer GET og POST metoder---------------------------------------------
    // Add costumer get metode
    @GetMapping("/AddCustomer")
    public String createCustomer() {
        return "/Customer/AddCustomer";
    }

    // Add customer post metode
    @PostMapping("/AddCustomer")
    public String createCustomer(@ModelAttribute Customer customer) {
        customerService.createCustomer(customer);
        return "redirect:/Customer";
    }

//----------------------------------------------Delete customer metode--------------------------------------------------
    // Delete customer metode
    @GetMapping("/deleteCustomer/{id}")
    public String deleteCustomer(@PathVariable("id") int id) {
        boolean deleted = customerService.deleteCustomer(id);
        if (deleted) {
            return "redirect:/Customer";
        } else {
            return "redirect:/Customer";
        }
    }

//----------------------------------------Update customer GET og POST metoder-------------------------------------------
    // Update customer get metode
    @GetMapping("/EditCustomer/{id}")
    public String editCustomer(@PathVariable("id") int id, Model model) {
        model.addAttribute("customer", customerService.findCustomerById(id));
        return "/Customer/EditCustomer";
    }

    // Update customer post metode
    @PostMapping("/EditCustomer")
    public String editCustomer(@ModelAttribute Customer customer) {
        customerService.editCustomer(customer.getCustomerID(), customer);
        return "redirect:/Customer";
    }

//-----------------------------------------Customer metoder afsluttet---------------------------------------------------



//------------------------------------------Employee metoder starter----------------------------------------------------
//--------------------------------------------Employee list metode------------------------------------------------------
    // Metode der henter alle vores Employee objekter ned på en liste,
    // som vi kan bruge til at displaye vores Employees
    @GetMapping("/Employee")
    public String employee(Model model) {
        List<Employee> employeeList = employeeService.showEmployeeList();
        model.addAttribute("Employees", employeeList);
        return"/Employee/Employee";
    }

//------------------------------------Create GET og POST metode til employee--------------------------------------------
    // Add employee get metode
    @GetMapping("/AddEmployee")
    public String createEmployee() {
        return "/Employee/AddEmployee";
    }

    // Add employee post metode
    @PostMapping("/AddEmployee")
    public String createEmployee(@ModelAttribute Employee employee) {
        employeeService.createEmployee(employee);
        return "redirect:/Employee";
    }

//--------------------------------------------Delete employee metode----------------------------------------------------
    // Delete employee metode
    @GetMapping("/deleteEmployee/{id}")
    public String deleteEmployee(@PathVariable("id") int id) {
        boolean deleted = employeeService.deleteEmployee(id);
        if (deleted) {
            return "redirect:/Employee";
        } else {
            return "redirect:/Employee";
        }
    }

//------------------------------------Update GET og POST metoder til employee-------------------------------------------
    // Update employee get metode
    @GetMapping("/EditEmployee/{id}")
    public String editEmployee(@PathVariable("id") int id, Model model) {
        model.addAttribute("employee", employeeService.findEmployeeById(id));
        return "/Employee/EditEmployee";
    }

    // Update employee post metode
    @PostMapping("/EditEmployee")
    public String editEmployee(@ModelAttribute Employee employee) {
        employeeService.editEmployee(employee.getEmployeeID(), employee);
        return "redirect:/Employee";
    }

//--------------------------------------Slutningen på employees metoder-------------------------------------------------



//---------------------------------------Starten på motor home metoder--------------------------------------------------
//-----------------------------------------Show motor home list metode--------------------------------------------------

// Metode der henter alle vores motor home objekter ned på en liste,
// som vi kan bruge til at displaye vores motor homes
    @GetMapping("/MotorHome")
    public String motorHome(Model model) {
    List<MotorHome> motorHomeList = motorHomeService.showMotorHomeList();
    model.addAttribute("MotorHomes", motorHomeList);
    return "/MotorHomes/MotorHome";
}

//-----------------------------------Create GET og POST metode til motor home-------------------------------------------
    // Add motor home get metode
    @GetMapping("/AddMotorHome")
    public String createMotorHome() {
        return "/MotorHomes/AddMotorHome";
    }

    // Add motor home post metode
    @PostMapping("/AddMotorHome")
    public String createMotorHome(@ModelAttribute MotorHome motorHome) {
        motorHomeService.createMotorHome(motorHome);
        return "redirect:/MotorHome";
    }

//-------------------------------------------Delete motor home metode---------------------------------------------------
    // Delete employee metode
    @GetMapping("/deleteMotorHome/{id}")
    public String deleteMotorHome(@PathVariable("id") int id) {
        boolean deleted = motorHomeService.deleteMotorHome(id);
        if (deleted) {
            return "redirect:/MotorHome";
        } else {
            return "redirect:/MotorHome";
        }
    }

//---------------------------------------Update GET og POST metoder til motor home--------------------------------------
    // Update employee get metode
    @GetMapping("/EditMotorHome/{id}")
    public String editMotorHome(@PathVariable("id") int id, Model model) {
        model.addAttribute("motorhome", motorHomeService.findMotorHomeById(id));
        return "/MotorHomes/EditMotorHome";
    }

    // Update employee post metode
    @PostMapping("/EditMotorHome")
    public String editMotorHome(@ModelAttribute MotorHome motorHome) {
        motorHomeService.editMotorHome(motorHome.getMotorHomeID(), motorHome);
        return "redirect:/MotorHome";
    }

//------------------------------------------Slutningen på motor home metoder--------------------------------------------



//--------------------------------------------------Repair Starter------------------------------------------------------
//---------------------------------------------Show repair list metode--------------------------------------------------
    @GetMapping("/Repair")
    public String repair(Model model) {
        List<MotorHome> motorHomeList = motorHomeService.showMotorHomeList();
        model.addAttribute("MotorHomes", motorHomeList);
        List<Repair> repairList = repairService.showRepairList();
        model.addAttribute("repair", repairList);
        return"/Repair/Repair";
    }

//-----------------------------------------Create repair GET og POST metoder--------------------------------------------
    // Add repair get metode
    @GetMapping("/MakeRepair/{id}")
    public String createRepair(@PathVariable("id") int id, Model model) {
        model.addAttribute("motorhome", motorHomeService.findMotorHomeById(id));
        return "/Repair/MakeRepair";
    }

    // Add repair post metode
    @PostMapping("/MakeRepair/{motorhomeID}")
    public String createRepair(@ModelAttribute Repair repair, @PathVariable("motorhomeID") int id) {

        repairService.createRepair(id, repair);

        /*MotorHome motorHome = motorHomeService.findMotorHomeById(id);
        repairService.addRepairToMotorHome(motorHome.getMotorHomeID());*/
        return "redirect:/Repair";
    }

//--------------------------------------------Delete repair GET metode--------------------------------------------------
    @GetMapping("/deleteRepair/{id}")
    public String deleteRepair(@PathVariable("id") int id) {
        boolean deleted = repairService.deleteRepair(id);
        if (deleted) {
            return "redirect:/Repair";
        } else {
            return "redirect:/Repair";
        }
    }

//---------------------------------------Edit GET og POST metoder til repair--------------------------------------------
    // Edit repair get metode
    @GetMapping("/EditRepair/{id}")
    public String editRepair(@PathVariable("id") int id, Model model) {
        model.addAttribute("Repairs", repairService.findRepairById(id));
        return "/Repair/EditRepair";
    }

    // Update employee post metode
    @PostMapping("/EditRepair/{repairID}")
    public String editRepair(@ModelAttribute Repair repair, @PathVariable("repairID") int id) {
        repairService.editRepair(id, repair);
        return "redirect:/Repair";
    }

//-----------------------------------------------Repair slutter her-----------------------------------------------------
}
