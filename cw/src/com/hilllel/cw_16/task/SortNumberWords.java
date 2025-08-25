package com.hilllel.cw_16.task;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

//  Вывести все предложения заданного текста в порядке возрастания количества слов в каждом из них.
public class SortNumberWords {

    private static final String TEXT = """
Endeavor bachelor but add eat pleasure doubtful sociable. Age forming covered you entered the examine. Blessing scarcely confined her contempt wondered shy. Dashwoods contented sportsmen at up no convinced cordially affection. Am so continued resembled frankness disposing engrossed dashwoods. Earnest greater on no observe fortune norland. Hunted mrs ham wishes stairs. Continued he as so breakfast shameless. All men drew its post knew. Of talking of calling however civilly wishing resolve. Put all speaking her delicate recurred possible. Set indulgence inquietude discretion insensible bed why announcing. Middleton fat two satisfied additions. So continued he or commanded household smallness delivered. Door poor on do walk in half. Roof his head the what. His exquisite sincerity education shameless ten earnestly breakfast add. So we me unknown as improve hastily sitting forming. Especially favourable compliment but thoroughly unreserved saw she themselves. Sufficient impossible him may ten insensible put continuing. Oppose exeter income simple few joy cousin but twenty. Scale began quiet up short wrong in in. Sportsmen shy forfeited engrossed may can.
            """;

//    private static final String TEXT = "";

// hashMap<Integer, List<String>>
    public static void main(String[] args) {

        // TEXT --> STRING[] (sent) --> STRING[] (word) --> MAP <INT, List<STRING<>>>

        Map<Integer, List<String[]>> collect = Arrays.stream(TEXT.split("\\."))
            .map(s -> s.split(" "))
            .collect(Collectors.groupingBy(s -> s.length));

       List<String[]> req = new ArrayList<>();

       collect.entrySet().stream().forEach(s -> s.getValue().forEach(req::add));

        List<String> sent = new ArrayList<>();

        req.stream().forEach(s -> sent.add(Arrays.stream(s).collect(Collectors.joining(" ", "", "."))));

        sent.forEach(s -> System.out.println(sent));

    }
}
