package Pharmacy;

import Cabinet.Cabinet;

import java.util.Arrays;
import java.util.Date;
import java.util.Random;

import Cabinet.Drug;

public class Pharmacy {
    String name;
    Pharmacist pharmacist;
    Cabinet cabinet;

    public Cabinet getCabinet() {
        return cabinet;
    }

    public Pharmacy(String name) {
        this.name = name;
        cabinet = initializeTestCabinet();
        pharmacist = new Pharmacist("Paul");
        cabinet.registerListener(pharmacist);
    }

    private Cabinet initializeTestCabinet() {
        Cabinet testCabinet = new Cabinet();

        Random random = new Random();
        char[] randomDrugLabel = new char[5];
        for (char drugLabel0 = 'A'; drugLabel0 <= 'Z'; drugLabel0++) {
            randomDrugLabel[0] = drugLabel0;
            for (char drugLabel1 = 'A'; drugLabel1 <= 'Z'; drugLabel1++) {
                randomDrugLabel[1] = drugLabel1;
                int number = Math.abs(random.nextInt()) % 1000;
                String numberLabel = Integer.toString(number);

                switch (numberLabel.length()) {
                    case 0:
                        randomDrugLabel[4] = '0';
                    case 1:
                        randomDrugLabel[3] = '0';
                    case 2:
                        randomDrugLabel[2] = '0';
                    default:
                        break;

                }
                switch (numberLabel.length()) {
                    case 3:
                        randomDrugLabel[2] = Integer.toString(number).charAt(2);
                    case 2:
                        randomDrugLabel[3] = Integer.toString(number).charAt(1);
                    case 1:
                        randomDrugLabel[4] = Integer.toString(number).charAt(0);
                }
                StringBuilder stringBuilder = new StringBuilder();
                for (Character character : randomDrugLabel) {
                    stringBuilder.append(character);
                }
                String randomDrugLabelString = stringBuilder.toString();
                Date randomDate = new Date(Math.abs(System.currentTimeMillis() + Math.abs(random.nextInt())));
                String randomCategory;
                switch (Math.abs(random.nextInt()) % 3) {
                    case 0:
                        randomCategory = "Hearth";
                        break;
                    case 1:
                        randomCategory = "Body";
                        break;
                    case 2:
                        randomCategory = "Soul";
                        break;
                    default:
                        randomCategory = "none";
                        break;
                }
                testCabinet.add(new Drug(randomDrugLabelString, randomDate, randomCategory));
                testCabinet.add(new Drug(randomDrugLabelString, new Date(Math.abs(System.currentTimeMillis() + Math.abs(random.nextInt()))), randomCategory));
                testCabinet.add(new Drug(randomDrugLabelString, new Date(Math.abs(System.currentTimeMillis() + Math.abs(random.nextInt()))), randomCategory));
                testCabinet.add(new Drug(randomDrugLabelString, new Date(Math.abs(System.currentTimeMillis() + Math.abs(random.nextInt()))), randomCategory));
                testCabinet.add(new Drug(randomDrugLabelString, new Date(Math.abs(System.currentTimeMillis() + Math.abs(random.nextInt()))), randomCategory));
            }
        }
        return testCabinet;
    }
}
