package org.acme.modelp;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.acme.validation.JvmLanguage;

import javax.json.bind.annotation.JsonbProperty;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
 * @Description 用来验证JSON、XML
 * @Author lxh
 * @Date 2022/5/3 11:30
 **/
public class Developer {
    @Size(min = 4)
    private String name;

    @JvmLanguage
    @NotBlank
    @JsonbProperty("favorite-Language")
    private String favoriteLanguage;

    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFavoriteLanguage() {
        return favoriteLanguage;
    }

    public void setFavoriteLanguage(String favoriteLanguage) {
        this.favoriteLanguage = favoriteLanguage;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Developer{" +
                "name='" + name + '\'' +
                ", favoriteLanguage='" + favoriteLanguage + '\'' +
                ", age=" + age +
                '}';
    }
}
