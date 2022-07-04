package br.univali.poo.termigame;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CSVReader {
    public List<List<String>> readFile(File csv) throws FileNotFoundException {
        List<List<String>> arrayList = new ArrayList();
        try {
            Scanner scanner = new Scanner(csv);
            do {
                arrayList.add(Arrays.asList(scanner.nextLine().split(";")));
            } while (scanner.hasNextLine());
        } catch (FileNotFoundException fileNotFoundException) {
            System.out.println("Arquivo não encontrado, enviando array vazio");
        }
        return transpose(arrayList);
    }

    //https://stackoverflow.com/questions/2941997/how-to-transpose-listlist
    private List<List<String>> transpose(List<List<String>> list) {
        final int N = list.stream().mapToInt(l -> l.size()).max().orElse(-1);
        List<Iterator<String>> iterList = list.stream().map(it->it.iterator()).collect(Collectors.toList());
        return IntStream.range(0, N)
                .mapToObj(n -> iterList.stream()
                        .filter(it -> it.hasNext())
                        .map(m -> m.next())
                        .collect(Collectors.toList()))
                .collect(Collectors.toList());
    }
}
