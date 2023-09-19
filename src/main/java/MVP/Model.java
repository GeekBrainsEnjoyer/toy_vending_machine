package MVP;

import Classes.Toy;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Model {
    private List<Toy> toy_list;
    private List<String> prize_pull;

    public List<String> getPrize_pull() {
        return prize_pull;
    }

    public void setPrize_pull(List<String> prize_pull) {
        this.prize_pull = prize_pull;
    }

    public List<Toy> getToy_list() {
        return toy_list;
    }

    public void setToy_list(List<Toy> toy_list) {
        this.toy_list = toy_list;
    }

    public Model() {
        toy_list = new ArrayList<Toy>();
        prize_pull = new ArrayList<String>();
    }

    public void add_toy_to_list(Toy toy) {
        toy_list.add(toy);
    }

    public Toy hold_a_draw() {
        Random random = new Random();
        float weights_sum = 0;
        int index_prize_toy = 0;
        float[] weigth_list = new float[toy_list.size()];
        for (int i = 0; i < toy_list.size() - 1; i++) {
            weigth_list[i] = toy_list.get(i).getProbability() * toy_list.get(i).getQuantity();
            weights_sum += weigth_list[i];
        }

        float token = random.nextFloat(weights_sum);

        for (int i = 1; i < weigth_list.length - 1; i++) {
            if (token <= weigth_list[i] && token > weigth_list[i - 1]) {
                index_prize_toy = i;
            }
        }

        return toy_list.get(index_prize_toy);
    }

    public void set_new_probability(String[] name_and_new_probability) {
        String name = name_and_new_probability[0];
        float new_probability = Float.parseFloat(name_and_new_probability[1]);
        for (Toy toy : toy_list) {
            if (toy.getName().equals(name))
                toy.setProbability(new_probability);
        }
    }

    public void add_to_prize_pull(Toy toy) {
        toy.setQuantity(toy.getQuantity() - 1);
        prize_pull.add(toy.getName());
    }

    public boolean add_prize_to_database(String chosen_prize) {
        for (String prize : prize_pull) {
            if (prize.equals(chosen_prize)) {
                try {
                    BufferedWriter bw = new BufferedWriter(new FileWriter("src/main/java/Prize_database/Database.txt", true));
                    bw.write(prize);
                    bw.newLine();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                prize_pull.remove(prize);
            }
            else return false;
        }
        return true;
    }
}
