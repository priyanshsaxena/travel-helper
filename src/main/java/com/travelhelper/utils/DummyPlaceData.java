package com.travelhelper.utils;

import com.travelhelper.model.Place;

import java.util.ArrayList;
import java.util.List;

public class DummyPlaceData {
    private List<Place> places;

    private static DummyPlaceData instance = null;
    public static DummyPlaceData getInstance(){
        if(instance == null){
            instance = new DummyPlaceData();
        }
        return instance;
    }


    public DummyPlaceData(){
        places = new ArrayList<>();
        places.add(new Place(1, "Kullu"));
        places.add(new Place(2, "Shimla"));
        places.add(new Place(3, "Dharamsala"));
        places.add(new Place(4, "Parashar Lake"));
        places.add(new Place(5, "Jalori Pass"));
    }

    public List<Place> getAllPlaces() {
        return places;
    }

    public boolean addPlace(int id, String name) {
        Place newPlace = new Place(id, name);
        places.add(newPlace);
        return true;
    }

    public Place getPlaceByName(String name) {
        for(Place place: places) {
            if(place.getName() == name) {
                System.out.println(place);
                return place;
            }
        }
        return null;
    }

    public boolean updatePlace(int id, String name) {
        // fill in some update logic :p
        return true;
    }

    public boolean deletePlaceByName(String name){
        for(Place place: places) {
            if(place.getName() == name) {
                // this shit needs immediate remedy!!!!!
                places.remove(place.getId());
                return true;
            }
        }
        return false;
    }

    public int getLastId () {
        // get last element
        int lastIndex = places.size() - 1;
        return places.get(lastIndex).getId();
    }
}
