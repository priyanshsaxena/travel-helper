package com.travelhelper.controllers;

import com.travelhelper.utils.DummyPlaceData;
import com.travelhelper.model.Place;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class HomeController {

    private DummyPlaceData dummyPlaceData = DummyPlaceData.getInstance();

    @RequestMapping("/")
    public String index() {
        return "Welcome to Travel-Helper";
    }

    @RequestMapping(value = "/places", method = RequestMethod.GET)
    public List<Place> getAllPlaces(){
        return dummyPlaceData.getAllPlaces();
    }

    @RequestMapping(value = "/place/{name}", method = RequestMethod.GET)
    public Place getPlace(@PathVariable String name){
        System.out.println(name);
        return dummyPlaceData.getPlaceByName(name);
    }

    @RequestMapping(value = "/place/add", method = RequestMethod.PUT)
    public boolean addPlace(@RequestBody Map<String, String> body){
        return dummyPlaceData.addPlace(dummyPlaceData.getLastId() + 1, body.get("name"));
    }

    @RequestMapping(value = "/place/update", method = RequestMethod.POST)
    public boolean updatePlace(@RequestBody Map<String, String> body){
        String currentName = body.get("oldName");
        String newName = body.get("newName");
        Place place = dummyPlaceData.getPlaceByName(currentName);
        return dummyPlaceData.updatePlace(place.getId(), newName);
    }

    @RequestMapping(value = "/place/delete", method = RequestMethod.DELETE)
    public boolean deletePlace(@RequestBody Map<String, String> body){
        return dummyPlaceData.deletePlaceByName(body.get("name"));
    }
}
