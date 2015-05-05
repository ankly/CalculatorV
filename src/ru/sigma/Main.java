package ru.sigma;

/**
 * Created by Student08 on 05.05.2015.
 */
public class Main {


        public static void main(String[] args) {
            Model model = new Model();
            ViewCalculator view = new ViewCalculator(model);
            view.buildGUI();
        }
    }

