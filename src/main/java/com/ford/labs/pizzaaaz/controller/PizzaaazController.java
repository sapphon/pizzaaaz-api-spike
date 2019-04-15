package com.ford.labs.pizzaaaz.controller;

import com.ford.labs.pizzaaaz.model.Flow;
import com.ford.labs.pizzaaaz.service.FlowService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PizzaaazController {

    private FlowService flowService;

    public PizzaaazController(FlowService flowService){
        this.flowService = flowService;
    }

    @PostMapping("/flow/add")
    public Flow createFlow(@RequestParam String name, @RequestBody List<String> steps){
        return flowService.createFlow(name, steps);
    }

    @GetMapping("/flow/{id}/get")
    public Flow getFlow(@PathVariable Long id){
        return this.flowService.getFlow(id);
    }

    @PostMapping("/flow/{id}/advance")
    public void advanceFlow(@PathVariable Long id){
        this.flowService.advanceFlow(id);
    }

    @GetMapping("/flow/{id}/currentStep/name")
    public String getNameOfCurrentStepOfFlow(@PathVariable Long id){
        return this.flowService.getCurrentStepNameForFlow(id);
    }

    @GetMapping("/flow/{id}/currentStep/number")
    public int getNumberOfCurrentStepOfFlow(@PathVariable Long id){
        return this.flowService.getCurrentStepNumberForFlow(id);
    }

    @GetMapping("/flow/search")
    public List<Flow> searchFlowsByName(@RequestParam String name){
        return this.flowService.searchForFlowsByName(name);
    }
}
