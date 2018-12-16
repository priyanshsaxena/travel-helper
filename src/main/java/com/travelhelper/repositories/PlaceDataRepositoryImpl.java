package com.travelhelper.repositories;

import com.travelhelper.model.Place;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PlaceDataRepositoryImpl implements PlaceDataRepository {

    private List<Place> placesList;

    public PlaceDataRepositoryImpl(){
        placesList = new ArrayList<>();
        placesList.add(new Place(1, "Kullu"));
        placesList.add(new Place(2, "Shimla"));
        placesList.add(new Place(3, "Dharamsala"));
        placesList.add(new Place(4, "Parashar Lake"));
        placesList.add(new Place(5, "Jalori Pass"));
    }

    public List<Place> getAllPlaces() {
        return placesList;
    }

    public void addPlace(Place place) {
        placesList.add(place);
    }

    public Place getPlace(String name) {
        for(Place place: placesList) {
            if(place.getName() == name) {
                // TODO: clean this up
                System.out.println(place);
                return place;
            }
        }
        return null;
    }

    public void updatePlace(int id, String name) {
        // fill in some update logic :p
    }

    public void deletePlace(String name){
        for(Place place: placesList) {
            if(place.getName() == name) {
                // this shit needs immediate remedy!!!!!
                placesList.remove(place.getId());
                return;
            }
        }
    }

    public int getLastId () {
        // get last element
        int lastIndex = placesList.size() - 1;
        return placesList.get(lastIndex).getId();
    }
}
