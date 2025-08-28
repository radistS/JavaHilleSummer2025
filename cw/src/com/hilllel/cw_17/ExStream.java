package com.hilllel.cw_17;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ExStream {
    public void printSpecies(List<SeaCreature> seaCreatures) {
        Set<Species> speciesSet = new HashSet<>();
        for (SeaCreature sc : seaCreatures) {
            if (sc.getWeight() >= 10)
                speciesSet.add(sc.getSpecies());
        }
        List<Species> sortedSpecies = new ArrayList<>(speciesSet);
        Collections.sort(sortedSpecies, new Comparator<Species>() {
            public int compare (Species a, Species b) {
                return Integer.compare(a.getPopulation(), b.getPopulation());
            }
        });
        for (Species s : sortedSpecies)
            System.out.println(s.getName());
    }

}
