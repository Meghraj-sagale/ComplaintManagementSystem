package in.sp.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import in.sp.main.entity.Complaint;
import in.sp.main.service.ComplaintService;

@Controller
public class ComplaintController {

    @Autowired
    private ComplaintService service;

    // View complaints (with optional filter)
    @GetMapping("/view")
    public String viewPage(@RequestParam(value = "status", required = false) String status,
                           Model m) {

        if (status != null && !status.isEmpty()) {
            m.addAttribute("list", service.getByStatus(status));
        } else {
            m.addAttribute("list", service.getAll());
        }

        return "index";
    }

    // Show add form
    @GetMapping("/addForm")
    public String addForm() {
        return "add";
    }

    // Save (ADD + UPDATE)
    @PostMapping("/save")
    public String saveComplaint(@ModelAttribute Complaint c, RedirectAttributes ra) {

        try {
            if (c.getStatus() == null || c.getStatus().isEmpty()) {
                c.setStatus("Pending");
            }

            boolean isUpdate = (c.getId() != null);

            service.save(c);

            if (isUpdate) {
                ra.addFlashAttribute("msg", "Complaint updated successfully!");
            } else {
                ra.addFlashAttribute("msg", "Complaint added successfully!");
            }

            ra.addFlashAttribute("type", "success");

        } catch (Exception e) {
            ra.addFlashAttribute("msg", "Operation failed!");
            ra.addFlashAttribute("type", "error");
        }

        return "redirect:/view";
    }

    // Load edit form (ONLY load data, no success message here)
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Long id, Model m, RedirectAttributes ra) {

        try {
            m.addAttribute("complaint", service.getById(id));
        } catch (Exception e) {
            ra.addFlashAttribute("msg", "Complaint not found!");
            ra.addFlashAttribute("type", "error");
            return "redirect:/view";
        }

        return "edit";
    }

    // Delete complaint
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id, RedirectAttributes ra) {

        try {
            service.delete(id);
            ra.addFlashAttribute("msg", "Complaint deleted successfully!");
            ra.addFlashAttribute("type", "success");
        } catch (Exception e) {
            ra.addFlashAttribute("msg", "Complaint not deleted!");
            ra.addFlashAttribute("type", "error");
        }

        return "redirect:/view";
    }
}