package org.acme.modelp;

/**
 * @Description XML element
 * @Author lxh
 * @Date 2022/5/3 12:21
 **/

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Computer {
    private String brand;

    private String serialNumber;

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    @Override
    public String toString() {
        return "Computer{" +
                "brand='" + brand + '\'' +
                ", serialNumber='" + serialNumber + '\'' +
                '}';
    }
}
