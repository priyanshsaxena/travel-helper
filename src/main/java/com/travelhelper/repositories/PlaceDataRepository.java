package com.travelhelper.repositories;

import com.travelhelper.model.Place;

import java.util.List;

public interface PlaceDataRepository {

    public List<Place> getAllPlaces();

    public Place getPlace(String name);

    public void updatePlace(int id, String name);

    public void deletePlace(String name);

    public void addPlace(Place place);

    public int getLastId();
    
}
