package com.ford.labs.pizzaaaz.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.bytebuddy.dynamic.loading.InjectionClassLoader;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Flow {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column
    private String name;
    @ElementCollection
    private List<String> steps;
    @Column
    private int currentStep;

    public Flow(String name, List<String> steps){
        this.name = name;
        this.steps = steps;
        this.currentStep = 0;
    }

    @Column
    public String getCurrentStepName(){
        if(this.currentStep < 0) return "Invalid";
        if(this.currentStep >= this.steps.size()) return this.steps.get(this.steps.size() - 1);
        return this.steps.get(currentStep);
    }

    public int getCurrentStep(){
        return currentStep + 1;
    }

    public void advanceStep(){
        this.currentStep = Math.min(currentStep + 1, this.steps.size() - 1);
    }


}
