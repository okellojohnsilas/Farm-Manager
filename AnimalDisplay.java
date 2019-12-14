/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package farm;

/**
 *
 * @author Okello John
 */
public class AnimalDisplay {
    private String tagNumber = null;
    private String animalBreed = null;
    private String animalGender = null;
    private String animalColor = null;
    private String animalType = null;
    private String hornType = null;
    private String ageGroup = null;
    private String animalPrice = null;

    public AnimalDisplay(String tag_Number, String animal_breed, String animal_gender, String animal_color, String animal_type, String horn_type, String age_group, String animal_price) {
        this.tagNumber = tag_Number;
        this.animalBreed = animal_breed;
        this.animalGender = animal_gender;
        this.animalColor = animal_color;
        this.animalType = animal_type;
        this.hornType = horn_type;
        this.ageGroup = age_group;
        this.animalPrice = animal_price;
    }
    
    public String getTagNumber() {
        return tagNumber;
    }

    public void setTagNumber(String tagNumber) {
        this.tagNumber = tagNumber;
    }

    public String getAnimalBreed() {
        return animalBreed;
    }

    public void setAnimalBreed(String animalBreed) {
        this.animalBreed = animalBreed;
    }

    public String getAnimalGender() {
        return animalGender;
    }

    public void setAnimalGender(String animalGender) {
        this.animalGender = animalGender;
    }

    public String getAnimalColor() {
        return animalColor;
    }

    public void setAnimalColor(String animalColor) {
        this.animalColor = animalColor;
    }

    public String getAnimalType() {
        return animalType;
    }

    public void setAnimalType(String animalType) {
        this.animalType = animalType;
    }

    public String getHornType() {
        return hornType;
    }

    public void setHornType(String hornType) {
        this.hornType = hornType;
    }

    public String getAgeGroup() {
        return ageGroup;
    }

    public void setAgeGroup(String ageGroup) {
        this.ageGroup = ageGroup;
    }

    public String getAnimalPrice() {
        return animalPrice;
    }

    public void setAnimalPrice(String animalPrice) {
        this.animalPrice = animalPrice;
    }
}
