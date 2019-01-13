package Pharmacy;

import Cabinet.Cabinet;

import java.util.Date;
import java.util.Random;

import Base.Drug;
import Cabinet.ICabinet;

public class Pharmacy implements IPharmacy {
    String name;
    IPharmacist pharmacist;
    ICabinet cabinet;

    Random random;


    public Pharmacy(String name) {
        random = new Random();
        this.name = name;
        cabinet = initializeTestCabinet();
        pharmacist = new Pharmacist("Paul");
        cabinet.registerListener(pharmacist);
    }

    private ICabinet initializeTestCabinet() {
        ICabinet testCabinet = new Cabinet();

        int count = 0;
        for (char drugLabel0 = 'A'; drugLabel0 <= 'Z'; drugLabel0++) {
            for (char drugLabel1 = 'A'; drugLabel1 <= 'Z'; drugLabel1++) {
                count = 0;
                while (count < 5) {
                    Drug randomDrug = randomDrug(drugLabel0, drugLabel1);
                    testCabinet.add(randomDrug);
                    count++;
                    if (Math.abs(random.nextInt()) % 200 != 0) {
                        int duplicates = Math.abs(random.nextInt()) % 4;
                        duplicates++;
                        while (duplicates != 0) {
                            Drug add = new Drug(randomDrug.getLabel(), randomDate(), randomDrug.getCategory());
                            testCabinet.add(add);
                            duplicates--;
                            count++;
                        }
                    }
                }
            }
        }
        return testCabinet;
    }

    private Drug randomDrug(char firstLabelChar, char secondLabelChar) {
        char[] randomDrugLabel = new char[5];
        randomDrugLabel[0] = firstLabelChar;
        randomDrugLabel[1] = secondLabelChar;

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
        return new Drug(randomDrugLabelString, randomDate(), randomCategory);
    }

    private Date randomDate() {
        return new Date(Math.abs(System.currentTimeMillis() + Math.abs(random.nextInt())));
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public IPharmacist getPharmacist() {
        return pharmacist;
    }

    public void setPharmacist(IPharmacist pharmacist) {
        this.pharmacist = pharmacist;
    }

    public ICabinet getCabinet() {
        return cabinet;
    }

    public void setCabinet(ICabinet cabinet) {
        this.cabinet = cabinet;
    }
}
