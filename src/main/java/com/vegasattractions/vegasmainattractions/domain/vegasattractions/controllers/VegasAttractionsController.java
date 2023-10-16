package com.vegasattractions.vegasmainattractions.domain.vegasattractions.controllers;

import com.vegasattractions.vegasmainattractions.domain.vegasattractions.models.VegasAttractions;
import com.vegasattractions.vegasmainattractions.domain.vegasattractions.services.VegasAttractionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/vegasAttractions")
@CrossOrigin("*")
public class VegasAttractionsController {

    private VegasAttractionsService vegasAttractionsService;

    @Autowired
    public VegasAttractionsController(VegasAttractionsService vegasAttractionService) {
        this.vegasAttractionsService = vegasAttractionService;
    }

    @GetMapping
    public ResponseEntity<List<VegasAttractions>> getAll() {
        List<VegasAttractions> requests = vegasAttractionsService.getAll();
        return new ResponseEntity<>(requests, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<VegasAttractions> create(@RequestBody VegasAttractions vegasAttractions) {
        vegasAttractions = vegasAttractionsService.create(vegasAttractions);
        return new ResponseEntity<>(vegasAttractions, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<VegasAttractions> getById(@PathVariable("id") Long id) {
        VegasAttractions vegasAttractions = vegasAttractionsService.getById(id);
        return new ResponseEntity<>(vegasAttractions, HttpStatus.OK);
    }

    @GetMapping("lookup")
    public ResponseEntity<VegasAttractions> getByEmail(@RequestParam String email){
        VegasAttractions vegasAttractions = vegasAttractionsService.getByEmail(email);
        return new ResponseEntity<>(vegasAttractions, HttpStatus.OK);
    }
    @PutMapping("{id}")
    public ResponseEntity<VegasAttractions> update(@PathVariable("id") Long id, @RequestBody VegasAttractions vegasAttractionsDetail){
        vegasAttractionsDetail = vegasAttractionsService.update(id, vegasAttractionsDetail);
        return new ResponseEntity<>(vegasAttractionsDetail, HttpStatus.ACCEPTED);
    }
    @DeleteMapping("{id}")
    public ResponseEntity delete(@PathVariable("id") Long id){
        vegasAttractionsService.delete(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
