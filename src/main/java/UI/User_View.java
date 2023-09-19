package UI;

import MVP.IView;

import java.util.Scanner;

public class User_View implements IView {
    Scanner sc;

    public User_View() {
        sc = new Scanner(System.in);
    }

    @Override
    public String menu() {
        System.out.println("Введите: 1 - добавить игрушку\n2 - начать розыгрыш\n3 - забрать приз\n4 - посмотреть на игрушки\n5 - изменить вероятности выпадения\n6 - выход");
        return sc.nextLine();
    }

    @Override
    public String creating_the_toy() {
        System.out.println("Введите название, колличество и вероятность выпадение игрушки:");
        return sc.nextLine();
    }

    public String change_probability() {
        System.out.println("Введите название игрушки, вероятность выпадения которой вы хотите поменять и новую вероятность(через запятую): ");
        return sc.nextLine();
    }

    public String prize_name(){
        System.out.println("Введите название игрушки, которую вы хотите забрать: ");
        return sc.nextLine();
    }
}
