package com.wildcodeschool.doctor.controller;

import com.wildcodeschool.doctor.model.Doctor;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.server.ResponseStatusException;

@Controller
public class DoctorController {

    @GetMapping("/doctor")

    public String doctor() {

        return "Welcome to the DoctorController!";
    }

    @GetMapping("/doctor/{number}")
    @ResponseBody
    public Doctor getDoctor(@PathVariable int number) {
        if (number == 13) {
            return new Doctor(13, "Jodie Whittaker");
        } else if (number >= 1 && number <= 12) {
            throw new ResponseStatusException(HttpStatus.SEE_OTHER, "See Other");
        } else {
            String message = "Impossible de récupérer l'incarnation " + number;
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, message);
        }
    }
}
