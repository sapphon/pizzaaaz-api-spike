package com.ford.labs.pizzaaaz.service;

import com.ford.labs.pizzaaaz.model.Flow;
import com.ford.labs.pizzaaaz.repository.FlowRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FlowService {
    private FlowRepository flowRepository;

    public FlowService(FlowRepository flowRepository){
        this.flowRepository = flowRepository;
    }

    public Flow createFlow(String name, List<String> steps){
        return flowRepository.save(new Flow(name, steps));
    }

    public void advanceFlow(Long id) {
        Optional<Flow> flowMaybe = this.flowRepository.findById(id);
        if(flowMaybe.isPresent())
        {

            Flow flow = flowMaybe.get();
            flow.advanceStep();
            flowRepository.save(flow);
        }
    }

    public String getCurrentStepNameForFlow(Long id){
        Optional<Flow> flowMaybe = this.flowRepository.findById(id);
        return flowMaybe.map(Flow::getCurrentStepName).orElse(null);
    }

    public Flow getFlow(Long id) {
        return this.flowRepository.findById(id).orElse(null);
    }

    public int getCurrentStepNumberForFlow(Long id) {
        Optional<Flow> flowMaybe = this.flowRepository.findById(id);
        return flowMaybe.map(Flow::getCurrentStep).orElse(Integer.MIN_VALUE);
    }

    public List<Flow> searchForFlowsByName(String name){
        return this.flowRepository.findAllByNameLike("%"+name+"%");
    }
}
